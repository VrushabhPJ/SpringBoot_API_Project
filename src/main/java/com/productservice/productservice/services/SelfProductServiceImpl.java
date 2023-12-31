package com.productservice.productservice.services;

import com.productservice.productservice.dtos.GenericProductDto;
import com.productservice.productservice.exceptions.ProductNotFoundException;
import com.productservice.productservice.models.Product;
import com.productservice.productservice.repository.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

//@Primary
@Service
public class SelfProductServiceImpl implements ProductService{

    private ProductRepository productRepository;
    SelfProductServiceImpl (ProductRepository productRepository) {
        this.productRepository= productRepository;
    }

    @Override
    public GenericProductDto getProductById(Long id) throws ProductNotFoundException {
        //make DB call & get the products with given id

        GenericProductDto genericProductDto= new GenericProductDto();
        Optional<Product> optionalProduct= productRepository.findById(UUID.fromString("07285a86-777a-41d6-845c-039b4d12ab20"));

        Product product= optionalProduct.get();
        genericProductDto.setTitle(product.getTitle());
        genericProductDto.setDescription(product.getDescription());
        genericProductDto.setImage(product.getImage());
        genericProductDto.setCategory(String.valueOf(product.getCategory()));
        genericProductDto.setPrice((int) product.getPrice().getValue());

        return genericProductDto;
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        return null;
    }

    @Override
    public GenericProductDto deleteProductById(Long id) {
        return null;
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
        return null;
    }

    @Override
    public GenericProductDto updateProductById(Long id, GenericProductDto genericProductDto) {
        return null;
    }
}
