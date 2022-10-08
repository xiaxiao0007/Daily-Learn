package xia.xiao.pojo;

public class Accounts {

    private int aid;
    private String aname;
    private String aconcent;

    public Accounts() {
    }

    public Accounts(int aid, String aname, String aconcent) {
        this.aid = aid;
        this.aname = aname;
        this.aconcent = aconcent;
    }

    @Override
    public String toString() {
        return "Accounts{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                ", aconcent='" + aconcent + '\'' +
                '}';
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getAconcent() {
        return aconcent;
    }

    public void setAconcent(String aconcent) {
        this.aconcent = aconcent;
    }
}
