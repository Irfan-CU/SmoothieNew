package com.backend.CustomerRegistration.Entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Connection;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerEntity {

    private String firstName;
    private String lastName;
    private String email;
    private String password;

}
