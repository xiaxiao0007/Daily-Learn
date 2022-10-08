package FengZhuang;

public class UserTest {
    public static void main(String[] args){

        FengZhuangTest user = new FengZhuangTest();

        user.setAge(151);
        //操作入口变成了只能通过set和get方法进行访问，在set方法和get方法执行过程中可以进行安全过滤。
        System.out.println(user.getAge());
    }
}
