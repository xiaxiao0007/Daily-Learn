package Algorithm;

public class BubbleAlgorithm {
    //冒泡排序算法
    public static void bubbleAlgorithm(int[] bubble){
        for (int i=0;i < bubble.length-1;i++){//外层循环只控制循环多少次
            for (int j=0;j < (bubble.length-i-1);j++){//排好就不需要在排
                if(bubble[j] > bubble[j+1]){
                    int a;
                    a = bubble[j+1];
                    bubble[j+1] = bubble[j];
                    bubble[j] = a;
                }
            }
        }
    }

    public static void bubble(int[] bubble){
        for (int i = bubble.length-1;i > 0;i--){//需要遍历length-1次
            for (int j = 0;j < i;j++){//需要交换length-1再减去已经排好的元素个数
                if(bubble[j] > bubble[j+1]){
                    int a;
                    a = bubble[j+1];
                    bubble[j+1] = bubble[j];
                    bubble[j] = a;
                }
            }
        }
    }

    //选择排序算法，相较于冒泡排序比较的次数一样的，交换次数变低了，效率提高了
    public static void selectSort(int[] a){
        for (int i = 0; i < a.length-1; i++) {//假设为最小元素的下标
            int min = i;
            for (int j = i+1; j < a.length; j++) {//需要交换数组长度减去已排好的元素的个数，比较到最右边的那个数进行比较
                if(a[j]<a[i]){
                    min = j;//先求出最小值的所在的下标
                }
            }
            if(min != i){
                int tem;
                tem = a[min];
                a[min] = a[i];
                a[i] = tem;
            }
        }
    }
}
