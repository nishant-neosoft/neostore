package com.neosoft.neostore.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.neosoft.neostore.R;
import com.neosoft.neostore.model.register.RegisterResponseModel;
import com.neosoft.neostore.serviceapi.ApiResponse;
import com.neosoft.neostore.serviceapi.GetServices;

public class RegisterScreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        final Button register = (Button) findViewById(R.id.btnRegister);

        final EditText editFname = (EditText) findViewById(R.id.etFirstname);
        final EditText editLname = (EditText) findViewById(R.id.etLastname);
        final EditText editPassword = (EditText) findViewById(R.id.etPassword);
        final EditText editconfirmPassword = (EditText) findViewById(R.id.etConfirmPassword);
        final EditText editEmail = (EditText) findViewById(R.id.etEmail);
        final EditText editPhone = (EditText) findViewById(R.id.etPhone);
        final RadioGroup radio = (RadioGroup) findViewById(R.id.radioGender);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedRadioButtonID = radio.getCheckedRadioButtonId();
                if (selectedRadioButtonID != -1) {
                    String gender = ((RadioButton) findViewById(selectedRadioButtonID)).getText().toString();
                    gender = gender.substring(0, 1);
                    GetServices apiServices = new GetServices();
                    apiServices.register(editFname.getText().toString().trim(),
                            editLname.getText().toString().trim(),
                            editEmail.getText().toString().trim(),
                            editPassword.getText().toString().trim(),
                            editconfirmPassword.getText().toString(),
                            gender,
                            editPhone.getText().toString(),
                            new ApiResponse<RegisterResponseModel>() {
                                @Override
                                public void onSuccess(RegisterResponseModel response) {
                                }
                                @Override
                                public void onError(String message) {
                                }
                            });
                }
                finish();
            }
        });
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
