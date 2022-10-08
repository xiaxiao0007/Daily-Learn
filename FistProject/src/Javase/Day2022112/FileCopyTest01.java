package Javase.Day2022112;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyTest01 {
    public static void main(String[] args) {
        FileInputStream file= null;
        FileOutputStream fileCopy= null;
        try {

            file = new FileInputStream("D:\\text01.txt");
            fileCopy = new FileOutputStream("D:\\text02.txt");

            byte[] bytes = new byte[10];
            int readCount = 0;
            while((readCount = file.read(bytes)) !=-1){//每次数组的元素都是不同的,每次写都会在末尾进行写操作
                fileCopy.write(bytes,0,readCount);
            }

            fileCopy.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(file != null) {
                try {
                    file.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileCopy != null){
                try {
                    fileCopy.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
