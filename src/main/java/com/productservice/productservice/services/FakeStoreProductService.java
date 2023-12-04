package com.productservice.productservice.services;

import com.productservice.productservice.dtos.FakeStoreProductDto;
import com.productservice.productservice.dtos.GenericProductDto;
import com.productservice.productservice.exceptions.ProductNotFoundException;
import com.productservice.productservice.thirdPartyClients.fakestoreclient.FakeStoreClient;
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

    private final FakeStoreClient fakeStoreClient;
    FakeStoreProductService(FakeStoreClient fakeStoreClient) {
        this.fakeStoreClient= fakeStoreClient;

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

        return convertToGenericProductDto(fakeStoreClient.getProductById(id));
    }

    @Override
    public List<GenericProductDto> getAllProducts() {

        List<FakeStoreProductDto> fakeStoreProductDtos= fakeStoreClient.getAllProducts();
        List<GenericProductDto> result =new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {
            result.add( convertToGenericProductDto(fakeStoreProductDto) );
        }

        return result;
    }

    @Override
    public GenericProductDto deleteProductById(Long id) {


        /*Delete() doesn't return anything, so we implement by using postForEntity() we just change
        ResponseEntity<FakeStoreProductDto>, "HttpMethod.DELETE"  */
        return convertToGenericProductDto(fakeStoreClient.deleteProductById(id));
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {

        return convertToGenericProductDto(fakeStoreClient.createProduct(genericProductDto));
    }

    @Override
    public GenericProductDto updateProductById(Long id, GenericProductDto genericProductDto) {
        // getProductById + createProduct
        // getProductById

        // createProduct

        return convertToGenericProductDto(fakeStoreClient.updateProductById(id, genericProductDto));
    }
}
