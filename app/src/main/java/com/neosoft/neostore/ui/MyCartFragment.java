package com.neosoft.neostore.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.daimajia.swipe.SwipeLayout;
import com.neosoft.neostore.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MyCartFragment extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> friendsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_cart_items);
        listView = (ListView) findViewById(R.id.list_item);
        friendsList = new ArrayList<>();
        getDataFromFile();
        setListViewAdapter();
    }

    private void getDataFromFile() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(getAssets().open("classmates.txt"), "UTF-8"));
            String line = reader.readLine();
            while (line != null && !line.equals("")) {
                line = reader.readLine();
                friendsList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void setListViewAdapter() {
        adapter = new ProdList(this, R.layout.list_single, friendsList);
        listView.setAdapter(adapter);
    }

    public void updateAdapter() {
        adapter.notifyDataSetChanged();
    }

}

