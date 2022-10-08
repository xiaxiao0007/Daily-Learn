package Javase.Day2022112;

import MethodStudy.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
序列化
* */
/*
1.参与序列化和反序列化的对象，必须实现Serializable接口
2.注意：通过源代码发现，Serializable接口只是一个标志接口：
    public interface Serializable {
    }
    这个接口当中什么代码都没有
    那么它起到一个什么作用呢?
        起到标识的作用，标志的作用，Java虚拟机看到这个类是实现了这个接口，可能会对这个类进行特殊待遇
3.一次序列化多个对象?
    可以，可以将对象放到集合当中，序列化集合
    提示
        参与序列化的ArrayList集合以及集合中元素Student都需要实现java.io.Serializable接口
4.关于transient关键字是使属性不参与序列化
5.序列化版本号的作用?
    当类名相同时，用于区别相同类名不同的类
    要自己手动的写序列化版本号
【最终结论】
    凡是一个类实现了Serializable接口，建议给该类提供一个固定不变的序列化版本号。
    这样，以后这个类即使代码修改了，但是版本号不变，Java虚拟机会认为时同一个类。
* */
public class ObjectOutputStreamTest01 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        /*
        Student student = new Student(111,"name");

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student"));

        oos.writeObject(student);

        oos.flush();
        oos.close();
        * */

        //多个对象进行序列化
        /*
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1,"张三"));
        studentList.add(new Student(2,"李四"));
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student"));
        oos.writeObject(studentList);
        oos.flush();
        oos.close();
        * */

        //反序列化
        /*ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student"));
        List<User> userList = (List<User>) ois.readObject();
        for (User user.properties:userList){
            System.out.println(user.properties);
        }*/
    }
}

class Student implements Serializable{
    //Java虚拟机看到Serializable接口之后，会自动生成一个序列化版本号。
    //这里没有手动写出来，Java虚拟机会默认提供这个序列化版本号
    private int no;
    private transient String name;//name不参与序列化

    public Student() {
    }

    public Student(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}