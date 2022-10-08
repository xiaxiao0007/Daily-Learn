package Algorithm;

public class test01 {
    public static void main(String[] args) {
        int[] a = {4,3,2,1};
        BubbleAlgorithm.bubbleAlgorithm(a);
        for (int i = 0;i< a.length; i++){
            System.out.println(a[i]);
        }

        System.out.println("=========================================");
        int[] b={1,3,2,4};
        BubbleAlgorithm.selectSort(b);
        for (int i = 0; i < a.length; i++) {
            System.out.println(b[i]);
        }
    }
}
