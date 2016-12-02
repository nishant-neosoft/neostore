package com.neosoft.neostore.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.neosoft.neostore.ui.LoginActivity;

/**
 * Created by webwerks1 on 1/12/16.
 */

public class Util {
    private static final String MyPREFERENCES = "MyPrefs";
    private static final String STATUS = "status";
    private static final String STATUS_IN = "in";
    private static SharedPreferences sharedpreferences;

    public static boolean isLoggedIn(LoginActivity loginActivity) {
        sharedpreferences = loginActivity.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        String status = sharedpreferences.getString(STATUS, null);
        if (status != null) {
            if (status.equals(STATUS_IN)) {
                return true;
            }
        }
        return false;
    }

    public static void login() {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(STATUS, STATUS_IN);
        editor.commit();
    }
}
