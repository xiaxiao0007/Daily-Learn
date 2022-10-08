package Javase.Day2022110;

import java.util.TreeSet;

/*
1.TreeSet集合底层实际上是一个TreeMap
2.TreeMap集合底层是一个二叉树
3.放到TreeSet集合中元素，等同于放到TreeMap集合key部分了
4.TreeSet集合中的元素：无序不可重复，但是可以按照元素的大小顺序自动排序。称为可排序集合
* */
/*
对于自定义的类型，TreeSet可以排序吗?
    需要指定自定义类型的排序规则
    需要实现一个接口Comparable
* */
public class TreeMapTest01 {
    public static void main(String[] args) {
        //创建一个TreeSet集合
        TreeSet<Integer> tree = new TreeSet<>();
        tree.add(1);
        tree.add(2);
        tree.add(3);
        for (Integer s:tree){
            System.out.println(s);
        }
    }
}
