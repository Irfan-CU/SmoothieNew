package com.backend.CustomerRegistration.Controller;

import com.backend.CustomerRegistration.Entities.CustomerEntity;
import com.backend.CustomerRegistration.Service.CustomerRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/CustomerEntityController")
public class CustomerEntityController {

    @Autowired
    CustomerRegistration customerRegistration;

    @PostMapping("/addCustomer")
    public void addUser(@RequestBody CustomerEntity customerEntity){
//        var dataSource = new SimpleDriverDataSource();
//
//        dataSource.setDriver(new com.mysql.jdbc.Driver());
//        dataSource.setUrl("jdbc:mysql://localhost:3307/testdb");
//        dataSource.setUsername("root");
//        dataSource.setPassword("root");

//        var sql = "SELECT * FROM cars WHERE id=?";
//        Long id = 2L;

//        var jtm = new JdbcTemplate(dataSource);

//        List<Car> car = (Car) jtm.queryForObject(sql, new Object[]{id},
//                BeanPropertyRowMapper.newInstance(Car.class));
//
//        System.out.println(car);
//        return car;

        customerRegistration.saveCustomer(customerEntity);

    }

    @GetMapping("/getCustomer")
    public CustomerEntity getCustomer(@RequestParam String email){
        return customerRegistration.getCustomer(email);
    }


    @GetMapping("/getAllCustomer")
    public List<CustomerEntity> getAllCustomer(){
        return customerRegistration.getAllCustomers();
    }

}
