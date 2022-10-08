package Javase.Day2022120;
/*
重点：给你一个类，怎么获取这个类的父类，已经实现了哪些接口？
* */
public class ReflectTest01 {
    public static void main(String[] args) throws Exception{
        //String
        Class stringClass = Class.forName("java.lang.String");

        //获取String的父类
        Class superClass = stringClass.getSuperclass();
        System.out.println(superClass.getName());

        //获取String所实现的接口
        Class[] interfaces = stringClass.getInterfaces();
        for (Class in:interfaces){
            System.out.println(in.getName());
        }
    }
}
