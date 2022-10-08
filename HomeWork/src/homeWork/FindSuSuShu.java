package homeWork;

import MethodStudy.MethodTest01;

public class FindSuSuShu {
    //一步一步的来
    public static void main(String[] args){
        int a = 0;
        for (int i=2;i<=100;i++){
            boolean flag = true;
            for (int j=2;j<i;j++) {
                if (i % j == 0 ) {//判断素数的反面，即此数不是素数，【素数(质数)的定义:除1和本身外有有其它的因数】
                    flag = false;//给一个标记
                    break;
                }
            }
            if(flag){
                a++;
                System.out.print(i+" ");
                //a++;
                //统计数据
                if (a%8==0){
                    System.out.print("\n");
                }
            }
           // if (flag&a%8==0){
                //System.out.print("\n");
            //}
        }
        MethodTest01.a("Hello World!");
    }
}
