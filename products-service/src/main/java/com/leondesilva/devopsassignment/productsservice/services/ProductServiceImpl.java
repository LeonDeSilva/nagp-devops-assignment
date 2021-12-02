package com.leondesilva.devopsassignment.productsservice.services;

import com.leondesilva.devopsassignment.productsservice.models.ProductModel;
import com.leondesilva.devopsassignment.productsservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation class of the product service.
 */
@Service
public class ProductServiceImpl implements ProductService {
    /**
     * Method to get all products.
     *
     * @return all the products
     */
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductModel> getProducts() {
        return productRepository.findAll();
    }

    /**
     * Method to get the product for a given id
     *
     * @param id the id
     * @return the product info
     */
    @Override
    public ProductModel getProductById(String id) {
        if (id == null) {
            throw new IllegalArgumentException("Product id cannot be null");
        }

        return productRepository.findById(id).orElse(null);
    }

    /**
     * Method to add a product.
     *
     * @param productModel the product information to insert
     * @return the added product information
     */
    @Override
    public ProductModel addProduct(ProductModel productModel) {
        return productRepository.save(productModel);
    }
}
