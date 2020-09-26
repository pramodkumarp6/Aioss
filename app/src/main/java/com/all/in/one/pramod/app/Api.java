package com.all.in.one.pramod.app;

import com.all.in.one.pramod.models.DefaultResponse;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {



    @FormUrlEncoded
    @POST("register")
    Call<DefaultResponse> createUser(
    );

    @FormUrlEncoded
    @POST("login")
    Call<DefaultResponse> userLogin(
    );

}