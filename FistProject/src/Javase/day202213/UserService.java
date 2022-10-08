package Javase.day202213;

public class UserService {

    public void register(String username,String password) throws ServiceException {
        if (null == username || username.length()<6 || username.length() > 14){
            throw new ServiceException("用户名不合法，长度必须在[6，14]之间");
        }
        System.out.println("注册成功");
    }
}

class ExceotionTest02{
    public static void main(String[] args) {

        UserService userService = new UserService();
        try {
            userService.register("null","123456");
        } catch (ServiceException e) {
            System.out.println(e.getMessage());
        }
    }
}