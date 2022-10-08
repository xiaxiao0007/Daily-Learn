package xia.xiao.proxy3;
/*
* 代理对象
* */
public class Agent implements Service{

    public Service target;

    public Agent(Service target) {
        this.target = target;
    }

    @Override
    public void buy() {
        try {
            // 切面的功能
            System.out.println("事务开始");
            target.buy();
            System.out.println("事务提交");
        }catch (Exception e){
            System.out.println("事务回滚");
        }
    }
}
