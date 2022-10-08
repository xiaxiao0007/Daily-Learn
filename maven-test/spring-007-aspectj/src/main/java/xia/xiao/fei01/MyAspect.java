package xia.xiao.fei01;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Locale;

/*
* 此类为切面类，包含各种切面方法
* */
@Aspect //交给AspectJ的框架取识别切面类
@Component
public class MyAspect {
    /*
    * 后置通知的方法的规范
    *   1.访问权限是public
    *   2.方法没有返回值void
    *   3.方法名称自定义
    *   4.方法有参数（也可以没有参数，如果目标方法没有返回值，则可以写无参的方法，
    * 但一般会写有参，这样可以处理有参可以处理无参），这个切面方法的参数就是目标方法的返回值
    *   5.使用@AfterReturning注解表明的后置通知
    *       参数：
    *           value：指定切入表达式
    *           returning：指定目标方法的返回值的名称，则名称必须与切面方法参数名称一致
    * */

    @AfterReturning(value = "execution(* xia.xiao.fei01.*.*(..))", returning="value")
    public void myAfterReturn(Object value){
        System.out.println("后置通知功能实现");
        if (value != null){
            if (value instanceof String){
                String obj = value.toString().toUpperCase();
                System.out.println("切面中的后置通知"+obj);
            }
        }
    }
}
