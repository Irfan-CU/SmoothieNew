package com.backend.RestaurantProfile.Repository;

import com.backend.RestaurantProfile.Entity.MenuEntity;
import com.backend.RestaurantProfile.Entity.RestaurantEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface RestaurantProfileRepository  extends MongoRepository<RestaurantEntity, Long> {


    RestaurantEntity findByRestaurantUniqueID(String restaurantUniqueID);
    void deleteRestaurantByRestaurantUniqueID(String restaurantUniqueID);

}
