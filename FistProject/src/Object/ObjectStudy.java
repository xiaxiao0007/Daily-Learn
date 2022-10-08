package Object;
/*
1.这个老祖宗类中的方法我们需要先研究一下，因为这些方法都是所有子类通用的。
  任何一个类默认继承Object，就算没有直接继承，最终也会间接继承。
2.Object类当中有那些常用的方法？
    我们去哪里找这些方法呢？
        第一种方法：去源代码当中。(但是这种方式比较麻烦，源代码也比较难)
        第二种方法：去查阅Java的类库的帮助文档。
    什么是API？
        应用程序编程接口。
        整个JDK的类库就是一个JavaSE的API
        每一个API都会配置一套API帮助文档
        SUN公司提前写好的这套类库就是API
    目前为止我们只需要知道这几个方法即可：
        protected Object clone()             //负责对象克隆的
        public int hashCode()                //获取对象哈希值的一个方法
        public boolean equals(Object obj)    //判断两个对象是否相等
        String toString()                    //将对象转换成字符串形式
        protected void finalize()            //垃圾回收器负责调用的方法
 */
/*
关于Object类中的toString()方法
    1.源代码长什么样？
        public String toString(){
            return this.getClass.getName+"@"+Integer.toHexString(hashCode());
        }
        源代码上toString()方法的默认实现是：类名@对象的内存地址转换为十六进制的形式
    2.SUN公司toString()方法的目的是什么？toString()方法的作用是什么？
        toString()方法设计的目的是通过调用这个方法可以将一个“Java对象”转换成“字符串表示形式”
    3.其实SUN公司开发Java语言的时候，建议所有的子类都去重写toString()方法。使toString()方法更见的简洁。
【注意】输出引用的时候，会自动调用该引用的toString()方法
 */
/*
关于Object类中的equals()方法
    1.equals()方法的源代码
        public boolean equals(Object obj){
            return (this == obj) ;
        }
        以上这个方法是Object类默认实现
    2.equals()方法的目的什么？
        以后编程的过程当中，都要通过equals()方法来判断两个对象是否相等。
        equals()方法是判断两个对象是否相等的。
    3.我们需要研究一下Object类给这个默认的equals()方法够不够用!!!
        在Object类中的equals方法当中，默认采用的是“==”判断两个Java对象是否相等。而“==”判断的
        是两个Java对象的内存地址，我们应该判断两个Java对象的内容是否相等。所以最开始的equals()
        方法不够用,需要在子类中重写equals()方法
    4.判断两个Java对象是否相等，不能使用“==”，因为“==”比较的是两个对象的内存地址。
    5.equals()方法【重写的时候要重写的彻底】
        以后所有类的equals()方法也需要重写，因为Object中的equals方法比较的是两个对象的内存地址
        ，我们应该比较内容，所以需要重写。
        重写规则：自己定，主要看是什么和什么相等时表示两个对象相等。
        基本数据类型比较使用：==
        对象和对象比较：调用equals()方法
        String类是SUN编写的，所以String类的equals方法重写了。以后判断两个字符串是否相等，
        最好不要使用==，要调用字符串的equals方法。
 */
//【重要】只要是个类，就能使用构造方法。
/*
java语言当中得字符串String有没有重写toString方法，有没有重写equals方法?
    重写了
    1.String类已经重写了equals方法，比较两个字符串不能使用==，必须使用equals。equals是通用的
    2.String类已经重写了toString方法。
大结论
    Java中什么类型的数据可以使用“==”判断
        Java中基本数据类型比较是否相等，使用==
    java中什么类型的数据统一使用equals方法来判断是否相等
        java中所有的引用数据类型统一使用equals方法来判断是否相等。(需要进行重写)
 */
