package com.backend.RestaurantProfile.Service;


import com.backend.RestaurantProfile.Entity.RestaurantEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RestaurantProfileService{



    void createRestaurantProfile(RestaurantEntity restaurantEntity);

    RestaurantEntity getRestaurant(String restaurantOwner, String restaurantAddress);

    List<RestaurantEntity> getAllRestaurants();

    RestaurantEntity editRestaurantMenu(RestaurantEntity restaurantEntity);

    void deleteRestaurant(String restaurantOwner, String restaurantAddress);

}
