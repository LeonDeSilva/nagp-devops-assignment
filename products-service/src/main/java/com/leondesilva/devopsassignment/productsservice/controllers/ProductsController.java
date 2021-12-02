package com.leondesilva.devopsassignment.productsservice.controllers;

import com.leondesilva.devopsassignment.productsservice.models.ProductModel;
import com.leondesilva.devopsassignment.productsservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductsController {
    @Autowired
    private ProductService productService;

    /**
     * Controller method to get all the products.
     *
     * @return all the products
     */
    @GetMapping("/products")
    public List<ProductModel> getAllProducts() {
        return productService.getProducts();
    }

    /**
     * Controller method to get product for given id.
     *
     * @param id the product id
     * @return the product information for the given id
     */
    @GetMapping("/products/{id}")
    public ResponseEntity<Object> getProduct(@PathVariable("id") String id) {
        if (id == null) {
            return ResponseEntity.badRequest().body("Product id cannot be null");
        }

        ProductModel product = productService.getProductById(id);

        if (product != null) {
            return ResponseEntity.ok().body(product);
        }

        return ResponseEntity.notFound().build();
    }

    /**
     * Controller method to add a new product.
     *
     * @param productModel the product to be added
     * @return 200 OK if success, else error code
     */
    @PostMapping("/products")
    public ResponseEntity<Object> addProduct(@RequestBody ProductModel productModel) {
        ProductModel savedModel = productService.addProduct(productModel);
        return ResponseEntity.ok().body(savedModel);
    }
}
