package com.backend.CustomerFoodOrdering.service;

import com.backend.CustomerFoodOrdering.domain.CustomerEntity;
import com.backend.CustomerFoodOrdering.domain.FoodOrderEntity;

import java.util.List;

public interface CustomerFoodOrdering {

    List<CustomerEntity> getAllCustomers();
    CustomerEntity getCustomer(String customerName);
    String orderFood(CustomerEntity customerEntity);
    String deleteFoodOrderEntityForExistingCustomer(CustomerEntity customerEntity);
    String deleteExistingCustomer(String customerName);
}
