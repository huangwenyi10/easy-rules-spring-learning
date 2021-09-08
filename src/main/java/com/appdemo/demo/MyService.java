package com.appdemo.demo;

import org.springframework.stereotype.Component;

/**
 * @author  ay
 * @since 2021-09-07
 */
@Component
public class MyService {

    public  void setInfo(User user){
        user.setName("rongfengliang");
    }
}
