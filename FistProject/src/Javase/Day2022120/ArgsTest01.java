package Javase.Day2022120;
/*
可变长度参数
    int...args 这就是可变长度参数
    语法：类型...
    1.可变长度参数要求的参数个数是0~n个
    2.可变长度参数在参数列表中必须在最后一个位置上，而且可变长度参数只能有一个
    3.可变长度参数可以当成一个数组来看，也可以传一个数组
* */
public class ArgsTest01 {
    public static void main(String[] args) {
        m();
        m(10);
        m(10,10,10);
    }

    public static void m(int... args){
        System.out.println("m方法执行了");
    }
}
