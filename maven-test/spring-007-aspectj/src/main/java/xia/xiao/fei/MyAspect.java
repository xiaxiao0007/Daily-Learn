package xia.xiao.fei;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/*
* 此类为切面类，包含各种切面方法
* */
@Aspect //交给AspectJ的框架取识别切面类
public class MyAspect {
    /*
    * 所有的切面的功能都是由切面方法来实现
    * 可以将各种切面都在此类中进行开发
    *
    * 前置通知的切面方法的规范
    *   1.访问权限是public
    *   2.方法的返回值是void
    *   3.方法名称自定义
    *   4.方法没有参数，如果有也只能是JoinPoint类型
    *   5.必须使用@Before注解来声明切入的时机和切入点
    *       参数：value 指定切入表达式
    *
    * 业务方法
    *    String doSome(String name,int age);
    * */

    @Before(value = "execution(public String xia.xiao.fei.SomeServiceImpl.doSome(String,int ))")
    public void myBefore(){
        System.out.println("切面方法的实现。。。。。");
    }
}
