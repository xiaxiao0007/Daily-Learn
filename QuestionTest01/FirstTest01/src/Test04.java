public class Test04 implements Runnable{
    @Override
    public void run() {
        for (int i = 0;i < 10000;i++) {
            System.out.println("副线程输出:"+i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ThreadTest01 {
    public static void main(String[] args) {
        Test04 test04 = new Test04();
        Thread thread = new Thread(test04);
        thread.start();
        for (int i = 0;i < 10000;i++) {
            System.out.println("主线程输出:"+i);
        }
    }
}