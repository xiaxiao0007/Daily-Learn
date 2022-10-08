package xia.xiao.proxy5;

/*
* 目标对象：代理对象
* */

public interface Service {

    // 规定业务的功能
    void buy();

    // 增加有参数有返回值的方法测试代理功能
    default String show(int age){return null;}
}