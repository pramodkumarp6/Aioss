package com.all.in.one.pramod.models.signInModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {
    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("user_branch")
    @Expose
    private String userBranch;
    @SerializedName("user_emp_type")
    @Expose
    private String userEmpType;
    @SerializedName("user_type")
    @Expose
    private String userType;
    @SerializedName("deviceId")
    @Expose
    private String deviceId;
    @SerializedName("deviceName")
    @Expose
    private String deviceName;
    @SerializedName("companyLogo")
    @Expose
    private String companyLogo;
    @SerializedName("branches")
    @Expose
    private List<Branch> branches = null;

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

    public String getUserEmpType() {
        return userEmpType;
    }

    public void setUserEmpType(String userEmpType) {
        this.userEmpType = userEmpType;
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

    public List<Branch> getBranches() {
        return branches;
    }

    public void setBranches(List<Branch> branches) {
        this.branches = branches;
    }
}
