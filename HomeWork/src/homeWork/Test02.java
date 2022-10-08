package homeWork;

public class Test02 {
    public static void main(String[] args){
        Test01 test01 = new Test01();
        System.out.println(test01.age);
        Test01 a = new Test01(10);
        System.out.println(test01.age);//与第六行有着相同的价值。对类中任何构造方法调用，都可能访问类中的成员变量
        System.out.println(a.age);
    }
}
