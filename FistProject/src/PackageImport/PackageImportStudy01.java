package PackageImport;
/*
关于Java语言中的package和import机制
    1.为什么要使用package？
        package是Java中包机制。包机制的作用是为了方便程序的管理
        不同功能的类分别存放在不同的包下。(按照功能划分，不同的软件具有不同的功能)
    2.package怎么用？
        package是一个关键字，后面加包名。例如：package PackageImport;
        注意：package语句只允许出现Java源代码的第一行。
    3.加入package后类名就发生变化了 PackageImport.PackageImportStudy01
     【注意】以后说类名的时候，如果带包名描述，表示完整类名。如果没有带包，描述的话，表示简类名
    4.关于import的使用
        import什么时候使用？
            A类中使用B类。
            A和B类都在同一个包下，不需要import
            A和B类不在同一个包下，需要使用import
        import怎么用？
            import语句只能出现在package语句之下，class声明语句之上。
            import语句还可以采用星号的方式
            import 完整类名;
            这个效率不低，因为编译器在编译的时候，会自动把*变成具体的类名。
            import 包名.*;

 */

import java.util.Scanner;

public class PackageImportStudy01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入字符串:");
        String str = scanner.next();
        System.out.println(str);
    }
}
