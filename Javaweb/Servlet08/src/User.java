import java.util.Objects;

public class User {

    private int num;
    private  String name;

    public User() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        User user = (User) o;
        return num == user.num && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(num, name);
    }

    @Override
    public String toString() {
        return "User{" +
                "num=" + num +
                ", name='" + name + '\'' +
                '}';
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
