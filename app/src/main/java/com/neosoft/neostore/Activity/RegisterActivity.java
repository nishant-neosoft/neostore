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

import com.neosoft.neostore.R;
import com.neosoft.neostore.ServiceAPI.Services;

import java.util.regex.Pattern;

import okhttp3.FormBody;
import okhttp3.RequestBody;

import static com.neosoft.neostore.ServiceAPI.UserAPI.REGISTER_URL;

/**
 * Created by webwerks on 28/11/16.
 */

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener,Services.ApiResponse{
    public static String ERROR_EMPTY_VALUE    = "Please enter value";
    public static String ERROR_INVALID_EMAIL    = "Please enter valid Email!";
    public static String ERROR_EMPTY_PASSWORD = "Please enter Password";
    public static String ERROR_CONFIRM_PASSWORD = "Please enter correct password";
    public static final Pattern EMAIL_ADDRESS_PATTERN = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+");

    Button register;
    Toolbar toolbar;
    EditText editFname, editLname, editEmail, editPass, editConfirmPass, editPhone;
    String fname, lname, email, pass, cpass, phone, gender;
    RadioGroup rdGrpGender;
    RadioButton rdbtnGender;

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
                if(validate()) {
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

                    RequestBody requestBody = new FormBody.Builder()
                            .add("first_name", fname)
                            .add("last_name", lname)
                            .add("email", email)
                            .add("password", pass)
                            .add("confirm_password", cpass)
                            .add("gender", gender)
                            .add("phone_no", phone)
                            .build();

                    Services ser = new Services(REGISTER_URL, requestBody,this);
                    ser.execute(requestBody);
                    Log.d("Response ---->>> ", "Service called");
                }
                break;
        }
    }

    boolean validate()
    {
        boolean isValid= false;

        if( isEmpty( editFname ) )
        {editFname.setError(ERROR_EMPTY_VALUE); return isValid = false;}
        else
        {  editFname.setError( null); isValid = true; }

        if( isEmpty( editLname ))
        { editLname.setError( ERROR_EMPTY_VALUE ); return isValid = false;}
        else
        {editLname.setError(null); isValid= true;}

        if (isEmpty(editEmail))
        {editEmail.setError( ERROR_EMPTY_VALUE ); return isValid = false;}
        if ( ! EMAIL_ADDRESS_PATTERN.matcher(editEmail.getText().toString()).matches())
        {editEmail.setError( ERROR_INVALID_EMAIL ); return isValid = false;}
        else
        {editEmail.setError( null ); isValid = true;}

        if (isEmpty(editPass))
        {editPass.setError( ERROR_EMPTY_PASSWORD ); return isValid = false;}
        else
        {editPass.setError( null ); isValid = true;}

        if ( isEmpty(editConfirmPass))
        {editConfirmPass.setError( ERROR_EMPTY_PASSWORD ); return isValid = false;}
        if (! editConfirmPass.getText().toString().equals(editPass.getText().toString()))
        { editConfirmPass.setError(ERROR_CONFIRM_PASSWORD); return isValid = false;}
        else
        {editConfirmPass.setError( null ); isValid = true;}

        if ( isEmpty( editPhone ) )
        {editPhone.setError( ERROR_EMPTY_VALUE ); return isValid = false;}
        else
        {editPhone.setError( null ); isValid = true;}

        return isValid;
    }

    public boolean isEmpty( EditText editText ) {
        return editText.getText().toString().trim().isEmpty();
    }

    @Override
    public void onSuccess(String response) {
        Log.e(RegisterActivity.class.getSimpleName(),"onSuccess response "+response);
    }
}
