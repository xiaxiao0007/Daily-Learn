import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Scanner;

/*
实现功能：
    1.需求：模拟用户登录功能的实现
    2.业务描述
        程序运行的时候，提供一个输入的入口，可以让用户输入用户名和密码，用户输入用户名和密码之后，
        提交信息，Java程序搜集到用户信息，Java程序连接数据库验证用户名和密码是否和合法
        合法：显示登录成功
        不合法：显示登录失败
    3.数据的准备
        在实际开发中，表的设计会使用专业的建模工具，
    4.当前程序存在的问题
        用户名：fdsa
        密码：fdsa' or '1'='1'
        这种现象被称为sql注入（安全隐患）。（黑客经常使用）
    5.导致SQL注入的原因
        用户输入的信息含有sql语句的关键字，并且这些关键字参与sql语句的编译过程，导致sql语句的愿意被扭曲，
        进而达到sql注入
* */
public class JDBCTest07 {
    public static void main(String[] args) {
        //初始化界面
        Map<String,String> userLoginInfo = initUI();
        
        //验证用户名和密码
        boolean loginSuccess = login(userLoginInfo);
        System.out.println(loginSuccess ? "登录成功":"登录失败");
    }

    /*
    * 用户登录
    * userLoginInfo 用户登录信息
    * false表示失败，true表示成功
    * */
    private static boolean login(Map<String, String> userLoginInfo) {
        //标记变量
        boolean flag = false;

        //JDBC代码
        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            Class.forName(bundle.getString("driver"));

            connection = DriverManager.getConnection(bundle.getString("url"),
                    bundle.getString("user"), bundle.getString("password") );

            //获取数据库的操作对象
            statement = connection.createStatement();

            //拼接字符串
            /*
            String sql = "select * from user where user = '"+userLoginInfo.get("loginName")+"' and password = '"+userLoginInfo.get("loginPassWord")+"'";
            //以上正好完成了sql语句的拼接，以下代码的含义是，发送sql语句给DBMS，DBMS进行SQL编译
            //正好将用户提供的”非法信息“编译进去，导致原sql语句的含义被扭曲了
            resultSet = statement.executeQuery(sql);
            if (resultSet.next()){
                flag = true;
            }
            * */

            //执行sql语句
            String sql = "select user,password from user";
            resultSet = statement.executeQuery(sql);

            //处理结果集
            while (resultSet.next()){
                String user = resultSet.getString("user");
                String password = resultSet.getString("password");
                if (user.equals(userLoginInfo.get("loginName")) && password.equals(userLoginInfo.get("loginPassWord"))){
                    flag = true;
                    break;
                }
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if (resultSet != null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return flag;
    }

    /*
    初始化用户界面
    @return 用户输入的用户名和密码登录信息
    Map集合可以保存成对的数据
    * */
    private static Map<String, String> initUI() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("用户名:");
        String loginName = scanner.nextLine();
        System.out.print("密码:");
        String loginPassWord = scanner.nextLine();
        
        Map<String,String>  userLoginInfo = new HashMap<>();
        userLoginInfo.put("loginName",loginName);
        userLoginInfo.put("loginPassWord",loginPassWord);
        
        return userLoginInfo;
    }


}
