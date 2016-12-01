package com.neosoft.neostore.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.neosoft.neostore.R;
import com.neosoft.neostore.adapter.HomepageAdapter;
import com.neosoft.neostore.fragment.HomepageFragment;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class HomeScreen extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    TextView mycart;
    LinearLayout badge_layout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        NavigationView navigationView = (NavigationView) findViewById(R.id.navlayout);
        navigationView.setNavigationItemSelectedListener(this);
        badge_layout = (LinearLayout) MenuItemCompat.getActionView(navigationView.getMenu().findItem(R.id.nav_mycart));
        badge_layout.setGravity(Gravity.CENTER);
        mycart = new TextView(this);
        mycart.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        mycart.setText("3");
        mycart.setBackgroundResource(R.drawable.roundtextview);
        mycart.setGravity(Gravity.CENTER);
        mycart.setTextColor(getResources().getColor(R.color.colorWhite));
        badge_layout.addView(mycart);
        List<Fragment> fragments = getFragments();
        HomepageAdapter pageAdapter = new HomepageAdapter(getSupportFragmentManager(), fragments);
        ViewPager pager = (ViewPager) findViewById(R.id.viewpager);
        pager.setAdapter(pageAdapter);
        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        indicator.setBackgroundColor(Color.parseColor("#00000000"));
        indicator.setViewPager(pager);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private List<Fragment> getFragments() {
        List<Fragment> fList = new ArrayList<Fragment>();
        fList.add(HomepageFragment.newInstance(R.drawable.furniture1));
        fList.add(HomepageFragment.newInstance(R.drawable.furniture));
        fList.add(HomepageFragment.newInstance(R.drawable.furniture2));
        return fList;
    }
}
