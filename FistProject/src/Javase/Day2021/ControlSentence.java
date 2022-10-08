package Javase.Day2021;/*
选择结构
    if 语句又被称为分支语句/条件控制语句
        1.if语句的语法结构:四种编写方式
            第一种：if(布尔表达式){
                    Java语句;
                }
            第二种：if(布尔表达式){
                    Java语句;
                }else{
                    java语句;
                }条件不为真执行else里面的语句
            第三种：if(布尔表达式){
                    Java语句;
                }else if(布尔表达式){
                    Java语句;
                }
            第四种：if(布尔表达式){
                    Java语句;
                }else if(布尔表达式){
                    Java语句;
                }else {
                    Java语句;
                }
        2.重点:对于Java中的if语句来说，只要有一个分支执行，整个if语句全部结束。
        3.注意:以上的第二种编写方式和第四种编写方式都带有else分支，这两种方式可以100%保证会有分支执行
        4.所有的控制语句都可以互相嵌套使用，只要合理嵌套即可
        5.if语句的分支中只有一个Java语句的话，大括号可以省略不写
    关于switch语句
        1.switch语句也属于选择结构，也是分支语句
        2.switch语句的语法结构：
            一个比较完整的switch语句应该这样编写：
                switch(不是布尔类型，只能是int或String类型的字面值或变量){
                    case int或String类型的字面值或变量:
                        java语句;
                        java语句;
                        .....
                        //break;
                    case int或String类型的字面值或变量:
                        java语句;
                        java语句;
                        .....
                        break;
                    ...
                    default:
                        java语句;
                        ...
                }
        3.switch执行原理:
            switch后面小括号当中的"数据"和case后面的”数据“进行一一匹配，匹配成功的分支执行。
            按照自上而下的顺序依次匹配。
        4.匹配成功的分支执行，分支当中最后有”break“;语句的话，整个switch语句终止。
        5.匹配成功的分支执行，分支当中最后没有”break“;语句的话，直接进入下一个分支执行(不进行匹配)。
        这种现象被称为case穿透现象。【提供break;语句可以避免穿透】
        6.所有分支都没有匹配成功，当有default的语句话，会执行default分支当中的程序。
        7.switch后面和case后面只能是int或者String类型的数据，不能探测其它类型
            当然byte，short，char也可以直接写到switch和case后面，因为它们可以进行自动类型转换
        8.case可以合并
            int i = 10;
            switch(i){
                case 1;case 2;case 10;
                    System.out.println("hello");
            }//执行1，2，10都可以输出语句


循环结构
    1.在程序当中总有一些需要反复/重复的执行代码，假设没有循环结构，那么这段需要重复执行的代码自然需要重复编写，
    代码无法得到重复使用。所以多数编程语言都是支持循环结构的。将来把需要“反复执行的代码片段”放到“循环体”，在联
    合“计数器”，共同控制这段需要反复执行的代码。
    2.for循环
        语法结构；
        for(初始化表达式;布尔表达式;更新表达式){
            是需要重复执行的代码片段【循环体：由Java语句构成】
        }
    3.for循环的执行过程/执行原理【非常的重要】
        3.1初始化表达式，布尔表达式，更新表达式都不是必须的【但是两个分号是必须的】
        3.2初始化表达式最先执行，并且在整个for循环当中执行一次。
        3.3布尔表达式必须是true/false，不能是其它值。
        3.4 for的执行过程
            先执行初始化表达式，并且该表达式只执行一次
            判断布尔表达式的结果是true还是false
                -布尔表达式是true
                    执行循环体
                    执行更新表达式
                    判断布尔表达式的结果是true还是false
                        -布尔表达式是true
                            执行循环体
                            执行更新表达式
                            判断布尔表达式的结果是true还是false
                                ....
                        -布尔表达式是false
                            循环结束
                -布尔表达式是false
                    循环结束
    while
        1.while循环的语法结构:
            while(布尔表达式){
                循环体;
            }
        2.while循环的执行原理:
            先判断布尔表达式的结果
                -true
                    执行循环体
                    判断布尔表达式的结果
                        -true
                            执行循环体
                            判断布尔表达式的结果
                            ......
                        -false
                            循环结束
                -false
                    循环结束
        3.while循环的循环次数:
            0~N次【注意:while循环的循环体可能执行次数为0次】
    do..while
        1.do..while循环的语法结构:
            do{
            }while(布尔表达式);
        2.do..while循环的执行原理:
            先循环体————>布尔表达式
        3.do..while循环的执行次数:
            do..while循环体的代码片段执行次数:1~N次【至少一次】
        4.使用do..while循环的注意事项:
            do..while循环语句最终有一个“分号”别丢了

控制循环的语句
    break
        中断Java语句，跳出当前整个作用域
    continue
        中断Java语句，但只跳出当前语句
 */
