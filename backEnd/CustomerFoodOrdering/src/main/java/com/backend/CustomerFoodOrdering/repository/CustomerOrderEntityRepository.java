package com.backend.CustomerFoodOrdering.repository;

import com.backend.CustomerFoodOrdering.domain.CustomerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerOrderEntityRepository extends MongoRepository<CustomerEntity, String> {

//    @Query("{customerName:'?0'}")
    CustomerEntity findByCustomerName(String customerName);
    boolean existsByCustomerName(String customerName);
    Long deleteByCustomerName(String customerName);

}
