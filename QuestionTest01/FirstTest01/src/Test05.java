public class Test05 implements Animal{
    public static void main(String[] args) {
        Test05 test05 = new Test05();


        if (test05 instanceof Animal){
            System.out.println("正确");
        }else {
            System.out.println("错误");
        }
    }
}
class Person{

}

interface Animal{

}
