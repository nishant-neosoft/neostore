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
 * Created by webwerks on 14/12/16.
 */

public class ProductDetailsFragment extends Fragment {

    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.row_product_details, container, false);
        initView();
        return view;
    }
    private void initView()
    {
        List<Fragment> fragments = getFragments();
        HomepageAdapter pageAdapter = new HomepageAdapter(getFragmentManager(), fragments);
        ViewPager pager = (ViewPager) view.findViewById(R.id.viewpagerImg);
        pager.setAdapter(pageAdapter);

        CircleIndicator indicator = (CircleIndicator) view.findViewById(R.id.indicate);
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
