package Javase.Day2022112;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
File
    1.File类和四大家族没有关系，所以File类不能完成文件的读和写
    2.File对象代表什么?
        文件和目录路径名的抽象表示形式。一个File对象有可能对应的是目录，也可能是文件。
    3.需要掌握File类中常用的方法
* */
public class FileTest01 {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\file");
        //判断是否存在
        boolean bo = file.exists();
        System.out.println(bo);

        //如果D:\file不存在，则以文件的形式创建出来
        /*if(!file.exists()){
            file.createNewFile();
        }*/

        //如果D:\file不存在，则以目录的形式创建出来
        /*if(!file.exists()){
            file.mkdir();
        }*/

        //创建多重目录 mkdirs()
       /* File f2 = new File("D:\\d\\c");
        if(!f2.exists()){
            f2.mkdirs();
        }*/

        //获取文件的父路径 getParent()
        /*File f3 = new File("D:\\d\\c");
        String parentPath = f3.getParent();
        System.out.println(parentPath);*/
        //获取文件的绝对路径 getAbsolutePath()
        /*File parentFile = f3.getParentFile();
        System.out.println("获取绝对路径"+parentFile.getAbsolutePath());*/

        /*File file1 = new File("D:\\d\\c");
        //获取文件名 getName()
        System.out.println("文件名"+file1.getName());*/

        //判断是否是一个目录
        //System.out.println(file.isDirectory());

        //判断是否是一个文件
        //System.out.println(file.isFile());

        /*//获取文件最后一次修改时间
        long haoMiao = file.lastModified();
        //将毫秒数转换成日期
        Date time = new Date(haoMiao);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss sss");
        String strTime = sdf.format(time);
        System.out.println(strTime);*/

        //获取文件大小
        //System.out.println(file.length());
    }
}
