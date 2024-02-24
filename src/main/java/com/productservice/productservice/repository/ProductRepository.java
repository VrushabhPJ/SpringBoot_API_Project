package com.productservice.productservice.repository;

import com.productservice.productservice.models.Product;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface ProductRepository extends JpaRepository<Product , UUID> {

    @Override
    List<Product> findAll();  //get all products

    List<Product> findAllByTitle(String title);

    List<Product> findAllByTitleContaining(String title, Pageable pageable);

    List<Product> findAllByTitleAndDescription(String title, String description);

    List<Product> findAllByPrice_ValueGreaterThan(Integer x);

    List<Product> findAllByPrice_ValueLessThan(Integer x);

    //@Query(value = "select * from product" , nativeQuery = true)
    List<Product> findAllByPrice_ValueBetween(Integer x, Integer y);

}
