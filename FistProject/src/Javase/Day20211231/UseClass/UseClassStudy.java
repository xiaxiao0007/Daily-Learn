package Javase.Day20211231.UseClass;

import java.nio.charset.StandardCharsets;

/*
String类【已经重写了toString()方法和equals()方法】
    1.String表示字符串类型，属于引用数据类型，不属于基本数据类型。
    2.在Java中随便使用双引号括起来的都是String对象。
    3.Java中规定，双括号括起来的字符串，是不可变的，也就是说“abc”自出生到死亡不可变
    4.在JDK当中双引号括起来的字符串，例如“abc”都是直接存储在方法区的字符串常量池当中的。
        为什么SUN公司把字符串存储在一个“字符串常量池”当中呢。
            因为字符串在实际开发中使用太频繁，为了执行效率，所以把字符串放到了方法区的字符串常量池当中。
    5.字符常量池中有字符串对象【只要以地址的形式出现都可以称为创建对象】,在Java中字符串都是String对象
    6.String类中的构造方法(常用的构造方法)
        (1)String s = new String("")
        (2)String s = ""
        (3)String s = new String(char数组)
        (4)String s = new String(char数组，起始下标，选择长度)
        (5)String s = new String(byte数组)
        (6)String s = new String(byte数组，起始下标，选择长度)
    7.String类中的方法
 */
public class UseClassStudy {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "hello";
        System.out.println(s1==s2);
        System.out.println(s1.equals(s2));

        //在堆内存中创建一个String对象，且保存了“abc”的内存地址
        String s3 = new String("abc");
        String s4 = new String("abc");
        //在比较的时候，比较的是堆内存中创建String对象的地址，而不是String对象中保存的“abc”的内存地址。
        System.out.println(s3 == s4);
        System.out.println(s3.equals(s4));
        String k = new String("testString");
        //"testString"这个字符串可以后面加"."呢?
        //因为"testString"是一个String字符串对象，只要是对象都能调用方法
        System.out.println("testString" == k    );
        System.out.println("testString".equals(k));

        //创建字符串对象最常用的一种方式
        String s5 = "hello word";
        System.out.println(s5);

        //这里只掌握常用的构造方法
        byte[] bytes = {98,99,100};//98是b，99是c，100是d
        String s6 = new String(bytes);//将数组内的数字转换成字符串
        //前面说过：输出一个引用的时候，会自动调用toString()方法，默认Object的话，会自动输出对象的内存地址。
        //通过输出结果可知：String类已经重写了toString()方法。
        //输出字符串对象的话，输出不是对象的内存地址，而是字符串本身
        System.out.println(s6);

        //String(字节数组，数组元素下标的起始位置，长度)
        //byte数组的一部分转化成字符串
        String s7 = new String(bytes,1,2);
        System.out.println(s7);

        //将char数组全部转换成字符串
        char[] chars = {'我','是','中','国','人'};
        String s8 = new String(chars);
        System.out.println(s8);
        //将char数组的一部分转换成字符串
        String s9 = new String(chars,2,3);
        System.out.println(s9);

        //String类(字符串)当中常用方法
        //1.charAt(int index)
        char a = "中国人".charAt(2);//"中国人"是一个字符串String对象，只要是对象就能"点"
        System.out.println(a);
        //2.int compareTo(String anotherString)
        //按照字典顺序排序
        int result = "abc".compareTo("abc");
        System.out.println(result);
        //3.(掌握)boolean contains(CharSequence s)
        //判断前面的字符串是否包含后面的子字符串
        System.out.println("HelloWorld.java".contains(".java"));
        //4.(掌握)boolean endsWith(String suffix)
        //判断当前字符串是否以某个子字符串结尾
        System.out.println("java.text".endsWith(".text"));
        //5.(掌握) boolean equals(Object anObject)
        //比较两个字符串必须使用equals方法
        System.out.println("abc".equals("abc"));
        //6.(掌握)boolean equalsIgnoreCase(String anotherString)
        //判断两个字符串是否相等，并且同时忽略大小写。
        System.out.println("abc".equalsIgnoreCase("ABC"));//true
        //7.(掌握)byte[] getBytes[]
        //将字符串转换成字节数据(存储到数组中)
        byte[] bytes1 = "abcdef".getBytes(StandardCharsets.UTF_8);
        for (int i = 0; i < bytes1.length; i++) {
            System.out.println(bytes1[i]);
        }
        //8.(掌握)int indexOf(String str)
        //判断某个字符串在当前字符串中第一次出现处的索引
        System.out.println("hjgdhajgdahgjgjavajkahdjkah".indexOf("java")+1);
        //9.(掌握)boolean isEmpty()
        //判断某个字符串是否为空
        System.out.println("".isEmpty());
        //10.(掌握)int length()
        //面试题，判断数组长度和判断字符串长度不一样
        //判断数组长度是length属性，判断字符串长度是length()方法
        System.out.println("abcd".length());
        //11.(掌握) int lastIndexOf(String str)
        //判断某个字符串在当前字符串中最后一次出现的索引(下标)
        System.out.println("ahsjagsjahgsjah".lastIndexOf("sj"));
        //12.(掌握)String replace(CharSequence target,CharSequence replacement)
        //替换
        //String的父接口就是CharSequence
        System.out.println("http://www.baidu.com".replace("http://","https://"));
        //13.(掌握)String[] split(String regex)
        //拆分字符串
        String[] s10 = "1997-12-15".split("-");//以"-"分隔符进行拆分
        for (int i = 0; i < s10.length; i++) {
            System.out.println(s10[i]);
        }
        //14.(掌握)boolean startsWith(String prefix)
        //判断某个字符串是否以某个子字符串开始
        System.out.println("http://www.baidu.com".startsWith("http"));
        //15.(掌握) String subString(int beginIndex)参数是起始下标
        //截取字符串
        System.out.println("http://www.baidu.com".substring(7));
        //16.(掌握) String subString(int beginIndex,int endIndex)
        //截取字符串
        System.out.println("http://www.baidu.com".substring(7,10));//www,左闭右开
        //17.(掌握) char[] toCharArray()
        //将字符串转换成char数组
        char[] chars1 = "我是中国人".toCharArray();
        for (int i = 0; i < chars1.length; i++) {
            System.out.println(chars1[i]);
        }
        //18.(掌握) String toLowerCase()
        //将字符串全部转换为小写
        System.out.println("agsSDSAS".toLowerCase());
        //19.(掌握) String toUpperCase();
        //将字符串全部转换为大写
        System.out.println("agsSDSAS".toUpperCase());
        //20.() String trim();
        //除去字符串前后空白
        System.out.println("    hello    world   ".trim());
        //21.() String中只有一个方法是静态的，不需要new对象.【类名.方法名】
        //这个方法叫做valueOf
        //作用：将“非字符串”转换成“字符串”
        String s11 = String.valueOf(true);
        System.out.println(s11);
        String s12 = String.valueOf(100);
        System.out.println(s12);
        //这个静态的的valueOf()方法，参数是一个对象的时候，会自动调用该对象的toString()方法么?
        //会
        String s13 = String.valueOf(new Customer());
        //System.out.println(s13);没有重写toString()方法之前是对象的内存地址
        System.out.println(s13);//你是sb!!!
        //通过源代码可以看出：为什么输出一个引用的时候，会调用toString()方法!!!
        //本质上System.out.println()这个方法在输出任何数据的时候都是先转换成字符串，再输出
        //-->String.valueOf-->toString
    }
}

class Customer {
    @Override
    public String toString() {
        return "你是sb";
    }
}