/*
finalize()方法
    1.在Object类中的源代码
      protected void finalize() throws Throwable{}
      GC:负责调用finalize()方法
    2.finalize()方法只有一个方法体，里面没有代码，而且这个方法是protected修饰的
    3.这个方法不需要程序员手动调用，JVM的垃圾回收器负责调用这个方法。finalize()方法只需要
      重写，重写完将来会有程序来调用。
    4.finalize()方法执行时机：
        当一个Java对象即将被垃圾回收器回收的时候，垃圾回收器负责调用finalize()方法
    5.finalize()方法实际上是SUN公司为Java程序员准备的一个时机，垃圾销毁时机。如果希望在对象销毁
      时机执行一段代码的话，这段代码要写到finalize()方法当中。
 */
/*
hashCode()方法
    1.public native int hashCode();带有native关键字，底层调用的C++程序
    2.hashCode()方法返回的是哈希码：
        实际上就是Java对象的内存地址，经过哈希算法，得出得一个值。所以hashCode()方法得执行结果
        可以等同看做一个Java对象得内存地址
 */
public class ObjectStudy {
    public static void main(String[] args) {

        A a = new A(10,10);
        A b = new A(10,10);
        System.out.println(a.equals(b));//发生了向上转型,引用b转换成了Object对象的引用了

        //实际上String也是一个类，不属于基本数据类型。既然String是一个类，那么一定存在构造方法。
        String s3 = new String("Test1");
        String s4 = "hello";
        String s5 = "hello";
        s4.equals(s5);//是引用就可以调用实例方法
        System.out.println(s4.equals(s5));//引用型数据类型的比较是使用equals

        Student a1 = new Student(0001,"义庄");
        Student a2 = new Student(0001,"义庄");
        System.out.println(a1.equals(a2));

        //两个对象的内存地址
        User user = new User("夏晓飞",new Address("合肥","翡翠路","安大"));
        System.out.println(user.toString());;
        User user01 = new User("夏晓飞",new Address("合肥","翡翠路","安大"));
        System.out.println(user.equals(user01));

        Person p = new Person();
        p = null;

        Object o = new Object();
        System.out.println(o.hashCode());

    }
}

class A extends Object{
    int a;
    int b;

    public A(){

    }

    public A(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public boolean equals(Object obj) {//Object是A的父类

        if(obj instanceof A){
            A tt = (A)obj;
        }

        return false;
    }
}

class Student{
    int no;
    String school;

    public Student() {
    }

    public Student(int no, String school) {
        this.no = no;
        this.school = school;
    }

    @Override
    public String toString() {
        return "学号"+no+",所在学校相同"+school;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null||!(obj instanceof Student)) return false;
        if (this == obj) return true;
        Student student = (Student)obj;
        return this.no==student.no && this.school.equals(student.school);
    }
}

class User{
    String name;
    Address adder;

    public User() {
    }

    public User(String name,Address addr) {
        this.name = name;
        this.adder = addr;
    }

    @Override
    public String toString() {
        return this.name+"学校的地址是"+this.adder.toString();
    }

    @Override
    public boolean equals(Object obj) {//自动类型转换，向上转型
        if (obj == null||!(obj instanceof User)) return false;
        if (this == obj) return true;
        User user = (User) obj;
        //字符串的equals()方法
        return this.name.equals(user.name) && this.adder.equals(user.adder);
    }

}
class Address{
    String city;
    String street;
    String zipcode;

    public Address() {
    }

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", zipcode='" + zipcode + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {//Object是Address的父类需要强制向下转型
        if (obj == null||!(obj instanceof Address)) return false;
        if (this == obj) return true;
        Address address = (Address) obj;
        return this.city.equals(address.city) && this.street.equals(address.street) && this.zipcode.equals(address.zipcode);
    }
}

//记录对象被释放的时间点，要放在finalize()方法中
class Person{

    //重写finalize()方法
    //Person类型的对象被垃圾回收器回收的时候，垃圾回收器负责调用：p.finalize();
    protected void finalize() throws Throwable{
        //this代表当前对象的
        System.out.println(this+"即将被销毁");
    }
}