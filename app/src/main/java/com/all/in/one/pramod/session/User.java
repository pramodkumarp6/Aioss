package com.all.in.one.pramod.session;

public class User {
    private String userId;
    private String userBranch;
    private String userEmp_Type;
    private String userType;
    private String deviceId;
    private String deviceName;
    private String companyLogo;

    public User(String userId, String userBranch, String userEmp_Type, String userType, String deviceId, String deviceName,String companyLogo) {
        this.userId = userId;
        this.userBranch = userBranch;
        this.userEmp_Type = userEmp_Type;
        this.userType = userType;
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.companyLogo = companyLogo;
    }




    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserBranch() {
        return userBranch;
    }

    public void setUserBranch(String userBranch) {
        this.userBranch = userBranch;
    }

    public String getUserEmp_Type() {
        return userEmp_Type;
    }

    public void setUserEmp_Type(String userEmp_Type) {
        this.userEmp_Type = userEmp_Type;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getCompanyLogo() {
        return companyLogo;
    }

    public void setCompanyLogo(String companyLogo) {
        this.companyLogo = companyLogo;
    }


}
