package xia.xiao.service.impl;

import xia.xiao.dao.UserMapper;
import xia.xiao.dao.UserMapperImpl;
import xia.xiao.pojo.Users;
import xia.xiao.service.UserService;
/*
* 业务逻辑层
*
* */
public class UserServiceImpl implements UserService {

    // 重点：在所有的业务逻辑层中都必定有数据访问层的对象

    private UserMapper userMapper = new UserMapperImpl();
    @Override
    public int insert(Users user) {
        return userMapper.insert(user);
    }
}
