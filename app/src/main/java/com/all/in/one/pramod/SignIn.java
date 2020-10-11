package com.all.in.one.pramod;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.all.in.one.pramod.app.RetrofitClient;
import com.all.in.one.pramod.models.SharedPrefManager;
import com.all.in.one.pramod.models.finacal.Financial;
import com.all.in.one.pramod.models.finacal.Fincial;
import com.all.in.one.pramod.models.signInModel.Branch;
import com.all.in.one.pramod.models.signInModel.Data;
import com.all.in.one.pramod.models.signInModel.UserSignModel;
import com.all.in.one.pramod.models.signInModel.Users;
import com.all.in.one.pramod.navigation.ProfileActivity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;

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
    private TextInputLayout pin_id;
    private TextInputLayout confirm_pin;
    private TextInputLayout password_id;
    private Financial financial;
    private Spinner spinner_finacil;
    ArrayList<String> FinancialYears = new ArrayList<>();
    ArrayList<String> DistricNameID = new ArrayList<>();
    private Handler adapter;


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
            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                spinner_finacil.setVisibility((s.length() > 1) ? View.VISIBLE : View.GONE);
            }
        });

/*

        country_code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String companyCode = country_code.getText().toString();
                Financial financial = new Financial(companyCode);
                Log.d(companyCode, "company");

                financial();

            }
        });
*/



        /*country_code.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    String companyCode = country_code.getText().toString();
                    Financial financial = new Financial(companyCode);
                    financial();
                    return true;
                }
                return false;
            }
        });

*/
        ArrayList<String> FinancialYears = new ArrayList<>();
        FinancialYears.add("Select Finanacial Year");
        ArrayAdapter<String> dataAdapter12 = new ArrayAdapter<String>(getApplicationContext(), R.layout.spinner_item, FinancialYears);


        dataAdapter12.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        spinner_finacil.setAdapter(dataAdapter12);


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

                Financial financial = new Financial(s);
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
                Intent intent = new Intent(SignIn.this, SignUp.class);
                startActivity(intent);
            }
        });


    }


    public void login() {


        String companyCode = country_code.getText().toString();
        final String userID = user_id.getText().toString();
           String  f = spinner_finacil.getSelectedItem().toString().trim();
         Log.d(f,"noida");
        String pin = pin_id.getEditText().getText().toString();
        final String repin = confirm_pin.getEditText().getText().toString();
        String password = password_id.getEditText().getText().toString();



       if (spinner_finacil.getSelectedItem().toString().trim().equalsIgnoreCase("Select Finanacial Year")) {
            Toast.makeText(this, "Select Finanacial Year", Toast.LENGTH_SHORT).show();

            return;

        }



        if (companyCode.isEmpty()) {
            Toast.makeText(SignIn.this, "Company Code Required", Toast.LENGTH_SHORT).show();

            return;
        }

        if (userID.isEmpty()) {
            Toast.makeText(SignIn.this, "UserId is Required", Toast.LENGTH_SHORT).show();

            return;
        }

        if (password.isEmpty()) {
            Toast.makeText(SignIn.this, "Password is Required", Toast.LENGTH_SHORT).show();

            return;
        }


        if (pin.isEmpty()) {
            Toast.makeText(SignIn.this, "Pin is Required", Toast.LENGTH_SHORT).show();
            return;
        } else if (!pin.equals(repin) || repin.length() < 4) {
            Toast.makeText(SignIn.this, "Pin is Not matching", Toast.LENGTH_SHORT).show();
            return;


        }


        Users users = new Users(companyCode, userID, password);


        progressDialog.show();


        Call<UserSignModel> call = RetrofitClient.getInstance().getApi().userLogin(users);


        call.enqueue(new Callback<UserSignModel>() {
            @Override
            public void onResponse(Call<UserSignModel> call, Response<UserSignModel> response) {

                progressDialog.dismiss();

                UserSignModel userSignModel = response.body();
                if (userSignModel.getStatus() == 1) {

                    Intent intent = new Intent(SignIn.this, ProfileActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    //  Context mCtx = null;
                    // mCtx.startActivity(new Intent(mCtx, SignIn.class));

                    startActivity(intent);


                } else {
                    Toast.makeText(SignIn.this, userSignModel.getMessage(), Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onFailure(Call<UserSignModel> call, Throwable t) {

                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();


            }
        });

    }


    public void financial() {
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
                    FinancialYears.clear();
                    DistricNameID.clear();
                    FinancialYears.add("Select Finanacial Year");

                    DistricNameID.add("125");
                    if (financialmodel.getStatus() == 1) {
                        for (int i = 0; i < financialmodel.getData().size(); i++) {

                            FinancialYears.add(financialmodel.getData().get(i).getFinancial_Year());

                            DistricNameID.add(financialmodel.getData().get(i).getId());
                        }

                        ArrayAdapter<String> dataAdapter12 = new ArrayAdapter<String>(getApplicationContext(), R.layout.spinner_item, FinancialYears);


                        dataAdapter12.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


                        spinner_finacil.setAdapter(dataAdapter12);


                    } else {
                        //Toast.makeText(getApplicationContext(), financialmodel.getMessage(), Toast.LENGTH_SHORT).show();

                       // Toast.makeText(getApplicationContext(), "Enter Right CODE", Toast.LENGTH_SHORT).show();
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