package ClassStudy01;

public class HumanAddressTest02 {
    public static void main(String[] args){

        HumanClass user = new HumanClass();

        Address address = new Address();

        user.address = address;

        System.out.println(user.address);//将地址和相关人物关联起来
    }
}
