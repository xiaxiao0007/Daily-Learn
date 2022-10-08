package Interface;
/*

 */
public class InterfaceStudyTest01 {
    public static void main(String[] args) {

        //经过测试：接口和接口之间在进行强制类型转换的时候，没有继承关系，也可以强转。
        //但是一定要注意，运行时可能会出现ClassCastException异常
        //但是最终实际上和之前还是一样，需要加：instanceof运算进行判断
        E a = new L();

        //这个编译没问题，运行也没问题
        //调用其它接口的方法，你需要转型(接口转型。)
        F b = (F) a;
        b.m2();

        if(a instanceof L){
            L c = (L) a;
        }
    }
}

interface E{
    void m1();
}

interface F{
    void m2();
}

interface G{
    void m3();
}

class L implements E,F,G{
    @Override
    public void m1() {

    }

    @Override
    public void m2() {
        System.out.println("测试");
    }

    @Override
    public void m3() {

    }
}