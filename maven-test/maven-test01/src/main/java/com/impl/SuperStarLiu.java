package com.impl;

import com.service.Service;
/*
*  目标对象
* */
public class SuperStarLiu implements Service {

    @Override
    public void sing() {
        System.out.println("唱歌");
    }
}
