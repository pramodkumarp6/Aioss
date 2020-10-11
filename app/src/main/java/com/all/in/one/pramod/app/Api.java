package com.all.in.one.pramod.app;

import com.all.in.one.pramod.models.finacal.Financial;
import com.all.in.one.pramod.models.finacal.Fincial;
import com.all.in.one.pramod.models.signInModel.UserSignModel;
import com.all.in.one.pramod.models.signInModel.Users;
import com.all.in.one.pramod.models.signUpModel.DefaultResponse;
import com.all.in.one.pramod.models.signUpModel.RegisterModel;
import com.all.in.one.pramod.models.stateModel.StateModel;
import com.all.in.one.pramod.models.stateModel.States;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Api {


    /****************************SignIn**********************************************/

    @POST("UserAuth/checkLogin")
    Call<UserSignModel> userLogin(@Body Users users);


    @POST("Utils/getFinancialYears")
    Call<Fincial> userfinacial(@Body Financial financial);


    /**************************************SingUp************************************/
    @POST("Utils/getAllStates")
    Call<StateModel> userState(@Body States s);



    @POST("Utils/getAllCites")
    Call<StateModel> userCity(@Body States states);




    @POST("Utils/getAllCites")
    Call<DefaultResponse> userCreate(@Body RegisterModel registerModel);


}