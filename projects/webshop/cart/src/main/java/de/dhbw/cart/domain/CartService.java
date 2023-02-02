package de.dhbw.cart.domain;

import de.dhbw.cart.domain.api.CartDto;
import de.dhbw.cart.domain.api.CartItemDto;
import de.dhbw.cart.domain.db.CartEntity;
import de.dhbw.cart.domain.db.CartItemEntity;
import de.dhbw.cart.domain.db.CartRepo;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CartService {

    private final CartRepo cartRepo;

    public CartService(CartRepo cartRepo) {
        this.cartRepo = cartRepo;
    }

    public CartDto getCartById(Long cartId) {

        return this.cartRepo.findById(cartId)
                .map(entity -> new CartDto(entity.getId(),
                        entity.getItems()
                                .stream()
                                .map(this::mapItem)
                                .collect(Collectors.toList())))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    }

    public CartDto createCart() {
        CartEntity cart = new CartEntity();
        cart.setItems(new ArrayList<>());

        return Optional.of(this.cartRepo.save(cart))
                .map(entity -> new CartDto(entity.getId(), new ArrayList<>()))
                .orElseThrow(() -> new IllegalStateException("cart == null"));
    }

    public CartDto updateCart(CartDto cartDto) {
        CartEntity cart = this.cartRepo.findById(cartDto.getCartId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return Optional.of(cart)
                .map(entity -> {
                    List<CartItemEntity> updatedItems = cartDto
                            .getItems()
                            .stream()
                            .map(item -> {
                                CartItemEntity itemEntity = new CartItemEntity();
                                itemEntity.setCart(entity);
                                itemEntity.setArticleId(item.getArticleId());
                                itemEntity.setCount(item.getCount());
                                return itemEntity;
                            })
                            .collect(Collectors.toList());

                    entity.setItems(updatedItems);
                    return entity;
                })
                .map(entity -> this.cartRepo.save(entity))
                .map(this::mapCart)
                .orElseThrow(() -> new IllegalStateException("cart == null"));
    }

    public void deleteCart(Long cartId) {
        this.cartRepo.deleteById(cartId);
    }

    private CartDto mapCart(CartEntity entity) {
        return new CartDto(entity.getId(),
                entity.getItems()
                        .stream()
                        .map(this::mapItem)
                        .collect(Collectors.toList()));
    }

    private CartItemDto mapItem(CartItemEntity cartItemEntity) {
        return new CartItemDto(cartItemEntity.getTitle(), cartItemEntity.getArticleId(), cartItemEntity.getCount());
    }
}
