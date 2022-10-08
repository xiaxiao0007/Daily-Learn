package Polymorphic;

public class Human {

    public void feed(Pet pet){//其中Pet pet是一个父类型的引用
        pet.eat();
    }
}
