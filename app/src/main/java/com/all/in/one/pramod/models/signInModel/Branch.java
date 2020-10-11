package com.all.in.one.pramod.models.signInModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Branch {

    @SerializedName("branch_code")
    @Expose
    private String branchCode;
    @SerializedName("branch_name")
    @Expose
    private String branchName;
    @SerializedName("contactperson")
    @Expose
    private String contactperson;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("place")
    @Expose
    private String place;

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getContactperson() {
        return contactperson;
    }

    public void setContactperson(String contactperson) {
        this.contactperson = contactperson;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
