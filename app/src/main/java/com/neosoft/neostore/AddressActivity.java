package com.neosoft.neostore;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by webwerks1 on 2/12/16.
 */

public class AddressActivity extends BaseActivityToolbar {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_list);
        ArrayList<AddressDetails> addressDetails = new ArrayList<>();
        ListView addressList = (ListView) findViewById(R.id.lv_addresslist);
        final AddressAdapter adapter = new AddressAdapter(this, addressDetails);
        addressList.setAdapter(adapter);
        setTitle("Address");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_address, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add_address: {
                startActivity(new Intent(AddressActivity.this, AddAddressActivity.class));
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
