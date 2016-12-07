package com.neosoft.neostore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by webwerks1 on 2/12/16.
 */

public class AddressAdapter extends BaseAdapter {
    private LayoutInflater layoutInflater;
    private RadioButton selected = null;
    private ArrayList<AddressDetails> addressdetails;

    public AddressAdapter(Context context, ArrayList<AddressDetails> addressdetails) {
        this.addressdetails = addressdetails;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return addressdetails.size();
    }

    @Override
    public Object getItem(int position) {
        return addressdetails.get(position);
    }

    @Override
    public long getItemId(int position) { return position; }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View row = layoutInflater.inflate(R.layout.address_listview_item, parent, false);
        final RadioButton addressSelected = (RadioButton) row.findViewById(R.id.rb_address_selected);
        TextView delete = (TextView) row.findViewById(R.id.btn_delete_address);
        TextView name = (TextView) row.findViewById(R.id.tv_name);
        TextView address = (TextView) row.findViewById(R.id.tv_address);
        name.setText(addressdetails.get(position).getName());
        address.setText(addressdetails.get(position).getAddress());
        addressSelected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selected != null) {
                    selected.setChecked(false);
                }
                addressSelected.setChecked(true);
                selected = addressSelected;
            }
        });
        delete.setTag(position);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selected==addressSelected) selected = null;
                addressdetails.remove(position);
                notifyDataSetChanged();
            }
        });
        return row;
    }

}
