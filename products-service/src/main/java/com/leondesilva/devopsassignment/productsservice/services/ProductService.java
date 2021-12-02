package com.leondesilva.devopsassignment.productsservice.services;

import com.leondesilva.devopsassignment.productsservice.models.ProductModel;

import java.util.List;

/**
 * Interface to represent the product service.
 */
public interface ProductService {
    /**
     * Method to get all products.
     *
     * @return all the products
     */
    List<ProductModel> getProducts();

    /**
     * Method to get the product for a given id
     *
     * @param id the id
     * @return the product info
     */
    ProductModel getProductById(String id);

    /**
     * Method to add a product.
     *
     * @param productModel the product information to insert
     * @return the added product information
     */
    ProductModel addProduct(ProductModel productModel);
}
