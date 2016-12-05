package com.neosoft.neostore.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

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
    private TextView totalClassmates;
    private SwipeLayout swipeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_cart_items);

        listView = (ListView)findViewById(R.id.list_item);

        friendsList = new ArrayList<>();
        getDataFromFile();
        setListViewHeader();
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
    private void setListViewHeader() {
        LayoutInflater inflater = getLayoutInflater();
        View header = inflater.inflate(R.layout.header_listview, listView, false);
        totalClassmates = (TextView) header.findViewById(R.id.total);
        swipeLayout = (SwipeLayout)header.findViewById(R.id.swipe_layout);
        listView.addHeaderView(header);
    }

    private void setListViewAdapter() {
        adapter = new ProdList(this, R.layout.list_single, friendsList);
        listView.setAdapter(adapter);
        totalClassmates.setText("(" + friendsList.size() + ")");
    }

    public void updateAdapter() {
        adapter.notifyDataSetChanged(); //update adapter
        totalClassmates.setText("(" + friendsList.size() + ")"); //update total friends in list
    }

}

