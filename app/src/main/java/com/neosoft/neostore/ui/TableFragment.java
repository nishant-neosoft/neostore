package com.neosoft.neostore.ui;

import android.app.Fragment;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import android.widget.ListView;
import com.neosoft.neostore.R;
import com.neosoft.neostore.adapter.TableAdapter;
import com.neosoft.neostore.model.Product.DataModel;
import com.neosoft.neostore.model.Product.ProductResponseModel;
import com.neosoft.neostore.serviceapi.ApiResponse;
import com.neosoft.neostore.serviceapi.GetServices;

import java.util.ArrayList;


public class TableFragment extends Fragment {
    private View rootView;
    ListView list;
    TableAdapter adapter;
    public  TableFragment TableListView = null;
    public ArrayList<DataModel> CustomListViewValuesArr = new ArrayList<DataModel>();
    public  View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_tables, container, false);
       final Resources res =getResources();
        list= ( ListView )rootView.findViewById(R.id.table_list);
        GetServices services= new GetServices();
        services.getProductlist("1", new ApiResponse() {
            @Override
            public void onSuccess(Object response) {
                Log.e("zzz", response.toString());
                ProductResponseModel responseModel = (ProductResponseModel) response;
                for(DataModel model:responseModel.getData()){
                    Log.e("DATA",model.getTableTitle() + " :::::");
                }
                adapter=new TableAdapter(getActivity(), responseModel.getData(),res );
                list.setAdapter( adapter );
            }
            @Override
            public void onError(String message) {
                Log.e("zzz", message);
            }
        });
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
        return rootView;
        }

    public void onItemClick(int mPosition)
    {
        DataModel tempValues = (DataModel)CustomListViewValuesArr.get(mPosition);
    }

}









