package xia.xiao;

import org.junit.Test;
import xia.xiao.proxy2.BookServiceImpl;
import xia.xiao.proxy2.SubBookServiceImpl;
import xia.xiao.proxy3.Agent;
import xia.xiao.proxy3.BookService;
import xia.xiao.proxy3.Service;

public class MyTest {

    @Test
    public void test02(){
        BookServiceImpl bookService = new SubBookServiceImpl();
        bookService.buy();
    }

    @Test
    public void test03(){
        Service agent = new Agent(new BookService());
        agent.buy();
    }

}
