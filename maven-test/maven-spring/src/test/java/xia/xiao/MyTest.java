package xia.xiao;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xia.xiao.pojo.Student;
import xia.xiao.pojo01.Students;

public class MyTest {

    ApplicationContext ac;

    @Before
    public void before(){
        ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Test
    public void testStudent(){
        // 程序员创建对象
        Student stu = new Student();
        System.out.println(stu);
    }

    @Test
    public void testStudentSpring(){
        // 由spring容器进行对象的创建

        // 如果想从spring容器中取出对象，则要先创建容器对象，并启动才可取对象。
        // ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 从容器中取出对象
        Student stu = (Student) ac.getBean("stu");
        System.out.println(stu);
    }

    @Test
    public void testRef(){

        // 取出学生对象
        Students stu = (Students) ac.getBean("students");
        System.out.println(stu);
    }
}
