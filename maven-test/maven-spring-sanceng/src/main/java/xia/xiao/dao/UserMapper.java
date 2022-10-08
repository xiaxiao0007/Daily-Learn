package xia.xiao.dao;

/*
* 数据访问层
* */

import xia.xiao.pojo.Users;

public interface UserMapper {
    // 增加用户的操作
    int insert(Users user);
}
