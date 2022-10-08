package StringBuffer;
/*
思考：
    我们再实际开发中，如果需要进行字符串的频繁拼接，会有什么问题?
    因为Java中的字符串是不可变的，每一次拼接都会产生新字符串。这样会占用大量方法区内存。
    造成内存空间的浪费。
        String s = "abc";
        s +="hello";
        就以上两行代码，就导致再方法区内有三个字符串
            "abc"
            "hello"
            "abchello"
如果以后需要进行大量字符串的拼接操作，建议使用JDK中自带的：
    java.lang.StringBuffer
    java.lang.StringBuilder
StringBuffer底层实际上是一个byte[]数组
往StringBuffer中放字符串，实际上是放到byte数组当中了
StringBuffer初始化容量是16

如何优化StringBuffer
    在创建StringBuffer的时候尽可能给定一个初始化容量。
    最好减少底层数组的扩容次数，预估一下，给一个大一些初始化容量。
    关键点：给定一个合适的初始化容量，可以提高程序的执行效率

StringBuffer是线程安全的，StringBuilder是非线程安全的
 */
public class StringBufferStudy {
    public static void main(String[] args) {
        //创建一个初始化容量为16个byte[] 数组。(字符串缓冲区对象)
        StringBuffer stringBuffer = new StringBuffer();
        //拼接字符串，以后拼接字符串统一调用append()方法。
        stringBuffer.append("1");
        stringBuffer.append("b");
        stringBuffer.append("c");
        //append方法底层在追加的时候，如果byte数组满了，会自动扩容。
        stringBuffer.append(3.14);
        System.out.println(stringBuffer);

        //char数组的输出形式比较特殊，直接输出数组内转换成字符的全部内容。
        char[] chars = {65,66,67};
        System.out.println(chars);
    }
}