/*
System.out.println();负责向控制台输出【从内存到控制台，输出的过程，这是从内存出来了】

接收用户键盘输入，从"键盘"到"内存".【输入过程，到内存中去了】
第一步：创建键盘扫描对象
java.util.Scanner s = new java.util.Scanner(System.in);接受用户输入
String userInputContent = s.next();
第二步：调用Scanner对象的next()方法开始接受用户键盘输入，程序执行到这里会停下来，等待用户的输入
       当用户输入的时候，并且最终敲回车键的时候，键入的信息会自动赋值给userInputContent
       程序执行到这里，用户输入的信息已经到内存中了
接受文本【以字符串形式接收】
String userInputContent = s.next();
接受数字【以整数型int的形式来接收】
int num = s.nextInt();
将内存中的数据输出到控制台
System.out.println("你输入了"+userInputContent);
 */

public class ControlSentence {
    public static void main(String[] args){
        /*
        java.util.Scanner s = new java.util.Scanner(System.in);
        System.out.print("输入年龄：");
        int age = s.nextInt();//相当于C语言中的scanf()函数
        String str = "傻逼";
        if(age > 10){
            str = "聪明";//这是字符串
           // System.out.println("傻逼");
        }

        System.out.println(str);
        System.out.println("欢迎使用简单计算器系统");
        System.out.print("请输入第一个数字：");
        int num1 = s.nextInt();
        System.out.print("请输入运算符：");
        String str1 = s.next();
        System.out.print("请输入第二个数字：");
        int num2 = s.nextInt();
        int result = 0;
        switch (str1){
            case "+":
                result = num1 + num2;
                System.out.println(num1+"+"+num2+"="+(num1+num2));
                break;
            case "-":
                result = num1 + num2;
                System.out.println(num1+"-"+num2+"="+(num1-num2));
                break;
            case "*":
                result = num1 + num2;
                System.out.println(num1+"*"+num2+"="+(num1*num2));
                break;
            case "/":
                result = num1 + num2;
                System.out.println(num1+"/"+num2+"="+(num1/num2));
                break;
            default:
                System.out.println("输入错误");
        }
        System.out.println(num1+str1+num2 +"="+result);
         */
        /*int c;//c定义在main方法中，作用范围在整个main方法体中
        for (c = 0;c < 10;c++){
            System.out.println(c);//每满足一次布尔表达式，执行一次循环体
            System.out.println("c-->"+c);//重点：用+运算符进行连接操作
        }
        System.out.println(c);

         */
        //循环语句和条件判断语句嵌套使用【for和if的嵌套】
        //累加的思想 sum += i;
        /*int d;
        int sum = 0;//最终的求和结果
        for (d = 1;d <= 100;d++){
            //System.out.println(d);
            if(d%2==1){//奇数的性质
                System.out.println(d);
                sum = sum+d;
                System.out.println(sum);
            }
        }
        System.out.println(sum);

         */

        //循环体中可以编写其它控制语句
        //控制语句可以嵌套使用
        //控制语句可以是:if,if..else,switch,for,while,do..while
        //循环体当中是一个for循环，不要将这个for循环特殊化，也只是一个普通的for循环，
        // 只是一个合法的代码,可以相当于一个Java语句
        //内层循环，内层循环中的变量名和外层循环中的变量名不能重名。
        /*
        for (int i=1;i < 10;i++){

            //这里的代码片段执行9遍
            //九九乘法表
            for (int j = 1;j <= i;j++){
                System.out.print(i+"*"+j+"="+(i*j)+" ");//+连接的是字符串，或者是求和运算符
            }
            System.out.print("\n");
        }
         */
        //注意:编译时，只检查语法错误，不会进行计算【变量】

    }
}
