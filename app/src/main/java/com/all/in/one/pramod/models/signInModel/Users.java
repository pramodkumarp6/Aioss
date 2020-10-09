package com.all.in.one.pramod.models.signInModel;

public class Users {
    private  String  companyCode;
    private  String  userId;
    private  String  password;

    public Users(String companyCode, String userid, String password) {
        this.companyCode = companyCode;
        this.userId = userid;
        this.password = password;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getUserid() {
        return userId;
    }

    public void setUserid(String userid) {
        this.userId = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
