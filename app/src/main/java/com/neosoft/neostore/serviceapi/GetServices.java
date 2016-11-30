package com.neosoft.neostore.serviceapi;

import android.util.Log;

import com.neosoft.neostore.activity.LoginActivity;

import okhttp3.FormBody;
import okhttp3.RequestBody;

import static com.neosoft.neostore.serviceapi.UserAPI.LOGIN_URL;
import static com.neosoft.neostore.serviceapi.UserAPI.REGISTER_URL;

public class GetServices implements Services.ApiResponse{

    public void login(String email, String pass)
    {
        RequestBody requestBody = new FormBody.Builder()
                .add("email",email)
                .add("password",pass)
                .build();
        Services ser = new Services(LOGIN_URL, requestBody, this);
        ser.execute(requestBody);
    }

    public void register(String fname, String lname, String email, String pass, String cpass, String gender, String ph_no)
    {
        RequestBody requestBody = new FormBody.Builder()
                .add("first_name",fname)
                .add("last_name",lname)
                .add("email",email)
                .add("password",pass)
                .add("confirm_password",cpass)
                .add("gender",gender)
                .add("phone_no",ph_no)
                .build();
        Services ser = new Services(REGISTER_URL, requestBody, this);
        ser.execute(requestBody);
    }

    @Override
    public void onSuccess(String response) {
        Log.e(LoginActivity.class.getSimpleName(), "onSuccess response " + response);
    }
}
