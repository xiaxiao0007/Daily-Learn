package Javase.Day2022119;

import java.lang.reflect.Field;

/*
必须掌握
    怎么通过反射机制访问一个java对象的属性
        给属性赋值set
        获取属性的值get
* */
public class ReflectFieldTest02 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class studentClass = Class.forName("Javase.Day2022119.Student");
        Object obj = studentClass.newInstance();//无参构造方法
        //获取no属性(根据属性的名称来获取Field)
        Field noField = studentClass.getDeclaredField("no");
        noField.set(obj,222);
        //获取obj对象的no属性的值
        System.out.println(noField.get(obj));

        Field nameField = studentClass.getDeclaredField("name");
        nameField.setAccessible(true);//打破封装
        nameField.set(obj,"name");
        System.out.println(nameField.get(obj));
    }
}
