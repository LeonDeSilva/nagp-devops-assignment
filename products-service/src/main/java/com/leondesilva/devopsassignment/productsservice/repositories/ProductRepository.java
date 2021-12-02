package com.leondesilva.devopsassignment.productsservice.repositories;

import com.leondesilva.devopsassignment.productsservice.models.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface for the product repository
 */
public interface ProductRepository extends JpaRepository<ProductModel, String> {
}
