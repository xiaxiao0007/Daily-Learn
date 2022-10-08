package xia.xiao.service;

import xia.xiao.pojo.User;

import java.util.List;

public interface UserService {

    List<User> selectUserPage(String userName, String userSex, int startRow);
}
