package MethodStudy;

//只在同一个文件下才会发生作用
//方法的重载
public class MethodTest01 {
    public static void a(String a){
        System.out.println(a);
    }

    public static void a(int a){
        System.out.println(a);
    }

    public static void a(double a){
        System.out.println(a);
    }
}
