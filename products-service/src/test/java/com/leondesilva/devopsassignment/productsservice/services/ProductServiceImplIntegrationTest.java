//package com.leondesilva.devopsassignment.productsservice.services;
//
//import com.leondesilva.devopsassignment.productsservice.models.ProductModel;
//import com.leondesilva.devopsassignment.productsservice.repositories.ProductRepository;
//import org.junit.ClassRule;
//import org.junit.Ignore;
//import org.junit.Test;
//import org.junit.jupiter.api.Disabled;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.util.TestPropertyValues;
//import org.springframework.context.ApplicationContextInitializer;
//import org.springframework.context.ConfigurableApplicationContext;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.testcontainers.containers.PostgreSQLContainer;
//import com.leondesilva.devopsassignment.productsservice.IntegrationTests;
//import org.junit.experimental.categories.Category;
//import org.junit.jupiter.api.Tag;
//
///**
// * Test class for product service integration
// */
//@Disabled
//@Tag("IntegrationTest")
//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@ContextConfiguration(initializers = {ProductServiceImplIntegrationTest.Initializer.class})
//public class ProductServiceImplIntegrationTest {
//    @Autowired
//    private ProductRepository productRepository;
//
//    @ClassRule
//    public static PostgreSQLContainer postgres = new PostgreSQLContainer("postgres")
//            .withDatabaseName("postgres")
//            .withUsername("postgres")
//            .withPassword("docker");
//
//    static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
//        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
//            TestPropertyValues.of(
//                    "spring.datasource.url=" + postgres.getJdbcUrl(),
//                    "spring.datasource.username=" + postgres.getUsername(),
//                    "spring.datasource.password=" + postgres.getPassword()
//            ).applyTo(configurableApplicationContext.getEnvironment());
//        }
//    }
//
//
//
//    @Test
//    public void ShouldSave_And_GetProductsToDB() {
//        ProductModel productModel = new ProductModel();
//        productModel.setId("ID1");
//        productModel.setName("NameA");
//        productModel.setQuantity(100);
//        productRepository.save(productModel);
//        System.out.println(productRepository.findAll());
//    }
//}
