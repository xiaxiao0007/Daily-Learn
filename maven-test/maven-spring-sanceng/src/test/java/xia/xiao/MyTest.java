package xia.xiao;

import org.junit.Test;
import xia.xiao.controller.UserController;
import xia.xiao.pojo.Users;

public class MyTest {

    @Test
    public void testInsert(){
        // 创建UserController对象
        UserController userController = new UserController();
        int num = userController.insert(new Users(100, "张三", 22));
        System.out.println(num);
    }
}
