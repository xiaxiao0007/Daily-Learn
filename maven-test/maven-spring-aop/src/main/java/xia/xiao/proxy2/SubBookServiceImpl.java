package xia.xiao.proxy2;

/*
*   子类就是代理类，将父类的图书购买功能添加事务切面
* */

public class SubBookServiceImpl extends BookServiceImpl{

    @Override
    public void buy() {
        // 事务切面
        try {
            System.out.println("事务开始");
            super.buy();
            System.out.println("事务提交");
        }catch (Exception e){
            System.out.println("事务回滚");
        }
    }
}
