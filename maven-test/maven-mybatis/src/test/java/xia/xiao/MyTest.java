package xia.xiao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyTest {

    SqlSession sqlSession;
    // 优化测试类
    @Before // 在所有的@Test方法前先执行的代码
    public void openSqlSession() throws IOException {
        // 使用文件流读取核心配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");

        // 创建SqlSessionFactory工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

        // 取出sqlSession的对象
        sqlSession = factory.openSession();
    }

    @After // 在所有的@Test方法之后在执行的代码
    public void closeSqlSession(){
        // 关闭sqlSession
        sqlSession.close();
    }

    @Test
    public void Test01() throws IOException {

        // 完成查询操作
        List<Student> list = sqlSession.selectList("xxf.getAll");
        list.forEach(student -> System.out.println(student));

    }

    @Test
    public void Test02() throws IOException {

        // 按主键完成查询操作
        Student stu = sqlSession.selectOne("xxf.getById",1);
        System.out.println(stu);;

    }

    @Test
    public void Test03() throws IOException {

        // 完成查询操作
        List<Student> list = sqlSession.selectList("xxf.getByName","张三");
        for (Student stu:list){
            System.out.println(stu);
        }

    }

    @Test
    public void Test04() throws IOException {
        // 完成插入操作
        int count = sqlSession.insert("xxf.insert",new Student("王二","wanger@123.com",19));
        System.out.println(count);
        // 切记：在所有的增删改后必须手工提交事务
        sqlSession.commit();

    }

    @Test
    public void Test05() throws IOException {

        /*
        未优化的写法
        使用文件流读取核心配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");

        创建SqlSessionFactory工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

        取出sqlSession的对象,sql连接的对象
        SqlSession sqlSession = factory.openSession();

        */

        // 完成插入操作
        int count = sqlSession.delete("xxf.delete",3);
        System.out.println(count);
        // 切记：在所有的增删改后必须手工提交事务
        sqlSession.commit();

        /*
        关闭sqlSession
        sqlSession.close();
        */
    }

    @Test
    public void Test06() throws IOException {

        // 完成插入操作
        int count = sqlSession.update("xxf.update",new Student());
        System.out.println(count);
        // 切记：在所有的增删改后必须手工提交事务
        sqlSession.commit();

    }

}
