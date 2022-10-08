package Javase.day202212;
/*
枚举类型:需要多种可能性的返回值
    1.枚举是一种引用类型
    2.枚举怎么定义，语法是？
        enum 枚举类型名{
            枚举值1,枚举值2,.....
        }
    3.结果只有两种情况的，建议使用布尔类型。结果超过两种并且还是可以一枚一枚列举出来的，建议使用枚举类型。
    4.switch语句支持枚举类型。byte，short，char自动类型转换成int所以也支持switch语句
 */
public class EnumTest {
    public static void main(String[] args) {
        Result value = divide(10,2);
        System.out.println(value == Result.SUCCESS ?"成功":"失败");
    }
    public static Result divide(int i,int j){
        try {
            int c = i/j;
            return Result.SUCCESS;
        }catch (Exception e){
            return Result.FAIL;
        }
    }
}

//枚举也是一个类
enum Result{
    //枚举中的每一个值都是一个“常量”
    SUCCESS,FAIL
}

