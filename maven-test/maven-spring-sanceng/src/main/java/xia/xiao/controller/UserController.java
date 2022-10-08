package xia.xiao.controller;


import xia.xiao.pojo.Users;
import xia.xiao.service.UserService;
import xia.xiao.service.impl.UserServiceImpl;

/*
* 界面层
* */
public class UserController {

    // 如何取访问业务逻辑层，就是创建对象
    // 【重要】所有的界面层都会有业务逻辑层的对象
    private UserService userService = new UserServiceImpl();

    // 界面层的功能实现，对外提供访问的功能
    public int insert(Users user){

        userService.insert(user);
        return 1;
    }
}
