package xia.xiao.fei01;


import org.springframework.stereotype.Service;

@Service
public class SomeServiceImpl implements SomeService {

    @Override
    public String doSome(String name, int age) {
        System.out.println("doSome业务功能实现。。。。");
        return "success";
    }
}
