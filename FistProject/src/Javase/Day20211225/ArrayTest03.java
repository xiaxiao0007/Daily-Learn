package Javase.Day20211225;
/*
数组的扩容
    在Java开发，数组长度一旦确定不可变，那么数组满了怎么办?
    数组满了，需要扩容。
    Java中对数组的扩容是：先新建一个大容量的数组，然后将小容量数组中的数据拷贝到大数组中。
结论：数组扩容效率较低，因为涉及到拷贝的问题。根据实开发际情况，合理指定数组的大小。

关于Java中的二维数组
    1.二维数组其实是一个特殊的一维数组，特殊在这个一维数组当中的每一个元素是一个一维数组。
    2.三维数组是什么？
        三维数组是一个特殊的二维数组，特殊在这个二维数组中每一个元素是一个一维数组。
    3.二维数组静态初始化
        int[][] 变量名 = {{},{},{}}
    4.二维数组的length属性?
        a.length = 二维数组中有多少个一维数组。
【重要】Object类可用于所用引用类型的数据，进行向上转型

 */
public class ArrayTest03 {
    public static void main(String[] args) {
        //数组的拷贝
        int[] a = {1,2,3};
        int[] b = new int[5];
        System.arraycopy(a,1,b,1,2);//底层调用C++，利用了多态机制，参数传递时发生类型转换?
        for (int j : b) {
            System.out.println(j);
        }

        System.out.println("=======================================");
        Object obj = a;//发生了向上转型，数组中的int类型数据转换成了Object类型的数据。
        System.out.println("=======================================");

        int[][] c = {{1,2,3},{1,4,9},{1,8,27}};
        System.out.println(c.length);
        int[] d = c[0];
        System.out.println(c[0]);//第一个一维数组中首下标的地址
        System.out.println(c[0].length);
        System.out.println(c[1][2]);//第一个中括号代表二维数组的第几个一维数组
        //d ={2,3,4};数组的赋值只能一个一个对元素进行赋值，对二维数组也是同样的道理。
        c[0][0] = 2;//重新赋值
        System.out.println(c[0][0]);
        System.out.println("=======================================");

        //二维数组的遍历
        c[0][0] = 1;
        for (int i = 0;i<c.length;i++){
            for (int j = 0;j<c[i].length;j++){
                System.out.print(c[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("=======================================");

        //二维数组的参数传递
        arrayLoop(c);
        //只有这两种写法
        arrayLoop(new int[][]{{1,2,3},{4,5,6},{7,8,9}});

    }

    public static void arrayLoop(int[][] e){
        for (int i = 0;i<e.length;i++){
            for (int j = 0;j<e[i].length;j++){
                System.out.print(e[i][j]+" ");
            }
            System.out.println();
        }
    }
}
