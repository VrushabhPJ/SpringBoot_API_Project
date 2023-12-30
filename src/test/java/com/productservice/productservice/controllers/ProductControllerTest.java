package com.productservice.productservice.controllers;

import com.productservice.productservice.exceptions.ProductNotFoundException;
import com.productservice.productservice.thirdPartyClients.fakestoreclient.FakeStoreClient;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ProductControllerTest {
//    private ProductController productController;
//    ProductControllerTest(ProductController productController) {
//        this.productController= productController;
//    }
    @Autowired
    private FakeStoreClient fakeStoreClient;

//    ProductControllerTest(FakeStoreClient fakeStoreClient) {
//        this.fakeStoreClient= fakeStoreClient;
//    }

    @Test
    void testOnePlusOneIsTwoOrNot() {
        //assert (2 == 1 + 1);
        //assertEquals(3, 1 + 1, "1 + 1 should be 2");  failing test case
//        assertEquals(2, 1 + 1, "1 + 1 should be 2");  passing test case
    }

    @Test
    void testGetProductByIdNegativeTC() throws ProductNotFoundException {
        assertThrows(ProductNotFoundException.class , () -> fakeStoreClient.getProductById(1000L));
        //assertNull(fakeStoreClient.getProductById(1000L));
    }
}
