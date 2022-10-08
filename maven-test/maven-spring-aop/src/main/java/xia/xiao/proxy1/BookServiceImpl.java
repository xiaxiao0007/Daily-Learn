package xia.xiao.proxy1;

/*
* 图书购买业务和事务耦合在一起
*
* */

public class BookServiceImpl {

    public void buy(){
        try {
            System.out.println("事务开始");
            System.out.println("图书购买业务功能实现.....");
            System.out.println("事务提交");
        }catch (Exception e){
            System.out.println("事务回滚");
        }
    }
}
