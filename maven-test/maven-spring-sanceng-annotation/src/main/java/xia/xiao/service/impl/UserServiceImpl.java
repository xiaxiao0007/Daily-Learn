package xia.xiao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xia.xiao.dao.UserMapper;
import xia.xiao.pojo.Users;
import xia.xiao.service.UserService;

/*
* 业务逻辑层
*
* */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int insert(Users user) {
        return userMapper.insert(user);
    }
}
