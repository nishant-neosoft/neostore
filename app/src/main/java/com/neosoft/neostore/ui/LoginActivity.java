package com.neosoft.neostore.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.neosoft.neostore.R;
import com.neosoft.neostore.model.login.LoginResponseModel;
import com.neosoft.neostore.serviceapi.ApiResponse;
import com.neosoft.neostore.serviceapi.ErrorHandler;
import com.neosoft.neostore.serviceapi.GetServices;
import com.neosoft.neostore.validate.Validate;


public class LoginActivity extends Activity {
    public static final String MyPREFERENCES = "MyPrefs";
    public static final String STATUS = "status";
    public static final String STATUS_IN = "in";
    SharedPreferences sharedpreferences;
    EditText editEmail,editPass;
    Validate valid = new Validate();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        String status = sharedpreferences.getString(STATUS, null);
        if (status != null) {
            if (status.equals(STATUS_IN)) {
                startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                finish();
            }
        }
        setContentView(R.layout.activity_login);
        Button signup = (Button) findViewById(R.id.btn_login_signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MyCartFragment.class);
                startActivity(intent);
            }
        });
        Button login = (Button) findViewById(R.id.btn_login);
        editEmail = (EditText) findViewById(R.id.edtEmail);
        editPass = (EditText) findViewById(R.id.edtPass);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if(valid.loginValidate(editEmail,editPass)) {
                GetServices apiServices = new GetServices();
                apiServices.login(editEmail.getText().toString(), editPass.getText().toString(), new ApiResponse<LoginResponseModel>() {
                    @Override
                    public void onSuccess(LoginResponseModel response) {
                        Toast.makeText(getApplicationContext(), response.getMessage().toString(), Toast.LENGTH_LONG).show();
                        Log.e("zzz", response.toString());
                        SharedPreferences.Editor editor = sharedpreferences.edit();
                        editor.putString(STATUS, STATUS_IN);
                        editor.commit();
                        startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                    }
                }, new ErrorHandler());
            }
            }
        });
    }
}
