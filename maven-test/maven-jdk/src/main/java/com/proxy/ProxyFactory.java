package com.proxy;

import com.service.Service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {

    // 类中国的成员变量设计为接口，目标对象
    Service target;

    public ProxyFactory(Service target) {
        this.target = target;
    }

    // 创建动态代理对象
    // 返回动态代理对象
    public Object getAgent(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy,//  创建代理对象
                                         Method method,// method就是目标方法sing(),show()
                                         Object[] args// 目标方法参数
                    ) throws Throwable {
                        // 代理功能
                        System.out.println("谈合同");

                        // 业务功能实现
                        Object invoke = method.invoke(target, args);


                        // 代理功能
                        System.out.println("费用结算");
                        return invoke;
                    }
                });
    }
}
