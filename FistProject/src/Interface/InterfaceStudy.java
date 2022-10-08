package Interface;
/*
接口基础语法：
    1.接口也是一种引用数据类型。接口编译之后也是一个class字节码文件
    2.接口是完全抽象的。(抽象类是半抽象)或者也可以说接口是特殊的抽象类。
    3.接口怎么定义，语法是什么？
        [修饰符列表] interface 接口名{
        }
    4.接口支持多继承，一个接口可以继承多个接口
    5.接口中只包含两部分内容，一部分是：常量。一部分是：抽象方法
    6.接口中所有的元素都是public修饰的。(都是公开的)
    7.接口中抽象方法定义时：public abstract修饰符可以省略。
    8.接口中的方法都是抽象方法，所以接口中的方法不能有方法体
    9.接口中的常量的public static final可以省略
    10.类和类之间叫做继承，类和接口之间叫做实现【也可以叫做继承】。
        继承使用extends关键字完成
        实现使用implements关键字完成
    11.【重要】一个非抽象的类，实现接口，必须将接口中所有的抽象方法进行覆盖/重写/实现，实现具体方法
    12.继承之后在子类中重写的方法访问权限只能更高。
    13.【重点】一个类可以同时实现多个接口(但是在这个类中需要实现所有接口中的抽象方法)。弥补类的单继承
    14.接口A和接口B虽然没有继承关系，但是写代码的时候，可以互转。编译器没有意见。但是运行时可能出现:ClassCastException异常
       但是最终实际上和之前还是一样，需要加：instanceof运算进行判断
    15.继承和实现都存的话，代码应该怎么写？
        extends关键字在前，implements关键字在后。
接口在开发中的作用
    注意:接口在开发中的作用，类似于多态在开发中的作用
    多态:面向抽象编程，不要面向具体编程，降低程序的耦合度，提高程序的扩展力
    更多的移植性，灵活性。
类型和类型之间的关系
    is a     继承
    has a    关联关系(属性)
    like a   实现关系(类实现接口)
抽象类和接口有什么区别
    1.抽象类是半抽象的
      接口是完全抽象的
    2.抽象类中有构造方法
      接口中没有构造方法
    3.接口和接口之间支持多继承
      类和类之间只能单继承
    4.一个类可以同时实现多个接口
      一个抽象类只能继承一个类(单继承)
    5.接口中只允许出现常量和抽象方法
”接口“一般都是对”行为“的抽象
 */
public class InterfaceStudy {
    public static void main(String[] args) {
        System.out.println(MyMath.PI);

        //多态【父类型的引用指向子类型的对象】
        MyMath myMath = new Abc();
        //面向接口的编程
        int cc = myMath.sum(10,20);
        System.out.println(cc);
    }
}

interface A{

}

interface B{

}

interface C extends A,B{

}


//特殊的抽象类，完全抽象，叫做接口。
interface MyMath{

    double PI =3.1415926;
    //public static final double PI = 3.1415926;

    //public abstract int sum(int a,int b);
    int sum(int a,int b);
}

class Abc implements MyMath{//没写extends,也是有的，默认继承Object。

    @Override//重写/覆盖/实现接口中的方法
    public int sum(int a, int b) {
        return a+b;
    }
}
