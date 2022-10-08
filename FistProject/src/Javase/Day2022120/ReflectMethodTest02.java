package Javase.Day2022120;

import java.lang.reflect.Method;

/*
重点：必须掌握，通过反射机制怎么调用方法
反射机制，让代码很具有通用性，可变化的内容都是写道到配置文件当中，将来修改配置文件之后，创建的对象就不一样了，
调用的方法也就不同了，但是java代码不需要做任何改动
* */
public class ReflectMethodTest02 {
    public static void main(String[] args) throws Exception {
        //使用反射机制来调用一个对象的方法
        Class userService = Class.forName("Javase.Day2022120.UserService");
        //创建对象
        Object object = userService.newInstance();
        //获取Method
        Method loginMethod = userService.getDeclaredMethod("login",String.class,String.class);
        Object retValue = loginMethod.invoke(object,"admin","123");
        System.out.println(retValue);
    }
}
