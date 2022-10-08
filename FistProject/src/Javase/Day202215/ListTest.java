package Javase.Day202215;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
* List接口中常用方法
*   1.List集合存储元素的特点：有序可重复
*       有序：List集合中元素有下标
*       从0开始，以1递增
*       可重复：存储一个1，还可以再存储1
*   2.List既然时Collection接口的子接口，那么肯定List接口有自己“特色”的方法：以下只列List接口特有常用的1方法
*       void add(in index,E element)
*       E get(int index)
*       int indexOf(Object o)
*       int lastIndexOf(Object o)
*       E remove(int index)
*       E set(int index,E element)
* */
public class ListTest {
    public static void main(String[] args) {
        //创建List类型的集合对象
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add("name");

        //把元素添加到指定位置
        list.add(1,6);

        Iterator ite = list.iterator();
        while (ite.hasNext()){
            Object obj = ite.next();
            System.out.println(obj);
        }

        //根据下标获取元素
        Object o = list.get(2);
        System.out.println(o);

        //因为有下标，所以List集合有自己比较特殊的遍历方式
        //通过下标遍历。【List集合特有的方式，Set没有。】
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        //获取指定对象第一次出现的索引
        System.out.println(list.indexOf(2));
        //获取指定对象最后一次出现的索引
        System.out.println(list.lastIndexOf(2));

        //删除指定下标位置元素
        System.out.println(list.remove(1));

        //修改指定位置的元素
        Object o1 = list.set(1,10);
        System.out.println(list.get(1));

    }
}
