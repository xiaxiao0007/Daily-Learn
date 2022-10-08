package Javase.Day2022116;
/*
死锁
* */
public class DeadSuo {
    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = new Object();

        Thread t1 = new MyClass01(o1,o2);
        Thread t2 = new MyClass02(o1,o2);
        t1.start();
        t2.start();
    }
}

class MyClass01 extends Thread {
    Object obj01;
    Object obj02;

    public MyClass01(Object obj01,Object obj02){
        this.obj01 = obj01;
        this.obj02 = obj02;
    }

    @Override
    public void run() {
        synchronized (obj01){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (obj02){

            }
        }
    }
}

class MyClass02 extends Thread{
    Object obj01;
    Object obj02;

    public MyClass02(Object obj01,Object obj02){
        this.obj01 = obj01;
        this.obj02 = obj02;
    }

    @Override
    public void run() {
        synchronized (obj02){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (obj01){

            }
        }
    }
}