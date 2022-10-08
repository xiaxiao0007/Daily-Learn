package Javase.Day20211225;

public class HomeworkSystem {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        hotel.print();
    }
}

class Room{
    private int num;
    private String type;
    private boolean status;

    public Room() {
    }

    public Room(int num, String type, boolean status) {
        this.num = num;
        this.type = type;
        this.status = status;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Room[" +
                "num=" + num +
                ", type='" + type + '\'' +
                ", status=" + (status ? "占用":"空闲")+"]";//三目运算符，需要重写toString()方法
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null||!(obj instanceof Room)) return false;
        if (this == obj) return true;
        Room room = (Room) obj;
        return this.num==room.num && this.type.equals(room.type)&&this.status == room.status;
    }
}
class Hotel{
    private Room[][] rooms;

    public Hotel() {
        rooms = new Room[3][10];
        for (int i=0;i<rooms.length;i++){
            for (int j=0;j<rooms[i].length;j++){
                if(i == 0){
                    rooms[i][j] = new Room((i+1)*100+j+1,"单人间",false);
                }else if (i == 1){
                    rooms[i][j] = new Room((i+1)*100+j+1,"标准间",false);
                }else{
                    rooms[i][j] = new Room((i+1)*100+j+1,"总统套房",false);
                }
            }
        }
    }

    public void print(){
        for (int i = 0;i<rooms.length;i++){
            for (int j = 0;j<rooms[i].length;j++){
                System.out.println(rooms[i][j]+"  ");
            }
            //System.out.println();
        }
    }

    public void order(int num){
        if (rooms[num/100-1][num%100-1].isStatus() == false)
        rooms[num/100][num%100-1].setStatus(true);
    }

    public void  exit(int num){
        if (rooms[num/100-1][num%100-1].isStatus() == true) {
            rooms[num / 100][num % 100 - 1].setStatus(false);
        }
    }
}