package com.productservice.productservice.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.productservice.productservice.dtos.GenericProductDto;
import com.productservice.productservice.exceptions.ProductNotFoundException;
import com.productservice.productservice.services.ProductService;
import jakarta.inject.Inject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.is;


@WebMvcTest(ProductController.class)
//@AutoConfigureWebMvc
public class ProductControllerWebMvcTest {
    @MockBean
    private ProductService productService;

    @Inject
    private MockMvc mockMvc;

    @Inject
    private ObjectMapper objectMapper;

    @Captor
    private ArgumentCaptor<Long> argumentCaptor;
    @Inject
    private ProductController productController;

    @Test
    void testGetAllProductsReturnEmptyList() throws Exception {
        when(productService.getAllProducts()).thenReturn(new ArrayList<>());

        mockMvc.perform(get("/products"))
                .andExpect(status().is(200))
                .andExpect(content().string("[]"));
    }

    @Test
    void testGetAllProductsReturnValidList() throws Exception {
        ArrayList<GenericProductDto> genericProductDtos= new ArrayList<>();
        genericProductDtos.add(new GenericProductDto());
        genericProductDtos.add(new GenericProductDto());
        genericProductDtos.add(new GenericProductDto());

        when(productService.getAllProducts()).thenReturn(genericProductDtos);

        mockMvc.perform(get("/products"))
                .andExpect(status().is(200))
                .andExpect(content().string(objectMapper.writeValueAsString(genericProductDtos)));
    }

    @Test
    void createProductShouldCreateValidProduct() throws Exception {
        GenericProductDto productToCreate= new GenericProductDto();
        productToCreate.setTitle("Macbook");
        productToCreate.setPrice(200000);
        productToCreate.setDescription("best laptop ever");
        productToCreate.setCategory("Laptop");

        GenericProductDto outputGenericProductDto= new GenericProductDto();
        outputGenericProductDto.setCategory(productToCreate.getCategory());
        outputGenericProductDto.setTitle(productToCreate.getTitle());
        outputGenericProductDto.setPrice(productToCreate.getPrice());
        outputGenericProductDto.setDescription(productToCreate.getDescription());
        outputGenericProductDto.setId(1000L);

        when(productService.createProduct(any()))
                .thenReturn(outputGenericProductDto);

        mockMvc.perform(post("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(productToCreate))
        )
                .andExpect(
                        content().string(objectMapper.writeValueAsString(outputGenericProductDto))
                )
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.title", is("Macbook")))
                .andExpect(jsonPath("$.price", is(200000)));

    }

    @Test
    @DisplayName("testProductControllerCallsProductServiceWithSameProductIdAsInput")
    void testIfSameInput() throws ProductNotFoundException {
        //This is the test case to check if productController is passing the same productId to the
        //productService as the input.
        Long id = 100L;

        when(productService.getProductById(id)).thenReturn(new GenericProductDto());

        GenericProductDto genericProductDto =  productController.getProductById(id);

        verify(productService).getProductById(argumentCaptor.capture());

        assertEquals(id, argumentCaptor.getValue());
    }

}
