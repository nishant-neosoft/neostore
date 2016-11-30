package com.neosoft.neostore.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;
import com.neosoft.neostore.R;
import com.neosoft.neostore.serviceapi.GetServices;
import com.neosoft.neostore.serviceapi.Services;
import com.neosoft.neostore.validate.Validate;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, Services.ApiResponse {

    Button btnLogin, btnRegister;
    EditText editEmail, editPass;
    String email, pass;
    Validate valid = new Validate();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editEmail = (EditText) findViewById(R.id.edtEmail);
        editPass = (EditText) findViewById(R.id.edtPass);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnRegister = (Button) findViewById(R.id.btnRegister);

        btnLogin.setOnClickListener(this);
        btnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnLogin:
                if (valid.loginValidate(editEmail,editPass)) {
                    email = String.valueOf(editEmail.getText());
                    pass = String.valueOf(editPass.getText());

                    GetServices getServices = new GetServices();
                    getServices.login(email,pass);
                }
                break;

            case R.id.btnRegister:
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
        }
    }

    @Override
    public void onSuccess(String response) {
        Log.e(LoginActivity.class.getSimpleName(), "onSuccess response " + response);

        new Gson().toJson(response);
    }
}
