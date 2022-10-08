package xia.xiao.proxy4;


public class Agent implements Service {

    // 传入目标（业务）对象，切面对象
    public Service target;
    AOP aop;

    public Agent(Service target, AOP aop) {
        this.target = target;
        this.aop = aop;
    }

    @Override
    public void buy() {
        try {
            // 切面的功能
            aop.before();
            target.buy();
            aop.after();
        }catch (Exception e){
            aop.exception();
        }
    }
}
