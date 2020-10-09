package com.all.in.one.pramod.models.stateModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StateData {
    private String id;
    private String state_code;
    private String state_name;
    @SerializedName("StateCode")
    @Expose
    private  String stateCode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getState_code() {
        return state_code;
    }

    public void setState_code(String state_code) {
        this.state_code = state_code;
    }

    public String getState_name() {
        return state_name;
    }

    public void setState_name(String state_name) {
        this.state_name = state_name;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }
}
