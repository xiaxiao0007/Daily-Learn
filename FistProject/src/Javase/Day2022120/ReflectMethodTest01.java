package Javase.Day2022120;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/*
反射method
* */
public class ReflectMethodTest01 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class userServiceClass = Class.forName("Javase.Day2022120.UserService");

        //获取所有的Method(包括私有的)
        Method[] methods = userServiceClass.getDeclaredMethods();
        System.out.println(methods.length);

        //遍历Method
        for (Method method:methods){
            //获取修饰符列表
            System.out.println(Modifier.toString(method.getModifiers()));
            //获取方法的返回值类型
            System.out.println(method.getReturnType().getSimpleName());
            //获取方法名
            System.out.println(method.getName());
            //获取方法参数列表
            Class[] parameterTypes =method.getParameterTypes();
            for (Class parameterType:parameterTypes){
                System.out.println(parameterType.getSimpleName());
            }
        }
    }
}
