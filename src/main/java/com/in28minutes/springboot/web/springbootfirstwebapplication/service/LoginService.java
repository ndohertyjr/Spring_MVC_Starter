package com.in28minutes.springboot.web.springbootfirstwebapplication.service;

import org.springframework.stereotype.Component;

@Component
public class LoginService {

    public boolean validateUser(String userid, String password) {
        //Check for valid user Neil, test
        return userid.equalsIgnoreCase("Neil") && password.equalsIgnoreCase("test");
    }
}
