package Javase.Day2022113;
/*
中断线程的睡眠
* */
public class ThreadTest06 {
    public static void main(String[] args) {
        Thread thread = new Thread(new MyThread03());
        thread.start();
        try {
            Thread.sleep(1000*5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main结束");

        //中断thread线程的睡眠(这种中断睡眠的方式依靠了java的异常处理机制)
        thread.interrupt();
    }
}

class MyThread03 implements Runnable{
    @Override
    public void run() {
        System.out.println("开始");
        try {
            Thread.sleep(1000*60*60*24);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("结束");
    }
}