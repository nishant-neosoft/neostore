package com.neosoft.neostore;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;


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
    }

    private List<Fragment> getFragments() {
        List<Fragment> fList = new ArrayList<Fragment>();
        fList.add(HomepageFragment.newInstance(R.drawable.furniture1));
        fList.add(HomepageFragment.newInstance(R.drawable.furniture));
        fList.add(HomepageFragment.newInstance(R.drawable.furniture3));
        return fList;
    }
}
