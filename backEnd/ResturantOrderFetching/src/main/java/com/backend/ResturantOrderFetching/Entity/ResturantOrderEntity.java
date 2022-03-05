package com.backend.ResturantOrderFetching.Entity;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResturantOrderEntity {

    private String price;
    private String foodItemName;
    private String foodItemCode;
    private String tableNumber;
    private String quantity;
    private String size;
    private String restaurantName;



}
