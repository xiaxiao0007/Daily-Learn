package Javase.Day20211225;

import java.util.Arrays;

/*
数组工具类(java.util.Arrays)当中的方法大部分都是静态的。
 */

public class ArraysTest01 {
    public static void main(String[] args) {
        int[] arr = {23,10,28,40,9,35};
        Arrays.sort(arr);
        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
