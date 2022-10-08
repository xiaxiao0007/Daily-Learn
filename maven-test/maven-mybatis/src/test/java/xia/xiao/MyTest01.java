package xia.xiao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import xia.xiao.mapper.StudentsMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyTest01 {

    SqlSession sqlSession;
    StudentsMapper stuMapper;
    // 优化测试类
    @Before // 在所有的@Test方法前先执行的代码
    public void openSqlSession() throws IOException {
        // 使用文件流读取核心配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");

        // 创建SqlSessionFactory工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

        // 取出sqlSession的对象
        sqlSession = factory.openSession();

        // 取出动态代理对象
        stuMapper = sqlSession.getMapper(StudentsMapper.class);
    }

    @After // 在所有的@Test方法之后在执行的代码
    public void closeSqlSession(){
        // 关闭sqlSession
        sqlSession.close();
    }

    @Test
    public void Test01(){

        // 完成查询操作
        // 取出动态代理的对象，完成接口中方法的调用，实则调用xml文件中相关的标签的功能
        // StudentsMapper stuMapper = sqlSession.getMapper(StudentsMapper.class);// 取出动态代理对象
        List<Student> students = stuMapper.getAll();
        for (Student student:students){
            System.out.println(student);
        }
    }

    @Test
    public void TestUpdate(){
        Student student = new Student(4,"麻子","mazi@123.com",20);
        int num = stuMapper.update(student);
        System.out.println(num);
        sqlSession.commit();
    }

    @Test
    public void testGetById(){
        Student student = stuMapper.getById(4);
        System.out.println(student);
    }

    @Test
    public void testGetByName(){
        List<Student> students = stuMapper.getByName("三");
        for (Student student:students){
            System.out.println(student);
        }
    }

    @Test
    public void testGetByNameGood(){
        List<Student> students = stuMapper.getByName("三");
        for (Student student:students){
            System.out.println(student);
        }
    }

    @Test
    public void testGetByNameOrAddress(){
        List<Student> students = stuMapper.getByNameOrAddress("email","@126");
        for (Student student:students){
            System.out.println(student);
        }
    }

    @Test
    public void testInsert(){
        int count = stuMapper.insert(new Student("王二","wanger@126.com",21));
        System.out.println(count);
        sqlSession.commit();
        System.out.println();
    }

    @Test
    public void testGetByCondition(){
        Student student = new Student();
        student.setName("二");
        student.setAge(21);
        List<Student> students= stuMapper.getByCondition(student);
        for (Student student1:students){
            System.out.println(student1);
        }
    }

    @Test
    public void testUpdateSet(){
        Student student = new Student();
        student.setId(9);
        student.setAge(22);
        int count = stuMapper.updateSet(student);
        sqlSession.commit();
        System.out.println(count);
    }

    @Test
    public void testSelectIds(){
        Integer[] arr = {1,2,3};
        List<Student> students = stuMapper.getByIds(arr);
        for (Student student:students){
            System.out.println(student);
        }
    }

    @Test
    public void testGetByAge(){
        List<Student> students = stuMapper.getByAge(18, 22);
        for (Student student:students){
            System.out.println(student);
        }
    }

    @Test
    public void testGetMap(){
        Map map = new HashMap<>();
        map.put("ageBegin",18);
        map.put("ageEnd", 20);
        List<Student> students = stuMapper.getByMap(map);
        for (Student student:students){
            System.out.println(student);
        }
    }

    @Test
    public void testGetReturnMap(){
         Map map = stuMapper.getReturnMap(1);
        System.out.println(map);
        System.out.println(map.get("name"));
    }

    @Test
    public void testGetReturnMaps() {
        Map map = new HashMap<>();
        map.put("idBegin", 1);
        map.put("idEnd", 3);
        List<Map> maps = stuMapper.getReturnMaps(map);
        for (Map map1 : maps) {
            System.out.println(map1);
            System.out.println(map1.get("name"));
        }
    }
}
