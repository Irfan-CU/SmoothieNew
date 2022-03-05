package com.backend.ResturantOrderFetching.RabbitMQ.Config;


import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageConfig {

    public static final String MACDONALDS_QUEUE = "macdonalds_message_queue";
    public static final String STARBUCKS_QUEUE = "starbucks_message_queue";
    public static final String DOMINOS_QUEUE = "dominos_message_queue";
    public static final String PIZZAPIZZA_QUEUE = "pizzapizza_message_queue";
    public static final String EXCHANGE = "message_exchange";
    public static final String MACDONALDS_ROUTING_KEY = "macdonalds_message_routingKey";
    public static final String STARBUCKS_ROUTING_KEY = "starbucks_message_routingKey";
    public static final String DOMINOS_ROUTING_KEY = "dominos_message_routingKey";
    public static final String PIZZAPIZZA_ROUTING_KEY = "pizzapizza_message_routingKey";


    @Bean
    public Queue macdonaldsQueue() {
        return  new Queue(MACDONALDS_QUEUE,true, false, false);
    }

    @Bean
    public Queue starbucksQueue() {
        return  new Queue(STARBUCKS_QUEUE,true, false, false);
    }


    @Bean
    public Queue dominosQueue() {
        return  new Queue(DOMINOS_QUEUE,true, false, false);
    }

    @Bean
    public Queue pizzaPizzaQueue() {
        return  new Queue(PIZZAPIZZA_QUEUE,true, false, false);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(EXCHANGE);
    }

    @Bean
    public Binding MacdonaldsBinding(Queue macdonaldsQueue, TopicExchange exchange) {
        return BindingBuilder
                .bind(macdonaldsQueue)
                .to(exchange)
                .with(MACDONALDS_ROUTING_KEY);
    }

    @Bean
    public Binding StarbucksBinding(Queue starbucksQueue, TopicExchange exchange) {
        return BindingBuilder
                .bind(starbucksQueue)
                .to(exchange)
                .with(STARBUCKS_ROUTING_KEY);
    }

    @Bean
    public Binding DominosBinding(Queue dominosQueue, TopicExchange exchange) {
        return BindingBuilder
                .bind(dominosQueue)
                .to(exchange)
                .with(DOMINOS_ROUTING_KEY);
    }

    @Bean
    public Binding PizzaPizzaBinding(Queue pizzaPizzaQueue, TopicExchange exchange) {
        return BindingBuilder
                .bind(pizzaPizzaQueue)
                .to(exchange)
                .with(PIZZAPIZZA_ROUTING_KEY);
    }


    @Bean
    public MessageConverter messageConverter() {
        return  new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(messageConverter());
        return  template;
    }
}
