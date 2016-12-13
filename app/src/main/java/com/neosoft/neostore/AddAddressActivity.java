package com.neosoft.neostore;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by webwerks1 on 5/12/16.
 */

public class AddAddressActivity extends BaseActivityToolbar implements View.OnClickListener {
    private EditText etAddAdress;
    private EditText etAddCity;
    private EditText etAddCountry;
    private EditText etAddLandmark;
    private EditText etAddState;
    private EditText etAddZipCode;
    private Button btnSaveAddress;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_address);
        initViews();
        btnSaveAddress.setOnClickListener(this);
    }

    private void initViews() {
        etAddAdress = (EditText) findViewById(R.id.et_address_add);
        etAddCity =(EditText) findViewById(R.id.et_city);
        etAddCountry=(EditText) findViewById(R.id.et_country);
        etAddLandmark=(EditText) findViewById(R.id.et_landmark);
        etAddState=(EditText) findViewById(R.id.et_state);
        etAddZipCode=(EditText) findViewById(R.id.et_zipcode);
        btnSaveAddress = (Button)findViewById(R.id.btn_save_address);
        setTitle("Add Address");
    }

    @Override
    public void onClick(View v) {

    }
}
