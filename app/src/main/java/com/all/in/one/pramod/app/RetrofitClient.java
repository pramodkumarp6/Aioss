package com.all.in.one.pramod.app;

import android.util.Base64;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static final String AUTH = "Basic " + Base64.encodeToString(("user:123456").getBytes(), Base64.NO_WRAP);



    private static final String BASE_URL = "http://aioss.co.in/aiossmobileapi/api/";

   // http://aioss.co.in/aiossmobileapi/api/Utils/getAllStates

  /*  {
        "companyCode":"Trad"
    }
*/



    private static RetrofitClient mInstance;
    private Retrofit retrofit;


    private RetrofitClient() {



            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .readTimeout(2, TimeUnit.MINUTES)
                    .connectTimeout(2, TimeUnit.MINUTES)
                    .writeTimeout(2, TimeUnit.SECONDS)
                    .addInterceptor(new Interceptor()

                                    {
                                @Override
                                public Response intercept(Chain chain) throws IOException {
                                    Request original = chain.request();

                                    Request.Builder requestBuilder = original.newBuilder()

                                            .addHeader("Authorization", AUTH)

                                            .method(original.method(), original.body());

                                    Request request = requestBuilder.build();
                                    return chain.proceed(request);
                                }
                            }
                    ).build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build();
    }

    public static synchronized RetrofitClient getInstance() {
        if (mInstance == null) {
            mInstance = new RetrofitClient();
        }
        return mInstance;
    }

    public Api getApi() {
        return retrofit.create(Api.class);
    }
}