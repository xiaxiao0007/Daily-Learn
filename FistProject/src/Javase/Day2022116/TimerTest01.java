package Javase.Day2022116;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/*
定时器
* */
public class TimerTest01 {
    public static void main(String[] args) throws ParseException {
        //创建定时器
        Timer timer = new Timer();
        //Timer timer = new Timer(true);//守护线程的方式

        //指定定时任务
        //timer.schedule(定时任务，第一次执行时间，间隔多久执行一次);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date firstTime = sdf.parse("2022-1-16 18:14:00");
        timer.schedule(new LogTimerTask(),firstTime,1000*10);

    }
}

class LogTimerTask extends TimerTask{
    @Override
    public void run() {
        //编写你需要执行的任务就行了
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sdf.format(new Date());
        System.out.println(time);
    }
}