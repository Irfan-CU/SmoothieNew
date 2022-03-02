package com.backend.CustomerRegistration.Repository;

import com.backend.CustomerRegistration.Entities.CustomerEntity;

import java.util.List;

public interface ICustomerRepository {

    CustomerEntity getCustomer(String email);
    void saveCustomer(CustomerEntity customerEntity);
    List<CustomerEntity> getAllCustomers();


}
