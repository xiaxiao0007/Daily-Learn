package xia.controller;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import xia.pojo.User;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class DateAction {

    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
/*
    @RequestMapping("/date")
    public String date(
            @DateTimeFormat(pattern = "yyyy-MM-dd")
            Date myDate) {
        System.out.println(myDate);
        System.out.println(sf.format(myDate));
        return "main";
    }
*/
    // 注册一个全局的日期处理注解
    /*@InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(Date.class,new CustomDateEditor(sf,true));
    }

    @RequestMapping("/date")
    public String date(Date myDate) {
        System.out.println(myDate);
        System.out.println(sf.format(myDate));
        return "main";
    }*/

    @RequestMapping("/myDate")
    public String list(HttpServletRequest request) throws ParseException {
        User user = new User("张三",sf.parse("2000-10-1"));
        User user1 = new User("王二",sf.parse("2000-10-2"));

        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user1);

        request.setAttribute("users",users);

        return "main";
    }
}
