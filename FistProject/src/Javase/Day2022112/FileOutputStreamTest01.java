package Javase.Day2022112;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
FileOutputStream
    文件字节输出流，负责写，从内存到硬盘

* */
public class FileOutputStreamTest01 {
    public static void main(String[] args) {
        FileOutputStream file = null;
        try {
            //这种方式谨慎使用，这种方式会将原文件清空，然后重新写入
            file = new FileOutputStream("D:\\text01.txt");
            //开始写
            byte[] bytes = new byte[]{97,98,99,100};
            //file.write(bytes);
            //将byte数组的一部分写入
            file.write(bytes,0,1);
            file.write(bytes,0,1);


            //以追加的方式在文件末尾写入，不会清空原文件内容
            /*file = new FileOutputStream("D:\\text01.txt",true);
            byte[] bytes = new byte[]{97,98,99,100};
            file.write(bytes);*/
            //写完之后一定要刷新
            file.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (file != null){
                try {
                    file.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
