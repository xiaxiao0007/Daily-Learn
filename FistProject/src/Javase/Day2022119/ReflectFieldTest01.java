package Javase.Day2022119;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/*
反射属性Filed
反射Student
* */
public class ReflectFieldTest01 {
    public static void main(String[] args) throws Exception{
        Class studentClass = Class.forName("Javase.Day2022119.Student");
        //获取文件名称
        String className = studentClass.getName();
        System.out.println(className);
        //获取类中所有的public修饰的Filed
        Field[] fields = studentClass.getFields();
        System.out.println(fields.length);
        //取出这个Filed
        Field f = fields[0];
        //取出这个Field它的名字
        String fieldName = f.getName();
        System.out.println(fieldName);

        //获取所有的Field
        Field[] fs = studentClass.getDeclaredFields();
        System.out.println(fs.length);
        System.out.println("=========================");

        for (Field field:fs){
            //获取属性的修饰符列表
            int i = field.getModifiers();//返回的修饰符是一个数字，每个数字是修饰符代号！！！
            System.out.println(i);
            //可以将这个”代号“数字转换成”字符串“吗?可以的
            String modifierString = Modifier.toString(i);
            System.out.println(modifierString);
            //获取属性的类型
            Class c = field.getType();//返回的是Class类
            String cName = c.getName();
            System.out.println(cName);
            //获取属性的名字
            System.out.println(field.getName());
            System.out.println("=========================");
        }

    }
}

class Student{
    public int no;//是Field对象
    private String name;
    protected  int age;
    boolean sex;

}