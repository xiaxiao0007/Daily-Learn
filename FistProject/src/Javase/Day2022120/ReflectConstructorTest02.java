package Javase.Day2022120;

import java.lang.reflect.Constructor;

/*
通过反射机制创建对象
* */
public class ReflectConstructorTest02 {
    public static void main(String[] args) throws Exception{
        Class c = Class.forName("Javase.Day2022120.UserService");
        //调用无参数的构造方法
        Object object = c.newInstance();
        //调用有参数构造方法
        //第一步：先获取到这个有参数的构造方法
        Constructor constructor = c.getDeclaredConstructor(int.class,String.class,boolean.class);
        //第二步：调用构造方法new对象
        Object newObj = constructor.newInstance(110,"jackson",false);
        System.out.println(newObj);
    }
}
