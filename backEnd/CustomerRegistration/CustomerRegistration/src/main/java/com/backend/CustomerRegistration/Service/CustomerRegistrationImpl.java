package com.backend.CustomerRegistration.Service;

import com.backend.CustomerRegistration.Entities.CustomerEntity;
import com.backend.CustomerRegistration.Repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerRegistrationImpl implements CustomerRegistration{

    @Autowired
    ICustomerRepository iCustomerRepository;

    @Override
    public CustomerEntity getCustomer(String email) {
        return iCustomerRepository.getCustomer(email);
    }

    @Override
    public void saveCustomer(CustomerEntity customerEntity) {
        iCustomerRepository.saveCustomer(customerEntity);
    }

    @Override
    public List<CustomerEntity> getAllCustomers() {
        return iCustomerRepository.getAllCustomers();
    }
}
