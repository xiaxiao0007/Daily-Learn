import java.sql.*;
import java.util.ResourceBundle;
import java.util.Scanner;

/*
* 实现升序降序功能
* */
public class JDBCTest09 {
    public static void main(String[] args) {
        // 用户在控制台输入desc就是降序
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入desc或asc,desc表示降序，asc表示升序");
        System.out.print("请输入:");
        String str = scanner.nextLine();

        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            Class.forName(bundle.getString("driver"));

            connection = DriverManager.getConnection(bundle.getString("url"),
                    bundle.getString("user"), bundle.getString("password") );

            statement = connection.createStatement();

            String sql = "select sal from emp order by sal "+str;
            resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                System.out.println(resultSet.getString("sal"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(resultSet != null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(statement != null){
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

    }
}
