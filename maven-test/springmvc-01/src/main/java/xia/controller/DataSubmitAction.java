package xia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DataSubmitAction {

    @RequestMapping("/one")
    public String one(String myName,int age){
        System.out.println("myName="+myName+",age="+(age+1));
        return "mian";
    }
}
