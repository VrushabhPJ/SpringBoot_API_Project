package com.productservice.productservice.controllers;

import com.productservice.productservice.dtos.GenericProductDto;
import com.productservice.productservice.dtos.SearchRequestDto;
import com.productservice.productservice.services.SearchService;
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
    public List<GenericProductDto> searchProduct(@RequestBody SearchRequestDto requestDto) {
        return searchService.searchProduct(requestDto.getQuery(), requestDto.getPageNumber(), requestDto.getPageNumber());
    }
}
