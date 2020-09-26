package com.all.in.one.pramod;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.all.in.one.pramod.app.RetrofitClient;
import com.all.in.one.pramod.models.DefaultResponse;
import com.all.in.one.pramod.navigation.ProfileActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignIn extends AppCompatActivity {
   private ProgressDialog progressDialog;
   private TextView textRegister;
   private Button btn_Login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        getSupportActionBar().setTitle("SignIn");

        textRegister = findViewById(R.id.register);
        btn_Login = findViewById(R.id.btnlogin);
        progressDialog = new ProgressDialog(this);
        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        textRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent = new Intent (SignIn.this, SignUp.class);
                startActivity(intent);
            }
        });




    }




    public void login(){
        Intent intent = new Intent(SignIn.this, ProfileActivity.class);
        startActivity(intent);
/*
        progressDialog.show();

        Intent intent = new Intent(SignIn.this, ProfileActivity.class);
        startActivity(intent);


        Call<DefaultResponse> call = RetrofitClient.getInstance().getApi().userLogin( );

        call.enqueue(new Callback<DefaultResponse>() {
            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                progressDialog.dismiss();

                Intent intent = new Intent(SignIn.this, ProfileActivity.class);
                startActivity(intent);





              *//*  DefaultResponse loginResponse = response.body();

                Intent intent = new Intent(SignIn.this, ProfileActivity.class);
                startActivity(intent);


                // progressDialog.dismiss();
                if (!loginResponse.isErr()) {
                    // progressDialog.dismiss();
                    finish();
                   // SharedPrefManager.getInstance(Login.this).saveUser(loginResponse.getUser());
                  //  Intent intent = new Intent(SignIn.this, ProfileActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    // mCtx.startActivity(new Intent(mCtx, Login.class));
                    startActivity(intent);
                    //finish();

                } else {
                    Toast.makeText(getApplicationContext(), "Invalid email or password", Toast.LENGTH_LONG).show();
                   // Intent intent = new Intent(SignIn.this, ProfileActivity.class);
                   // startActivity(intent);

                }*//*
            }

            @Override
            public void onFailure(Call<DefaultResponse> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                 finish();
            }
        });*/

    }

}