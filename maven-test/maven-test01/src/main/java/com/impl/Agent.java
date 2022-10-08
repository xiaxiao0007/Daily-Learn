package com.impl;

import com.service.Service;
/*
*  代理对象
* */
public class Agent implements Service {

    // 类中成员变量设计为接口
    public Service target;

    // 传入目标对象，方法的参数设计为接口
    public Agent(Service target){
        this.target = target;
    }

    @Override
    public void sing() {
        System.out.println("谈合同");

        // SuperStarLiu liu = new SuperStarLiu();
        // liu.sing();

        // 改进：面向接口编程：调用时，接口指向实现类
        target.sing();

        System.out.println("结算费用");
    }
}
