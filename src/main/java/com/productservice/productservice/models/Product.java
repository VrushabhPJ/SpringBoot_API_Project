package com.productservice.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel{
    private String title;
    private String description;
    private String image;

    //category isn't primitive attr it's relation
    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Category category;

    /*
    1           1
    product  : category
    m           1
    */
    @OneToOne(optional = false)
    @JoinColumn(nullable = false)
    private Price price;
}
