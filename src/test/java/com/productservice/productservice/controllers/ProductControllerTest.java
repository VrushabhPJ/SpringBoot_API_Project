package com.productservice.productservice.controllers;

import com.productservice.productservice.dtos.GenericProductDto;
import com.productservice.productservice.exceptions.ProductNotFoundException;
import com.productservice.productservice.services.ProductService;
import com.productservice.productservice.thirdPartyClients.fakestoreclient.FakeStoreClient;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductControllerTest {
    @Inject
    private ProductController productController;
//    ProductControllerTest(ProductController productController) {
//        this.productController= productController;
//    }
    @Inject
    private FakeStoreClient fakeStoreClient;

    @MockBean
    private ProductService productService; // for dummy object

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
        //assertThrows(ProductNotFoundException.class , () -> fakeStoreClient.getProductById(1000L));
        //assertNull(fakeStoreClient.getProductById(1000L));
    }

    @Test
    void testGetProductByIdMocking() throws ProductNotFoundException {
        /*set dummy data from productService.getProductById(any Long value) when
        productController.getProductById(7374L) called then going to productService they used our
        mocking dependency that set in when();
        */
        GenericProductDto genericProductDto= new GenericProductDto();
        when(productService.getProductById(any(Long.class))).thenReturn(genericProductDto);

        GenericProductDto genericProductDto1= productController.getProductById(7374L);
        //assertNull(productController.getProductById(100L));
        assertEquals(genericProductDto, genericProductDto1);
    }

    @Test
    void testGetProductByIdExceptionMocking() throws ProductNotFoundException {
        when(productService.getProductById(1L)).thenThrow(ProductNotFoundException.class);

        assertThrows(ProductNotFoundException.class, () -> productController.getProductById(1L));
    }
}
