package com.all.in.one.pramod;

import android.app.ProgressDialog;
import android.os.Build;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;

import android.widget.Spinner;
import android.widget.Toast;

import com.all.in.one.pramod.app.RetrofitClient;




import com.all.in.one.pramod.models.stateModel.StateModel;
import com.all.in.one.pramod.models.stateModel.States;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.os.Build.DEVICE;

public class SignUp extends AppCompatActivity {
    private ProgressDialog progressDialog;
    private TextInputEditText country_code;
    private TextInputLayout user_id;
    private TextInputLayout Name_singup;
    private TextInputLayout mobile_signup;
    private Spinner spinnerState;
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


    private Button btn_sigup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getSupportActionBar().setTitle("SignUp");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        country_code = findViewById(R.id.companycode);
        spinnerState = findViewById(R.id.state);
         spinnerState.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

             }

             @Override
             public void onNothingSelected(AdapterView<?> adapterView) {

             }
         });

        country_code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String companyCode = country_code.getText().toString();
                States states = new States(companyCode);
                Log.d(companyCode, "company");

                state();
            }
        });


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
        String pin = pin_id.getEditText().getText().toString();
        String landmark = landmark_signup.getEditText().getText().toString();
        String address = address_signup.getEditText().getText().toString();
        String gst = gstno_signup.getEditText().getText().toString();

        String pass = password_id.getEditText().getText().toString();


        Log.d(companyCode, "companyCode");
        Log.d(device_id, "device");
        Log.d(device_Model, "device_Model");


        Log.d(email, "email");
        Log.d(name, "name");
        Log.d(mobile, "mobile");
        Log.d(pin, "pin");
        Log.d(landmark, "landmark");
        Log.d(address, "adres");
        Log.d(gst, "gst");


        if (companyCode.length() < 4) {
            country_code.setError("Company Code  is required ");
            country_code.requestFocus();
            return;
        }


        if (companyCode.length() < 4) {
            country_code.setError("Company Code  is required ");
            country_code.requestFocus();
            return;
        }



       /* if (user.length() < 10)  {
            user_id.setError("Enter valid UserID");
            user_id.requestFocus();
            return;
        }*/



        /*if (password.length() < 8) {
            editPass.setError("Password required");
            editPass.requestFocus();
            return;
        }

        if (! confirm_pin.equals(password)  )   {
            editconfirm_pass.setError("Confirm is Not match");
            editconfirm_pass.requestFocus();
            return;

        }*/
    /* if (pass.length() < 8) {
         password_id.setError("Password required");
         password_id.requestFocus();
            return;
        }

*/
        //Log.d(user,"user_id");
        Log.d(companyCode, "companyCode");



       /* progressDialog.setMessage("Registering user...");
        progressDialog.show();

        Call<DefaultResponse> call = RetrofitClient.getInstance().getApi().createUser( );


        call.enqueue(new Callback<DefaultResponse>() {
            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response)
            {
                progressDialog.dismiss();

                Toast.makeText(getApplicationContext(), response.body().getMsg(), Toast.LENGTH_LONG).show();


            }

            @Override
            public void onFailure(Call<DefaultResponse> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });


*/
    }


    public void state() {
        String companyCode = country_code.getText().toString();
        States states = new States(companyCode);

        Call<StateModel> call = RetrofitClient.getInstance().getApi().userfinacial(states);


        call.enqueue(new Callback<StateModel>() {
            @Override
            public void onResponse(Call<StateModel> call, Response<StateModel> response) {

                try {


                    StateModel stateModel = response.body();
                    System.out.println(stateModel);

                    Gson gson = new GsonBuilder().setPrettyPrinting().create();
                    Log.e("States:", gson.toJson(stateModel));
                    stateNames.clear();


                    stateNames.add("Select State");

                    if (stateModel.getStatus() == 1) {
                        for (int i = 0; i < stateModel.getData().size(); i++) {

                            stateNames.add(stateModel.getData().get(i).getState_name());

                            // DistricNameID.add(financialmodel.getData().get(i).getId());
                        }

                        ArrayAdapter<String> dataAdapter12 = new ArrayAdapter<String>(getApplicationContext(), R.layout.spinner_item, stateNames);


                        dataAdapter12.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


                        spinnerState.setAdapter(dataAdapter12);


                    } else {
                        Toast.makeText(getApplicationContext(), "States is  not available", Toast.LENGTH_SHORT).show();
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
