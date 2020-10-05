package com.all.in.one.pramod;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.all.in.one.pramod.app.RetrofitClient;
import com.all.in.one.pramod.models.DefaultResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();


        Thread t=new Thread() {
            public void run() {

                try {

                    sleep(1000);


                    Intent intent =new Intent(MainActivity.this,SignIn.class);
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




