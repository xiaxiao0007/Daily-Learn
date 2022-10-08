package Javase.Day2022112;

import java.io.*;

/*
拷贝目录
* */
public class HomeworkCopy {
    public static void main(String[] args) {
        File srcFile = new File("D:\\Book");
        File desFile = new File("D:\\机器学习");
        copydir(srcFile,desFile);
    }

    private static void copydir(File srcFile, File desFile) {
        if (srcFile.isFile()){

            FileInputStream in = null;
            FileOutputStream out = null;

            try {
                in = new FileInputStream(srcFile);
                String path = desFile.getAbsolutePath().endsWith("\\") ? desFile.getAbsolutePath() : (desFile.getAbsolutePath()+"\\") + desFile.getAbsolutePath().substring(3);
                out = new FileOutputStream(path);
                byte[] bytes = new byte[1024*1024];
                int readCount = 0;
                while((readCount = in.read(bytes)) !=-1){//每次数组的元素都是不同的,每次写都会在末尾进行写操作
                    out.write(bytes,0,readCount);
                }
                out.flush();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (out != null){
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (in != null){
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }//递归结束出口

        File[] files = srcFile.listFiles();
        for (File file:files){
            if (file.isDirectory()){
                String srcDir = file.getAbsolutePath();
                String desDir = desFile.getAbsolutePath().endsWith("\\") ? desFile.getAbsolutePath() : (desFile.getAbsolutePath()+"\\") + srcDir.substring(3);
                File newFile = new File(desDir);
                if (!newFile.exists()){
                    newFile.mkdirs();
                }
            }
            copydir(file,desFile);
        }
    }
}
