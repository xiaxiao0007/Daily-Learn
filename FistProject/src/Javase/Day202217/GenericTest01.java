package Javase.Day202217;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/*
1.JDK5.0之后推出的新特性：泛型
2.泛型这种语法机制，只在程序编译阶段起作用，只是给编译器参考的。(运行阶段泛型没用)
3.使用泛型的好处是什么?
    第一：集合中存储的元素类型统一了
    第二：从集合中取出的元素类型是泛型指定的类型，不需要进行大量的“向下转型”！
4.泛型的缺点是什么？
    集合中的元素缺乏多样性
 */

public class GenericTest01 {
    public static void main(String[] args) {
        /*List list =new ArrayList();

        //准备对象
        Cat cat =new Cat();
        Bird bird =new Bird();

        //将对象添加到集合当中
        list.add(cat);
        list.add(bird);

        //遍历集合，取出Cat让他抓老鼠。
        Iterator it = list.iterator();
        while(it.hasNext()){
            Object obj = it.next();
        }*/

        //使用JDK5之后的泛型机制
        //使用泛型机制List<Animal>之后，表示List集合中只允许存储Animal类型的数据
        //用泛型来指定集合中存储的数据类型
        List<Animal> myList = new LinkedList<Animal>();
        //JDK8以后引入了：自动类型推断机制。(又称砖石表达式)
        //List<Animal> myList = new LinkedList<>();


        //准备对象
        Cat cat =new Cat();
        Bird bird =new Bird();

        //将对象添加到集合当中
        myList.add(cat);
        myList.add(bird);
        //获取迭代器
        //这个表示迭代器迭代的是Animal类型
        Iterator<Animal> it = myList.iterator();
        while(it.hasNext()) {
            Animal an = it.next();
            an.move();
        }
    }
}

class Animal{
    public void move(){
        System.out.println("走");
    }
}

class Cat extends Animal{
    public void catchMouse(){
        System.out.println("抓老鼠");
    }
}

class Bird extends Animal{
    public void fly(){
        System.out.println("fly");
    }
}