package xia.xiao.fei;

public class SomeServiceImpl implements SomeService{

    @Override
    public String doSome(String name, int age) {
        System.out.println("doSome业务功能实现。。。。");
        return "success";
    }
}
