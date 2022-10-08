package Interface;

public class InterfaceStudyTest02 {
    public static void main(String[] args) {

        //创建对象(表面上Animal没什么用)
        Flyable flyable = new Cat();
    }
}

//动物类
class Animal{

}

//可飞翔的接口(是一个接口)
//能插拔的就是接口(没有接口怎么插拔)
//接口通常提取的是行为动作
interface Flyable{
    void fly();
}

//动物类子类：猫类
//Flyable是一个接口，是一对翅膀的接口，通过接口插到猫身上，让猫可以飞翔
class Cat extends Animal implements Flyable{
    @Override
    public void fly() {
        System.out.println("肥猫起飞");
    }
}

class Snake extends Animal{

}