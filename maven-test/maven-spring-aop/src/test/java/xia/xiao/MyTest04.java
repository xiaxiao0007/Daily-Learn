package xia.xiao;

import org.junit.Test;
import xia.xiao.proxy4.*;

public class MyTest04 {

    @Test
    public void test04(){
        Service agent = new Agent(new BookService(), new aopImpl());
        agent.buy();
        Service agent1 = new Agent(agent, new LogImpl());
        agent1.buy();
    }
}
