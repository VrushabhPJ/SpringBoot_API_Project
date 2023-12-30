package com.productservice.productservice.thirdPartyClients.fakestoreclient;

import com.productservice.productservice.dtos.FakeStoreProductDto;
import com.productservice.productservice.dtos.GenericProductDto;
import com.productservice.productservice.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class FakeStoreClient {
    private RestTemplateBuilder restTemplateBuilder;
    private String fakeStoreUrl;
    private String pathForProducts;
    private String specificProductUrl;
    private String genericProductUrl;

    FakeStoreClient(RestTemplateBuilder restTemplateBuilder ,
                    @Value("${fakestore.api.url}") String fakeStoreUrl,
                    @Value("${fakestore.api.paths.products}") String pathForProducts) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.genericProductUrl= fakeStoreUrl + pathForProducts;
        this.specificProductUrl= fakeStoreUrl + pathForProducts + "/{id}";

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


    public FakeStoreProductDto  getProductById(Long id) throws ProductNotFoundException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity =
                restTemplate.getForEntity(specificProductUrl, FakeStoreProductDto.class, id);

        FakeStoreProductDto fakeStoreProductDto= responseEntity.getBody();

        if(fakeStoreProductDto == null) {
            throw new ProductNotFoundException("Product id "+ id +" doesn't exist");
            //return null;
        }

        return fakeStoreProductDto;
    }

    public List<FakeStoreProductDto> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> responseEntity =
                restTemplate.getForEntity(genericProductUrl , FakeStoreProductDto[].class);

        List<FakeStoreProductDto> fakeStoreProductDtos= List.of(responseEntity.getBody());

        return fakeStoreProductDtos;
    }

    public FakeStoreProductDto deleteProductById(Long id) {
        RestTemplate restTemplate= restTemplateBuilder.build();

        /*Delete() doesn't return anything, so we implement by using postForEntity() we just change
        ResponseEntity<FakeStoreProductDto>, "HttpMethod.DELETE"  */
        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor =
                restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> responseEntity=
                restTemplate.execute(specificProductUrl, HttpMethod.DELETE, requestCallback, responseExtractor, id);

        return responseEntity.getBody();
    }


    public FakeStoreProductDto createProduct(GenericProductDto genericProductDto) {
        RestTemplate restTemplate= restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity=
                restTemplate.postForEntity(genericProductUrl, genericProductDto, FakeStoreProductDto.class);

        return responseEntity.getBody();
    }

    public FakeStoreProductDto updateProductById(Long id, GenericProductDto genericProductDto) {
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

        return responseEntity1.getBody();
    }
}
