package com.all.in.one.pramod;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.all.in.one.pramod.app.RetrofitClient;
import com.all.in.one.pramod.models.DefaultResponse;
import com.all.in.one.pramod.models.Users;
import com.all.in.one.pramod.navigation.ProfileActivity;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignIn extends AppCompatActivity {
   private ProgressDialog progressDialog;
   private TextView textRegister;
   private Button btn_Login;
    private TextInputLayout country_code;
    private TextInputLayout user_id;
    private TextInputLayout  pin_id;
    private TextInputLayout  confirm_pin;
    private TextInputLayout  password_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        getSupportActionBar().setTitle("SignIn");

        textRegister = findViewById(R.id.register);
        btn_Login = findViewById(R.id.btnlogin);
        progressDialog = new ProgressDialog(this);

        country_code = findViewById(R.id.companycode);
        user_id = findViewById(R.id.userid);
        pin_id = findViewById(R.id.pin);
        confirm_pin = findViewById(R.id.rePin);
        password_id = findViewById(R.id.password);





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


        String companyCode = country_code.getEditText().getText().toString();
        String userID = user_id.getEditText().getText().toString();
        String pin = pin_id.getEditText().getText().toString();
        String repin = confirm_pin.getEditText().getText().toString();
        String password = password_id.getEditText().getText().toString();




        Users users = new  Users(companyCode,userID,password);

                 System.out.println(users.getCompanyCode()+"Test");
                 System.out.println(users.getPassword()+"TestPassword");
                 System.out.println(users.getUserid()+"UserId");








        progressDialog.show();

       // Intent intent = new Intent(SignIn.this, ProfileActivity.class);
       // startActivity(intent);


        Call<ResponseBody> call = RetrofitClient.getInstance().getApi().userLogin(users);


        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

              //  System.out.println(response+"hello+Trad");

                try {
                    String res = response.body().string();

                    Toast.makeText(getApplicationContext(), res, Toast.LENGTH_LONG).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }


                progressDialog.dismiss();

              /*  String  tata  = response.message();
                System.out.println("TATA"+tata);
*/




               // DefaultResponse loginResponse = response.body();

               // Intent intent = new Intent(SignIn.this, ProfileActivity.class);
               // startActivity(intent);


                // progressDialog.dismiss();
             //   if (!loginResponse.isErr()) {
                    // progressDialog.dismiss();
                    finish();
                   // SharedPrefManager.getInstance(Login.this).saveUser(loginResponse.getUser());
                  //  Intent intent = new Intent(SignIn.this, ProfileActivity.class);
                    //intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    // mCtx.startActivity(new Intent(mCtx, Login.class));
                    //startActivity(intent);
                    //finish();

               // } else {
                   // Toast.makeText(getApplicationContext(), "Invalid email or password", Toast.LENGTH_LONG).show();
                   // Intent intent = new Intent(SignIn.this, ProfileActivity.class);
                   // startActivity(intent);

                //}*/
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                 finish();
            }
        });

    }

}