package com.neosoft.neostore.Validate;

import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.regex.Pattern;

/**
 * Created by webwerks on 30/11/16.
 */

public class Validate {

    public static String ERROR_EMPTY_VALUE = "Please enter value";
    public static String ERROR_EMPTY_GENDER_VALUE = "Please select gender";
    public static String ERROR_EMPTY_EMAIL = "Please enter Email!";
    public static String ERROR_INVALID_EMAIL = "Please enter valid Email!";
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


    public boolean loginValidate(EditText editEmail, EditText editPass)
    {
        boolean isValid;

        if (isEmpty(editEmail)) {
            editEmail.setError(ERROR_EMPTY_EMAIL);
            return isValid = false;
        }
        if (!EMAIL_ADDRESS_PATTERN.matcher(editEmail.getText().toString()).matches()) {
            editEmail.setError(ERROR_INVALID_EMAIL);
            return isValid = false;
        } else {
            editEmail.setError(null);
            isValid = true;
        }

        if (isEmpty(editPass)) {
            editPass.setError(ERROR_EMPTY_PASSWORD);
            return isValid = false;
        } else {
            editPass.setError(null);
            isValid = true;
        }

        return isValid;
    }


    public boolean registerValidate(EditText editFname, EditText editLname, EditText editEmail, EditText editPass, EditText editCPass, RadioGroup radioGenderGrp, TextView txtGenErr, EditText editphoneNo)
    {
        boolean isValid= false;
        if( isEmpty( editFname ) )
        {
            editFname.setError(ERROR_EMPTY_VALUE); return isValid = false;
        }
        else
        {
            editFname.setError( null); isValid = true;
        }

        if( isEmpty( editLname ))
        {
            editLname.setError( ERROR_EMPTY_VALUE ); return isValid = false;
        }
        else
        {
            editLname.setError(null); isValid= true;
        }

        if (isEmpty(editEmail))
        {
            editEmail.setError( ERROR_EMPTY_VALUE ); return isValid = false;
        }
        if ( ! EMAIL_ADDRESS_PATTERN.matcher(editEmail.getText().toString()).matches())
        {
            editEmail.setError( ERROR_INVALID_EMAIL ); return isValid = false;
        }
        else
        {
            editEmail.setError( null ); isValid = true;
        }

        if (isEmpty(editPass))
        {
            editPass.setError( ERROR_EMPTY_PASSWORD ); return isValid = false;
        }
        else
        {
            editPass.setError( null ); isValid = true;
        }

        if ( isEmpty(editCPass))
        {
            editCPass.setError( ERROR_EMPTY_PASSWORD ); return isValid = false;
        }
        if (! editCPass.getText().toString().equals(editPass.getText().toString()))
        {
            editCPass.setError(ERROR_CONFIRM_PASSWORD); return isValid = false;
        }
        else
        {
            editCPass.setError( null ); isValid = true;
        }

        if (radioGenderGrp.getCheckedRadioButtonId() == -1)
        {
            txtGenErr.setError(ERROR_EMPTY_GENDER_VALUE); return isValid=false;
        }
        else
        {
            txtGenErr.setError(null);
            txtGenErr.setVisibility(View.INVISIBLE);
            isValid=true;
        }

        if ( isEmpty( editphoneNo ) )
        {
            editphoneNo.setError( ERROR_EMPTY_VALUE ); return isValid = false;
        }
        else
        {
            editphoneNo.setError( null ); isValid = true;
        }

        return isValid;
    }

    public boolean isEmpty(EditText editText) {
        return editText.getText().toString().trim().isEmpty();
    }
}
