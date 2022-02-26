package com.backend.CustomerFoodOrdering.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FoodOrderEntity {

    private String price;
    private String foodItemName;
    private String foodItemCode;
    private String tableNumber;
    private String quantity;


    @Override
    public String toString() {
        return "ItemEntity{" +
                ", price='" + price + '\'' +
                ", foodItemName='" + foodItemName + '\'' +
                ", FoodItemCode='" + foodItemCode + '\'' +
                ", tableNumber='" + tableNumber + '\'' +
                '}';
    }
}
