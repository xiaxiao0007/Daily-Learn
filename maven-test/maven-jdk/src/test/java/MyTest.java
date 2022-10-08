import com.proxy.ProxyFactory;
import com.service.Service;
import com.service.impl.SuperStarDog;
import com.service.impl.SuperStarLiu;
import org.junit.Test;

public class MyTest {

    @Test
    public void testJDK(){

        ProxyFactory factory = new ProxyFactory(new SuperStarDog());
        Service agent = (Service) factory.getAgent();
        agent.sing();
    }

    @Test
    public void testJDK01(){
        // 使用动态代理
        ProxyFactory factory = new ProxyFactory(new SuperStarLiu());
        Service agent = (Service) factory.getAgent();
        agent.show();
    }
}
