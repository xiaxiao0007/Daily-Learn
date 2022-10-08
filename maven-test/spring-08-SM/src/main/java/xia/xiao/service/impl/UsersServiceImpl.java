package xia.xiao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xia.xiao.mapper.UsersMapper;
import xia.xiao.pojo.Accounts;
import xia.xiao.pojo.Users;
import xia.xiao.service.AccountsService;
import xia.xiao.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    UsersMapper usersMapper;

    @Autowired
    AccountsService accountsService;

    @Override
    public int insert(Users user) {
        int num = usersMapper.insert(user);
        System.out.println("用户增加成功num="+num);

        // 调用账户的增加操作，调用的账户业务逻辑层的功能
        num = accountsService.insert(new Accounts(300,"王五","账户好的"));

        return num;
    }
}
