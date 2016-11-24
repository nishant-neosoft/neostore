package com.neosoft.neostore;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnLogin;
    TextView txtV;
    EditText editEmail,editPass;
    String email,pass;


    public static final String URL_LOGIN = "http://staging.php-dev.in:8844/trainingapp/api/users/login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editEmail = (EditText) findViewById(R.id.edtEmail);
        editPass = (EditText) findViewById(R.id.edtPass);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        new Login().execute();


    }

    public class Login extends AsyncTask<String , Void, String>
    {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            email = editEmail.getText().toString();
            pass = editPass.getText().toString();
        }

        @Override
        protected String doInBackground(String... strings) {
            try {
            OkHttpClient client = new OkHttpClient();

            RequestBody requestBody = new FormBody.Builder()
                    .add("email",email)
                    .add("password",pass)
                    .build();

            Request request = new Request.Builder()
                    .url(URL_LOGIN)
                    .post(requestBody)
                    .build();


                Response response = client.newCall(request).execute();
                String res = response.body().string();

                return res;

            } catch (IOException e) {
                e.printStackTrace();

            }

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.d("Response---->>>",s.toString());


        }
    }
}
