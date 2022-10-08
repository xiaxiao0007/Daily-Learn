package Javase.Day2022113;
/*
1.怎么获取当前线程对象?
    Thread.currentThread()
2.获取线程对象的名字?
    t.getName()
3.修改线程对象的名字?
    t.setName("ttt")
* */
public class ThreadTest03 {
    public static void main(String[] args) {
        //currentThread就是当前线程对象
        //这个代码出现在main方法当中，所以当前线程就是主线程
        Thread currentThread = Thread.currentThread();
        System.out.println(currentThread.getName());

        //创建线程对象
        MyThread t = new MyThread();
        //设置线程名字
        t.setName("ttt");
        //获取线程的名字
        String tName = t.getName();
        System.out.println(tName);

        MyThread t2 = new MyThread();
        System.out.println(t2.getName());

        //启动线程
        t.start();
    }
}
