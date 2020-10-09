package com.all.in.one.pramod;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.all.in.one.pramod.app.RetrofitClient;
import com.all.in.one.pramod.models.finacal.Financial;
import com.all.in.one.pramod.models.finacal.Fincial;
import com.all.in.one.pramod.models.signInModel.Users;
import com.all.in.one.pramod.navigation.ProfileActivity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignIn extends AppCompatActivity {
   private ProgressDialog progressDialog;
   private TextView textRegister;
   private Button btn_Login;
    private TextInputEditText country_code;
    private TextInputEditText user_id;
    private TextInputLayout  pin_id;
    private TextInputLayout  confirm_pin;
    private TextInputLayout  password_id;
    private Financial financial;
    private Spinner spinner_finacil;
    ArrayList<String> DistricName = new ArrayList<>();
    ArrayList<String> DistricNameID = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        getSupportActionBar().setTitle("SignIn");

        textRegister = findViewById(R.id.register);
        btn_Login = findViewById(R.id.btnlogin);
        progressDialog = new ProgressDialog(this);
        spinner_finacil = findViewById(R.id.fnacl);
        spinner_finacil.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });






        country_code = findViewById(R.id.companycode);



























        user_id = findViewById(R.id.userid);

        user_id.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {}

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                spinner_finacil.setVisibility((s.length() > 1) ? View.VISIBLE : View.GONE);
            }
            });









        country_code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String companyCode = country_code.getText().toString();
                Financial financial = new Financial(companyCode);
                Log.d(companyCode,"company");

                financial();

            }
        });










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


        String companyCode = country_code.getText().toString();

        String userID = user_id.getText().toString();
        String pin = pin_id.getEditText().getText().toString();
        String repin = confirm_pin.getEditText().getText().toString();
        String password = password_id.getEditText().getText().toString();




        Users users = new  Users(companyCode,userID,password);









       // progressDialog.show();

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
                    Toast.makeText(getApplicationContext(), res, Toast.LENGTH_LONG).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }


                progressDialog.dismiss();

              /*  String  tata  = response.message();
                System.out.println("TATA"+tata);
*/




               // DefaultResponse loginResponse = response.body();

                Intent intent = new Intent(SignIn.this, ProfileActivity.class);
               startActivity(intent);


                // progressDialog.dismiss();
             //   if (!loginResponse.isErr()) {
                    // progressDialog.dismiss();
                   // finish();
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


    public  void financial(){
       String companyCode = country_code.getText().toString();
        Financial financial = new Financial(companyCode);

        Call<Fincial> call = RetrofitClient.getInstance().getApi().userfinacial(financial);


        call.enqueue(new Callback<Fincial>() {
            @Override
            public void onResponse(Call<Fincial> call, Response<Fincial> response) {

                try {


                    Fincial financialmodel = response.body();
                    System.out.println(financialmodel);

                    Gson gson = new GsonBuilder().setPrettyPrinting().create();
                    Log.e("fincilyear:", gson.toJson(financialmodel));
                    DistricName.clear();
                    DistricNameID.clear();

                    DistricName.add("Select Finanacial Year");
                    DistricNameID.add("125");
                    if (financialmodel.getStatus()==1) {
                        for (int i = 0; i < financialmodel.getData().size(); i++) {

                            DistricName.add(financialmodel.getData().get(i).getFinancial_Year());

                            DistricNameID.add(financialmodel.getData().get(i).getId());
                        }

                       ArrayAdapter<String> dataAdapter12 = new ArrayAdapter<String>(getApplicationContext(),R.layout.spinner_item, DistricName);


                        dataAdapter12.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


                        spinner_finacil.setAdapter(dataAdapter12);








                    } else {
                        Toast.makeText(getApplicationContext(), "Finacial is  not available", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }




            @Override
            public void onFailure(Call<Fincial> call, Throwable t) {

                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }


}