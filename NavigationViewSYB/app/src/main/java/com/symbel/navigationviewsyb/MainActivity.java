package com.symbel.navigationviewsyb;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private boolean menu_visible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        menu_visible = false;

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_navigate_next_black_48dp);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);







    }



}
