package Javase.Day2022119;
/*
获取Class,能干什么?
    通过Class的newInstance()方法来实例化对象
    注意:newInStance()方法内部实际上调用了无参数构造方法，必须保证无参数构造的存在才可以
验证反射机制
* */
public class ReflectTest02 {
    public static void main(String[] args) {

        try {
            //通过反射机制，获取Class,通过Class实例化对象
            Class c = Class.forName("Javase.Day2022119.User");
            //newInstance()会调用User这个类的无参构造方法，完成对象的创建
            //重点是：newInstance()调用的是无参数构造，必须保证无参构造是存在的
            Object obj = c.newInstance();
            System.out.println(obj);//Javase.Day2022119.User@776ec8df
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
