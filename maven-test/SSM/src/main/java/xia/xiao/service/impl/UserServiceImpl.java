package xia.xiao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xia.xiao.mapper.UserMapper;
import xia.xiao.pojo.User;
import xia.xiao.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    // 切记：一定会有数据访问层的对象
    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> selectUserPage(String userName, String userSex, int startRow) {
        return userMapper.selectUserPage(userName, userSex, startRow);
    }
}
