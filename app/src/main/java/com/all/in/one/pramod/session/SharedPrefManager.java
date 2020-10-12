package com.all.in.one.pramod.session;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

import com.all.in.one.pramod.SignIn;

public class SharedPrefManager {


    private static SharedPrefManager mInstance;
    private static Context mCtx;

    private static final String SHARED_PREF_NAME = "mysharedpref12";
    private static final String KEY_USER_ID = "admin";
    private static final String KEY_USER_BRANCH = "keybrach";
    private static final String KEY_USER_EMP_TYPE = "keyuseremptype";
    private static final String KEY_USER_TPYE = "userid";
    private static final String KEY_DEVICE_ID = "mobile";
    private static final String KEY_DEVICE_NAME = "keydeviceName";
    private static final String KEY_COMAPNY_LOGO = "companylogo";


    private SharedPrefManager(Context context) {
        mCtx = context;

    }

    public static synchronized SharedPrefManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SharedPrefManager(context);
        }
        return mInstance;
    }


    public void saveUser(User user) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_USER_ID, user.getUserId());
        editor.putString(KEY_USER_EMP_TYPE, user.getUserEmp_Type());
        editor.putString(KEY_USER_BRANCH, user.getUserBranch());
        editor.putString(KEY_USER_TPYE, user.getUserType());
        editor.putString(KEY_DEVICE_ID, user.getDeviceId());
        editor.putString(KEY_DEVICE_NAME, user.getDeviceName());
        editor.putString(KEY_COMAPNY_LOGO, user.getCompanyLogo());

        Log.d(user.getCompanyLogo(),"Prashant");


        editor.apply();
    }


    public boolean isLoggedIn() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString("KEY_USER_ID", null) != null;
    }


    public User getUser() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return new User(
                sharedPreferences.getString(KEY_USER_ID, null),
                sharedPreferences.getString(KEY_USER_BRANCH, null),
                sharedPreferences.getString(KEY_USER_TPYE, null),
                sharedPreferences.getString(KEY_USER_EMP_TYPE, null),

                sharedPreferences.getString(KEY_DEVICE_NAME, null),
                sharedPreferences.getString(KEY_DEVICE_NAME, null),
                sharedPreferences.getString(KEY_COMAPNY_LOGO, null)



        );

    }




    public void logout() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        mCtx.startActivity(new Intent(mCtx, SignIn.class));
    }


}
