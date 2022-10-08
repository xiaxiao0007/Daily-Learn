import java.sql.*;
import java.util.ResourceBundle;

public class JDBCTest01 {
    public static void main(String[] args) throws Exception {

        //创建对象可以通过反射机制
        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
        String className = bundle.getString("className");
        Class c = Class.forName(className);
        //JDBC jdbc = (JDBC)c.newInstance();

        //以下代码都是面向接口调用方法，不需要修改
        //jdbc.getConnection();
    }
}
