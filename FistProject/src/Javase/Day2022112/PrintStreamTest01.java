package Javase.Day2022112;

import java.io.FileOutputStream;
import java.io.PrintStream;

/*
java.io.PrintStream：标准的字节输出流，默认输出到控制台
* */
public class PrintStreamTest01 {
    public static void main(String[] args) throws Exception{
        System.out.println("hello world");

        PrintStream ps = System.out;
        ps.println("hello world");//标准输出流不需要手动close()关闭

        //标准输出流不再指向控制台，指向"log"文件
        PrintStream printStream = new PrintStream(new FileOutputStream("log"));
        //修改输出方向，将输出方向修改到"log"文件
        System.setOut(printStream);
        //再输出
        System.out.println("hello world");
    }
}
