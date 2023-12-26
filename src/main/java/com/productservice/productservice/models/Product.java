package com.productservice.productservice.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Product extends BaseModel{
    private String title;
    private String description;
    private String image;

    //category isn't primitive attr it's relation
    @ManyToOne(optional = false)
    private Category category;


    @OneToOne(cascade = {CascadeType.REMOVE , CascadeType.PERSIST})
    private Price price;
    private int inventoryCount;
}
/*
    1           1
    product  : category
    m           1
    */
