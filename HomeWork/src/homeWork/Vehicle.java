package homeWork;

public class Vehicle {
    private int speed;

    private double size;

    public Vehicle() {
    }

    public Vehicle(int speed, double size) {
        this.speed = speed;
        this.size = size;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public void move(){

    }

    public void speedUp(){
        int speed01 = this.getSpeed();
        this.setSpeed(++speed01);
    }

    public void speedDown(){
        //最好有个判断
        speed = --speed;
    }
}

class VehicleTest{
    public static void main(String[] args) {
        //无参数构造方法创建对象
        Vehicle car = new Vehicle();
        car.setSpeed(10);
        car.setSize(14.5);
        System.out.println(car.getSpeed()+"+"+ car.getSize());
        car.speedUp();
        System.out.println(car.getSpeed());
        car.speedDown();
        System.out.println(car.getSpeed());


        //有参数构造方法创建对象
        Vehicle car01 = new Vehicle(10,5.4);

    }
}
