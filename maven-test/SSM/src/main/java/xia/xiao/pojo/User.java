package xia.xiao.pojo;

public class User {
    private String userId;
    private String cardType;
    private String cardNo;
    private String userName;
    private String userSex;
    private String userAge;
    private String userRoles;

    public User() {
    }

    public User(String userId, String cardType, String cardNo, String userName, String userSex, String userAge, String userRoles) {
        this.userId = userId;
        this.cardType = cardType;
        this.cardNo = cardNo;
        this.userName = userName;
        this.userSex = userSex;
        this.userAge = userAge;
        this.userRoles = userRoles;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", cardType='" + cardType + '\'' +
                ", cardNo='" + cardNo + '\'' +
                ", userName='" + userName + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userAge='" + userAge + '\'' +
                ", userRoles='" + userRoles + '\'' +
                '}';
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserAge() {
        return userAge;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }

    public String getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(String userRoles) {
        this.userRoles = userRoles;
    }
}
