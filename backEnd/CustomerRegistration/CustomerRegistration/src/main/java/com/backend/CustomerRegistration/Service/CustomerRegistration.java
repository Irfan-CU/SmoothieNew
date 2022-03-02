package com.backend.CustomerRegistration.Service;

import com.backend.CustomerRegistration.Entities.CustomerEntity;

import java.util.List;

public interface CustomerRegistration {

    CustomerEntity getCustomer(String email);
    void saveCustomer(CustomerEntity customerEntity);
    List<CustomerEntity> getAllCustomers();


}
