package com.leondesilva.devopsassignment.productsservice.controllers;



import com.leondesilva.devopsassignment.productsservice.ProductsServiceApplication;
import org.junit.experimental.categories.Category;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


/**
 * Integration test for product controller.
 */
@Tag("IntegrationTest")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = ProductsServiceApplication.class)
@AutoConfigureMockMvc
class ProductsControllerIntegrationTest {
    @Autowired
    private MockMvc mvc;

    @Test
    void ShouldReturnOkResponse_When_GettingProductsFromController() throws Exception {
        mvc.perform(get("/products")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void ShouldReturnNotFoundResponse_When_GettingInvalidSingleProductFromController() throws Exception {
        mvc.perform(get("/products/2021")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}