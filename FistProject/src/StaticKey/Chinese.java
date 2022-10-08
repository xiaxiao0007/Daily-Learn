package StaticKey;

public class Chinese {

    //身份证号
    private int id;

    //姓名
    private String name;

    //国籍【每一个对象由于都是由”Chinese“实例化的，所以每一个中国人的国籍都是”中国“】
    //无论通过Chinese类实例化多少个Java对象，这些对象的国籍都是”中国“
    //实例变量【实例变量是一个Java对象就有一份，100个Java对象，就有100个country】
    //国籍【所有对象国籍一样，这种特征属于类级别的特征，可以提升为整个模板的特征，可以在变量前添加static关键字修饰】
    //静态变量，静态变量在类加载的时候初始化，不需要创建对象，内存就开辟了。
    //静态变量存储在方法区内存当中
    private static String country;

    //构造方法
    public Chinese(){
        /*
        this.id = 0;
        this.name = NULL;
        this.country = NULL;
         */
    }

    //构造方法
    public Chinese(int id,String name){
        this.id = id;
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static void setCountry(String country) {
        Chinese.country = country;
    }

    public static String getCountry() {
        return country;
    }
}
