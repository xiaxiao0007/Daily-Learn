package xia.xiao.proxy5;

public class LogImpl implements AOP {

    @Override
    public void before() {
        System.out.println("打印日志");
    }
}
