package xia.xiao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xia.xiao.fei02.SomeService;

public class MyTest {

    @Test
    public void test(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("fei/applicationContext.xml");
        SomeService someService = (SomeService) ac.getBean("someService");
        System.out.println(someService.getClass());
        String s = someService.doSome("张三",22);
        System.out.println(s);
    }

    @Test
    public void test1(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("fei01/applicationContext.xml");
        SomeService someService = (SomeService) ac.getBean("someServiceImpl");
        System.out.println(someService.getClass());
        String s = someService.doSome("张三",22);
        System.out.println("测试中的返回值"+s);
    }

    @Test
    public void test2(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("fei02/applicationContext.xml");
        SomeService someService = (SomeService) ac.getBean("someServiceImpl");
        System.out.println(someService.getClass());
        String s = someService.doSome("张三",22);
        System.out.println("测试中的返回值"+s);
    }
}
