package Javase.Day2021;

/*
关于Java语言当中final关键字:
    1.final是一个关键字，表示最终的，不可变的
    2.final修饰的类无法被继承
    3.final修饰的方法无法被覆盖
    4.final修饰的变量一旦赋值后，不可重新赋值,只能赋一次值
    5.final修饰的实例变量？
        实例变量有默认值+final修饰的变量一旦赋值不能重新赋值
        Java语言最终规定实例变量使用final修饰之后，必须手动赋值，不能采用系统默认值。
    6.final修饰的引用
         final修饰引用，一旦指向某个对象之后，不能再指向其它对象，那么被指向的对象无法被垃圾器回收。
         直到当前方法结束，才会释放内存。
         final修饰的引用虽然指向某个对象之后不能指向其它对象，但是所指向的对象内部的内存是可以被修改的。
         【结论】final修饰的实例变量，系统不负责赋默认值，要求程序员必须手动赋值。
                这个手动赋值，在变量后面赋值可以，在构造方法中赋值也可以。
    7.final修饰的实例变量是不可变的，这种变量一般和static联合使用，被称为“常量”
        public static final 类型 常量名 = 值;
常量：实际上常量和静态变量一样，区别在于：常量的值不能变。
    常量和静态变量，都是存储在方法区，并且都是在类加载时初始化。
    常量一般都是公开的
对于以后大家所学习的类库，一般都是包括三个部分的：
    -源码【可以看源码来理解程序】
    -字节码【程序开发过程中使用的就是这部分】
    -帮助文档【对源码的解释说明被提取出来，更方便程序的开发】
    注意:版本使用要一致
成员变量默认值向零靠近
【重点】实例变量在什么时候赋值(初始化)？
    构造方法执行的过程中赋值。(new的时候赋值)
 */
public class finalKey {

    public static void main(String[] args) {

        String b = "sjhskahak";

        int a = b.length();

        System.out.println(a);
        System.out.println(Chinese.country);//静态变量的调用【类名.变量名】

    }
}
class Chinese{
    public static final String country = "中国";
}