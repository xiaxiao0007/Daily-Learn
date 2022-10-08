package Javase.Day202217;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/*
JDK5.0之后推出的了一个新特性，叫做增强for循环，或者叫做for each
* */
public class ForEachTest01 {
    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,5};

        //遍历数组(普通for循环)
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

        //增强for循环(for each)
        //以下是语法
        /*for(元素类型 变量名:数组或集合实现迭代器接口的集合){

        }*/
        //foreach有一个缺点：没有下标。在需要使用下标的循环中，不建议使用foreach循环
        for(int data : a){
            //data是数组中的具体元素
            System.out.println(data);
        }

        List<String> list =new LinkedList<>();
        list.add("my");
        list.add("name");
        list.add("is");
        list.add("==============================");

        //遍历，迭代器遍历
        Iterator<String> it = list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        //普通for循环遍历
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        //增强foreach循环
        for(String s:list){
            System.out.println(s);
        }
    }
}
