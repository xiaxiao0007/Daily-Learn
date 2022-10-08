package Algorithm;
/*
折半查找应用于排好的数据
 */

public class ArraySearch {
    public static void main(String[] args) {
        int[] c = {1,2,3,4,5};
        int arr = search(c,5);
        System.out.println(arr);
        System.out.println("==============================================");

        int[] array = {100,200,300,400};
        int arr1 = diGuiSearch(array,0,array.length-1,200);
        System.out.println(arr1);
    }

    public static int search(int[] obj,int num){
        int begin = 0;
        int end = obj.length-1;

        //开始元素的下标只要再结束元素下标的左边，就有机会继续循环。
        while (begin <= end) {
            int middle=(begin+end)/2;
            if (obj[middle] == num) {
                return middle;
            } else if (obj[middle] < num) {
                begin = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        return -1;
    }

    public static int diGuiSearch(int[] arr,int begin,int end,int num){
        int middle = (begin+end);
        if (arr[middle] == num){
            return middle;
        }else if(arr[middle] < num){
            return diGuiSearch(arr,middle+1,end,num);
        }else if (arr[middle] > num){
            return diGuiSearch(arr,begin,middle-1,num);
        }
        return -1;
    }
}
