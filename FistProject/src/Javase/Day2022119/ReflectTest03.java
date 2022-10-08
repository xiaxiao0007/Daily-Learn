package Javase.Day2022119;

import java.io.FileReader;
import java.util.Properties;

/*
验证反射机制的灵活性
* */
public class ReflectTest03 {
    public static void main(String[] args) throws Exception  {
        //创建IO流，并通过IO流读取user.properties
        FileReader reader = new FileReader("D:\\Java\\IdealProject\\FistProject\\src\\user.properties");

        //创建属性类对象Map
        Properties pro = new Properties();//key value都是String
        //加载
        pro.load(reader);
        //关闭流
        reader.close();

        //通过key获取value
        String className = pro.getProperty("className");

        //通过反射机制实例化对象
        Class c = Class.forName(className);
        Object obj = c.newInstance();
        System.out.println(obj);

        /*
        String str = new String();
        System.out.println(str);
        * */

    }
}
