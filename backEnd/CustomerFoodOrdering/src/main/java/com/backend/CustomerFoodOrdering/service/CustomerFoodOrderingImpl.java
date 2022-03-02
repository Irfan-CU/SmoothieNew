package com.backend.CustomerFoodOrdering.service;

import com.backend.CustomerFoodOrdering.domain.CustomerEntity;
import com.backend.CustomerFoodOrdering.domain.FoodOrderEntity;
import com.backend.CustomerFoodOrdering.repository.CustomerOrderEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerFoodOrderingImpl implements CustomerFoodOrdering{


    private CustomerOrderEntityRepository foodOrderEntityRepository;

    @Autowired
    CustomerFoodOrderingImpl(CustomerOrderEntityRepository foodOrderEntityRepository){
        this.foodOrderEntityRepository = foodOrderEntityRepository;
    }


    public CustomerEntity addNewCustomer(String customerName, List<FoodOrderEntity> foodOrderEntity) {
        CustomerEntity customerEntity = new CustomerEntity(customerName,foodOrderEntity);
        return  customerEntity;
    }

    public void saveCustomer(CustomerEntity customerEntity) {
        this.foodOrderEntityRepository.save(customerEntity);
    }

    public List<FoodOrderEntity> getCustomerFoodOrderEntityList(CustomerEntity customerEntity){
        return customerEntity.getFoodItems();
    }



    public CustomerEntity checkIfCustomerExist(String customerName){
        if (foodOrderEntityRepository.existsByCustomerName(customerName)){
            return foodOrderEntityRepository.findByCustomerName(customerName);
        }else{
            return null;
        }
    }


    public void addFoodOrderEntityToCustomerDatabase(String customerName, List<FoodOrderEntity> foodOrderEntity) {
        CustomerEntity cE =  foodOrderEntityRepository.findByCustomerName(customerName);
        if (cE!=null){
            for (FoodOrderEntity item:foodOrderEntity){
                cE.getFoodItems().add(item);
            }
            saveCustomer(cE);
        }
        else{
            cE = this.addNewCustomer(customerName,foodOrderEntity);
            saveCustomer(cE);
        }
    }

    @Override
    public String deleteExistingCustomer(String customerName){
        CustomerEntity cE = checkIfCustomerExist(customerName);
        if (cE!=null){
            foodOrderEntityRepository.deleteByCustomerName(customerName);
            return "Delete customer";
        }else{
            return "Cannot delete a customer that does not exist!";
        }
    }

    @Override
    public String deleteFoodOrderEntityForExistingCustomer(CustomerEntity customerEntity){
        CustomerEntity cE = checkIfCustomerExist(customerEntity.getCustomerName());
        if (cE!=null){
            for (FoodOrderEntity fE: customerEntity.getFoodItems()){
                cE.getFoodItems().removeIf(item -> item.getFoodItemName().equalsIgnoreCase(fE.getFoodItemName()));
            }
            saveCustomer(cE);
            return "Deleted Food Item for the Customer";
        }else{
            return "Cannot delete a Food Item for a customer that does not exist!";
        }
    }






    @Override
    public List<CustomerEntity> getAllCustomers() {
       return this.foodOrderEntityRepository.findAll();
    }

    @Override
    public CustomerEntity getCustomer(String customerName) {
       return checkIfCustomerExist(customerName);
    }



    @Override
    public String orderFood(CustomerEntity customerEntity) {
        this.addFoodOrderEntityToCustomerDatabase(customerEntity.getCustomerName(),customerEntity.getFoodItems());
        // Should generate a RabbitMQ message
        return "OrderedFood";
    }


}
