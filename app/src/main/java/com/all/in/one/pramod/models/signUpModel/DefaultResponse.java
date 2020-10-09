package com.all.in.one.pramod.models.signUpModel;

import com.google.gson.annotations.SerializedName;

public class DefaultResponse {

    @SerializedName("status")
    private boolean err;

    @SerializedName("message")
    private String msg;

    public DefaultResponse(boolean err, String msg) {
        this.err = err;
        this.msg = msg;
    }

    public boolean isErr() {
        return err;
    }

    public String getMsg() {
        return msg;
    }
}


