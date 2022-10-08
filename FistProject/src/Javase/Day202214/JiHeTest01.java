package Javase.Day202214;

import java.util.ArrayList;
import java.util.Collection;

/*
类在强制类型转换过程中，如果是类转换成接口类型，那么类和接口之间不需要存在继承关系，也可以转换。
 */
/*
【非常得重要】
1.集合概述(集合也是一个对象)【所有的集合都是课迭代】
    1.1 什么是集合？有什么用？
        数组其实就是一个集合。集合实际上就是一个容器。可以来容纳其它类型得数据。
        集合起到承载得作用。
    1.2 集合不能直接存储基本数据类型，另外集合不能直接存储Java对象，集合在当中存储得都是Java对象得内存地址。
        (或者说集合中存储引用)
    1.3 在Java中每一个不同得集合，底层会对应不同的数据结构，往不同的集合中存储元素，等于将数据放到了不同的
        数据结构当中。
        new ArrayList();底层是数组
    1.4 集合在Java JDK 中那个包下？
        java.util.*
            所有的集合类和集合接口都在Java.util包下
    1.5 集合的继承结构图
    1.6 在Java中集合分为两大类
        一类是单个方式存储元素：
            单个方式存储元素，这一类集合中超级父接口：java.util.Collection
        一类是以键值对儿的方式存储元素
            以键值对的方式存储元素，这一类集合中超级父接口：java.util.Map
 */
/*
* 关于java.util.Collection接口中常用的方法。
*   1.Collection中能存放什么元素？
*       没有使用“泛型”之前，Collection中可以存储Object的所有子类。是使用“泛型”之后，
*       Collection中只能存储某个具体的类型。
*   2.Collection接口中常用的方法
*       boolean add(Object e) 向集合中添加元素
*       int size() 获取集合中元素的个数
*       void clear() 清空集合
*       boolean contains(Object e) 判断当前集合中是否包含元素e，包含返回true，不包含返回false
*       boolean remove(Object e) 删除集合中的e元素
*       boolean isEmpty() 判断集合是否为空，为空返回true，不为空返回false
*       【了解】Object[] toArray() 调用这个方法可以把集合转换成数组
* */
/*
* 关于contains()方法源码的分析
*   在contains()源码的底层调用了equals()方法
* 结论：存放在一个集合中的类型，一定要重写equals()方法。
* */
public class JiHeTest01 {
    public static void main(String[] args) {
        //多态，父类型的引用指向子类型的对象
        Collection collection = new ArrayList();
        //测试Collection接口中的常用方法
        //向集合中添加元素
        collection.add(120);//自动装箱，实际上存放120的内存地址
        collection.add(1300);
        //返回集合中元素的个数
        System.out.println(collection.size());
        collection.add("钢铁侠");
        collection.add("美国队长");
        System.out.println(collection.contains("钢铁侠"));
        //删除集合中的某个元素
        collection.remove(1300);
        System.out.println(collection.size());
        //判断集合是否为空
        System.out.println(collection.isEmpty());
        //清空集合中所有的元素
        collection.clear();
        System.out.println(collection.isEmpty());
        //把集合转换成数组
        collection.add(1);
        collection.add("name");//字符串和Integer都重写toString()方法
        Object[] objects = collection.toArray();
        for (int i = 0; i < objects.length; i++) {
            System.out.println(objects[i]);
        }

        /*List list = new ArrayList();
        list.add(100);
        list.add(1,120);
        System.out.println(list.get(0));*/
    }
}
