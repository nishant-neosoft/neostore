package com.neosoft.neostore.ui;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.neosoft.neostore.R;
import com.neosoft.neostore.adapter.CartAdapter;
import com.neosoft.neostore.model.mycart.Datum;
import com.neosoft.neostore.model.mycart.MyCartResponseModel;
import com.neosoft.neostore.serviceapi.ApiFailure;
import com.neosoft.neostore.serviceapi.ApiResponse;
import com.neosoft.neostore.serviceapi.ErrorHandler;
import com.neosoft.neostore.serviceapi.GetServices;
import com.neosoft.neostore.util.Util;

import java.util.ArrayList;

public class MyCartFragment extends Fragment implements ApiFailure{

    private View rootView;
    ListView list;
    CartAdapter adapter;
    public  MyCartFragment CartListView = null;
    public ArrayList<Datum> arrayList = new ArrayList<Datum>();
    LayoutInflater inflater = null;
    TextView total;
    private static final String MyPREFERENCES = "MyPrefs";
    static String ACCESS_TOKEN = "value";

    public  View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final Resources res =getResources();
        rootView = inflater.inflate(R.layout.fragment_cart_items,container,false);
        list= ( ListView ) rootView.findViewById(R.id.list_item);
        total = (TextView)rootView.findViewById(R.id.txtFooter1);
        GetServices services= new GetServices();

        //getActivity().getSharedPreferences("",Context.MODE_PRIVATE).edit().putString(",",",").commit().
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        ACCESS_TOKEN = sharedPreferences.getString("access_token", null);
        services.getCartItems(ACCESS_TOKEN, new ApiResponse() {
            @Override
            public void onSuccess(Object response) {
                MyCartResponseModel responseModel = (MyCartResponseModel) response;
                adapter=new CartAdapter(getActivity(),responseModel.getData(),res );
                list.setAdapter(adapter);
                total.setText(""+responseModel.getTotal());
            }
        }, new ErrorHandler());

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            }
        });
        return rootView;
    }
    public void onItemClick(int mPosition)
    {
    }

    @Override
    public String onError(String msg) {
        return msg;
    }
}
