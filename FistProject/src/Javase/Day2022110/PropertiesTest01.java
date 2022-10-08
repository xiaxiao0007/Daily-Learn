package Javase.Day2022110;

import java.util.Properties;

/*
目前只需要掌握properties属性类对象的相关方法即可
Properties是Map集合，继承Hashtable，Properties的key和value都是String类型。Properties被称为属性对象
Properties是线程安全的
* */
public class PropertiesTest01 {
    public static void main(String[] args) {
        Properties properties = new Properties();
        //需要掌握Properties的两个方法，一个存，一个取
        properties.setProperty("url","www.baidu.com");
        properties.setProperty("username","root");
        properties.setProperty("password","123");
        //通过key获取value
        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
    }
}
