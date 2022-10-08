package Javase.Day2021;

/*
关于Java语言当中得this关键字:this代表当前动作的对象，是一个引用，保存内存地址的变量
    1.this是一个关键字，翻译为:这个
    2.this是一个引用，this是一个变量，this变量中保存了内存地址指向了自身，this存储在jvm堆内存Java对象内部
    3.创建100个Java对象,每一个对象都有this，也就是有100个不同得this
    4.this可以出现在“实例方法“当中，this指向当前正在执行这个动作的对象。(this代表当前对象)
    5.this在多数情况下都是可以省略不写的
    6.this不能使用在带有static的方法中
    7.用来区别局部变量和实例变量的时候不能省略
    8.this可以用在哪里
        (1).可以使用在实例方法当中，代表当前对象【语法格式：this.】
        (2).可以使用在构造方法当中，通过当前的构造方法调用其它的构造方法【语法格式:this(实参);】
        【重点(记忆)】:this()这种语法只能出现在构造方法得第一行
    9.带有static的方法，其实既可以采用类名的方式访问，也可以采用引用的方式访问
      但是即使采用引用的方式去访问，实际上执行的时候和引用指向的对象无关。
 */
/*
最终结论:
    在带有static的方法当中不能”直接“访问实例变量和实例方法。
    因为实例变量和实例方法都需要对象的存在
    而static的方法当中是没有this的，也就是说当前对象是不存在的，自然也是无法访问当前对象的实例变量和实例方法。
 */
public class thisKey {
    private int id;//实例变量
    private String name;

    //构造函数
    //setter and getter
    /*public void setId(int i){
        id = i;
    }
     */

    //以下程序的id和实例变量无关，不能采用这种方式
    /*
    public void setId(int id){
        id = id;
    }
     */

    public void setId(int id){
        //等号前边的this.id是实例变量id
        //等号后面的id是局部变量的id
        this.id = id;
    }
}
