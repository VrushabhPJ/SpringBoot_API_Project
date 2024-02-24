package com.productservice.productservice.services;

import com.productservice.productservice.dtos.FakeStoreProductDto;
import com.productservice.productservice.dtos.GenericProductDto;
import com.productservice.productservice.models.Product;
import com.productservice.productservice.repository.ProductRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService {
    private ProductRepository productRepository;

    public SearchService (ProductRepository productRepository) {
        this.productRepository= productRepository;
    }

    private static GenericProductDto convertToGenericProductDto(Product product) {
        GenericProductDto genericProductDto = new GenericProductDto();
        genericProductDto.setImage(product.getImage());
        genericProductDto.setCategory(String.valueOf(product.getCategory()));
        genericProductDto.setDescription(product.getDescription());
        genericProductDto.setTitle(product.getTitle());
        //genericProductDto.setPrice(product.getPrice());

        return genericProductDto;
    }


    public List<GenericProductDto> searchProduct(String query, int pageNumber, int pageSize ) {
        PageRequest pageRequest= PageRequest.of(pageNumber, pageSize);

        List<Product> products= productRepository.findAllByTitleContaining(query, pageRequest);
        List<GenericProductDto> genericProductDtos= new ArrayList<>();

        for(Product product: products) {
            genericProductDtos.add(convertToGenericProductDto(product));
        }
        return genericProductDtos;
    }
}
