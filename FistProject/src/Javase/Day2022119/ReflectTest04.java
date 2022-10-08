package Javase.Day2022119;
/*
【重点】如果你只希望一个类的静态代码块执行，其它代码一律不执行，你可以使用：Class.forName("完整类名")
       这个方法执行会导致类加载，类加载时，静态代码块执行。
* */
public class ReflectTest04 {

    public static void main(String[] args) {
        try {
            //Class.forName()这个方法的执行会导致：类加载
            Class.forName("Javase.Day2022119.MyClass");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class MyClass {
    static {
        //静态代码块在类加载时执行，并且只执行一次
        System.out.println("类加载");
    }
}