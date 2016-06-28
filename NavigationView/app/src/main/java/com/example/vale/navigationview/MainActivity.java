package com.example.vale.navigationview;

import android.annotation.TargetApi;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private boolean menu_visible;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menu_visible = false;

        /**
         *
         * Para gestionar el dibujo del menú lateral y los eventos asociados a su aparición/
         * ocultación, podría haber definido un objeto ActionBarDrawerToggle y setearlo
         * como listener al objeto DrawerLayout.setDrawerListener (ActionBarDrawerToogle)
         * que poseerá sus métodos onDrawerOpenned y onDrawerCloses
         */


        getSupportActionBar().setHomeAsUpIndicator(R.mipmap.ic_fingerprint_white_24dp);//dibujo el menú de navigator
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //


        NavigationView navigationView = (NavigationView) findViewById(R.id.navview);

        navigationView.setNavigationItemSelectedListener(new NavigationMenuListener(this));

        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        //drawerLayout.setElevation(2f);




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        switch(item.getItemId()) {
            case android.R.id.home:
                if (menu_visible)
                {
                    drawerLayout.closeDrawers();
                    menu_visible = false;
                } else
                {
                    drawerLayout.openDrawer(GravityCompat.START);
                    menu_visible = true;
                }

               // return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void cierramenu() {

        drawerLayout.closeDrawers();
        menu_visible = false;
    }
}
