package Javase.Day2022119;
/*
反射机制
    1.反射机制有什么作用
        通过java语言中的反射机制可以操作字节码文件。(可以读和修改字节码文件)
        通过反射机制可以操作代码片段。(class文件)
    2.反射机制的相关类在那个包下?
        java.lang.reflect.*
    3.反射机制相关的类有那些
        java.lang.Class 代表字节码文件，代表整个类
        java.lang.reflect.Method 代表字节码中的方法字节码
        java.lang.reflect.Constructor 代表字节码中的构造方法字节码
        java.lang.reflect.Field 代表字节码中的属性字节码(静态变量+实例变量)
* */
/*
获取字节码(class)的三种方式
    第一种 Class.forName("完整类名")
    第二种 对象引用.getClass();
    第三种 任何类型.class;
【重要】字节码文件在方法区中只有一份
* */
public class ReflectTest01 {
    public static void main(String[] args) {
        /*
        Class.forName()
            1.静态方法
            2.方法参数是一个字符串
            3.字符串需要的是一个完整类名
            4.完整类名必须带有包名。java.lang包不能省略
        * */
        Class c1 = null;
        try {
            c1 = Class.forName("java.lang.String");//c1代表String.class文件
            System.out.println(c1.getName());//获取类名(包括包名)
            System.out.println(c1.getSimpleName());//只获取类名，不包括包名
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //java中任何一个对象都有一个方法:getClass(),获取字节码文件
        String s = "abc";
        Class x = s.getClass();//x代表String.class字节码文件，x代表String类
        System.out.println(x == c1);//true(==判断对象的内存地址的大小)

        //java语言中任何一种类型，包括基本数据类型，它都有.class属性
        Class k = int.class;//k是int类型
    }
}
