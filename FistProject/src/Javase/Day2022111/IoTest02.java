package Javase.Day2022111;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
int read (byte[] b)
    一次最多读取b.length个字节。
    减少硬盘和内存的交互，提高程序的执行效率
    往byte[]数组当中读
* */
public class IoTest02 {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            //相对路径
            fis = new FileInputStream("D:\\text01.txt");

            //开始读，采用byte数组，一次读取多个字节。最多读取"数组.length"个字节
            byte[] bytes = new byte[4];
            //这个方法的返回值是：读取到的字节数量
            //int readData = fis.read(bytes);
            int readData = 0;
            while ((readData = fis.read(bytes)) != -1){
                System.out.println(new String(bytes,0,readData));
            }
            /*while(true){
                int readData = fis.read(bytes);
                if (readData == -1){
                    break;
                }
                System.out.println(new String(bytes,0,readData ));
            }*/
            /*System.out.println(readData);
            System.out.println(new String(bytes,0,readData));
            for (byte bytes01 : bytes){
                System.out.println(bytes01);
            }*/
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
