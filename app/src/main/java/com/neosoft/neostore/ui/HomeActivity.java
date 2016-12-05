package com.neosoft.neostore.ui;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.neosoft.neostore.R;

import static com.neosoft.neostore.R.id.nav_mycart;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    TextView mycart;
    LinearLayout badge_layout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        initDrawer();
        loadFragment(0);
    }

    private void loadFragment(int i) {
        switch (i){
            case 0:
                getFragmentManager().beginTransaction().add(R.id.container,
                        new HomepageFragment(),HomepageFragment.class.getSimpleName())
                        .commit();
                break;
            default:
                break;
        }
    }
public boolean onTouchEvent(MotionEvent event){


    return false;
}
    private void initDrawer() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.navlayout);
        navigationView.setNavigationItemSelectedListener(this);
        badge_layout = (LinearLayout) MenuItemCompat.getActionView(navigationView.getMenu().findItem(nav_mycart));
        badge_layout.setGravity(Gravity.CENTER);
        mycart = new TextView(this);
        mycart.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        mycart.setText("3");
        mycart.setBackgroundResource(R.drawable.roundtextview);
        mycart.setGravity(Gravity.CENTER);
        mycart.setTextColor(getResources().getColor(R.color.colorWhite));
        badge_layout.addView(mycart);
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

        int selectedId = item.getItemId();
        switch (selectedId) {
            case R.id.nav_mycart:
                Intent intent = new Intent(getApplicationContext(),HomepageFragment.class);
                startActivity(intent);
                break;
            case R.id.nav_tables:
            Intent intent1 = new Intent(getApplicationContext(),MyCartFragment.class);
            startActivity(intent1);
                break;
        }
        return true;
    }


}
