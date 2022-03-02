package com.backend.CustomerFoodOrdering.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.LinkedList;
import java.util.List;

@Document("CustomerEntity")
@Data
@AllArgsConstructor
public class CustomerEntity {

    @Id
    private String customerName;
    private List<FoodOrderEntity> foodItems;


    public CustomerEntity() {
        this.customerName="";
        this.foodItems=new LinkedList<>();
    }

}