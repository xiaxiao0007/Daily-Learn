package MethodStudy;

public class Test01 {
    public static void main(String[] args){
        User user = new User();//实例化对象名，无参数调用构造方法就是实例化对象
        User a = new User(1);//调用构造方法
        System.out.println(user);
        System.out.println(a);

    }
}
