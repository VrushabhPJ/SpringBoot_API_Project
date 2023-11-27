package com.productservice.productservice.services;

import com.productservice.productservice.dtos.GenericProductDto;

import java.util.ArrayList;
import java.util.List;

public interface ProductService {
    GenericProductDto getProductById(Long id);

    List<GenericProductDto> getAllProducts();

    void deleteProductById(Long id);

    GenericProductDto createProduct(GenericProductDto genericProductDto);

    void updateProductById();
}
