package com.service.impl;

import com.service.Service;

public class SuperStarLiu implements Service {

    @Override
    public void sing() {
        System.out.println("我是大猫，猫叫两声");
    }

    @Override
    public void show() {
        System.out.println("我是大猫，在走猫步");
    }
}
