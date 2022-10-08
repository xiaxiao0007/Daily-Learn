package com;

import com.impl.Agent;
import com.impl.Fa;
import com.impl.SuperStarLiu;
import com.service.Service;
import org.junit.Test;

import java.lang.reflect.Proxy;
import java.util.UUID;

public class MyTest {

    @Test
    public void testAgent(){
        // 测试功能
        // SuperStarLiu liu = new SuperStarLiu();
        // liu.sing();

        // Agent agent = new Agent();
        // agent.sing();

        // 有接口和实现类，必须使用接口指向实现类（规范）
        // Service agent = new Agent();
        // agent.sing();
    }

    // 改进成面向接口的编程
    @Test
    public void testAgent01(){
        Service agent = new Agent(new Fa());
        agent.sing();
    }

    @Test
    public void testUUID(){
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid.toString().replace("-","").substring(20));
    }
}
