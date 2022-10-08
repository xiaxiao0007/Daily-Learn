package xia.xiao.dao;

import org.springframework.stereotype.Repository;
import xia.xiao.pojo.Users;

/*
* 数据访问层
* */

@Repository
public class UserMapperImpl implements UserMapper {
    @Override
    public int insert(Users user) {
        System.out.println(user.getUname()+"用户增加成功");
        return 1;
    }
}
