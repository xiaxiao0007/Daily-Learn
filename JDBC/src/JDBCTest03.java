/*
注册驱动的另一种方式（这种方式常用）
创建JDBC应用程序
    构建一个 JDBC 应用程序包括以下六个步骤
        导入数据包：需要你导入含有需要进行数据库编程的JDBC类的包。大多数情况下使用 import java.sql.就足够了。
        注册JDBC驱动器：需要你初始化一个驱动器，以便于你打开一个与数据库的通信通道。
        打开连接：需要使用 DriverManager.getConnection()方法创建一个Connection对象，它代表与数据库的物理连接。
        执行查询：需要使用类型声明的对象建立并提交一个SQL语句到数据库。
        提取结果数据：要求使用适当的 ResultSet.getXXX()方法从结果集中检索数据。
        清理环境：依靠JVM的垃圾收集来关闭所有需要明确关闭的数据库资源。
* */
import java.sql.*;
public class JDBCTest03 {

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try{
            //STEP 1: Register JDBC driver,注册驱动
            //通过反射机制来注册
            //注册驱动的第二种方式：常用的
            //为什么这种方式常用?因为参数是一个字符串，字符串可以写到xxx.properties文件中
            //以下方法不需要接受返回值，因为我们只想要它的类加载动作
            Class.forName("com.mysql.cj.jdbc.Driver");

            //STEP 2: Open a connection，打开连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test01","root","1215..zx");

            //STEP 3: 获取数据库操作对象
            stmt = conn.createStatement();

            //STEP 4:执行sql语句
            int count = stmt.executeUpdate("insert into dept(deptno,dname,loc) values(60,'人事部','北京')");
            System.out.println(count == 1 ? "保存成功":"保存失败");

            //STEP 5: Extract data from result set


            //STEP 6: Clean-up environment
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
    }//end main
}
