package Javase.Day2022111;

import java.util.Comparator;
import java.util.TreeSet;

/*
TreeSet集合中元素可排序的第二种方式:使用比较器的方式
最终的结论：
    放到TreeSet或者TreeMap集合key部分的元素要想做到排序，包括两种方式:
        第一种：放在集合中的元素实现java.lang.Comparable接口。
        第二种：在构造TreeSet或者TreeMap集合的时候给它传一个比较器对象。
Comparable和Comparator怎么选择?
    当比较规则不会发生改变的时候，或者说当比较规则只有一个的时候，建议是西安Comparable接口
    如果比较规则有多个，并且需要多个比较规则之间频繁切换，建议使用Comparator接口

    Comparator接口符合OCP原则
* */
public class TreeSetTest01 {
    public static void main(String[] args) {
        //创建TreeSet集合的时候，需要使用这个比较器
        //TreeSet<Animal> animals = new TreeSet<>(); 这样不行，没有通过构造方法传递一个比较器进去
        //给构造方法传递一个比较器
        //可以使用匿名内部类
        TreeSet<Animal> animals = new TreeSet<>(new AnimalComparator());

        animals.add(new Animal(100));
        animals.add(new Animal(200));
        animals.add(new Animal(300));

        for (Animal animal:animals){
            System.out.println(animal);
        }
    }
}

class Animal{
    int age;

    public Animal() {
    }

    public Animal(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "age=" + age +
                '}';
    }
}

//单独编写一个比较器
//比较实现java.util.Comparator接口。(Comparable是Java.lang包下的。Comparator是java.util包下的)
class AnimalComparator implements Comparator<Animal>{

    @Override
    public int compare(Animal o1, Animal o2) {
        return o1.age- o2.age;
    }
}