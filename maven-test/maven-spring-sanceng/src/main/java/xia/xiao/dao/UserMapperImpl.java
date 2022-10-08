package xia.xiao.dao;

import xia.xiao.pojo.Users;

public class UserMapperImpl implements UserMapper {
    @Override
    public int insert(Users user) {
        System.out.println(user.getUname()+"用户增加成功");
        return 1;
    }
}
