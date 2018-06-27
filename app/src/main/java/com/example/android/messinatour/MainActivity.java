package com.example.android.messinatour;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        //if then else that open inherent list
        if (id == R.id.nav_restaurants) {
            RestaurantFragment restaurant = new RestaurantFragment();
            android.support.v4.app.FragmentManager FM = getSupportFragmentManager();
            FM.beginTransaction().replace(R.id.content_main, restaurant, restaurant.getTag()).commit();
        }
        else if (id == R.id.nav_location) {
            LocationFragment location = new LocationFragment();
            android.support.v4.app.FragmentManager FM = getSupportFragmentManager();
            FM.beginTransaction().replace(R.id.content_main, location, location.getTag()).commit();
        }
        else if (id == R.id.nav_nightclub) {
            NightClubFragment nightclub = new NightClubFragment();
            android.support.v4.app.FragmentManager FM = getSupportFragmentManager();
            FM.beginTransaction().replace(R.id.content_main, nightclub, nightclub.getTag()).commit();
        }
        else if (id == R.id.nav_event) {
            EventFragment event = new EventFragment();
            android.support.v4.app.FragmentManager FM = getSupportFragmentManager();
            FM.beginTransaction().replace(R.id.content_main, event, event.getTag()).commit();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
