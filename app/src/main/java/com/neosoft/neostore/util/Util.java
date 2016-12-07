package com.neosoft.neostore.util;

import android.content.Context;
import android.content.SharedPreferences;

public class Util {
    private static final String MyPREFERENCES = "MyPrefs";
    private static final String STATUS = "status";
    private static SharedPreferences sharedpreferences;

    public static boolean isLoggedIn(Context context) {
        sharedpreferences = context.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
            return (sharedpreferences.getBoolean(STATUS,false));
    }
    public static void saveLoginStatus() {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putBoolean(STATUS,true);
        editor.commit();
    }
}