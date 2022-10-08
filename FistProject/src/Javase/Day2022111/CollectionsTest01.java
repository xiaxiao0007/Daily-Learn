package Javase.Day2022111;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
java.util.Collections 集合工具类
对于set集合排序:先将set集合转换成List集合，通过List集合的构造方法传递Set集合
* */
public class CollectionsTest01 {
    public static void main(String[] args) {
        //ArrayList集合不是线程安全的
        List<String> list = new ArrayList<>();

        //变成线程安全的
        Collections.synchronizedList(list);

        list.add("name");

        //注意：对List集合中的元素排序，需要保证List集合中的元素实现了：Comparable接口中compareTo()方法
        Collections.sort(list);
    }
}
