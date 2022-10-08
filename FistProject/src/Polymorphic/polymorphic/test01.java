package Polymorphic.polymorphic;

public class test01 {
    public static void main(String[] args) {

        //使用多态语法机制
        /*
        1.Anima和Cat之间存在继承关系，Animal是父类，Cat是子类
        2.Cat is a Animal
        3.new Cat()创建对象的类型是Cat，cat这个引用数据类型是Animal，可见他们进行了类型转换，
          子类型转换成父类型
         */
        Animal cat = new Cat();//指向的内存地址是Cat()

        /*
        1.java程序永远分为编译阶段和运行阶段。
        2.先分析编译阶段，再分析运行阶段，编译无法通过时，既也无法运行的
        3.编译阶段编译器检查cat这个引用数据类型为Animal，由于Animal.class字节码当中有move()方法，
          所以编译通过了，这个过程我们称为静态绑定，编译阶段绑定。只有静态绑定成功之后才有后续的运行
        4.在程序运行阶段，JVM堆内存当中真实创建的对象是Cat对象，那么以下程序在运行阶段，一定会调用
          Cat对象的move()方法，此时发生了程序的动态绑定，运行阶段绑定
        5.无论是Cat类有没有重写move方法，运行阶段一定调用的是Cat对象的move方法，因为低层真实对象就是Cat对象
        6.父类型引用指向子类型对象这种机制导致程序存在编译阶段绑定和运行阶段绑定两种不同的形态/状态，这种机制可以成为一种多态语法机制。
        7.向上转型编译通过，运行一定不会出现问题:Animal cat = new Cat()
         */
        cat.move();//不是方法重写，编译时与Animal绑定，所以语法通过。运行时与new Cat()绑定，所以运行通过。

        //强制类型转换，父类-->子类
        /*
        什么时候需要使用向下转型呢？
            当调用的方法是子类型中特有的，在父类型当中不存在，必须进行向下转型。
         */
        Cat cat1 = (Cat)cat;
        cat1.catMouse();

        //父类型引用指向子类型对象【多态】
        Animal bird = new Bird();//自动类型转换

        /*
        1.以下程序的编译是没有问题的，因为编译器检查bird的数据类型是Animal，Animal是父类型，Cat是子类型
          父类型转换成子类型叫做向下转型，语法合格。
        2.程序虽然编译通过了，但是程序在运行阶段异常，因为JVM堆内存当中真实存在的对象是Bird类型，Bird对象无法转成Cat对象
          因为两种类型之间不存在任何继承关系，此时出现了著名地异常:
            java.lang.ClassCastException
            类型转换异常，这种异常总是在“向下转型”的时候发生
        3.向下转型编译通过，运行可能错误:Animal bird = new Bird();Cat bird01 = (Cat) bird;
         */
        //Cat bird01 = (Cat) bird;

        /*
        1.怎么避免向下转型出现的ClassCastException呢？
            使用instanceof运算符可以避免出现以上的异常
        2.instanceof运算符怎么用？
            2.1语法格式:
                (引用 instanceof 数据类型)
            2.2以上运算的执行结果类型是布尔类型，结果可能是true/false
            2.3关于运算结果true/false:
                假设:(a instanceof Animal)
                true表示:
                    a这个引用指向的对象是一个Animal类型
                false表示:
                    a这个引用指向的对象不是一个Animal类型
        */
        //向下转型【只有当访问子类对象当中特有的方法】
        if (bird instanceof Cat){
            Cat bird1 = (Cat) bird;
            bird1.catMouse();//调用子类中特有的方法
        }else if (bird instanceof Bird){
            Bird bird1 = (Bird) bird;
            bird1.fly();
        }
    }
}
