package Javase.Day2021;

public class DataType {
    /*
    1.数据类型的作用：不同的数据类型的数据占用空间大小不同，主要是指示jvm虚拟机在运行的时候
      给数据分配多大的内存空间。
    2.Java中的数据类型包括两种：
        基本数据类型【四大类八小种】
            第一类：整数型 byte(1个字节大小)，short(2个字节大小)，int(4个字节大小)，long(8个字节大小)
            第二类：浮点型 float(4个字节大小)，double(8个字节大小)
            第三类：布尔型 boolean(1 个字节大小)
            第四类：字符型 char(2个字节大小) 文字，英语字母，都有规定二进制代码(用十进制表示)
                   人为制定对照转换关系：字符编码：ASCII码 'a'=97 'A'= 65 '0'=48
                   'a' ---(按照ASCII解码)--> 01100001
                   01100001 ---按照ASCII编码--> 'a' 运用这种规则不会出现乱码
        引用数据类型：
            类
            接口
            数组
            java语言中所有的class都属于引用数据类型
     3.字符串"abc"不属于基本数据类型，属于引用数据类型,字符属于基本数据类型
        字符串使用双引号"abc"
        字符使用单引号'a'
     4.Java语言源代码采用的是Unicode（统一编码）编码方式,所以"标识符"可以用中文。
     5.成员变量没有手动赋值系统会默认赋值【局部变量不会】
 char类型
     6.转义字符 \n 换行符(代表一个字符) 反斜杠在Java语言当中具有转义功能
          \t 制表符
          转义字符可以出现在特殊字符之前,可以将特殊字符转换成普通字符
     7.jdk中自带的native2ascii.exe命令,可以将文字转换成Unicode编码形式
        \ u    翻译对应的编码方式
     8.Java中数据字面值会默认是int类型,在使用long类型时需要将字面值转换成long类型
     9.强制类型转换(大容量转换成小容量需要发生强制类型转换) int y = (int) 100L,会损失精度,精度损失严重.
 浮点型
     10.在Java语言中,所有的浮点型字面值,默认被当作double类型来处理,
        要想该字面值当作float类型来处理，需要在字面值后面添加F/f
        注意:double和float在计算机内部二进制存储的都是近似值
 布尔类型
     11.布尔类型在实际开发当中非常重要，经常使用在逻辑运算和条件控制语句当中
数据类型的转换
     12.转换规则
        八种基本的数据类型当中除布尔类型之外剩下的7种类型之间都可以互相转换
        小容量向大容量转换，称为自动类型转换，容量从小到大排序
            byte < short < int < long < float < double
                   char  <
            注：任何浮点类型不管占用多少个字节，都比整数型容量大。
            char和short可表示的种类数量相同，但是char可以取更大的正整数
         大容量向小容量转换，叫强制类型转换，需要加强制类型转换符，程序才能编译通过，但是在运行阶段可能会损失精度，所以谨慎使用
         当整数字面没有超出byte，short，char的取值范围，可以直接赋值给byte，short，char类型的变量
         byte，short，char混合运算的时候，各自先转换成int类型再做运算
         多种数据类型混合运算，先转换成大容量的那种类型再做运算
     */
    public static void main(String[] args){

        char a=67;//整数字面值和'a'都行
        System.out.println(a);

        char c='\n';
        System.out.println(c);

        System.out.print("hello world\n");

        //反斜杠将后面的单引号转义成不具备特殊含义的普通单引号字,左边的单引号缺少了结束的单引号字符,编译报错
       /*
       char y ='\'
       System.out.print("hello world\n");
        */
        //能顺利进行
        char f='"';
        System.out.println(f);

        char g='\u4e2d';
        System.out.println(g);

        char h='\u0000';
        System.out.println(h);

        //123这个整数型字面值是int类型
        //i变量声明的时候也是int类型
        //int类型的123赋值给int类型的变量i,不存在类型转换
        int i=123;
        System.out.println(i);

        //int类型的字面值456赋值给long类型的变量x,存在类型转换
        //int类型转换成long类型,int类型是小容量,long类型是大容量,小容量可以自动转换成大容量,称为自动类型转换
        long x=456;
        System.out.println(x);

        //long z = 2147483648 会报错,因为2147483648会默认为整型,并且超出了整型的范围,需要对其进行处理
        //对2147483648字面值做long类型的处理,在字面值后面添加L
        //2147483648L是8个字节的long类型
        //z是long类型变量,以下程序不存在类型转换
        long z=2147483648L;
        System.out.println(z);

        //50是int类型字面值，而b1是byte类型,显然是大容量int转换成小容量byte,需要发生强制类型转换,需要添加强制类型符号
        //但是sun公司规定,没有超出byte,short,char类型取值范围的话,该整数字面值可以直接赋值给byte,short,char类型的变量
        byte a1 = 50;
        System.out.println(a1);

        double x1=10/3;//结果为3
        double x2=10.0/3;//结果为3.3333333

        byte x3=3;
        int x4=10;
        //byte x5=x4/3(只是int类型);编译报错，编译只检查语法，不会“运算”x4/3
        byte x5=(byte)(x4/3);

    }

}
