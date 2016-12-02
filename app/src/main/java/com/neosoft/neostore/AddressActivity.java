package com.neosoft.neostore;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by webwerks1 on 2/12/16.
 */

public class AddressActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_list);
        ArrayList<AddressDetails> addressDetails = new ArrayList<>();
        addressDetails.add(new AddressDetails("name1","ggfghjkkklhjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjhjhsdjvadalsdas"));
        addressDetails.add(new AddressDetails("name2","ahdfuysagkjfhlisadfvb.skjdfnvaksdfuAHDFLSADBFSDNFSJDBHKADSFsdf"));
        ListView addressList = (ListView) findViewById(R.id.lv_addresslist);
        AddressAdapter adapter = new AddressAdapter(this,addressDetails);
        addressList.setAdapter(adapter);
    }
}
