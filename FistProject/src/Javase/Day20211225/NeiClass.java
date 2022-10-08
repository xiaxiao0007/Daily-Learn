package Javase.Day20211225;
/*
匿名内部类：
    1.什么是内部类
        内部类：在类的内部又定义了一个新的类。被称为内部类
    2.内部类的分类
        静态内部类：类似于静态变量
        实例内部类：类似于实例变量
        局部内部类：类似于局部变量
    3.使用内部类编写的代码，可读性很差，能不用尽量不用
    4.匿名内部类是局部内部类的一种。因为这个类没有名字而得名，叫做匿名内部类。

 */
public class NeiClass {
    public static void main(String[] args) {
        Mymath mymath = new Mymath();
        //匿名内部类，后面的大括号是对接口的实现
        mymath.mySum(new Computer() {
            @Override
            public int sum(int x, int y) {
                return x+y;
            }
        },100,20);
    }
}

class Test01{

    //静态内部类
    static class Inner1{

    }

    //实例内部类
    class Inner2{

    }

    public void some(){
        int i=100;
        //局部内部类
        class Inner3{

        }
    }
}

interface  Computer{
    int sum(int x,int y);
}

class Mymath{
    public void mySum(Computer c,int x,int y){
        int reValue = c.sum(x, y);
        System.out.println(reValue);
    }
}