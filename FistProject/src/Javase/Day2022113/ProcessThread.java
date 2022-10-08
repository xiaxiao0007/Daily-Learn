package Javase.Day2022113;
/*
Java中的多线程和进程
    在Java语言中，线程A和线程B，堆内存和方法区内存共享，但是栈内存独立，一个线程一个栈。
Java语言中，实现线程有两种方式，那两种方式呢?
Java支持多线程机制，并且Java已经将多线程实现了，我们只需要继承就行
    第一种方式：编写一个类，直接继承java.lang.Thread,重写run方法
* */
/*
怎么创建线程? new对象
怎么启动线程呢? 调用线程对象start()方法
* */
public class ProcessThread {
    public static void main(String[] args) {
        //这里是main方法，这里的代码属于主线程，在主栈中运行。
        //新建一个分支线程对象
        MyThread myThread = new MyThread();

        //myThread.run();//不会启动线程，不会分配新的分支栈

        //启动线程
        //start()方法的作用：启动一个分支线程，在JVM中开辟新的栈空间，这段代码任务完成瞬间就结束了。
        //这段代码的任务只是为了开启一个新的栈空间，只要新的栈空间开出来，start()方法就结束了，线程就启动成功了。
        //启动成功的线程会自动调用run()方法，并且run()方法在分支栈的栈底部(压栈)。
        //run()方法在分支栈的栈底部，main()方法在主栈的栈底部。run()和main()是平级的
        myThread.start();

        //这里的代码还是运行在主线程
        for (int i = 0; i < 10; i++) {
            System.out.println("主线程="+i);
        }
    }
}

//实现线程的第一种方式
//这是一个线程类
class MyThread extends Thread{
    @Override
    public void run() {
        //编写程序，这段程序运行在分支线程中(分支栈)
        for (int i = 0; i < 10; i++) {
            System.out.println("分支线程"+i);
        }
    }
}