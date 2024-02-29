package com.productservice.productservice.services;

import com.productservice.productservice.dtos.FakeStoreProductDto;
import com.productservice.productservice.dtos.GenericProductDto;
import com.productservice.productservice.exceptions.ProductNotFoundException;
import com.productservice.productservice.security.JWTObject;
import com.productservice.productservice.security.TokenValidator;
import com.productservice.productservice.thirdPartyClients.fakestoreclient.FakeStoreClient;
import org.antlr.v4.runtime.Token;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Primary
@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{

    private final FakeStoreClient fakeStoreClient;
    private TokenValidator tokenValidator;
    private RedisTemplate<String, FakeStoreProductDto> redisTemplate;

    FakeStoreProductService(FakeStoreClient fakeStoreClient, TokenValidator tokenValidator, RedisTemplate redisTemplate) {
        this.fakeStoreClient= fakeStoreClient;
        this.tokenValidator= tokenValidator;
        this.redisTemplate= redisTemplate;
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
    public GenericProductDto getProductById(String authToken, Long id) throws ProductNotFoundException {

        //System.out.println(authToken);
        Optional<JWTObject> jwtObjectOptional= tokenValidator.validateToken(authToken);

//        if(jwtObjectOptional.isEmpty()) {
//            //reject the request
//            return null;
//        }

        FakeStoreProductDto fakeStoreProductDto = (FakeStoreProductDto) redisTemplate.opsForHash().get("PRODUCTS", id);
        if (fakeStoreProductDto != null) {
            return convertToGenericProductDto(fakeStoreProductDto);
        }

        fakeStoreProductDto = fakeStoreClient.getProductById(id);
        redisTemplate.opsForHash().put("PRODUCTS", id, fakeStoreProductDto);

        return convertToGenericProductDto(fakeStoreProductDto);
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
