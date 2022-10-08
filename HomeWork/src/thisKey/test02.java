package thisKey;

public class test02 {

    String name;

    public static void test03(){
        System.out.println("不能访问");
    }

    public void test04(){
        System.out.println(this.name);
        test03();//不会出现空指针异常
        System.out.println("能访问");
    }
}//实例方法能访问实例变量和实例方法
