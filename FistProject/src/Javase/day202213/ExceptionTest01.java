package Javase.day202213;
/*
java中怎么自定义异常呢
    第一步：编写一个类继承Exception或者RunTimeException
    第二步：提供两个构造方法，一个无参构造，一个带有String参数的构造
创建异常，抛出异常的时候，需要是throws扔出这个方法中的异常，给其调用着进行处理
采用throw手动方法抛出异常

之前讲解方法覆盖的时候，当时遗留了一个问题?
    重写之后的方法不能比重写之前的方法抛出更多(更宽泛)的异常，可以更少
 */

//自定义异常
public class ExceptionTest01 extends Exception{

    public ExceptionTest01() {
    }

    public ExceptionTest01(String message) {
        super(message);
    }
}

class Test{
    public static void main(String[] args) {
        ExceptionTest01 e = new ExceptionTest01("111");
        e.printStackTrace();
    }
}