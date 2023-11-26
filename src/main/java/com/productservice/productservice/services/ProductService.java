package com.productservice.productservice.services;

import com.productservice.productservice.dtos.GenericProductDto;

public interface ProductService {
    GenericProductDto getProductById(Long id);

    void getAllProducts();

    void deleteProductById(Long id);

    void createProduct();

    void updateProductById();
}
