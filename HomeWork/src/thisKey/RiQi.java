package thisKey;

public class RiQi {

    int year;

    int month;

    int day;

    public RiQi(){
        /*
        代码重复性高
        this.year = 1970;
        this.month = 1;
        this.day = 1;
         */

        //以上代码可以通过调用另一个构造方法来完成
        //但前提是不能创建新的对象，以下代码表示创建了一个全新的对象
        //new RiQi(1970,1,1);

        //需要采用以下的语法来完成构造方法的调用
        //这种方式不会创建新的Java对象。但是同时有可以达到调用其它的"构造方法"
        //
        this(1970,1,1);//这个只能
    }

    public RiQi(int year,int month,int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void setYear(int year){
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getMonth() {
        return month;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getDay() {
        return day;
    }

    public void print(){
        System.out.println(this.year+"年"+this.month+"月"+this.day+"日");
    }
}
