package xia.xiao.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Users {

    private int uid;
    private String uname;
    private int uage;

    public Users() {
        System.out.println("用户的无参构造");
    }

    public Users(int uid, String uname, int uage) {
        this.uid = uid;
        this.uname = uname;
        this.uage = uage;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public int getUage() {
        return uage;
    }

    public void setUage(int uage) {
        this.uage = uage;
    }

    @Override
    public String toString() {
        return "Users{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", uage=" + uage +
                '}';
    }
}
