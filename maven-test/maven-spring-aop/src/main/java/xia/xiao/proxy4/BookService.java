package xia.xiao.proxy4;

/*
* 使用的代理对象
* */

public class BookService implements Service {

    @Override
    public void buy() {
        System.out.println("图书购买功能实现");
    }
}
