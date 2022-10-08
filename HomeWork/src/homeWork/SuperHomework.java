package homeWork;

public class SuperHomework {
    public static void main(String[] args) {
        new C();
    }
}
class A{
    public A(){
        System.out.println("1");
    }
}
class B extends A{
    public B(){
        System.out.println("2");
    }
    public B(String name){
        //默认的super(),调用了父类的无参数构造方法
        System.out.println("3");
    }
}
class C extends B{
    public C(){
        this("zhangsan");
        System.out.println("4");
    }

    public C(String name){
        this(name,10);
        System.out.println("5");
    }

    public C(String name,int age){
        super(name);
        System.out.println("6");
    }

}