package Javase.Day20211225;
//String[] args 数组的应用
public class ArrayTest02 {
    public static void main(String[] args) {
        if(args.length !=2){
            System.out.println("使用该系统");
            return;
        }
        String username = args[0];
        String password = args[1];
        if (username.equals("admin")&&password.equals("123")){
            System.out.println("登录成功");
        }

    }
}
