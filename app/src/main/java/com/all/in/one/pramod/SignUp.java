package com.all.in.one.pramod;

import android.app.ProgressDialog;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.all.in.one.pramod.app.RetrofitClient;
import com.all.in.one.pramod.models.DefaultResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUp extends AppCompatActivity {
    private ProgressDialog progressDialog;
    private TextInputLayout country_code;
    private TextInputLayout user_id;
    private TextInputLayout  pin_id;
    private TextInputLayout  confirm_pin;
    private TextInputLayout  password_id;

    private Button btn_sigup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getSupportActionBar().setTitle("SignUp");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        country_code = findViewById(R.id.companycode);
        user_id = findViewById(R.id.userid);
        pin_id = findViewById(R.id.pin);
        confirm_pin = findViewById(R.id.rePin);
        password_id = findViewById(R.id.password);





        btn_sigup = findViewById(R.id. btnsigup);

        btn_sigup.setOnClickListener(new View.OnClickListener() {




            @Override
            public void onClick(View v) {
              //  register();
            }
        });



















    }



    public void register(){



        String companyCode = country_code.getEditText().getText().toString();
        String user = user_id.getEditText().getText().toString();
        String pin = pin_id.getEditText().getText().toString();
       // String repin = confirm_pin.getEditText().getText().toString();

       // String pass = password_id.getEditText().getText().toString();


        Log.d(user,"user_id");
        Log.d(companyCode,"companyCode");
        Log.d(pin,"pin");

       // Log.d(repin,"confirm_pin");
        //Log.d(pass,"pass");



        if (companyCode.length() <4) {
            country_code.setError("Company Code  is required ");
            country_code.requestFocus();
            return;
        }

       /* if (user.length() < 10)  {
            user_id.setError("Enter valid UserID");
            user_id.requestFocus();
            return;
        }*/



       /* if (password.length() < 8) {
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
        Log.d(user,"user_id");
        Log.d(companyCode,"companyCode");



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

    public boolean onOptionsItemSelected(MenuItem menuItem)
    {    int id = menuItem.getItemId();

        if(id== android.R.id.home)
        {
            this.finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
