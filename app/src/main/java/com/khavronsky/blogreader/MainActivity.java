package com.khavronsky.blogreader;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    Toolbar toolbar;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawer;
    FragmentTransaction fragmentTransaction;
    FragmentManager fragmentManager;
    Fragment firstFragment;
    Fragment secondFragment;
    Fragment thirdFragment;
    Fragment fourthFragment;
    NavigationView navigationView;
    private static final String TAG = "MAIN ACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
        }
        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void init() {
        Log.d(TAG, "init: start");
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        firstFragment = new FirstFragment();
        secondFragment = new SecondFragment();
        thirdFragment = new ThirdFragment();
        fourthFragment = new FourthFragment();
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Log.d(TAG, "onNavigationItemSelected: start");
        int id = item.getItemId();
        switch (id) {
            case (R.id.fragment1):
                startFragment(firstFragment);
                break;
            case (R.id.fragment2):
                startFragment(secondFragment);
                break;
            case (R.id.fragment3):
                startFragment(thirdFragment);
                break;
            case (R.id.fragment4):
                startFragment(fourthFragment);
                break;
            default:
                break;
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        Log.d(TAG, "onNavigationItemSelected: DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);");
        drawer.closeDrawer(GravityCompat.START);
        Log.d(TAG, "onNavigationItemSelected: drawer.closeDrawer(GravityCompat.START);");
        return true;
    }

    public void setDrawerIndicatorEnabled(boolean set) {
        this.toggle.setDrawerIndicatorEnabled(set);
    }

    public void onFragmentButtonSelected(View v) {
        int id = v.getId();
        switch (id) {
            case (R.id.first_button):
                startFragment(secondFragment);
                break;
            case (R.id.second_button):
                startFragment(thirdFragment);
                break;
            case (R.id.third_button):
                startFragment(fourthFragment);
                break;
            case (R.id.fourth_button):
                startFragment(firstFragment);
                break;
            default:
                break;
        }
    }

    public void startFragment(Fragment fragment) {
        fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, fragment)
                .addToBackStack(null)
                .commit();


//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d("...", "OnClick work!");
//                if (getFragmentManager().getBackStackEntryCount() > 0) {
//                    Log.d(TAG, "ONCLICK onBackPressed: ");
//                    onBackPressed();
//                } else {
////                    getSupportActionBar().setDisplayShowHomeEnabled(false);
////                    Log.d(TAG, "setDrawerIndicatorEnabled: ");
//                    toggle.setDrawerIndicatorEnabled(false);
//                    toggle.setDrawerIndicatorEnabled(true);
//                    drawer.addDrawerListener(toggle);
//                    toggle.syncState();
//                    navigationView.setNavigationItemSelectedListener(MainActivity.this);
//
////                    drawer.
////                    toggle.syncState();
////                    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
////                    drawer.openDrawer(GravityCompat.START, true);
//
//                }
//
//            }
//        });
    }

    @Override
    public void onBackPressed() {
        Log.d(TAG, "onBackPressed: start");

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        Log.d(TAG, "onBackPressed: DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);");
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
            Log.d(TAG, "onBackPressed: drawer.closeDrawer(GravityCompat.START);");
        } else if (getFragmentManager().getBackStackEntryCount() > 0) {
//            Log.d(TAG, "onBackPressed: ");
            super.onBackPressed();
        } else {

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.d(TAG, "onCreateOptionsMenu: start");

        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    protected Dialog onCreateDialog(int id) {
        AlertDialog.Builder adb = new AlertDialog.Builder(this);

        adb.setTitle("RED BO-O-OM BUTTON");

        adb.setMessage("Oh, no!!!\n You pressed this fucking red button!!!");

        adb.setIcon(R.mipmap.scare);

        adb.setPositiveButton("Everybody must die", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        adb.setNegativeButton("I'm so sorry", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "NO! Everybody must die", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                finish();
            }
        });
        return adb.create();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.d(TAG, "onOptionsItemSelected: start");

        int id = item.getItemId();

        switch (id) {
            case (R.id.red_button):
                showDialog(0);
                break;
            case (R.id.pusher):
                Toast toast = Toast.makeText(this,
                        R.string.push, Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                break;
            case (R.id.settings):

                break;
            case (R.id.settings_too):

                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
