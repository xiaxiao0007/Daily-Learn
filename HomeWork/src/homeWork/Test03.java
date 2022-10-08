package homeWork;

public class Test03 {
    public static void main(String[] args) {
        char[] a = {65,66,67};
        System.out.println(a);//ABC 输出引用的时候，默认调用toString()方法，
        //但根据实际出结果，char类型的toString()方法已重写

        int[] b = {1,2,3};
        System.out.println(b);

        byte[] bytes = {65,66,67};
        System.out.println(bytes);
    }
}
