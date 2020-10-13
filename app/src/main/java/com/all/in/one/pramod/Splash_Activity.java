package com.all.in.one.pramod;

import android.app.ProgressDialog;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.all.in.one.pramod.databinding.ActivitySplashBinding;

public class Splash_Activity extends AppCompatActivity {

            private ActivitySplashBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_splash);
                   getSupportActionBar().hide();



        Thread t=new Thread() {
            public void run() {

                try {

                    sleep(1000);


                    Intent intent =new Intent(Splash_Activity.this,SignIn.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);


                    finish();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };


        t.start();
    }
}




