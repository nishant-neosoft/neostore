package com.neosoft.neostore.ui;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.neosoft.neostore.R;
import com.neosoft.neostore.adapter.HomepageAdapter;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

/**
 * Created by webwerks1 on 1/12/16.
 */

public class HomepageFragment extends Fragment {

    private View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_homepage, container, false);
        initViews();
        return rootView;
    }

    private void initViews() {
        List<Fragment> fragments = getFragments();
        HomepageAdapter pageAdapter = new HomepageAdapter(getFragmentManager(), fragments);
        ViewPager pager = (ViewPager) rootView.findViewById(R.id.viewpager);
        pager.setAdapter(pageAdapter);

        CircleIndicator indicator = (CircleIndicator) rootView.findViewById(R.id.indicator);
        indicator.setBackgroundColor(Color.parseColor("#00000000"));
        indicator.setViewPager(pager);
    }

    private List<Fragment> getFragments() {
        List<Fragment> fList = new ArrayList<Fragment>();
        fList.add(ImagePagerFragment.newInstance(R.drawable.furniture1));
        fList.add(ImagePagerFragment.newInstance(R.drawable.furniture));
        fList.add(ImagePagerFragment.newInstance(R.drawable.furniture2));
        return fList;
    }
}
