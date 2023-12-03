package com.productservice.productservice.services;

import com.productservice.productservice.dtos.FakeStoreProductDto;
import com.productservice.productservice.dtos.GenericProductDto;
import com.productservice.productservice.exceptions.ProductNotFoundException;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{
    private RestTemplateBuilder restTemplateBuilder;
    private String specificProductUrl = "https://fakestoreapi.com/products/{id}";
    private String genericProductUrl = "https://fakestoreapi.com/products/";

    FakeStoreProductService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    private static GenericProductDto convertToGenericProductDto(FakeStoreProductDto fakeStoreProductDto) {
        GenericProductDto genericProductDto = new GenericProductDto();
        genericProductDto.setId(fakeStoreProductDto.getId());
        genericProductDto.setImage(fakeStoreProductDto.getImage());
        genericProductDto.setCategory(fakeStoreProductDto.getCategory());
        genericProductDto.setDescription(fakeStoreProductDto.getDescription());
        genericProductDto.setTitle(fakeStoreProductDto.getTitle());
        genericProductDto.setPrice(fakeStoreProductDto.getPrice());

        return genericProductDto;
    }

    @Override
    public GenericProductDto getProductById(Long id) throws ProductNotFoundException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity =
                restTemplate.getForEntity(specificProductUrl, FakeStoreProductDto.class, id);

        FakeStoreProductDto fakeStoreProductDto= responseEntity.getBody();

        if(fakeStoreProductDto == null) {
            throw new ProductNotFoundException("Product id "+ id +" doesn't exist");
        }

        return convertToGenericProductDto(fakeStoreProductDto);
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> responseEntity =
                restTemplate.getForEntity(genericProductUrl , FakeStoreProductDto[].class);

        List<FakeStoreProductDto> fakeStoreProductDtos= List.of(responseEntity.getBody());
        List<GenericProductDto> result =new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {
            result.add( convertToGenericProductDto(fakeStoreProductDto) );
        }

        return result;
    }

    @Override
    public GenericProductDto deleteProductById(Long id) {
        RestTemplate restTemplate= restTemplateBuilder.build();

        /*Delete() doesn't return anything, so we implement by using postForEntity() we just change
        ResponseEntity<FakeStoreProductDto>, "HttpMethod.DELETE"  */
        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor =
                restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> responseEntity=
                restTemplate.execute(specificProductUrl, HttpMethod.DELETE, requestCallback, responseExtractor, id);

        return convertToGenericProductDto(responseEntity.getBody());
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
        RestTemplate restTemplate= restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity=
                restTemplate.postForEntity(genericProductUrl, genericProductDto, FakeStoreProductDto.class);

        return convertToGenericProductDto(responseEntity.getBody());
    }

    @Override
    public GenericProductDto updateProductById(Long id, GenericProductDto genericProductDto) {
        // getProductById + createProduct
        RestTemplate restTemplate= restTemplateBuilder.build();
        // getProductById
        ResponseEntity<FakeStoreProductDto> responseEntity =
                restTemplate.getForEntity(specificProductUrl, FakeStoreProductDto.class, id);
        GenericProductDto genericProductDto1= convertToGenericProductDto(responseEntity.getBody());

        // createProduct
        genericProductDto1.setTitle(genericProductDto.getTitle());
        genericProductDto1.setPrice(genericProductDto.getPrice());
        genericProductDto1.setCategory(genericProductDto.getCategory());
        genericProductDto1.setDescription(genericProductDto.getDescription());
        genericProductDto1.setImage(genericProductDto.getImage());

        ResponseEntity<FakeStoreProductDto> responseEntity1=
                restTemplate.postForEntity(genericProductUrl, genericProductDto1, FakeStoreProductDto.class);

        return convertToGenericProductDto(responseEntity1.getBody());
    }
}
