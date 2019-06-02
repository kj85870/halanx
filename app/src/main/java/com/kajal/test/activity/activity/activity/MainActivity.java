package com.kajal.test.activity.activity.activity;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.kajal.test.R;
import com.kajal.test.activity.activity.model.CommonMethod;
import com.kajal.test.activity.activity.model.Login;
import com.kajal.test.activity.activity.rest.ApiClient;
import com.kajal.test.activity.activity.rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    String username,password;
    TextView msg;
    Button btnLogin;
    EditText editTextUsername, editTextPassword;
    ApiInterface apiInterface;
    private Dialog mDailog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassowrd);
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        msg = findViewById(R.id.textViewMsg);
        btnLogin = findViewById(R.id.buttonSignIn);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if (checkValidation()){
                   if (CommonMethod.isNetworkAvailable(MainActivity.this)){
                       loginRetrofit2Api(username,password);
                   }
                   else {
                       CommonMethod.showAlert("Internet Connectity Failure",MainActivity.this);
                   }
               }
            }
        });
    }

    private void loginRetrofit2Api(String username,String password) {
        final Login login = new Login(username,password);
        Call<Login> call = apiInterface.createUser(login);

        call.enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call,Response<Login> response) {
                if (response.isSuccessful()){
                    startActivity(new Intent(getApplicationContext(),Home.class));
                }else {
                    CommonMethod.showAlert("Please Enter correct Credential ",MainActivity.this);
                }
            }

            @Override
            public void onFailure(Call<Login> call,Throwable t) {
                Toast.makeText(getApplicationContext(),"OnFailure called", Toast.LENGTH_SHORT).show();
                call.cancel();
            }
        });
    }

    private boolean checkValidation() {
         username = editTextUsername.getText().toString();
         password = editTextPassword.getText().toString();

        Log.e("Keshav","userId is ->"+username);
        Log.e("keshav","password ->"+password);

        if (editTextUsername.getText().toString().trim().equals("")){
            CommonMethod.showAlert("User Id Cannot be left blank", MainActivity.this);
            return false;
        }else if (editTextPassword.getText().toString().trim().equals("")){
            CommonMethod.showAlert("Password Cannot be Left Blank",MainActivity.this);
            return false;
        }
        return true;
    }
}
