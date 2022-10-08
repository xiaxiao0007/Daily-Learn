package xia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller // 交给spring去创建对象
public class DemoAction {

    /*
    * action中所有的功能实现都是由方法来完成的
    * action方法的规范
    *   1.访问权限是public
    *   2.方法的返回值任意
    *   3.方法名称任意
    *   4.方法可以没有参数，如果有可以是任意类型
    *   5.要使用@requestMapping注解来声明一个访问路径（名称）
    * */

    @RequestMapping("/demo")
    public String demoAction(){
        return "main";
    }

    @RequestMapping(value = "/req", method = RequestMethod.GET)
    public String getDemoAction(){
        System.out.println("处理get请求");
        return "main";
    }
}
