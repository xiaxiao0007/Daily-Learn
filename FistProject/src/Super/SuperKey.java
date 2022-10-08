package Super;
/*
1.super是一个关键字，全部小写
2.super和this对比学习。
    this:
        this能出现在实例方法和构造方法中。
        this的语法是:“this.”,“this()”
        this不能使用在静态方法中
        this.大部分情况下是可以省略的。
        this.什么时候不能省略呢？在区分局部变量和实例变量的时候不能省略。
            public void setName(String){
                this.name = name;
            }
        this()只能出现在构造方法第一行，通过当前的构造方法区调用“本类”中其它的构造方法，目的是；代码复用
    super:
        super能出现在实例方法和构造方法中。
        super的语法是:“super.”,“super()”
        super不能使用在静态方法中
        super.大部分情况下是可以省略的。调用父类的实例变量,实例方法
        super.什么时候不能省略呢？
            父类中有，子类中又有，如果想在子类中访问父类中的特征，super.不能省略
        super()只能出现在构造方法第一行，通过当前的构造方法区调用“父类”中的构造方法。
        目的是：创建子类对象的的时候，先初始化父类特征。
3.super():
    可以表示通过子类的构造方法调用父类的构造方法。
    模拟现实世界中的这种场景:要想有儿子，需要现有父亲
4.重要结论:
    当一个构造方法第一行既没有this()又没有super()的话，默认会有一个super();表示通过当前子类的构造方法调用父类的
    无参数构造方法。所以必须保证父类的无参数构造方法是存在的
5.注意:
    this()与super()不能共享，它们都是只能出现在构造方法第一行
6.父类的构造方法百分之百会执行【构造方法中一定会调用其它的构造方法】
7.super代表的是“当前对象(this)”的父类特征。【super(),调用父类无参数构造方法。】
8."super(实参)"到底是干啥的？【super(实参):调用父类的构造方法】
    super(实参)的作用是:初始化当前对象的父类型特征。并不是创建新对象。实际上对象只创建了1个
8.super关键字代表了什么？
    super关键字代表的就是"当前对象"的那部分父类型特征
9.引用.实例变量名【等同于this.变量名】与实例变量名有着相同的效果
10.super不是引用。super也不保存内存地址，super也不指向任何对象。super只是代表当前对象内部的那一块父类型的特征。
 */
public class SuperKey {
    public static void main(String[] args) {
        //创建子类对象
       B b =  new B();
       b.eat();//通过子类可以调用父类的方法
    }
}
class A{
    String name;
    public A(){
        this.name = null;
        System.out.printf("A类");
    }

    public void eat(){
        System.out.println("ok");
    }
}
class B extends A{
    public B(){
        //super();第一行没有的话默认提供一个super();
        System.out.printf("b类");
    }
}