package Javase.Day2022111;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
FileInputStream类的其它常用方法
    int available():返回流当中剩余的没有读到的字节数量
    long skip(long n):跳过几个字节不读
* */
public class IoTest03 {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("D:\\text01.txt");
            System.out.println("总字节数量" + fis.available());
            byte[] bytes = new byte[fis.available()];//不适合大的数据
            int readData = fis.read();
            System.out.println("剩下多少个字节没有读" + fis.available());
            //skip跳过几个字节不读取，这个方法也可能以后会用
            fis.skip(1);
            System.out.println(fis.read());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        char[] chars = {'我'};
        String str = new String(chars);
        System.out.println(str);
    }
}
