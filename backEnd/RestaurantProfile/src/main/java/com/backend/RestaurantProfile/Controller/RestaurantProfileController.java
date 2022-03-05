package com.backend.RestaurantProfile.Controller;

import com.backend.RestaurantProfile.Entity.RestaurantEntity;
import com.backend.RestaurantProfile.Service.RestaurantProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping(value = "/RestaurantProfile")
public class RestaurantProfileController {


    private RestaurantProfileService restaurantProfileService;

    @Autowired
    RestaurantProfileController (RestaurantProfileService restaurantProfileService){
        this.restaurantProfileService = restaurantProfileService;
    }

    @GetMapping("/Controller")
    public String check(){
        return "RestaurantProfileController is accessible";
    }


    @PostMapping(value = "/createRestaurant")
    public void createRestaurantProfile(@RequestBody RestaurantEntity restaurantEntity){
        restaurantProfileService.createRestaurantProfile(restaurantEntity);
    }

    @GetMapping(value = "/getRestaurant")
    public RestaurantEntity getRestaurant(@RequestParam String restaurantOwner,@RequestParam String restaurantAddress){
        return restaurantProfileService.getRestaurant(restaurantOwner,restaurantAddress);
    }

    @GetMapping(value = "/getAllRestaurant")
    public List<RestaurantEntity> getAllRestaurant(){
        return restaurantProfileService.getAllRestaurants();
    }

    @PutMapping(value = "/editRestaurantMenu")
    public void editRestaurantMenu(@RequestBody RestaurantEntity restaurantEntity){
        restaurantProfileService.editRestaurantMenu(restaurantEntity);
    }

    @DeleteMapping(value = "/deleteRestaurant")
    public void deleteRestaurant(@RequestParam String restaurantOwner,@RequestParam String restaurantAddress){
        restaurantProfileService.deleteRestaurant(restaurantOwner,restaurantAddress);
    }

}
