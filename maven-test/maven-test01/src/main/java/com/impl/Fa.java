package com.impl;

import com.service.Service;

public class Fa implements Service {

    @Override
    public void sing(){
        System.out.println("我是大猫，猫叫了两声");
    }
}
