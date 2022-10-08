package Final;

public class FianlTest {
    public static void main(String[] args) {

    }
}

class User{
    final double height = 1.8;

    //以下这一堆代码全部联合起来，weight变量也是赋值了1次
    //实例变量
    final double weight;
    //构造方法
   /* public User(){
        System.out.println("Hello Word");
        //this.weight = 10;系统赋默认值是在这个时候，weight = 0;
        //只要我赶在系统赋默认值之前赋值就行
    }*/

    public User(double d){
        this.weight = d;
    }

}
