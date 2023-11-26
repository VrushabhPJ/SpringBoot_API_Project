package com.productservice.productservice.controllers;

import com.productservice.productservice.dtos.GenericProductDto;
import com.productservice.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;
    ProductController(@Qualifier("fakeStoreProductService") ProductService productService) {
        this.productService= productService;
    }

    @GetMapping("/{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id) {
        return productService.getProductById(id);
    }

    @GetMapping
    public void getAllProducts() {

    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable("id") Long id) {

    }

    @PostMapping
    public void createProduct() {
        //return productService.createProduct(genericProductDto);

    }

    public void updateProductById() {

    }
}
