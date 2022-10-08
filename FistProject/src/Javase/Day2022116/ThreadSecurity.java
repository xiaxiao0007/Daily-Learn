package Javase.Day2022116;
/*
关于多线程并发环境下，数据的安全问题。
    1.为什么这个是重点?
      需要知道自己编写的程序是在多线程环境中，需要保证数据的安全性
    2.什么时候存在线程安全问题?
      条件1:多线程并发
      条件2:有共享数据
      条件3:共享数据有修改的行为
   3.怎么解决线程安全问题呢?
     线程排队执行。(不能并发)
     线程同步机制
   4.线程同步的两个专业术语
     异步编程模型：并发，不考虑安全问题
     同步变成模型：排队执行线程里的程序
   5.使用进程的互斥的机制。进行解决
   6.局部变量不存在线程安全问题
以后开发中应该怎么解决线程安全问题?
    第一种方案:尽量使用局部变量代替“实例变量和静态变量”
    第二种方案:如果必须是实例变量，那么可以考虑创建多个对象，这样实例变量的内存就不共享了。(一个线程
    对应一个对象)
    第三种方案:如果不能使用局部变量，对象也不能创建多个，这个时候就只能选择synchronized了。线程同步机制。
* */
public class ThreadSecurity {
    public static void main(String[] args) {
        Account account = new Account("1111",10000);
        //创建账户类的两个线程
        Thread accountThread01 = new AccountThread(account);
        Thread accountThread02 = new AccountThread(account);
        accountThread01.start();
        accountThread02.start();
    }
}

class Account{
    private String no;
    private double balance;

    public Account() {
    }

    public Account(String no, double balance) {
        this.no = no;
        this.balance = balance;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void withdraw(double money){
        //以下这几行代码必须是线程排队的，不能并发
        //一个线程把这里的代码全部执行结束之后，另一个线程才能进来
        /*
        线程同步机制的语法是：
            synchronized (){
                //线程同步代码块。
            }
            synchronized后面小括号传的这个“数据”是相当关键的。
            这个数据必须是多个线程共享的数据，才能达到多线程排队

            ()中写什么?
                那要看你想让那些线程同步
                假设t1,t2,t3,t4,t5有5个线程，你只希望t1,t2,t3排队，t4,t5不需要排队。怎么办?
                你一定要在()中写t1,t2,t3共享的对象。然而这个对象对于t4,t5来说不是共享的。
        * */
        synchronized (this) {
            double before = this.balance;
            double after = before - money;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //更新余额
            this.setBalance(after);
        }
    }
}

class AccountThread extends Thread{
    //两个线程必须共享同一个对象
    private  Account act;
    //通过构造方法传递过来账户对象
    public AccountThread(Account act){
        this.act = act;
    }

    @Override
    public void run() {
        //run方法的执行表示取款操作
        double money = 1000.0;
        act.withdraw(money);

        System.out.println(act.getBalance());
    }
}