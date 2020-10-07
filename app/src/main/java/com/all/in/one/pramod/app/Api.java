package com.all.in.one.pramod.app;

import com.all.in.one.pramod.models.DefaultResponse;
import com.all.in.one.pramod.models.Financial;
import com.all.in.one.pramod.models.Fincial;
import com.all.in.one.pramod.models.User;
import com.all.in.one.pramod.models.Users;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {





    @POST("UserAuth/checkLogin")
    Call<ResponseBody> userLogin(@Body Users users);


    @POST("Utils/getFinancialYears")
    Call<ResponseBody> userfinacial(@Body Financial financial);







}