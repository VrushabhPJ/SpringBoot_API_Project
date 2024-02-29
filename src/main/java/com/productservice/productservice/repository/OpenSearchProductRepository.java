package com.productservice.productservice.repository;

import com.productservice.productservice.models.Product;
import org.springframework.data.domain.Pageable;
//import org.springframework.data.elasticsearch.core.RefreshPolicy;
//import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;
import java.util.Optional;

//@EnableJpaRepositories
//public interface OpenSearchProductRepository extends ElasticsearchRepository<Product, Long> {
//    @Override
//    Iterable<Product> findAll();
//
//    @Override
//    Optional<Product> findById(Long aLong);
//
//    @Override
//    <S extends Product> S save(S entity, RefreshPolicy refreshPolicy);
//
//    List<Product> findAllByTitleContainingIgnoreCase(String title, Pageable pageable);
//}
