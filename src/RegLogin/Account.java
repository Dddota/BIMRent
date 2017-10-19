package RegLogin;

import item.ForRentMessage;

import java.io.Serializable;


public class Account implements Serializable {
    private String userName;
    private String password;
    private String phoneNumber;
    private String idnum;//身份证号码
    private String type;//账号的种类，房东或房客。Lodger、Landlord
    private int creditPoint = 50;//账号的信用积分
    //private String choose;//账号的选择


    public int getCreditPoint() {
        return creditPoint;
    }

    public void setCreditPoint(int creditPoint) {
        this.creditPoint = creditPoint;
    }

    public String getIdnum() {
        return idnum;
    }

    public void setIdnum(String idnum) {
        this.idnum = idnum;
    }



    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }



    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}