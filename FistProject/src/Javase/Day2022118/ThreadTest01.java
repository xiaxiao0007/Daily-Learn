package Javase.Day2022118;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/*
实现线程的第三种方式：实现Callable接口。(JDK8新特性)
    这种方式实现的线程可以获取线程的返回值。
    之前讲解的哪两种方式是无法获取线程返回值的，因为run方法返回void。
    优点：可以获取当前线程的执行结果
    缺点：效率比较低，在获取t线程执行结果之前时，当前线程会阻塞
* */
public class ThreadTest01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //第一步：创建一个”未来任务类”对象
        //参数非常重要，需要给一个Callable接口来实现类对象
        FutureTask task = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {//call()方法就相当于run方法，只不过这个有返回值
                //线程执行一个任务，执行之后可能会有一个执行结果
                //模拟执行
                System.out.println("call method begin");
                Thread.sleep(1000*10);
                int a = 100;
                int b = 200;
                return a+b;
            }
        });

        //创建线程对象
        Thread t = new Thread(task);
        //启动线程
        t.start();

        //这里是main方法，这是在主线程中。
        //在主线程中，怎么获取线程的返回结果?
        //get()方法的执行会导致当前线程阻塞
        Object obj = task.get();
        System.out.println(obj);

    }
}
