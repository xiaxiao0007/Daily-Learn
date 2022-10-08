package ClassStudy01;

public class HumanAddressTest01 {
    public static void main(String[] args){

        //user也是一个引用型变量
        //String这个引用型变量比较特殊
        HumanClass user = new HumanClass();
        System.out.println(user);
        System.out.println(user.no);
        System.out.println(user.name);
        System.out.println(user.address);

        user.no = 00001;
        user.name = "Cheng";
        //"引用"要赋值一个内存地址，而new对象正好创建一个内存地址
        user.address = new Address();//创建一个对象赋值个给这个address引用
        System.out.println(user.no);
        System.out.println(user.name);
        System.out.println(user.address);//拿到的是ObjectTest03对象的内存地址

        user.address.city = "阜阳";
        System.out.println(user.address.city);
    }
}
