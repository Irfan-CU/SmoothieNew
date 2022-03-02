package com.backend.CustomerFoodOrdering.controller;


import com.backend.CustomerFoodOrdering.domain.CustomerEntity;
import com.backend.CustomerFoodOrdering.domain.FoodOrderEntity;
import com.backend.CustomerFoodOrdering.service.CustomerFoodOrdering;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/CustomerFoodOrderingController")
public class CustomerFoodOrderingController {

    private CustomerFoodOrdering customerFoodOrdering;
    @Autowired
    CustomerFoodOrderingController(CustomerFoodOrdering customerFoodOrdering){
        this.customerFoodOrdering = customerFoodOrdering;
    }

    @GetMapping(value = "/checking")
    public String checking (){
        return "Working Contorller";
    }

    @PostMapping(value = "/orderFood")
    public String orderFood(@RequestBody CustomerEntity customerEntity){
        return customerFoodOrdering.orderFood(customerEntity);
    }

    @GetMapping(value = "/getAllFoodOrderEntitiesStoredInDatabase")
    public List<CustomerEntity>getAllCustomers(){
        return customerFoodOrdering.getAllCustomers();
    }

    @GetMapping(value = "/getCustomer")
    public CustomerEntity getCustomer(@ RequestParam String customerName){
        CustomerEntity customerEntity = customerFoodOrdering.getCustomer(customerName);
        return customerEntity;
    }

    @PostMapping(value = "/deleteCustomer")
    public String deleteExistingCustomer(@RequestParam String customerName){
        return customerFoodOrdering.deleteExistingCustomer(customerName);
    }

    @PostMapping(value = "/deleteFoodOrderEntityForExistingCustomer")
    public String deleteFoodOrderEntityForExistingCustomer(@RequestBody CustomerEntity customerEntity){
        return customerFoodOrdering.deleteFoodOrderEntityForExistingCustomer(customerEntity);
    }

}
