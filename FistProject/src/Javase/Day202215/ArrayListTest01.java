package Javase.Day202215;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/*
1.ArrayList集合初始化容量是10(底层先创建一个长度为0数组，当添加第一个元素的时候，初始化容量为10)
2.ArrayList集合的底层是Object类型的数组 Object[]
3.构造方法：new ArrayList(); new ArrayList(20);
4.ArrayList集合的扩容
    原容量的1.5倍
    ArrayList集合底层是数组，怎么优化?
        尽可能少的扩容。因为数组扩容效率比较低，建议使用ArrayList集合的时候预估计元素的个数，给定一个初始化容量
5.数组的优点
    检索效率比较高
6.数组的缺点
    随机增删元素效率比较低
7.向数组末尾添加元素，效率很高，不搜影响
8.这么多集合中，ArrayList集合用的多
9.非线程安全的
* */
public class ArrayListTest01 {
    public static void main(String[] args) {

        //默认初始化容量为10
        List list1 = new ArrayList();
        //集合size()方法是获取当前集合种元素的个数，不是获取集合的容量
        System.out.println(list1.size());
        //容量为20
        List list2 = new ArrayList(20);

        //创建一个HashSet集合
        Collection c = new HashSet();
        c.add(123);
        c.add(456);
        c.add("name");
        //通过这个构造方法就可以将HashSet集合转换成List集合。
        List myList = new ArrayList(c);
        for (int i = 0; i < myList.size(); i++) {
            System.out.println(myList.get(i));
        }

    }
}
