package Javase.Day2022120;

public class UserService {

    int no;
    String name;
    boolean sex;

    public UserService() {
    }

    public UserService(int no, String name, boolean sex) {
        this.no = no;
        this.name = name;
        this.sex = sex;
    }

    public  boolean login(String name, String password){
        if ("admin".equals(name)&&"123".equals(password)){
            return true;
        }
        return false;
    }

    public void logout(){
        System.out.println("系统已经安全退出！");
    }
}
