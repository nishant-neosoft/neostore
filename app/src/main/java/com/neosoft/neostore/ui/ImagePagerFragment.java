package com.neosoft.neostore.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.neosoft.neostore.R;

public class ImagePagerFragment extends Fragment {
    public static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";
    private View v;
    private boolean imageloaded;

    public static final ImagePagerFragment newInstance(int message) {
        ImagePagerFragment f = new ImagePagerFragment();
        Bundle bdl = new Bundle();
        bdl.putString(EXTRA_MESSAGE, String.valueOf(message));
        f.setArguments(bdl);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String message = getArguments().getString(EXTRA_MESSAGE);
        if (!imageloaded) {
            v = inflater.inflate(R.layout.homepage_layout, container, false);
            ImageView imageView = (ImageView) v.findViewById(R.id.home_imageView);
            imageView.setImageResource(Integer.parseInt(message));
            imageloaded = true;
        }
        return v;
    }
}