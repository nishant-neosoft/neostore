package com.neosoft.neostore.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.neosoft.neostore.R;

public class HomepageFragment extends Fragment {
    public static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";
    View v;
    private boolean imageloaded;


    public static final HomepageFragment newInstance(int message) {
        HomepageFragment f = new HomepageFragment();
        Bundle bdl = new Bundle();
        bdl.putString(EXTRA_MESSAGE, String.valueOf(message));
        f.setArguments(bdl);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String message = getArguments().getString(EXTRA_MESSAGE);

        if (!imageloaded) {
            Log.d("insight","here");
            v = inflater.inflate(R.layout.homepage_layout, container, false);
            ImageView imageView = (ImageView) v.findViewById(R.id.home_imageView);
            imageView.setImageResource(Integer.parseInt(message));
            imageloaded = true;
        }

        return v;
    }
}