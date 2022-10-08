package Javase.Day2022111;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
1.IO流，什么是IO?
    I:Input
    O:Output
    通过IO可以完成对硬盘文件的读和写
2.IO流的分类?
    有多种分类方式
        输出方式
        读取数据的方式
            按字节，只能读8位比特，可以使用不同的文本
            按字符读取，只能读取纯文本
3.java IO流这块有四大家族
    java.io.InputStream 字节输入流
    java.io.OutputStream 字节输出流
    java.io.Reader 字符输入流
    java.io.Writer 字符输出流
    四大家族的首领都是抽象类
    所有的流都是可关闭的(实现了java.io.Closeable接口)
    所有的输出流的都实现了:java.io.Flushable接口。都是可刷新的，都有flush()方法
        刷新的作用是清空管道
    注意：以Stream结尾的都是字节流，以Reader或者Writer结尾的都是字符流
4.java.io包下需要掌握的流有16个
    文件专属
        java.io.FileInputStream
        java.io.FileOutputStream
        java.io.FileReader
        java.io.FileWriter

    转换流(将字节流转换成字符流)
        java.io.InputStreamReader
        java.io.OutputStreamWriter

    缓冲流专属
        java.io.BufferedReader
        java.io.BufferedWriter
        java.io.BufferedInputStream
        java.io.BufferedOutputStream

    数据流专属
        java.io.DataInputStream
        java.io.DataOutputStream

    标准输出流
        java.io.PrintWriter
        java.io.PrintStream

    对象专属流
        java.io.ObjectInputStream
        java.io.ObjectOutputStream
* */
/*
java.io.FileInputStream
    1.文件字节输入流，万能的，任何类型的文件都可以采用这个流来读
    2.字节的方式，完成输入的操作，完成读的操作(硬盘 ——> 内存)
    3.
* */
public class IoTest01 {
    public static void main(String[] args) {
        //创建文件字节流输入对象。(建立通道)
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("D:\\text01.txt");
            //开始读
            int readData = fis.read();//这个方法的返回值是:读取到的“字节”本身
            System.out.println(readData);//97,读到文件的末尾之后再读返回的是-1。
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null){//避免空指针异常
                //关闭流的前提是:流不是空。流是null的时候没必要关闭
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
