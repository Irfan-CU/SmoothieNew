package com.backend.ResturantOrderFetching.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;




import java.util.LinkedList;
import java.util.List;


@AllArgsConstructor
@Data
public class CustomerEntity {

    private String customerName;
    private List<ResturantOrderEntity> foodItems;



    public CustomerEntity() {
        this.customerName="";
        this.foodItems=new LinkedList<>();
    }

}