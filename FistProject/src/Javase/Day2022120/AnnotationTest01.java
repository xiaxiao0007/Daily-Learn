package Javase.Day2022120;

import java.lang.reflect.Field;

/*
1.注解，或者叫做注释 Annotation
    注解的作用：标识提醒的一种作用
2.注解Annotation是一种引用数据类型，编译之后生成xxx.class文件
3.怎么自定义注解呢?语法格式?
    [修饰符列表] @interface 注解类型名{
    }
4.注解怎么使用，用在什么地方
    第一:注解使用时的语法格式是
        @注解类型名
    第二:注解可以出现在类上，属性上，方法上，变量上等，注解还可以出现在注解类型上。
5.注解可以通过反射机制来获得
* */
public class AnnotationTest01 {
    public static void main(String[] args) throws Exception{

        //获取类
        Class userClass = Class.forName("Javase.Day2022120.User");
        //判断类上是否存在Id注解
        if(userClass.isAnnotationPresent(Id.class)){
            //当一个类上面有@Id注解的时候，要求类中必须存在int类型的id属性
            //如果没有int类型的id属性则报异常
            //获取类的属性
            Field[] fields = userClass.getDeclaredFields();
            boolean isRight = false;//给一个默认的标记
            for (Field field:fields){
                if ("id".equals(field.getName())&& "int".equals(field.getType().getSimpleName())){
                    //表示这个类是合法的类。有@Id注解。则这个类中必须有int类型的id
                    isRight = true;
                    break;
                }
            }
            //判断是否合法
            if (!isRight){
                throw new HasNotIdPropertyException("被@Id");
            }
        }
    }
}

@Id
class User{
    //int id;
}
/*
自定义异常
* */
class HasNotIdPropertyException extends RuntimeException {

    public HasNotIdPropertyException() {
    }

    public HasNotIdPropertyException(String message) {
        super(message);
    }
}