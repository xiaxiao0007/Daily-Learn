package Javase.Day2021;

/*
访问控制权限修饰符
    1.访问控制权限修饰符来控制元素的访问范围
    2.访问控制权限修饰符包括:
        public          表示公开的，在任何位置都可以访问
        protected       同包，只有其子类可以访问
        缺省(不写)        本类，同包，不能在子类中访问
        private         表示私有的，只能在本类中访问
        访问控制修饰符    本类     同包     子类     任意位置
        public         可以     可以     可以     可以
        protected      可以     可以     可以     不行
        不写(默认)       可以     可以     不行     不行
        private        可以     不行     不行     不行
    3.访问控制权限修饰符可以修饰类，变量，方法...
    4.当某个数据只希望子类使用，使用protected进行修饰
    5.修饰符的范围:
        private<缺省(不写)<protected<public
    6.类只能采用public和缺省的修饰符进行修饰。【内部类除外】
    7.访问控制权修饰符可以修饰什么？
        属性(4个都能用)
        方法(4个都能用)
        类(public和默认不写能用，其它不行)
        接口(public和默认不写能用，其它不行)
 */
public class ControlPower {
    public static void main(String[] args) {
        System.out.println();
    }
}