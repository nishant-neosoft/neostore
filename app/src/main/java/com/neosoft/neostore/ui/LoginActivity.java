package com.neosoft.neostore.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.neosoft.neostore.R;
import com.neosoft.neostore.model.login.LoginResponseModel;
import com.neosoft.neostore.serviceapi.ApiResponse;
import com.neosoft.neostore.serviceapi.GetServices;
import com.neosoft.neostore.validate.Validate;

public class LoginActivity extends Activity implements View.OnClickListener{
    Button btnLogin, btnRegister;
    EditText editEmail, editPass;
    String email, pass;
    Validate valid = new Validate();



    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        editEmail = (EditText) findViewById(R.id.edtEmail);
        editPass = (EditText) findViewById(R.id.edtPass);
        btnLogin = (Button) findViewById(R.id.btn_login);
        btnRegister = (Button) findViewById(R.id.btn_login_signup);

        btnLogin.setOnClickListener(this);
        btnRegister.setOnClickListener(this);

        setContentView(R.layout.activity_login);
        Button signup = (Button) findViewById(R.id.btn_login_signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterScreen.class);
                startActivity(intent);
            }
        });
        Button login = (Button) findViewById(R.id.btn_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {

                GetServices apiServices = new GetServices();
                apiServices.login("av@example.com", "abhijeet", new ApiResponse<LoginResponseModel>() {
                    @Override public void onSuccess(LoginResponseModel response) {
                        Log.e("zzz", response.toString());
                    }
                    @Override public void onError(String message) {
                        Log.e("zzz", message);
                    }
                });
            }
        });
    }

    @Override
    public void onClick(View view) {

    }
}
