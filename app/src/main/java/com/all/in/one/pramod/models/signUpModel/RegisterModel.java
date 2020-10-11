package com.all.in.one.pramod.models.signUpModel;

public class RegisterModel {
    private String email;
    private String pinCode;
    private String name;
    private String mobile;
    private String state;
    private String city;
    private String password;
    private String address;
    private String lankmak;
    private String gstNumber;
    private String device_id;
    private String device_Model;


    public RegisterModel(String email, String pinCode, String name, String mobile, String state, String city, String password, String address, String lankmak, String gstNumber, String device_id, String device_Model) {
        this.email = email;
        this.pinCode = pinCode;
        this.name = name;
        this.mobile = mobile;
        this.state = state;
        this.city = city;
        this.password = password;
        this.address = address;
        this.lankmak = lankmak;
        this.gstNumber = gstNumber;
        this.device_id = device_id;
        this.device_Model = device_Model;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLankmak() {
        return lankmak;
    }

    public void setLankmak(String lankmak) {
        this.lankmak = lankmak;
    }

    public String getGstNumber() {
        return gstNumber;
    }

    public void setGstNumber(String gstNumber) {
        this.gstNumber = gstNumber;
    }

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    public String getDevice_Model() {
        return device_Model;
    }

    public void setDevice_Model(String device_Model) {
        this.device_Model = device_Model;
    }
}