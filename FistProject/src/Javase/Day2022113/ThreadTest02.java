package Javase.Day2022113;
/*
匿名内部类实现线程的创建
* */
public class ThreadTest02 {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("分支线程="+i);
                }
            }
        });
        //启动线程
        thread.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("主线程="+i);
        }
    }
}
