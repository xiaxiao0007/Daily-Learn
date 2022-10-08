package Javase.Day202211;
/*
* 1.java中为8种基本数据类型准备了8种包装类型，8种包装类属于引用数据类型，父类是Object
* 2.思考：为什么要再提供8种包装类呢?
*   因为8种基本数据类型不够用，所以SUN又提供对应的8种包装类型
* 3. 8种基本数据类型对应的包装类型名是是吗?
*    基本数据类型                包装类型
* -----------------------------------------------------------------------
*    byte                      java.lang.Byte(类名)
*    short                     java.lang.Short
*    int                       java.lang.Integer
*    long                      java.lang.Long
*    float                     java.lang.Float
*    double                    java.lang.Double
*    boolean                   java.lang.Boolean
*    char                      java.lang.Character
*
* 4.以上八种包装类中，重点以java.lang.Integer为代表进行学习，其它类型照葫芦画瓢就行。
* 5.八种包装类中其中6个都是数字对应的包装类，他们的父类都是Number，可以先研究一下Number中公共的方法：
*   Number是一个抽象类，无法实例化对象，
*   Number类中又这样的方法：
*        byte byteValue() 以byte形式返回指定的数值
*        abstract double doubleValue() 以double形式返回指定的数值
 *       abstract float floatValue() 以float形式返回指定的数值
 *       abstract int intValue() 以int形式返回指定的数值
 *       abstract long longValue() 以long形式返回指定的数值
 *       abstract short shortValue() 以short形式返回指定的数值
 *      这些方法其实所有的数字包装类的子类都有，这些方法是负责拆箱的
 *
 * 6.在Java5之后，引入了一种新特性，自动装箱和自动拆箱
 *      自动装箱：基本数据类型-->(自动转换为)-->引用数据类型,对应的基本类型转换成对应的基本类型的包装类型
 *      自动拆箱：引用数据类型-->(自动转换为)-->基本数据类型(6个基本数据类型：byte,short,int,long,float,double)
 *7.Java中为了提高程序的执行效率，将[-128,127]之间的所有的包装对象提前创建好，放到了一个方法区的"整数型常量池"当中了，
 * 目的是只要这个区间的数据不需要再new了，直接从常量池当中取出来。
 *  Integer类加载的时候会初始化整数型常量池：256个对象。池：就是缓存机制
 * */
public class BaseBaoZhuangLei {
    public static void main(String[] args) {

        //有没有这种需求：调用doSome()方法的时候需要传一个数字
        //但是数字属于基本数据类型，而doSome()方法参数的类型是Object
        //可见doSome()方法无法接收基本数据类型的数字，那怎么呢？可以传一个数字对应的包装类进去。
        //把100这个数字经过构造方法包装成对象。
        MyInt myInt = new MyInt(100);
        //doSome()方法虽然不能额直接传100，但是可以传一个100对应的包装类型
        doSome(myInt);

        //123这个基本类型，进行构造方法的包装达到了：基本数据类型向引用数据类型的转换。
        //基本数据类型(int)->(转换为)->引用数据类型(int包装类)(装箱)【可以调用Integer.valueOf(int i)】
        Integer integer = new Integer(123);//出现横线已过时
        System.out.println(integer);//会调用toString()方法
        Integer integer1 = new Integer("123");//String型数字
        System.out.println(integer1);
        //引用数据类型-->(转换为)-->基本数据类型(拆箱)
        int result = integer.intValue();

        //自动装箱
        Integer integer2 = 10;
        //自动拆箱
        int a = integer2;
        //==比较的是对象的内存地址，a和b两个引用中保存的对象内存地址不同
        //==这个运算不会触发自动拆箱机制。(只有+,-,*,/等运算的时候才会触发)
        System.out.println(integer2+1);
        Integer b = 1000;
        Integer c = 1000;
        System.out.println(b == c);
        System.out.println(c.equals(b));//Integer类中的equals()方法重写了
    }

    public static void doSome(Object object){
        System.out.println(object);
    }
}

class MyInt{
    int value;

    public MyInt() {
    }

    public MyInt(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}