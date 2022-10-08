package xia.xiao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xia.xiao.pojo.Accounts;
import xia.xiao.pojo.Users;
import xia.xiao.service.AccountsService;
import xia.xiao.service.UsersService;

public class MyTest {

    @Test
    public void testSimple(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext_service.xml");
        // 取出UserServiceImpl
        UsersService usersServiceImpl = (UsersService) ac.getBean("usersServiceImpl");

        int num = usersServiceImpl.insert(new Users(100,"张三", "123"));
        System.out.println(num);
    }

    @Test
    public void testSimple01(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext_trans.xml");
        // 取出UserServiceImpl
        AccountsService accountsServiceImpl = (AccountsService) ac.getBean("accountsServiceImpl");

        int num =accountsServiceImpl.insert(new Accounts(104,"张三03", "账户_安全"));
        System.out.println(num);
    }
}
