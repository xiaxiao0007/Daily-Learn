package Polymorphic;

/*
关于Java语言当中的多态机制
    1.Animal,Cat,Bird三个类之间的关系
        Cat继承Animal
        Bird继承Animal
        Cat和Bird之间没有任何继承关系
    2.面向对象三大特征:封装,继承,多态
    3.关于多态中涉及到的几个概念
        向上转型(upcasting)
            子类型-->父类型
            又被称为:自动类型转换
        向下转型(downcasting)
            父类型-->子类型
            又被称为:强制类型转换【需要加 强制类型转换】
        需要记忆:无论是向上转型还是向下转型，两种类型之间必须有继承关系。没有继承关系，程序无法通过的
多态在实际开发中的作用
    降低成程序的耦合度，提高程序的扩展力。
    能使用多态尽量使用多态
    【父类型引用指向子类型对象】
 */
public class PolymorphicTest {
    public static void main(String[] args) {
        /*
        多态在实际开发中的作用，以下以主人喂养宠物为例说明多态的作用:
            1.分析:主人喂养宠物这个场景要实现需要进行类型的抽象:
                主人【类】
                主人可以喂养宠物，所以主人有喂养的这个动作
                宠物【类】
                宠物可以吃东西，所以宠物有吃东西的这个动作
                定义号类，然后将类实例化为对象，给一个环境驱使一下，让各个对象之间协作起来形成一个系统
         */
        //创建主人对象
        Human ZhangSan = new Human();
        //创建猫对象
        Cat Tom = new Cat();
        //主人喂养猫
        ZhangSan.feed(Tom);
        //创建狗对象
        Dog dog = new Dog();
        //主人喂狗
        ZhangSan.feed(dog);
        //面向抽象编程，不要面向具体编程 耦合低，扩展能力强
    }
}
