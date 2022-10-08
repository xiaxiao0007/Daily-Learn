package Javase.Day2022119;
/*
研究路径相关问题
* */
public class AboutPath {
    public static void main(String[] args) {
        //什么是类路径下？
        //在src下的都是类路径
        //src是类的根路径
        //getResource() 【获取资源】 这是类加载器对象的方法，当前线程的类加载器默认从类的根路径下加载资源
        String path = Thread.currentThread().getContextClassLoader()
                .getResource("user.properties").getPath();
        //采用以上代码可以拿到一个文件的绝对路径
        //适应各种操作系统
        System.out.println(path);

        //获取db.properties文件的绝对路径(从类的根路径下作为起点开始)
        String path01 = Thread.currentThread().getContextClassLoader()
                .getResource("Javase/Day2022119/db.properties").getPath();//路径种不能数字
        System.out.println(path01);
    }
}
