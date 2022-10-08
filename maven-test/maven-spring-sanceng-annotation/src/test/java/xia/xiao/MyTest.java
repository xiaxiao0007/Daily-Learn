package xia.xiao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xia.xiao.controller.UserController;
import xia.xiao.pojo.Users;

public class MyTest {

    @Test
    public void testSimple(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserController userController = (UserController) ac.getBean("userController");
        int num = userController.insert(new Users(100,"三",20));
        System.out.println(num);

    }
}
