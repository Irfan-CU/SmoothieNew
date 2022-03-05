package com.backend.CustomerFoodOrdering.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.LinkedList;
import java.util.List;

@Document("CustomerEntity")
@AllArgsConstructor
@Getter
@Setter
public class CustomerEntity {

    @Id
    private String customerName;
    private List<FoodOrderEntity> foodItems;


    public CustomerEntity() {
        this.customerName="";
        this.foodItems=new LinkedList<>();
    }

}