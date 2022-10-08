package Javase.Day2022113;
/*

* */
public class ThreadTest05 {
    public static void main(String[] args) {
        Thread thread = new MyThread3();

        try {
            thread.sleep(1000*5);//虽然这里是引用调用，但是静态方法在执行的时候还会转换成Thread.sleep()方法
            //静态方法都是类名.方法名【重点啊】
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hello World");
    }
}

class MyThread3 extends Thread{
    @Override
    public void run() {
        super.run();
    }
}