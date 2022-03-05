package com.backend.RestaurantProfile.Entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class MenuEntity {

    private String price;
    private String foodItemName;
    private String foodItemCode;
    private String tableNumber;
    private String quantity;
    private String size;

}
