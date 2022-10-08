package xia.xiao.pojo;

public class Users {
    private Integer userid;
    private String uname;
    private String upass;

    public Users() {
    }

    public Users(Integer userid, String uname, String upass) {
        this.userid = userid;
        this.uname = uname;
        this.upass = upass;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpass() {
        return upass;
    }

    public void setUpass(String upass) {
        this.upass = upass;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userid=" + userid +
                ", uname='" + uname + '\'' +
                ", upass='" + upass + '\'' +
                '}';
    }
}
