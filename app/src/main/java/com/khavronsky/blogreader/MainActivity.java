package com.khavronsky.blogreader;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    Toolbar toolbar;
    ActionBarDrawerToggle toggle;
    FragmentTransaction fragmentTransaction;
    Fragment firstFragment;
    Fragment secondFragment;
    Fragment thirdFragment;
    Fragment fourthFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        firstFragment = new FirstFragment();
        secondFragment = new SecondFragment();
        thirdFragment = new ThirdFragment();
        fourthFragment = new FourthFragment();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.fragment1) {
//            startFirstFragment();
            startFragment(firstFragment);

        } else if (id == R.id.fragment2) {
//            startSecondFragment();
            startFragment(secondFragment);

        } else if (id == R.id.fragment3) {
//            startThirdFragment();
            startFragment(thirdFragment);

        } else if (id == R.id.fragment4) {
//            startFourthFragment();
            startFragment(fourthFragment);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }

    public void onFragmentButtonSelected(View v) {
        int id = v.getId();
        switch (id) {
            case (R.id.first_button):
                startFragment(secondFragment);
//                startSecondFragment();
                break;
            case (R.id.second_button):
                startFragment(thirdFragment);
//                startThirdFragment();
                break;
            case (R.id.third_button):
                startFragment(fourthFragment);
//                startFourthFragment();
                break;
            case (R.id.fourth_button):
//                startFirstFragment();
                startFragment(firstFragment);
                break;
            default:
                break;
        }
    }

    public void startFragment(Fragment fragment) {
        fragmentTransaction = getFragmentManager().beginTransaction();
//        getFragmentManager().getBackStackEntryAt(0);
//        if(getBackStackEntryCount()>0)
//            getBackStackEntryAt( getBackStackEntryCount() -1)
//        getFragmentManager().findFragmentById(0);
//        getFragmentManager().
//        if (fragmentTransaction.isEmpty()) {
//            fragmentTransaction.add(R.id.container, fragment);
//        }
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.commit();
    }

//    public void startFirstFragment() {
//        fragmentTransaction = getFragmentManager().beginTransaction();
//        fragmentTransaction.add(R.id.container, firstFragment);
//        fragmentTransaction.commit();
//
//    }
//
//    public void startSecondFragment() {
//        fragmentTransaction = getFragmentManager().beginTransaction();
//        fragmentTransaction.add(R.id.container, secondFragment);
//        fragmentTransaction.commit();
//
//    }
//
//    public void startThirdFragment() {
//        fragmentTransaction = getFragmentManager().beginTransaction();
//        fragmentTransaction.add(R.id.container, thirdFragment);
//        fragmentTransaction.commit();
//
//    }
//
//    public void startFourthFragment() {
//        fragmentTransaction = getFragmentManager().beginTransaction();
//        fragmentTransaction.add(R.id.container, fourthFragment);
//        fragmentTransaction.commit();
//
//    }

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
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
