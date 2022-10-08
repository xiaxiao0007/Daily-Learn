package CanShuChuanDi;

public class Test01 {
    public static void main(String[] args){
        User user = new User(10);//user本身是变量占用内存地址
        add(user);//其本身就是个内存地址
        System.out.println(user.age);
    }
    public static void add(User user){//user是局部变量
        user.age++;
        System.out.println(user.age);
    }
}
class User{

    int age;//实例变量在堆内存中

    static int number; //静态变量再方法去中

    public User(int i){
        age = i;
    }
}