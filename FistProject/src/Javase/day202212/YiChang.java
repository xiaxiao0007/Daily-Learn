package Javase.day202212;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
1.什么是异常?Java提供异常处理机制有什么用?
    打印输出异常，给程序员阅读，以对程序进行修改，让程序更加得健壮，后续代码能继续执行
2.JVM输出打印异常信息。
3.Java语言中异常以什么形式存在的呢?
    (1).异常在Java中以类的形式存在，每一个异常类都可以创建异常对象。
    (2).编译时异常和运行时异常，都发生在运行阶段。编译阶段异常是不会发生的。
    编译时异常因为什么而得名?
        因为编译时异常必须在编译(编写)阶段预处理，如果不处理编译器报错，因此得名。
        所有异常都是在运行阶段发生的。因为只有程序运行阶段才可以new对象。
        因为异常的发生就是new异常对象
    (3).编译时异常和运行时异常的区别?
        编译时异常一般发生的概率比较高【在编译要及时进行处理】
        运行时异常一般发生的概率比较低
    (4).java语言中对异常的处理包括两种方式:
        第一种方式：在方法声明的位置上，使用throws关键字，抛给上一级，谁调用我，我就抛给谁。
        第二种方式：使用try..catch语句进行异常的捕捉
4.异常得继承结构
    Object
    Object下有Throwable(可抛出的)
    Throwable下有两个分支:Error(不可处理，直接退出JVM)和Exception(可处理得)
    Exception下有两个分支:
        Exception的直接子类:编译时异常(要求程序员在编写程序阶段必须预先对这些异常进行处理)
        RuntimeException:运行时异常(在编写程序阶段，程序员既可以处理，也可以不处理)
5.深入try..catch
    (1).catch后面的小括号的类型可以是具体的异常类型，也可以是该异常类型的父类型
    (2).catch可以写多个，建议catch的时候精确的一个一个的处理，这样有利于程序的调试
    (3).catch写多个的时候，从上到下，必须遵守从小到大
6.注意
    只要异常没有捕捉，采用上报的方式，此方法的后续代码不会执行，另外需要注意，try语句块中的某一行出现异常，
    该行后面的代码不会执行。try..catch捕捉异常之后，后续代码可以执行.
7.在以后的开发中，处理编译时异常，应该上报还是捕捉。怎么选？
    如果希望调用者来处理，选择throws上报，其它情况选择捕捉方式。
8.异常对象有两个非常重要的方法:
    获取异常简单的描述信息
    String msg = exception.getMessage();
    打印异常追踪的堆栈信息【Java后台打印异常堆栈追踪信息的时候，采用了异步线程的方式打印的】
    exception.printStackTrace();
9.关于try..catch中的finally字句:
    (1).在finally字句中的代码时最后执行的，并且时一定会执行的，即使try语句块中的代码出现了异常。
        finally字句必须和try一起出现，不能单独编写。
    (2).finally语句通常使用在那些情况下呢?
        通常在finally语句块中完成资源的释放/关闭。因为finally中的代码比较有保障，
        即使try语句块中代码出现异常，finally中代码也会正常执行。
    (3).try和finally可以直接使用
        try{
            1:System.out.println("1");
            3:return;【return语句只要执行方法必然结束】【return语句一定最后执行的】
        }finally{
            2:System.out.println("finally...");
        }
        程序执行顺序为1，2，3
    (4)System.exit(0)可以不执行finally语句中的内容
10.final finally finalize
    final 关键字，最终的，不变的
        final修饰的类无法被继承
        final修饰的方法无法覆盖
        final修饰的变量不能重新赋值
    finally 关键字，与try..catch语句一起使用，异常处理机制
    finalize()是Object类中的一个方法，作为方法名出现，所以finalize是标识符
 */
public class YiChang {
    public static void main(String[] args) {
        FileInputStream file = null;
        try {
            System.out.println("begin");
            file= new FileInputStream("C:\\桌面\\炸我学习日记.text");
            //file.close();
        } catch (FileNotFoundException e) {//FileNotFoundException为引用类型 e为变量名 可以使用
            //可以使用多态机制
            e.printStackTrace();
        } finally {
            System.out.println("hello");
            if(file !=null){
                try {
                    file.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        int i=10;
        i=i++;//先发生了赋值后发生了自加操作
        System.out.println(i);
    }
}
