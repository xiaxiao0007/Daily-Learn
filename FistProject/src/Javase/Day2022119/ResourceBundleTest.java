package Javase.Day2022119;

import java.util.ResourceBundle;

/*
资源绑定器:读取属性配置文件里面的内容，
* */
public class ResourceBundleTest {
    public static void main(String[] args) {
        ResourceBundle bundle = ResourceBundle.getBundle("user");//里面的路径必须在类路径下，本质未路径 不需要写.后缀
        String className = bundle.getString("className");
        System.out.println(className);
    }
}
