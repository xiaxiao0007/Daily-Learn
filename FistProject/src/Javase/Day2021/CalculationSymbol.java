package Javase.Day2021;

/*
运算符
    算术运算符
        1.+求和 -相减 *相乘 /商 %求余数【取模】 ++自加1 --自减1
        2.注意：一个表达式当中有多个运算符，运算符有优先级，不确定的加小括号，优先级得到提升
    关系运算符
        1.>大于 >=大于等于 <小于 <=小于等于 ==等于 !=不等于
        2.=赋值运算符
        3.关系运算符的运算结果一定是布尔类型：true/false
        4.关系运算符的运算原理
            int a=10;
            int b=10;
            a>b 比较的时候，比较的是a中保存的10这个值和b中保存的10这个值之间的大小比较
    逻辑运算符
        1.&逻辑与 |逻辑或 !逻辑非(单目运算符) ^逻辑异或 &&短路与() ||短路或()
        2.逻辑运算符要求两边的算子都是布尔类型，并且逻辑运算符最终的运算结果也是一个布尔类型
        3.短路与和逻辑与最终结果是相同的，只不过短路与存在短路现象。同理得短路或
        4.什么情况下发生短路现象呢？
            第74行
        5.什么情况下发生短路或？
            第一个表达式执行结果是true，会发生短路或。
        6.什么情况下发生短路与？
            第一个表达式执行结果是false，会发生短路与。
    赋值类运算符
        1.赋值类运算符包括两种：基本的赋值类运算符 = 扩展的赋值运算符 += -= *= /= %=
        赋值类运算符的优先级：先执行等号右边的表达式，将执行结果赋值给左边的变量。
        2.注意以下代码：
            byte i = 10；
            i += 5; 等同于:i =(byte)(i+5)
            int k = 10
            k +=5; 等同于: k = (int)(k+5)
            long x = 10L;
            int y=20;
            y +=x;等同于:y = (int)(y+x);
        3.重要结论:扩展类赋值运算符不该变运算结果类型，假设最初这个变量的类型是byte类型，
                  无论怎么进行追加或追减，最终该变量的数据类型还是byte类型
    关于Java中的"+"运算符
        1.加法运算，求和     字符串的连接运算
        2.当"+"运算符两边的数据都是数字的话，一定是进行加法运算。
        3.当"+"运算符两边的数据只要有一个数据是字符串，一定会进行字符串连接运算。
        并且连接运算之后的结果还是一个字符串类型。
        4. 在一个表达式当中可以出现多个"+",在没有添加小括号的前提之下，遵循自左向右的顺序依次运算。
    三元运算符
        1.语法规则
            布尔表达式?表达式1:表达式2
        2.三元运算符的执行原理？
            当布尔表达式的结果是true的时候，选择表达式1作为整个表达式的执行结果
            当布尔表达式的结果是false的时候，选择表达式1作为整个表达式的执行结果
 */
public class CalculationSymbol {
    public static void main(String[] args){
        // 以++为例
        int i = 10;
        //++运算符可以出现在变量后面【单目运算符】
        i++;
        System.out.println(i);

        int j = 10;
        //++运算符可以出现在变量前面【单目运算符】
        ++j;
        System.out.println(j);
        //++运算符可以出现在变量前也可以出现在变量后，无论是变量前还是变量后，只要++运算结束，该变量中的值一定会自加1

        //++ 出现在变量后。先做赋值运算，再对变量中保存的值进行自加1
        int k = 10;
        int b = k ++;
        System.out.println(k);//11
        System.out.println(b);//10

        //++ 出现在变量前.先进行自加1运算，然后在进行赋值操作。
        int m = 20;
        int n = ++m;
        System.out.println(m);//21
        System.out.println(n);//21

        int xx = 500;//整数类型
        System.out.println(xx);//整数类型转换成字符类型，在控制台上进行显示

        int xb = 100;
        System.out.println(xb++);//100
        System.out.println(xb);//101，上一个语句xb++已完成经运行，xb自加已完成

        int xc = 100;
        System.out.println(++xc);//101,
        System.out.println(xc);//101

        System.out.println(5 > 3 & 5 > 2);//true
        System.out.println(true & true);//true
        System.out.println(false | true);//true
        System.out.println(true ^ true);//false

        //逻辑与和短路与
        int x = 10;
        int y = 8;
        //逻辑与
        /*
        System.out.println(x < y & ++x < y);
        System.out.println(x);//11
         */
        //短路与:x<y结果是false，整个表达式结果已经确定是false，所有后面的表达式没有再执行，这种现象被称为短路现象
        //短路与才会有短路现象，逻辑与不会存在短路现象
        System.out.println(x < y && ++x < y);
        System.out.println(x);//10
        /*
        短路与更智能，由于后面的表达式可能不执行，所以执行效率较高。这种方式在实际开发中使用较多
        在某些业务要求，要知道第二个表达式的结果
         */

        int abb = 10;
        System.out.println(abb);//10
        abb = abb+10;
        System.out.println(abb);//20

        abb +=10;//等同于：abb = (int)abb+10 其它类似
        System.out.println(abb);//30

        byte b1 = 10;
        //编译器只能检查语法，不运行程序，编译器发现b1+5的类型是int类型，b1变量的数据类型是byte
        //大容量向小容量转换需要加强制类型转换符，所以以下程序编译报错
        //b1 = b1 + 5;
        b1 = (byte)(b1+5);
        System.out.println(b1);//15

        byte xxx = 10;
        xxx +=5;//等同于：xxx = (byte)(xxx+5),其实并不等同于：xxx = xxx + 5
        System.out.println(xxx);//15

        int ba = 10;
        int bb = 10;
        System.out.println("ba+bb="+(ba+bb));
        System.out.println(ba+"+"+bb+"="+(ba+bb));

        //引用类型String
        //String是SUN在JavaSE当中提供的字符串类型，在String.class字节码文件当中
        //定义一个String类型的变量，起名username，赋值zhang
        String username = "zhang";
        System.out.println(username);
        System.out.println("登录成功"+username+"欢迎回来");

        boolean sex = true;
        //sex?'男':'女' 编译错误，不是语句
    }
}
