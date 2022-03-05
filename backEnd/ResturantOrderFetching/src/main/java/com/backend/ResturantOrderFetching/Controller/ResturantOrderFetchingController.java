package com.backend.ResturantOrderFetching.Controller;


import com.backend.ResturantOrderFetching.Entity.CustomerEntity;
import com.backend.ResturantOrderFetching.RabbitMQ.Config.MessageConfig;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/resturantOrderFetchingController")
public class ResturantOrderFetchingController {

    @GetMapping("/Controller")
    public String check(){
        return "restaurantOrderFetchingController is working";
    }

    @RabbitListener(bindings ={
               @QueueBinding(value =
               @Queue(value = MessageConfig.MACDONALDS_QUEUE), exchange = @Exchange(value = MessageConfig.EXCHANGE), key = {
                       MessageConfig.MACDONALDS_ROUTING_KEY
               })
    })
    public void Macdonaldslistner(CustomerEntity customerEntity){
        System.out.println("Macdonalds");
        System.out.println(customerEntity.toString());
    }


    @RabbitListener(bindings ={
            @QueueBinding(value =
            @Queue(value = MessageConfig.STARBUCKS_QUEUE), exchange = @Exchange(value = MessageConfig.EXCHANGE), key = {
                    MessageConfig.STARBUCKS_ROUTING_KEY
            })
    })
    public void Starbuckslistner(CustomerEntity customerEntity){
        System.out.println("Starbucks");
        System.out.println(customerEntity.toString());
    }


    @RabbitListener(bindings ={
            @QueueBinding(value =
            @Queue(value = MessageConfig.DOMINOS_QUEUE), exchange = @Exchange(value = MessageConfig.EXCHANGE), key = {
                    MessageConfig.DOMINOS_ROUTING_KEY
            })
    })
    public void Dominoslistner(CustomerEntity customerEntity){
        System.out.println(customerEntity.toString());
    }



    @RabbitListener(bindings ={
            @QueueBinding(value =
            @Queue(value = MessageConfig.PIZZAPIZZA_QUEUE), exchange = @Exchange(value = MessageConfig.EXCHANGE), key = {
                    MessageConfig.PIZZAPIZZA_ROUTING_KEY
            })
    })
    public void PizzaPizzalistner(CustomerEntity customerEntity){
        System.out.println(customerEntity.toString());
    }


}
