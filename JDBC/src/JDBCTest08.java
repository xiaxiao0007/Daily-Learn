import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Scanner;

/*
* 1.解决SQL注入问题（使用预编译SQL语句的方法,PreparedStatement）【重要】
*   只要用户提供的信息不参与SQL语句的编译过程，问题就解决了。
*   即使用户提供的信息中含有SQL语句的关键字，但是没有参与编译，不起作用
*   要想用户信息不参与SQL语句的编译，那么必须使用java.sql.PreparedStatement
*   PreparedStatement接口继承了java.sql.statement
*   PreparedStatement是属于预编译的数据库操作对象
*   PreparedStatement的原理是：预先对SQL语句的的框架进行编译，然后SQL语句传”值“
* 3.解决SQL注入的关键
*   用户提供的信息中即使含有sql语句的关键字，但是这些关键字并没有参与编译。不起作用
* 4.对比一下Statement和PreparedStatement?
*   -Statement存在sql注入问题，PreparedStatement解决了SQL注入问题
*   -Statement是编译一次执行一次。PreparedStatement是编译一次，可执行N次。PreparedStatement效率较高
*   -PreparedStatement会在编译阶段做类型检查
*
*   综上所述：PreparedStatement使用较多，只有极少数情况下需要使用Statement
* 5.什么情况下必须使用Statement呢?
*   业务方面要求必须支持SQL注入的时候
*   Statement支持SQL注入，凡是业务方面要求是需要进行SQL语句拼接的，必须使用Statement
* */
public class JDBCTest08 {
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
        PreparedStatement ps = null;//这里使用PreparedStatement（预编译的数据库操作对象）
        ResultSet resultSet = null;

        try {
            Class.forName(bundle.getString("driver"));

            connection = DriverManager.getConnection(bundle.getString("url"),
                    bundle.getString("user"), bundle.getString("password") );


            //3.获取预编译的数据库的操作对象【重点】
            //SQL语句的框子。其中一个 ? ,表示一个占位符,一个 ? 将来接受一个”值“。注意: ? 不能用单引号括起来
            String sql = "select * from user where user = ? and password = ?";
            //程序执行到此处，会发送sql语句框子给DBMS，然后DBMS进行SQL语句的预编译
            ps = connection.prepareStatement(sql);
            //给占位符?传值（第一个问号下标是1,第二问号下标是2,JDBC中所有下标从1开始）
            ps.setString(1,userLoginInfo.get("loginName"));
            ps.setString(2,userLoginInfo.get("loginPassWord"));


            //4.执行SQL语句
            resultSet = ps.executeQuery();

            //5.处理结果集
            if (resultSet.next()){
                flag = true;
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
            if (ps != null){
                try {
                    ps.close();
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
