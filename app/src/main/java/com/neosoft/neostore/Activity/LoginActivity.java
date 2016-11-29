package com.neosoft.neostore.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.neosoft.neostore.R;
import com.neosoft.neostore.ServiceAPI.Services;

import java.util.regex.Pattern;

import okhttp3.FormBody;
import okhttp3.RequestBody;

import static com.neosoft.neostore.ServiceAPI.UserAPI.LOGIN_URL;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener ,Services.ApiResponse{

    public static String ERROR_EMPTY_EMAIL    = "Please enter Email!";
    public static String ERROR_INVALID_EMAIL    = "Please enter valid Email!";
    public static String ERROR_EMPTY_PASSWORD = "Please enter Password";
    public static final Pattern EMAIL_ADDRESS_PATTERN = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+");

    Button btnLogin, btnRegister;
    EditText editEmail, editPass;
    String email, pass;
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
                if (validate()) {
                    email = String.valueOf(editEmail.getText());
                    pass = String.valueOf(editPass.getText());

                    RequestBody requestBody = new FormBody.Builder()
                            .add("email", email)
                            .add("password", pass)
                            .build();

                    Services ser = new Services(LOGIN_URL, requestBody,this);
                    ser.execute(requestBody);
                    Log.d("Response ---->>> ", "Service called");
                }
            break;

            case R.id.btnRegister:
                Intent intent = new Intent(getApplicationContext(),RegisterActivity.class);
                startActivity(intent);
        }
    }

    boolean validate()
    {
        boolean isValid;
        if ( isEmpty( editEmail ) ) {
            editEmail.setError( ERROR_EMPTY_EMAIL );
            return isValid = false;
        }
        if ( ! EMAIL_ADDRESS_PATTERN.matcher(editEmail.getText().toString()).matches())
        {
            editEmail.setError( ERROR_INVALID_EMAIL );
            return isValid = false;
        }
        else {
            editEmail.setError( null );
            isValid = true;
        }

        if ( isEmpty( editPass ) ) {
            editPass.setError( ERROR_EMPTY_PASSWORD );
            return isValid = false;
        }
        else {
            editPass.setError( null );
            isValid = true;
        }

        return isValid;
    }

    public boolean isEmpty( EditText editText ) {
        return editText.getText().toString().trim().isEmpty();
    }

    @Override
    public void onSuccess(String response) {
        Log.e(LoginActivity.class.getSimpleName(),"onSuccess response "+response);

    }
}
