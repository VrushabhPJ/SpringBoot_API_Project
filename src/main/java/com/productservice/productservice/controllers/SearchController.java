package com.productservice.productservice.controllers;

import com.productservice.productservice.dtos.GenericProductDto;
import com.productservice.productservice.dtos.SearchRequestDto;
import com.productservice.productservice.services.SearchService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {
    private SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService= searchService;
    }

    @PostMapping
    public Page<GenericProductDto> searchProduct(@RequestBody SearchRequestDto requestDto) {
        List<GenericProductDto> genericProductDtos= searchService.searchProduct(requestDto.getTitle(),
                requestDto.getPageNumber(),
                requestDto.getPageNumber(),
                requestDto.getSortParams());

        Page<GenericProductDto> genericProductDtoPage= new PageImpl<>(
                genericProductDtos
        );

        return genericProductDtoPage;
    }
}
