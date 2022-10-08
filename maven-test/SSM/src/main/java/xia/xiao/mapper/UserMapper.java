package xia.xiao.mapper;

import org.apache.ibatis.annotations.Param;
import xia.xiao.pojo.User;

import java.util.List;

public interface UserMapper {

    List<User> selectUserPage(
            @Param("userName")
            String userName,
            @Param("userSex")
            String userSex,
            @Param("startRow")
            int startRow);

    int insert(User user);
}
