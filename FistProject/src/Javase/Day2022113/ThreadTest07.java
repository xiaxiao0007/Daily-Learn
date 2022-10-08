package Javase.Day2022113;
/*
在java中怎么强行终止一个线程的执行
    引用.stop()
    这种方式存在很大的缺点：容易丢失数据。因为这种方式是直接将线程杀死了，线程没有保存的数据将会丢失。不建议使用
在java中如何合理终止线程的执行
    打一个boolean标记
* */
public class ThreadTest07 {
    public static void main(String[] args) {
        MyRunnable01 myRunnable01 = new MyRunnable01();
        Thread thread = new Thread(myRunnable01);
        thread.setName("t");
        thread.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //终止线程
        //你想要什么时候终止t的执行，那你把标记修改为false，就结束了
        myRunnable01.run = false;
    }
}

class MyRunnable01 implements Runnable{
    //打一个boolean标记
    boolean run = true;
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (run){
                System.out.println(Thread.currentThread().getName()+"="+i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else {
                return;
            }
        }

    }
}