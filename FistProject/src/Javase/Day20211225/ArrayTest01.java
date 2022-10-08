package Javase.Day20211225;
/*
1.java语言中的数组是一种引用数据类型。不属于基本数据类型。数据的父类是Object。
2.数组实际上是一个容器，可以同时容纳多个元素。(数组是一个数据的集合)数组：字面意思是“一组数据”
3.数组当中可以存储“基本数据类型”的数据，也可以存储“引用数据类型”的数据。
4.数组因为是引用类型，所以数组对象是在堆内存当中
5.数组当中如果存储的是“Java对象”的话，实际上存储的是对象的“引用”(内存地址)
6.数组一旦创建，在Java中规定，长度不可变。
7.数组的分类：一维数组，二维数组，多维数组
8.所有的数组对象都有length属性（Java自带的），用来获取数组中元素的个数。
9.Java中数组要求数组中元素的类型统一。
10.数组在内存方面存储的时候，数组中的元素内存地址是连续的。一种数据结构
11.所有的数组都是拿“第一个小方框的内存地址”作为整个数组对象的内存地址。(数组中首元素的内存地址作为整个数组对象的地址)
12.数组的每一个元素都是又下表的，下标从0开始，以1递增。最后一个元素的下表是：length-1
13.数组这种数据结构的优点和缺点是什么？
    优点：查询/查找/检索某个下标上的元素时效率极高。可以说时查询效率最高的一个数据结构。
        为什么检索效率高？
            (1).每一个元素的内存地址在空间存储上时连续的。
            (2).每一个元素类型相同，所以占用空间大小一样。
            (3).知道第一个元素内存地址，知道每一个元素占用空间的大小，又知道下标，所以通过一个数学表达式就可以计算出
                某个下标上元素的内存地址。直接通过内存地址定位元素，所以数组的检索效率时最高的。
    缺点：(1)由于为了保证数组中每一个元素的内存地址连续，所以在数组上随机删除或增加元素的时候，效率较低，因为随机增删元素会涉及到
            后面元素统一向前或者向后移位的操作
         (2)数组不能存大容量的数据
    【注意】：最后一个元素的增删时没什么影响的
14.怎么声明/定义一个一维数组
    类型[] 标识符;
15.怎么初始化一个一维数组呢？
    包括两种方式:静态初始化一维数组，动态初始化一维数组。
    静态初始化语法格式:
        int[] array = {100，200，300，55};
    动态初始化语法格式：
        int[] array = new int[5];这里的5表示数组的元素个数
16.什么时候采用静态数组初始化方式，什么时候使用动态初始化方式呢？
    当你创建数组的时候，确定数组中存储的那些具体的元素时，采用静态初始化方式。
    当你创建数组的时候，不确定将来数组中存储那些数据，你可以采用动态初始化的方式，预先分配内存。
17.当一个方法的参数是一个数组的时候，我们还可以采用这种方式传。
18.main方法上的“String[] args”有什么用？
    谁会负责调用main方法：(JVM)
    JVM调用main方法的时候，会自动传一个String数组过来。由程序员传递一个数组
19.数组需要运用for循环来进行遍历
20.数组
    常见的算法：
        排序算法：
            冒泡排序算法
            选择排序算法
        查找算法
            二分法查找
    算法实际上在Java中不需要精通，因为Java中已经封装好了，要排序就调用方法就行。例如：Java中提供了一个
    数组工具类：java.util.Arrays Arrays是一个工具类，其中有一个sort()方法，可以排序，是静态方法，
    直接使用类名.方法名去调用
21.数组工具类(java.util.Arrays)
    所有方法都是静态的，直接用类名调用
    主要使用的两个方法：二分法查找(Array.binarySearch())，排序(Arrays.sort())
 */
public class ArrayTest01 {
    public static void main(String[] args) {

        //静态初始化数组
        int[] array01 = {1,2,3,4,5};
        System.out.println(array01[0]);
        System.out.println(array01[array01.length-1]);
        array01[0] = 10;
        //遍历数组中的元素
        for(int i = 0;i <array01.length;i++){
            System.out.println(array01[i]);
        }
        String[] strings = {"11","222","333"};
        System.out.println("==================================");

        //动态初始化数组
        int[] a = new int[5];//创建长度为4的int数组，数组中每个元素的默认值是0
        for (int j= 0;j<a.length;j++){
            a[j] = j;
            System.out.println(a[j]);
        }
        System.out.println("==================================");

        //也可以这样定义静态初始化数组
        int[] aa = new int[]{1,2,3,4,5};
        for (int ii=0;ii < aa.length;ii++){
            System.out.println(aa[ii]);
        }
        System.out.println("==================================");

        //调用形参为数组的元素
        int[] d={6,7,8,9,10};
        sumArray(d);
        System.out.println("==================================");
        //使用这种方法可以
        sumArray(new int[3]);
        System.out.println("==================================");
        //如果直接传递一个静态数组的话，语法必须这样写
        sumArray(new int[]{3,4,5});
        System.out.println("==================================");

        //数组的多态性
        //动态初始化Animal数组，长度为2
        Animal[] animals = new Animal[2];
        //创建一个Animal对象放到animals[0]中
        animals[0] = new Animal();
        //Animal数组中可以存放Cat类型数组，因为Cat是一个Animal的子类
        animals[1] = new Cat();
        animals[1].move();//子类中有特殊的方法，需要使用向下转型使用instanceof

    }

    public static void sumArray(int[] array){
        for (int c=0;c< array.length;c++){
            System.out.println(array[c]);
        }
    }

}

class Animal{

    public void move(){
        System.out.println("走路");
    }
}

class Cat extends Animal{

    public void  move(){
        System.out.println("跑");
    }
}