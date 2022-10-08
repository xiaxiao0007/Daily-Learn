package xia.xiao;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xia.xiao.pojo.User;
import xia.xiao.service.UserService;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext_mapper.xml","classpath:applicationContext_service.xml"})
public class MyTest {

    @Autowired
    UserService userService;

    @Test
    public void testSelect(){
        List<User> list = userService.selectUserPage(null,null,0);
        list.forEach(user-> System.out.println(user));
    }


}
