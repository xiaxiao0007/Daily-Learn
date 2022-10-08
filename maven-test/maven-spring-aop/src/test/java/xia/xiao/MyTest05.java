package xia.xiao;

import org.junit.Test;
import xia.xiao.proxy5.BookService;
import xia.xiao.proxy5.LogImpl;
import xia.xiao.proxy5.ProxyFactory;
import xia.xiao.proxy5.Service;

public class MyTest05 {

    @Test
    public void test(){
        // 得到动态代理对象
        Service agent = (Service)ProxyFactory.getAgent(new BookService(), new LogImpl());
        agent.buy();
    }

    @Test
    public void test01(){
        // 得到动态代理对象
        Service agent = (Service)ProxyFactory.getAgent(new BookService(), new LogImpl());
        agent.show(10
        );
    }
}
