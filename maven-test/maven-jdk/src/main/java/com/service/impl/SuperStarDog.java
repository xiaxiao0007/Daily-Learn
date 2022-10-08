package com.service.impl;

import com.service.Service;

public class SuperStarDog implements Service {

    @Override
    public void sing() {
        System.out.println("我是大狗，狗叫一声");
    }

    @Override
    public void show() {
        System.out.println("我是大狗，在奔跑");
    }
}
