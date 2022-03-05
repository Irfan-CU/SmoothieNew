package com.backend.RestaurantProfile.Entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Locale;

@Document("Restaurant")
@Data
public class RestaurantEntity {

    private String restaurantName;
    private String restaurantAddress;
    private String restaurantOwner;
    private String restaurantEmail;


    private String restaurantUniqueID;

    private List<MenuEntity> restaurantMenuList;



}
