public class Test01 {
    public static void main(String[] args) {
        double a = 10/3;/* 这里的结果为3.0,因为10和3都是int,所以最后的运算结果为int,然后进行向上的类型转换*/
        double i = 10.0/3.0;/* 这里的结果为3.333333, 因为10.0为double类型，运算结果也为double*/
        System.out.println(a);
        System.out.println(i);

    }
}
