/*
    classpath是Java定义的环境变量，是个classloader指定路径的。
    如果设置好了环境变量,打开DOS在什么地方都能进行。
    如果没有配置classpath路径，类加载器从当前路径下找字节码文件。
    classpath = .【当前文件夹进行访问】
    classpath是找字节码文件的
*/
//public 表示公开的
//class表示定义一个类
//HelloWord表示定义一个类名。

public class HelloWorld {//表示定义一个公开的类，起名为HelloWord
    //【类体】
     /*
        static 表示静态的
        void 表示空
        main 表示方法名为main
        String[] args是方法名main方法的形式参数列表
        */
    //类体中不允许编写Java语句【除声明的变量之外】

    public static void main(String[] args){//表示定义一个公开的静态的主方法，一个程序的“主方法”是程序入口
        //【方法体】在方法体当中的Java代码，是遵守自上而下的顺序依次执行的。逐行执行
        //Java语句：以;结尾
        //java中所有的”字符串“都需要使用双引号括起来
        System.out.println("hello word");//向控制台输出以一段字符串；

        System.out.println("LongGe");

        //”程序员“是字符串
        System.out.println("我是”程序员“");

    }
}

/*class HelloWorld{

    public static void main(String[] args){

        System.out.println("testone");

    }
}
 */

/*public class 与class的差别？
    一个Java源文件中可以定义多个class【类】
    一个Java源文件中当public的class不是必须的
    一个class会定义生成一个xxx.class字节码文件
    一个java源文件当中如果定义公开的类的话，public的class只能有一个，并且该类名称必须和Java文件名称一致。
    每一个class当中都可以定义一个main方法，定义一个程序的入口。运行 【Java 类名】
*/

//一个类中可以定义很多种方法，但建议一个类定义一种方法。