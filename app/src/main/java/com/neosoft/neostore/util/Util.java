package com.neosoft.neostore.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.neosoft.neostore.model.login.LoginResponseModel;

public class Util {
    private static final String MyPREFERENCES = "MyPrefs";
    private static final String STATUS = "status";
    private static final String ACCESS_TOKEN = "access_token";
    private static SharedPreferences sharedpreferences;

    public static boolean isLoggedIn(Context context) {
        sharedpreferences = context.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
            return (sharedpreferences.getBoolean(STATUS,false));
    }
    public static void saveLoginStatus(LoginResponseModel response) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(ACCESS_TOKEN,""+response.getData().getAccessToken().toString());
        editor.putBoolean(STATUS,true);
        Log.e("Response--->>>","next line");
        editor.commit();
    }
}