package Javase.day202212;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Random;

/*
1.关于数字的格式化(了解)
2.BigDecimal 属于大数据，精度极高，不属于基本数据类型，属于Java对象(引用数据类型)。专门用在财务软件当中。
 */
public class NumberFormat {
    public static void main(String[] args) {

        //java.text.DecimalFormat 专门负责数字格式化的
        //DecimalFormat df = new DecimalFormat("数字格式化格式");
        /*
        数字格式有那些?
            # 代表任意数字
            , 代表千分位
            . 代表小数
            0 代表不够时补0
            ###,###.## 表示：加入千分位，保留2个小数
         */
        DecimalFormat df = new DecimalFormat("###,###.##");
        String s1 = df.format(1234.56);
        System.out.println(s1);

        BigDecimal v1 = new BigDecimal(100);
        BigDecimal v2 = new BigDecimal(100);
        //调用方法求和,不能用“+”
        BigDecimal v3 = v1.add(v2);
        System.out.println(v3);

        //随机数,创建引用，调用实例方法
        Random random = new Random();
        //随机产生一个int类型取值范围内的数字。
        int a = random.nextInt();
        System.out.println(a);
        //产生[0~100]之间的随机数，不能产生101
        //nextInt翻译为:下一个int类型的数据101，表示只能取到100
        int num = random.nextInt(101);
        System.out.println(num);

        int[] array = random();
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

    }

    //随机产生5个不同的随机数
    public static int[] random(){
        Random random = new Random();
        int[] array = new int[5];
        for (int i = 0; i < array.length; i++) {
            array[i] = -1;
        }
        int index = 0;
        while(index < array.length) {
            int num = random.nextInt(5);
            System.out.println("生成随机数:"+num);
            if (contains(array,num)) {
                array[index++] = num;
            }
        }
        return array;
    }

    //单独编写一个方法，这个方法专门用来判断数组中是否包含某个元素
    public static boolean contains(int[] array,int num){
        boolean flag = true;
        for (int i = 0; i < array.length; i++) {//每次都是从数组起始下标0开始遍历
            if(array[i] == num){
                flag = false;
                break;
            }
        }
        return  flag;

        /*Arrays.sort(array);
        return Arrays.binarySearch(array,num) >= 0;*/
    }
}
