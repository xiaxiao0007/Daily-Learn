package xia.xiao.proxy4;
/*
* 切面对象的接口
*
* */
public interface AOP {

    default void before(){}
    default void after(){}
    default void exception(){}
}
