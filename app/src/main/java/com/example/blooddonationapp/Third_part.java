package com.example.blooddonationapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.blooddonationapp.Fragments.Donors_list;
import com.example.blooddonationapp.Fragments.Map;
import com.example.blooddonationapp.Fragments.home;
import com.example.blooddonationapp.Fragments.info;
import com.example.blooddonationapp.Profiles.Users_profile;
import com.google.android.material.navigation.NavigationView;

public class Third_part extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener , View.OnClickListener {
    private DrawerLayout drawer;
    ImageButton tab_one,tab_two,tab_three,tab_four;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_part);

         tab_one=findViewById(R.id.home_button_id);tab_one.setOnClickListener(this);
        tab_two=findViewById(R.id.list_button_id);tab_two.setOnClickListener(this);
        tab_three=findViewById(R.id.map_button_id);tab_three.setOnClickListener(this);
        tab_four=findViewById(R.id.Info_button_id);tab_four.setOnClickListener(this);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new home()).commit();
         //   navigationView.setCheckedItem(R.id.nav_message);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_message:
               // getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                       // new MessageFragment()).commit();
                break;
            case R.id.nav_chat:
                //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                       // new ChatFragment()).commit();
                break;
            case R.id.nav_profile:
                //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                       // new ProfileFragment()).commit();
                break;
            case R.id.nav_share:
               // Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_send:
               // Toast.makeText(this, "Send", Toast.LENGTH_SHORT).show();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return false;
    }
    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    //Option menu activities
// Activity's overrided method used to set the menu file
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }
// Activity's overrided method used to perform click events on menu items

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
// Handle action bar item clicks here. The action bar will
// automatically handle clicks on the Home/Up button, so long
// as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
//noinspection SimplifiableIfStatement
// Display menu item's title by using a Toast.
        if (id == R.id.action_settings) {
            Toast.makeText(getApplicationContext(), "Setting Menu", Toast.LENGTH_SHORT).show();
            return true;
//        } else if (id == R.id.action_search) {
//            Toast.makeText(getApplicationContext(), "Search Menu", Toast.LENGTH_SHORT).show();
//            return true;
        } else if (id == R.id.action_user) {
            Toast.makeText(getApplicationContext(), "User Menu", Toast.LENGTH_SHORT).show();
            Intent i= new Intent(Third_part.this, Users_profile.class);
            startActivity(i);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.home_button_id:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new home()).commit();
                break;
            case R.id.list_button_id:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Donors_list()).commit();
                break;
            case R.id.Info_button_id:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new info()).commit();
                break;
            case R.id.map_button_id:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Map()).commit();
                break;
        }
    }
}