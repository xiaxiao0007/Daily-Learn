package ClassStudy02;

public class StudentTest01 {
    public static void main(String[] args){

        //通过一个类可以实例花N个对象
        //实例化对象的语法：new 类名();
        //new是Java语言当中的一个运算符
        //new运算符的作用是创建对象，在JVM堆内存当中开辟新的内存空间
        //堆内存：new的对象在堆内存中。
        //Student是一个引用数据类型
        //s是一个变量名【s中保存的一个对象内存地址】
        //new Student()是一个学生对象
        //s是一个局部变量【在栈内存中存储】
        //什么是对象？new运算符在堆内存中开辟的内存空间称为对象
        //什么是引用？引用是一个变量，只不过这个变量中保存了另一个Java对象的内存地址
        //Java语言当中，程序员不能直接操作堆内存，Java中没有指针。
        //Java语言当中，程序员只能通过“引用”去访问堆内存当中对象内部的实例变量。
        Student a = new Student();

        //访问实例变量的语法格式
        //读取数据：引用.变量名
        //修改数据：引用.变量名 = 值；
        int stuNo = a.num;
        System.out.println(stuNo);
        a.name = "Long";
        System.out.println(a.name);

        //再通过类实例化一个全新的对象
        //stu是一个引用
        //stu同时也是一个局部变量
        //ObjectTest02是变量的数据类型。【变量(存储的数据)要有数据类型】
        Student stu = new Student();
        System.out.println(stu.sex);
    }
}
