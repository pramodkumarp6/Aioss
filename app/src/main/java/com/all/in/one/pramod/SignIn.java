package com.all.in.one.pramod;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.all.in.one.pramod.app.RetrofitClient;
import com.all.in.one.pramod.models.DefaultResponse;
import com.all.in.one.pramod.models.Financial;
import com.all.in.one.pramod.models.Financial_Year;
import com.all.in.one.pramod.models.Users;
import com.all.in.one.pramod.navigation.ProfileActivity;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignIn extends AppCompatActivity implements   AdapterView.OnItemSelectedListener {
   private ProgressDialog progressDialog;
   private TextView textRegister;
   private Button btn_Login;
    private TextInputLayout country_code;
    private TextInputLayout user_id;
    private TextInputLayout  pin_id;
    private TextInputLayout  confirm_pin;
    private TextInputLayout  password_id;
    private  Financial financial;
    private Spinner spinner;
    String[] country = {"Select", "Financial_Year\": \"2019 - 2020","Financial_Year\": \"2020 - 2021"};
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

        spinner= findViewById(R.id.spinnerFincial);

        spinner.setOnItemSelectedListener(this);



        ArrayAdapter aa = new ArrayAdapter(this,R.layout.spinner_item,country);
        aa.setDropDownViewResource(R.layout.spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spinner.setAdapter(aa);



        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
                financial();
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
        String con = spinner.getSelectedItem().toString().trim();


        if (companyCode.isEmpty() ) {
            country_code.setError("Company Code  is required ");
            country_code.requestFocus();
            return;
        }

        if (userID.isEmpty())  {
            user_id.setError("Enter valid UserID");
            user_id.requestFocus();
            return;
        }



        if (password.isEmpty()) {
            password_id.setError("Password required");
            password_id.requestFocus();
            return;
        }


       if (pin.isEmpty()) {
           pin_id.setError("Password required");
           pin_id.requestFocus();
            return;
        }


        if (repin.isEmpty()) {
            confirm_pin.setError("Password required");
            confirm_pin.requestFocus();
            return;
        }





        Users users = new  Users(companyCode,userID,password);
        Financial financial = new Financial(companyCode);
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

                   System.out.println(res);

                   // Toast.makeText(getApplicationContext(), res, Toast.LENGTH_LONG).show();
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

    public void financial(){
        String companyCode = country_code.getEditText().getText().toString();
        Financial financial = new Financial(companyCode);



        Call<Financial_Year> call = RetrofitClient.getInstance().getApi().loginFinacial(financial);
        System.out.println(financial.getCompanyCode());


        call.enqueue(new Callback<Financial_Year>() {
            @Override
            public void onResponse(Call<Financial_Year> call, Response<Financial_Year> response) {






                progressDialog.dismiss();


            }

            @Override
            public void onFailure(Call<Financial_Year> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                finish();
            }
        });


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}