package de.dhbw.webshop.cart;

import de.dhbw.webshop.cart.db.CartEntity;
import de.dhbw.webshop.cart.db.CartItemEntity;
import de.dhbw.webshop.cart.dto.Cart;
import de.dhbw.webshop.cart.dto.CartItem;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController()
@RequestMapping("api")
public class CartController {

  private CartRepo cartRepo;
  private ItemRepo itemRepo;

  public CartController(CartRepo cartRepo, ItemRepo itemRepo) {
    this.cartRepo = cartRepo;
    this.itemRepo = itemRepo;
  }

  @GetMapping("cart")
  public Cart getCart(String cartId) {
    Optional<CartEntity> result = this.cartRepo.findById(cartId);
    if (result.isPresent()) {
      return Cart.fromEntity(result.get());
    }

    throw new ResponseStatusException(HttpStatus.NOT_FOUND);
  }

  @PostMapping("cart")
  public Cart createNewCart() {
    return Cart.fromEntity(this.cartRepo.save(new CartEntity()));
  }

  @PutMapping("cart/{cartId}")
  public Cart addItemToCart(@PathVariable("cartId") String cartId, @RequestBody CartItem cartItem) {

    Optional<CartEntity> result = this.cartRepo.findById(cartId);
    if (result.isPresent()) {
      CartEntity cart = result.get();
      List<CartItemEntity> duplicates =
          cart.items.stream()
              .filter(item -> item.itemId.equals(cartItem.id))
              .collect(Collectors.toList());
      if (duplicates.isEmpty()) {
        CartItemEntity itemEntity = CartItem.toEntity(cartItem);
        // set cart ref
        itemEntity.cart = cart;
        cart.items.add(itemEntity);

      } else {
        // update existing
        duplicates.forEach(
            entity -> {
              entity.count = cartItem.count;
              entity.title = cartItem.title;
              entity.price = cartItem.price;
            });
      }
      return Cart.fromEntity(this.cartRepo.save(cart));
    }
    throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
  }

  @DeleteMapping("cart/{cartId}/{itemId}")
  @Transactional
  public Cart deleteItem(
      @PathVariable("cartId") String cartId, @PathVariable("itemId") String itemId) {
    CartEntity cart = new CartEntity();
    cart.cartId = cartId;
    Optional<CartItemEntity> itemEntity = this.itemRepo.findByCartAndItemId(cart, itemId);
    if (itemEntity.isPresent()) {
      this.itemRepo.delete(itemEntity.get());
    }

    Optional<CartEntity> cartEntity = this.cartRepo.findById(cartId);
    if (cartEntity.isPresent()) {
      return Cart.fromEntity(cartEntity.get());
    }

    throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
  }

  @PutMapping("cart/{cartId}/{itemId}")
  public Cart modifyItem(
      @PathVariable("cartId") String cartId,
      @PathVariable("itemId") String itemId,
      @RequestBody CartItem cartItem) {

    CartEntity cart = new CartEntity();
    cart.cartId = cartId;
    Optional<CartItemEntity> itemResult = this.itemRepo.findByCartAndItemId(cart, itemId);
    if (itemResult.isPresent()) {
      CartItemEntity itemEntity = itemResult.get();
      itemEntity.price = cartItem.price;
      itemEntity.title = cartItem.title;
      itemEntity.count = cartItem.count;
      return Cart.fromEntity(this.cartRepo.save(itemEntity.cart));
    }
    throw new ResponseStatusException(HttpStatus.NOT_FOUND);
  }
}
