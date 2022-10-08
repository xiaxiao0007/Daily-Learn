package Javase.Day2022112;

import java.io.File;

/*
File中的listFiles方法
* */
public class FileTest02 {
    public static void main(String[] args) {
        //File[] listFiles()
        //获取当前目录下所有的子文件
        File file = new File("D:");
        File[] files = file.listFiles();
        for (File file1: files){
            System.out.println(file1.getName());
        }
    }
}
