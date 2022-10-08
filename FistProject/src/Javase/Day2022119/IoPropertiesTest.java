package Javase.Day2022119;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.util.Properties;

public class IoPropertiesTest {
    public static void main(String[] args) throws Exception {
        //获取一个文件的绝对路径
        /*
        String path = Thread.currentThread().getContextClassLoader()
                .getResource("user.properties").getPath();
        FileReader reader = new FileReader(path);
        * */
        //以流的方式返回所需要的路径
        InputStream reader = Thread.currentThread().getContextClassLoader().getResourceAsStream("user.properties");

        Properties properties = new Properties();
        properties.load(reader);
        reader.close();
        //通过key获取value
        String className = properties.getProperty("className");
        System.out.println(className);
    }
}
