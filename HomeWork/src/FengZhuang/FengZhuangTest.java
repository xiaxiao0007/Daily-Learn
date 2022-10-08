package FengZhuang;

public class FengZhuangTest {

    private int age;

    public void setAge(int a){
        //在这进行编写逻辑代码进行安全控制
        //age = a;
        if (a>150|a<0){
            System.out.println("年龄不合法");
        }
        age = a;

    }

    public int getAge(){
        return age;
    }
}
