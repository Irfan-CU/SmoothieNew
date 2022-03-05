package com.backend.CustomerFoodOrdering.controller;


import com.backend.CustomerFoodOrdering.RabbitMQ.Config.MessageConfig;
import com.backend.CustomerFoodOrdering.domain.CustomerEntity;
import com.backend.CustomerFoodOrdering.domain.FoodOrderEntity;
import com.backend.CustomerFoodOrdering.service.CustomerFoodOrdering;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/CustomerFoodOrderingController")
public class CustomerFoodOrderingController {

    private CustomerFoodOrdering customerFoodOrdering;
    private RabbitTemplate rabbitTemplate;
    @Autowired
    CustomerFoodOrderingController(CustomerFoodOrdering customerFoodOrdering, RabbitTemplate rabbitTemplate){
        this.customerFoodOrdering = customerFoodOrdering;
        this.rabbitTemplate = rabbitTemplate;
    }

    @GetMapping(value = "/checking")
    public String checking (){
        return "Working Controller";
    }

    @PostMapping(value = "/orderFood")
    public String orderFood(@RequestBody CustomerEntity customerEntity, @RequestParam String resturantName){
//      customerFoodOrdering.orderFood(customerEntity);
        if (resturantName.equalsIgnoreCase("Starbucks")){
            rabbitTemplate.convertAndSend(MessageConfig.EXCHANGE ,MessageConfig.STARBUCKS_ROUTING_KEY ,customerEntity);
        }
        if (resturantName.equalsIgnoreCase("Macdonalds")){
            rabbitTemplate.convertAndSend(MessageConfig.EXCHANGE ,MessageConfig.MACDONALDS_ROUTING_KEY ,customerEntity);
        }
        if (resturantName.equalsIgnoreCase("dominos")){
            rabbitTemplate.convertAndSend(MessageConfig.EXCHANGE ,MessageConfig.DOMINOS_ROUTING_KEY ,customerEntity);
        }
        if (resturantName.equalsIgnoreCase("pizzapizza")){
            rabbitTemplate.convertAndSend(MessageConfig.EXCHANGE ,MessageConfig.PIZZAPIZZA_ROUTING_KEY ,customerEntity);
        }
        return "Success";
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
