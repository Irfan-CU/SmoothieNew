package com.backend.RestaurantProfile.Service;


import com.backend.RestaurantProfile.Entity.MenuEntity;
import com.backend.RestaurantProfile.Entity.RestaurantEntity;
import com.backend.RestaurantProfile.Repository.RestaurantProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class RestaurantProfileServiceImpl implements RestaurantProfileService{

    @Autowired
    RestaurantProfileRepository restaurantProfileRepository;

    @Override
    public void createRestaurantProfile(RestaurantEntity restaurantEntity) {
        restaurantEntity.setRestaurantUniqueID(restaurantEntity.getRestaurantOwner()
                .concat(restaurantEntity.getRestaurantAddress()).toLowerCase(Locale.ROOT));
        RestaurantEntity restaurantEntity_tmp = getRestaurant(restaurantEntity.getRestaurantOwner(),restaurantEntity.getRestaurantAddress());
        if (restaurantEntity_tmp==null){
            restaurantProfileRepository.save(restaurantEntity);
        }

    }

    @Override
    public RestaurantEntity getRestaurant(String restaurantOwner, String restaurantAddress) {
        String restaurantUniqueID = restaurantOwner.concat(restaurantAddress).toLowerCase(Locale.ROOT);
        return restaurantProfileRepository.findByRestaurantUniqueID(restaurantUniqueID);
    }

    @Override
    public List<RestaurantEntity> getAllRestaurants() {
        return restaurantProfileRepository.findAll();
    }


    @Override
    public RestaurantEntity editRestaurantMenu(RestaurantEntity restaurantEntity) {
        RestaurantEntity restaurantEntity_tmp = getRestaurant(restaurantEntity.getRestaurantOwner(), restaurantEntity.getRestaurantAddress());
        if (restaurantEntity_tmp!=null){
            for (MenuEntity menuEntity : restaurantEntity.getRestaurantMenuList()){
                restaurantEntity_tmp.getRestaurantMenuList().removeIf(item -> item.getFoodItemName().equalsIgnoreCase(menuEntity.getFoodItemName()));
                restaurantEntity_tmp.getRestaurantMenuList().add(menuEntity);
            }
            restaurantProfileRepository.deleteRestaurantByRestaurantUniqueID(restaurantEntity_tmp.getRestaurantUniqueID());
            restaurantProfileRepository.save(restaurantEntity_tmp);
            return restaurantEntity;
        }
        return null;
    }


    @Override
    public void deleteRestaurant(String restaurantOwner, String restaurantAddress) {
        RestaurantEntity restaurantEntity_tmp = getRestaurant(restaurantOwner, restaurantAddress);
        if (restaurantEntity_tmp!=null) {
            restaurantProfileRepository.deleteRestaurantByRestaurantUniqueID(restaurantEntity_tmp.getRestaurantUniqueID());
        }

    }
}
