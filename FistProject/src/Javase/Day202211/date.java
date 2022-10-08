package Javase.Day202211;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

/*
java.lang包不需要导入已经导入过了
java中对日期的处理
    直接调用无参数构造方法Date date = new date();
简单总结一下System类的相关属性和方法(带括号的是方法，不带括号的是属性)
    System.out 【out是System类的静态变量】
    System.out.println()【println()方法不是System类的，是PrintStream类的方法】
    System.gc() 建议启动垃圾回收器
    System.currentTimeMillis() 获取自1970年1月1日到系统当前时间的总毫秒数
    System.exit(0) 退出JVM
 */
public class date {
    public static void main(String[] args) throws Exception{

        //获取当前日期时间,Date类的无参构造，是获取当前的时间
        Date nowTime = new Date();
        System.out.println(nowTime);//println方法会调用对象的toString()方法

        //日期可以格式化么?
        //将日期类型Date，按照指定的格式进行转换：Date -- 转换成具有一定格式的日期字符串--> String
        //SimpleDateFormat是java.text包下的。专门负责日期格式化的
        /*
        * yyyy年(4位)
        * MM 月(2位)
        * dd 日
        * HH 时
        * mm 分
        * ss 秒
        * sss 毫秒(3位)
        * 【注意】在日期格式中，除了y M d H m s S这些字符不饿能随便写之外，剩下的符号格式自己随意组织
        * */
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss SSS");
        String date = sdf.format(nowTime);
        System.out.println(date);

        //假设现在有一个日期字符串String，怎么转换成Date类型？
        String time = "2022-1-1 21:27";
        //SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        //SimpleDateFormat中的参数格式要和日期字符串格式相同
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        Date dateTime = sdf2.parse(time);
        System.out.println(dateTime);

        //获取自1970年1月1日00:00:00当前系统时间的总毫秒数
        long nowTimeMills = System.currentTimeMillis();
        System.out.println(nowTimeMills);

        //需求：统计一个方法执行所耗费的时长
        long beginTime = System.currentTimeMillis();
        loop();
        long endTime = System.currentTimeMillis();
        System.out.println("耗费时长"+(endTime-beginTime)+"毫秒");

        //date类有参构造方法
        Date timeOne =new Date(1);//将传递的毫秒数转换成对应的日期时间
        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss SSS");
        String strTime = sdf3.format(timeOne);
        System.out.println(strTime);

        //获取昨天此时的时间
        Date timeTwo = new Date(System.currentTimeMillis()-24*60*60*1000);
        SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss SSS");
        String timeThree = sdf4.format(timeTwo);
        System.out.println(timeThree);

        LocalDate date1 = LocalDate.now();
        System.out.println(date1);
    }
    public static void  loop(){
        for (int i = 0; i < 1000; i++) {
            //System.out.println(i);
            //continue;
        }
    }
}
