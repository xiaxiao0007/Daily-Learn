package xia.xiao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xia.xiao.pojo.User;
import xia.xiao.service.UserService;

import java.util.List;

@CrossOrigin // 在服务端支持跨域访问
@Controller // 如果本类中全部都是Ajax请求，则使用此注解，方法上的@RequestBody可不写
@RequestMapping("/user")
public class UserController {

    //【重要】 一定有业务逻辑层的对象
    @Autowired
    UserService userService;

    public static final int PAGE_SIZE =5;

    @RequestMapping("/selectUserPage")
    @ResponseBody
    public List<User> selectUserPage(String userName, String userSex, Integer page){
        // 根据页码计算起始行
        int startRow = 0;
        if (page != null){
            startRow = (page -1) * PAGE_SIZE;
        }

        return userService.selectUserPage(userName, userSex,startRow);
    }
}
