package com.backend.CustomerFoodOrdering.domain;

import lombok.*;


@Data
@NoArgsConstructor
public class FoodOrderEntity {

    private String price;
    private String foodItemName;
    private String foodItemCode;
    private String tableNumber;
    private String quantity;
    private String size;
    private String restaurantName;


}
