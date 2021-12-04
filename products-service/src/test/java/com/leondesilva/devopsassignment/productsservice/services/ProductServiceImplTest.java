package com.leondesilva.devopsassignment.productsservice.services;


import com.leondesilva.devopsassignment.productsservice.models.ProductModel;
import com.leondesilva.devopsassignment.productsservice.repositories.ProductRepository;
import org.junit.experimental.categories.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@Tag("UnitTest")
class ProductServiceImplTest {
    private ProductService productService;
    private ProductRepository productRepository;
    private ProductModel productModel1;
    private ProductModel productModel2;

    @BeforeEach
    void setUp() {
        productRepository = mock(ProductRepository.class);
        productModel1 = mock(ProductModel.class);
        productModel2 = mock(ProductModel.class);
        when(productRepository.findAll()).thenReturn(Arrays.asList(productModel1, productModel2));
        when(productRepository.save(productModel2)).thenReturn(productModel2);
        productService = new ProductServiceImpl();
        ReflectionTestUtils.setField(productService, "productRepository", productRepository);
    }

    /**
     * Test to verify that all products are returned when get products method is called.
     */
    @Test
    void ShouldReturnAllProducts_When_GetProductsMethodIsCalled() {
        List<ProductModel> products = productService.getProducts();
        assertEquals(2, products.size());
        assertTrue(products.contains(productModel1));
        assertTrue(products.contains(productModel2));
    }

    /**
     * Test to verify that exception is thrown when id is null at product retrieval
     */
    @Test
    void ShouldThrowException_When_IdIsNullAtProductRetrieval() {
        assertThrows(IllegalArgumentException.class, () -> productService.getProductById(null));
    }

    /**
     * Test to verify that repository save is called when product add is called.
     */
    @Test
    void ShouldCallRepositorySave_When_AddProductMethodIsCalled() {
        ProductModel productModelResult = productService.addProduct(productModel2);
        assertEquals(productModel2, productModelResult);
        verify(productRepository, times(1)).save(productModel2);
    }
}