package Javase.Day202211;
/*
总结一下之前所学过的经典异常
    空指针异常：NullPointException
    类型转换异常：ClassCastException
    数组下标越界异常：ArrayIndexOutOfBoundsException
    数字格式化异常：NumberFormatException
Integer类当中的常用方法
 */
public class IntegerMethod {
    public static void main(String[] args) {

        //重点方法
        //static int parentInt(String s)
        //静态方法，传参String，返回int
        //将数字型字符串转换成数字
        int retvalue = Integer.parseInt("123");
        System.out.println(retvalue);

        //Integer.valueOf(int i)方法或Integer.valueOf(String str)方法
        //将int -> Integer 或 String -> Integer
        System.out.println(Integer.valueOf(1000));
        System.out.println(Integer.valueOf("1000"));

        String string = "1997-12-15";
        String[] str = string.split("-");
        int a = Integer.parseInt(str[0]);
        System.out.println(a);

        //String -> int
        String s1 = "123";
        int i = Integer.parseInt(s1);
        System.out.println(i);
        //int -> String
        int i1 = 12;
        String s2 = String.valueOf(i1);
        System.out.println(i1);
        //int -> Integer
        int i2 = 10;
        Integer a1 = Integer.valueOf(i2);
        System.out.println(a1);
        //Integer -> int
        Integer a2 = 13;
        int i3 = a2.intValue();
        System.out.println(i3);
        //String -> Integer
        String s3 = "456";
        Integer a3 = Integer.valueOf(s3);
        System.out.println(a3);
        //Integer -> String
        Integer a4 = 123;
        String s4 = String.valueOf(a4);
        System.out.println(s4);
    }
}
