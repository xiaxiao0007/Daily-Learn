/*
创建对象时代码的执行顺序
    父类的静态属性初始化和静态代码块
    子类的静态属性初始化和静态代码块
    父类普通属性初始化和普通代码块
    父类构造器显示代码块
    子类普通属性初始化和普通代码块
    子类构造器显示代码块
static(静态)代码块是在类加载时被执行，不管类加载多少次，静态代码块都只会执行一次，第一次加载类的时候执行。
    静态代码块只能调用静态成员
普通代码块是创建对象时被执行，创建一个对象就执行一次非静态代码块
    代码块可以视为构造的补充，将多个构造器里面共有的部分提取出来，减少代码冗余
    普通代码块可以调用静态和非静态成员
* */
public class TestClass {
    public static void main(String[] args) {
        Bo2 bo2 = new Bo2();
        bo2.doSome();
    }
}

class Ao1{
    static{
        System.out.println(1);
    }

    int i=3;

    public Ao1() {
        System.out.println(2);
    }
}

class Bo2 extends Ao1{
    static {
        System.out.println(3);
    }

    public Bo2() {
        super();
        System.out.println(4);
    }

    public void doSome(){
        System.out.println(5);
    }
}