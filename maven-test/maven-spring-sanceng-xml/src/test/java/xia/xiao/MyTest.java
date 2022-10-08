package xia.xiao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xia.xiao.controller.UserController;
import xia.xiao.pojo.Users;

public class MyTest {

    @Test
    public void testInsert() {
        // 创建容器并启动
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 取出对象
        UserController userController = (UserController) ac.getBean("uController");
        // 测试功能
        int num = userController.insert(new Users(200, "王二", 20));
    }
}
