package com.neosoft.neostore.ui;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import com.neosoft.neostore.R;
import com.neosoft.neostore.adapter.HomepageAdapter;
import java.util.ArrayList;
import java.util.List;
import me.relex.circleindicator.CircleIndicator;

public class HomePage extends FragmentActivity {
    HomepageAdapter pageAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);
        List<Fragment> fragments = getFragments();
        pageAdapter = new HomepageAdapter(getSupportFragmentManager(), fragments);
        ViewPager pager = (ViewPager) findViewById(R.id.viewpager);
        pager.setAdapter(pageAdapter);
        CircleIndicator indicator = (CircleIndicator)findViewById( R.id.indicator);
        indicator.setBackgroundColor(Color.parseColor("#00000000"));
        indicator.setViewPager(pager);
    }
    private List<Fragment> getFragments() {
        List<Fragment> fList = new ArrayList<Fragment>();
        fList.add(HomepageFragment.newInstance(R.drawable.furniture1));
        fList.add(HomepageFragment.newInstance(R.drawable.furniture));
        fList.add(HomepageFragment.newInstance(R.drawable.furniture2));
        return fList;
    }
}
