import java.sql.*;
/*
JDBC编程六步，用记事本打开
* */
public class JDBCTest02 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement statement = null;
        try {
            //1.注册驱动
            Driver driver = new com.mysql.cj.jdbc.Driver();//多态，父类型引用指向子类型对象
            /*
            1.出错原因？
                在注册的过程中现需要先把连接数据库的驱动jar导入到需要的项目中去
            2.新的驱动class在com.mysql.cj.jdbc包下
            * */
            DriverManager.registerDriver(driver);

            //2.获取连接
            /*
            url:统一资源定位符（网络中某个资源的绝对路径）
            https://www.baidu.com/ 这就是URL
            URL包括哪几部分
                协议
                IP
                PORT（端口号）
                资源名
            http://182.61.200.7:80/index.html
                http:// 通信协议
                182.61.200.7 服务器IP地址
                80 服务器上软件的端口
                index.html 是服务器上某个资源名

            说明:localhost和182.61.200.7都是本机IP地址

            什么是通信协议，有什么用
                通信协议是通信之前就提前定好的数据传送格式。数据包具体怎么传数据，格式提前定好的
            * */
            String url = "jdbc:mysql://localhost:3306/test01";
            String user = "root";
            String password = "1215..zx";
            conn = DriverManager.getConnection(url,user,password);

            //3.获取数据库操作对象（Statement专门执行专门执行sql语句）
            statement = conn.createStatement();

            //4.执行sql语句
            //String sql = "insert into dept(deptno,dname,loc) values(60,'人事部','南京')";
            //专门执行DML语句的（insert,delete,update）
            //返回值是“影响数据库中记录条数”
            //int count = statement.executeUpdate(sql);
            //System.out.println(count == 1 ? "保存成功":"保存失败");
            String deleteSql01 = "delete from dept where dname = '人事部'";
            statement.executeUpdate(deleteSql01);

            //5.处理查询结果
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            //6.释放资源
            /*
            为了保证资源一定释放，在finally语句块中关闭资源
            并且遵循从小到大依次关闭
            分别对其try..catch
            * */
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
