package xia.xiao.proxy5;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {

    public static Object getAgent(Service target, AOP aop){
        return Proxy.newProxyInstance(
                // 类加载器
                target.getClass().getClassLoader(),
                // 目标对象实现的所有接口
                target.getClass().getInterfaces(),
                //代理功能的实现
                new InvocationHandler() {
                    @Override
                    public Object invoke(
                            // 生成代理对象
                            Object proxy,
                            // 正在被调用的目标方法buy(),show()
                            Method method,
                            // 目标方法参数
                            Object[] args) throws Throwable {
                        Object obj = null;
                        try {
                            // 切面
                            aop.before();
                            // 业务
                            obj = method.invoke(target, args);
                            // 切面
                            aop.after();
                        }catch(Exception e){
                            aop.exception();
                        }
                        // 生成的动态代理对象
                        return obj;
                    }
                }
        );
    }
}
