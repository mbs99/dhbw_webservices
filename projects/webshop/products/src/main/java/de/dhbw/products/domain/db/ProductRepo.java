package de.dhbw.products.domain.db;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepo extends CrudRepository<ProductEntity, Long> {

    List<ProductEntity> findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String queryTitle, String queryDescription);
}
