package Javase.Day2022118;

import java.util.ArrayList;
import java.util.List;

/*
1.实现生产者和消费者模式
2.wait和notify方法不是线程对象的方法，是普通Java对象都有的方法
* */
public class ThreadTest02 {
    public static void main(String[] args) {
        List list = new ArrayList();

        //生产者线程
        Thread t1 = new Thread(new Producer(list));
        //消费者线程
        Thread t2 = new Thread(new Consumer(list));

        t1.setName("生产者线程");
        t2.setName("消费者线程");

        t1.start();
        t2.start();
    }
}

//生产线程
class Producer implements Runnable{
    //仓库
    private List list;

    public Producer(List list) {
        this.list = list;
    }

    @Override
    public void run() {
        //一直生产
        int i = 0;
        while(i<2){
            //给仓库对象List加锁
            synchronized (list) {
                if (list.size() > 0) {//大于0，说明仓库中已经有1个元素了
                    //当前线程进入状态，并且释放list的锁
                    try {
                        //当前线程进入等待状态，并且释放Producer之前占有的list集合的锁
                        list.wait();//wait()方法会释放共享对象的锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //程序到这里说明仓库是空的，可以生产
                Object obj = new Object();
                list.add(obj);
                System.out.println(Thread.currentThread().getName()+"--->"+obj);
                //唤醒消费者进行消费
                list.notify();//notify()方法不会释放共享对象的锁
            }
            i++;
        }
    }
}

//消费者线程
class Consumer implements Runnable{
    //仓库
    private List list;

    public Consumer(List list) {
        this.list = list;
    }

    @Override
    public void run() {
        int i = 0;
        //一直消费
        while(i<2){
            synchronized (list){
                if (list.size() == 0){
                    try {
                        //仓库已经空了
                        //消费者线程等待，释放掉list集合的锁
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //程序执行到此处，说明仓库中有数据，进行消费
                Object obj = list.remove(0);
                System.out.println(Thread.currentThread().getName()+"--->"+obj);
                //唤醒生产者生产
                list.notify();
            }
            i++;
        }
    }
}