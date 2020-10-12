package com.all.in.one.pramod;

import android.app.ProgressDialog;
import android.os.Build;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Patterns;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;

import android.widget.Spinner;
import android.widget.Toast;

import com.all.in.one.pramod.app.RetrofitClient;


import com.all.in.one.pramod.models.signUpModel.DefaultResponse;
import com.all.in.one.pramod.models.signUpModel.RegisterModel;
import com.all.in.one.pramod.models.stateModel.StateData;
import com.all.in.one.pramod.models.stateModel.StateModel;
import com.all.in.one.pramod.models.stateModel.States;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUp extends AppCompatActivity {

    private ProgressDialog progressDialog;
    private TextInputEditText country_code;
    private TextInputLayout user_id;
    private TextInputLayout Name_singup;
    private TextInputLayout mobile_signup;
    private Spinner spinnerState;
    private Spinner spinnerCity;
    private TextInputLayout name_persion;
    private TextInputLayout address_signup;
    private TextInputLayout landmark_signup;
    private TextInputLayout gstno_signup;
    private TextInputLayout pin_id;
    private TextInputLayout email_id;
    private TextInputLayout confirm_pin;
    private TextInputLayout password_id;
    private States states;

    ArrayList<String> stateNames = new ArrayList<>();
    ArrayList<String> stateId = new ArrayList<>();

    ArrayList<String> CitisNames = new ArrayList<>();

    String RegionId = "";
    private Button btn_sigup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getSupportActionBar().setTitle("SignUp");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        progressDialog = new ProgressDialog(this);

        country_code = findViewById(R.id.companycode);
        spinnerState = findViewById(R.id.state);
        spinnerState.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


               int  getid = parent.getSelectedItemPosition();

               String s = String.valueOf(getid);



                Toast.makeText(SignUp.this, s, Toast.LENGTH_SHORT).show();






            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        country_code.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                System.out.println(charSequence);


            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }

            @Override
            public void afterTextChanged(Editable editable) {

                String s = editable.toString();
                States states = new States(s);
                state();

            }
        });


        ArrayList<String> stateNames = new ArrayList<>();
        stateNames.add("Select State");
        ArrayAdapter<String> dataAdapter12 = new ArrayAdapter<String>(getApplicationContext(), R.layout.spinner_item, stateNames);
        dataAdapter12.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerState.setAdapter(dataAdapter12);


        /***********************city*************************************************************/

        spinnerCity = findViewById(R.id.city);
        spinnerCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {



            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayList<String> stateCitis = new ArrayList<>();
        CitisNames.add("Select City");
        ArrayAdapter<String> datacity = new ArrayAdapter<String>(getApplicationContext(), R.layout.spinner_item, CitisNames);
        dataAdapter12.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCity.setAdapter(datacity);


        City();


        email_id = findViewById(R.id.emailid);
        name_persion = findViewById(R.id.name);
        mobile_signup = findViewById(R.id.mobile);


        pin_id = findViewById(R.id.pinCode);
        landmark_signup = findViewById(R.id.landmarkSignup);

        address_signup = findViewById(R.id.addressSignup);

        gstno_signup = findViewById(R.id.gstNumber);

        password_id = findViewById(R.id.password);


        btn_sigup = findViewById(R.id.btnsigup);

        btn_sigup.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                register();
            }
        });


    }


    public void register() {


        String device_id = Build.DEVICE;
        String device_Model = Build.MODEL;
        String companyCode = country_code.getText().toString();
        String email = email_id.getEditText().getText().toString();
        String name = name_persion.getEditText().getText().toString();
        String mobile = mobile_signup.getEditText().getText().toString();
        String States = spinnerState.getSelectedItem().toString().trim();

        String city = spinnerCity.getSelectedItem().toString().trim();
        String pin = pin_id.getEditText().getText().toString();
        String landmark = landmark_signup.getEditText().getText().toString();
        String address = address_signup.getEditText().getText().toString();
        String gst = gstno_signup.getEditText().getText().toString();

        String pass = password_id.getEditText().getText().toString();




        if (companyCode.isEmpty()) {
            Toast.makeText(SignUp.this, "Company Code Required", Toast.LENGTH_SHORT).show();

            return;
        }

        if (email.isEmpty()) {
            Toast.makeText(SignUp.this, "Email is Empaty", Toast.LENGTH_SHORT).show();
            return;
        }


        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(SignUp.this, "Email Id is invalid", Toast.LENGTH_SHORT).show();
            return;
        }


        if (mobile.isEmpty()) {
            Toast.makeText(SignUp.this, "Mobile  number is Required", Toast.LENGTH_SHORT).show();
            return;
        }

        if (spinnerState.getSelectedItem().toString().trim().equalsIgnoreCase("Select State")) {
            Toast.makeText(this, "Select  State", Toast.LENGTH_SHORT).show();

            return;

        }











        if (pin.isEmpty()) {
            Toast.makeText(SignUp.this, "Pin Code  number is Required", Toast.LENGTH_SHORT).show();
            return;
        }


        if (address.isEmpty()) {
            Toast.makeText(SignUp.this, "Address Code Required", Toast.LENGTH_SHORT).show();
            return;
        }

        if (gst.isEmpty()) {
            Toast.makeText(SignUp.this, "GST Number is  Required", Toast.LENGTH_SHORT).show();
            return;
        }
        if (pass.isEmpty()) {
            Toast.makeText(SignUp.this, "Password is Required", Toast.LENGTH_SHORT).show();
            return;
        }


        progressDialog.setMessage("Registering user...");
        progressDialog.show();

        RegisterModel registerModel = new RegisterModel(companyCode, email, name, mobile, pin, landmark, address, gst, device_id, device_Model, States,city);


        Call<DefaultResponse> call = RetrofitClient.getInstance().getApi().userCreate(registerModel);


        call.enqueue(new Callback<DefaultResponse>() {
            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                progressDialog.dismiss();

                //Toast.makeText(getApplicationContext(), response.body().getMsg(), Toast.LENGTH_LONG).show();


            }

            @Override
            public void onFailure(Call<DefaultResponse> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });


    }


    public void state() {
        String companyCode = country_code.getText().toString();
        States states = new States(companyCode);

        Call<StateModel> call = RetrofitClient.getInstance().getApi().userState(states);


        call.enqueue(new Callback<StateModel>() {
            @Override
            public void onResponse(Call<StateModel> call, Response<StateModel> response) {

                try {


                    StateModel stateModel = response.body();
                    System.out.println(stateModel);

                    Gson gson = new GsonBuilder().setPrettyPrinting().create();
                    Log.e("States:", gson.toJson(stateModel));
                    stateNames.clear();
                    stateId.clear();
                     stateId.add("125");
                    stateNames.add("Select State");

                    if (stateModel.getStatus() == 1) {
                        for (int i = 0; i < stateModel.getData().size(); i++) {

                            stateNames.add(stateModel.getData().get(i).getState_name());

                            stateId.add(stateModel.getData().get(i).getId());
                        }

                        ArrayAdapter<String> dataAdapter12 = new ArrayAdapter<String>(getApplicationContext(), R.layout.spinner_item, stateNames);
                        dataAdapter12.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinnerState.setAdapter(dataAdapter12);


                    } else {
                        //Toast.makeText(getApplicationContext(), "States is  not available", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


            @Override
            public void onFailure(Call<StateModel> call, Throwable t) {

                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }


    public void City() {


        String companyCode = country_code.getText().toString();
        States states = new States(companyCode);


        Call<StateModel> call = RetrofitClient.getInstance().getApi().userCity(states);


        call.enqueue(new Callback<StateModel>() {
            @Override
            public void onResponse(Call<StateModel> call, Response<StateModel> response) {

                try {


                    StateModel stateModel = response.body();
                    System.out.println(stateModel);

                    Gson gson = new GsonBuilder().setPrettyPrinting().create();
                    Log.e("States:", gson.toJson(stateModel));
                    CitisNames.clear();


                    CitisNames.add("Select City");

                    if (stateModel.getStatus() == 1) {
                        for (int i = 0; i < stateModel.getData().size(); i++) {

                            CitisNames.add(stateModel.getData().get(i).getId());

                            // DistricNameID.add(financialmodel.getData().get(i).getId());
                        }

                        ArrayAdapter<String> dataAdapter12 = new ArrayAdapter<String>(getApplicationContext(), R.layout.spinner_item, CitisNames);
                        dataAdapter12.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinnerState.setAdapter(dataAdapter12);


                    } else {
                        Toast.makeText(getApplicationContext(), "Cities is  not available", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


            @Override
            public void onFailure(Call<StateModel> call, Throwable t) {

                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                finish();
            }
        });

    }


    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int id = menuItem.getItemId();

        if (id == android.R.id.home) {
            this.finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
