package Javase.Day202217;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
* 怎么将一个线程不安全的ArrayList集合转换成线程安全的呢?
*   使用集合工具类：java.util.Collections;
*
*   java.util.Collection 是集合接口
*   java.util.Collections 是集合工具类
* */
public class ArrayListTest01 {
    public static void main(String[] args) {
        List myList = new ArrayList();//非线程安全的
        //变成线程安全的
        Collections.synchronizedList(myList);
        //线程安全的
        myList.add("name");
        myList.add(11);//自动装箱

    }

}
