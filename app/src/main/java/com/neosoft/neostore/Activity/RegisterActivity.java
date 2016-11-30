package com.neosoft.neostore.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.neosoft.neostore.R;
import com.neosoft.neostore.ServiceAPI.GetServices;
import com.neosoft.neostore.ServiceAPI.Services;
import com.neosoft.neostore.Validate.Validate;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener,Services.ApiResponse{

    Button register;
    Toolbar toolbar;
    EditText editFname, editLname, editEmail, editPass, editConfirmPass, editPhone;
    String fname, lname, email, pass, cpass, phone, gender;
    RadioGroup rdGrpGender;
    RadioButton rdbtnGender;
    TextView txtGengerErr;
    Validate valid = new Validate();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editFname = (EditText) findViewById(R.id.etFirstname);
        editLname = (EditText) findViewById(R.id.etLastname);
        editEmail = (EditText) findViewById(R.id.etEmail);
        editPass = (EditText) findViewById(R.id.etPassword);
        editConfirmPass = (EditText) findViewById(R.id.etConfirmPassword);
        editPhone = (EditText) findViewById(R.id.etPhone);
        register = (Button) findViewById(R.id.btnRegister);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        rdGrpGender = (RadioGroup) findViewById(R.id.radioGender);
        txtGengerErr = (TextView) findViewById(R.id.txtGenderValidate);
        txtGengerErr.setVisibility(View.VISIBLE);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        register.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnRegister :

                if(valid.registerValidate(editFname,editLname,editEmail,editPass,editConfirmPass,rdGrpGender,txtGengerErr,editPhone)) {
                    int genderId = rdGrpGender.getCheckedRadioButtonId();
                    rdbtnGender = (RadioButton) findViewById(genderId);
                    fname = String.valueOf(editFname.getText());
                    lname = String.valueOf(editLname.getText());
                    email = String.valueOf(editEmail.getText());
                    pass = String.valueOf(editPass.getText());
                    cpass = String.valueOf(editConfirmPass.getText());
                    phone = String.valueOf(editPhone.getText());
                    if(rdbtnGender.getText().equals("Male"))
                        gender = "M";
                    else
                        gender = "F";

                    GetServices services = new GetServices();
                    services.register(fname,lname,email,pass,cpass,gender,phone);
                }
                break;
        }
    }

    @Override
    public void onSuccess(String response) {
        Log.e(RegisterActivity.class.getSimpleName(),"onSuccess response "+response);
    }
}
