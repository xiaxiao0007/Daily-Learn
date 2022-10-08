package Abstract;
/*
* 抽象类：
*   1.什么是抽象类？
*       类和类之间具有共同特征，将这些共同特征提取出来，形成的就是抽象类。
*       类本身是不存在的，所以抽象类无法创建对象《无法实例化》
*   2.抽象类属于什么类型？
*       抽象类也属于引用数据类型。
*   3.抽象类怎么定义？
*       语法：
*           [修饰符列表] abstract class 类名{
*               类体;
*           }
*   4.抽象类是无法实例化的，无法创建，所以抽象类是用来被子类继承的。
*   5.final和abstract无法联合使用
*   6.抽象类的子类可以是抽象类，也可以是非抽象类。
*   7.抽象类虽然无法实例化，但是抽象类有构造方法，这个构造方法是供子类使用的。super(实参);
*   8.抽象类关联到一个概念：抽象方法，什么是抽象方法呢？
*       抽象方法表示没有实现的方法，没有方法体的方法。
*       public abstract void doSome();
*       抽象方法特点是:
*           特点1:没有方法体，以分号结尾
*           特点2：前面修饰符列表中有abstract关键字。
*   9.抽象类中不一定有抽象方法【可以有非抽象方法】，抽象方法必须出现在抽象类中。
*   10.重要结论:一个非抽象的类继承抽象类，必须将抽象类中的抽象方法实现了。这是Java语法上强行规定，
*      必须的，不然编译器报错了。
*      这里的覆盖或者说重写，也可以叫做实现。在非抽象类中发生继承抽象类的时候要对抽象类中的抽象方法进行实现
* 11.【重点】：一个非抽象的类，继承抽象类，必须将抽象类中所有的抽象方法进行覆盖/重写/实现
* 12.Object类中就有很多方法都没有方法体，都是以”;“结尾的，但是他们都不是抽象方法。
*   例如:public native int hashCode();
*       这个方法底层调用了c++写的动态链接库程序。
*       前面修饰符列表中没有：abstract。有一个native。表示调用JVM本地程序。
* */
public class AbstractStudy {
    public static void main(String[] args) {

        Animal a = new Bird();//自动类型的转换，【面向抽象的编程】
        /*
        分析以下【多态机制，父类型引用指向子类型对象】
            编译的时候这个move()方法是谁的？
                move()是Animal
            运行的时候这个move()方法又是谁的？
                move()是Bird的
         */
        a.move();

        Animal c = new Cat();
        //多态机制与抽象类的结合
        c.move();
    }
}
abstract class Animal{
    public abstract void move();
    public abstract void action();
}

class Bird extends Animal{
    @Override
    public void move() {
        System.out.println("鸟儿在飞翔");
    }

    @Override
    public void action() {
        System.out.println("飞");
    }
}

class Cat extends Animal{

    @Override
    public void move() {
        System.out.println("猫在吃鱼");
    }

    @Override
    public void action() {
        System.out.println("跑");
    }
}