public class Test02 extends father{
    // 静态方法中不能使用this和super关键字
    // this和super都属于引用，静态方法加载的时候，对象还不一定创建了
    public static void main(String[] args) {

    }

    public void test(){
        this.getI();
    }
}

class father{
    public int getI() {
        return i;
    }

    private int i = 1;
}