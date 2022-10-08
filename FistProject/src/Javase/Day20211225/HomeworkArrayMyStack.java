package Javase.Day20211225;
//数组定义在了内部
public class HomeworkArrayMyStack {

    private int top = 0;
    private Object a;
    private Object[] object;

    public HomeworkArrayMyStack(){
        this.object = new Object[10];
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public Object getA() {
        return a;
    }

    public void setA(Object a) {
        this.a = a;
    }

    public Object[] getObject() {
        return object;
    }

    public void setObject(Object[] object) {
        this.object = object;
    }

    public void Push(Object obj){
        if (this.top == (this.object.length-1)){
            System.out.println("压栈失败");
        }else {
            this.object[this.top++] = obj;
            System.out.println("压栈成功");
        }
    }

    public Object visit(int i){
        return this.object[i];
    }

    public Object Pop(){
        if (this.top == 0){
            System.out.println("弹栈失败");
        }else{
            this.a = this.object[--this.top];
            System.out.println("弹栈成功");
        }
        return this.a;
    }

    //Object[][] objects = {{1,2,3},{"name"}};
}
