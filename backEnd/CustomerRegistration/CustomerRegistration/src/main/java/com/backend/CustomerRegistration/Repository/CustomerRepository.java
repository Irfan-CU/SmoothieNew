package com.backend.CustomerRegistration.Repository;

import com.backend.CustomerRegistration.Entities.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepository implements ICustomerRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public CustomerRepository(){
        String sql = "SELECT * FROM customers WHERE email=?";

    }

    @Override
    public CustomerEntity getCustomer(String email){
        String sql = "SELECT * FROM customers WHERE email=?";
        Object[] param = new Object[]{email};
        return jdbcTemplate.queryForObject(sql,param, BeanPropertyRowMapper.newInstance(CustomerEntity.class));
    }

    @Override
    public void saveCustomer(CustomerEntity customerEntity){
        String sql = "INSERT INTO customers VALUES(?,?,?,?)";
        Object[] params = new Object[]{customerEntity.getFirstName(),customerEntity.getLastName(),customerEntity.getEmail(),customerEntity.getPassword()};
        jdbcTemplate.update(sql,params);
    }

    @Override
    public List<CustomerEntity> getAllCustomers(){
        String sql = "SELECT * from customers";
        return jdbcTemplate.query(sql,BeanPropertyRowMapper.newInstance(CustomerEntity.class));
    }







}
