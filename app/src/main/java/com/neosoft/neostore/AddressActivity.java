package com.neosoft.neostore;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by webwerks1 on 2/12/16.
 */

public class AddressActivity extends AppCompatActivity {
    Toolbar toolbar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_list);
        ArrayList<AddressDetails> addressDetails = new ArrayList<>();
       /* toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);*/
        addressDetails.add(new AddressDetails("name1","ggfghjkkklhjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjhjhsdjvadalsdas"));
        addressDetails.add(new AddressDetails("name2","ahdfuysagkjfhlisadfvb.skjdfnvaksdfuAHDFLSADBFSDNFSJDBHKADSFsdf"));
        ListView addressList = (ListView) findViewById(R.id.lv_addresslist);
        final AddressAdapter adapter = new AddressAdapter(this,addressDetails);
        addressList.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu options from the res/menu/menu_editor.xml file.
        // This adds menu items to the app bar.
        getMenuInflater().inflate(R.menu.menu_address, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:{
                NavUtils.navigateUpFromSameTask(this);
            }
                return true;
            }
        return super.onOptionsItemSelected(item);
    }
}
