package com.symbel.navigationviewsyb;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.NavigationView;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * Created by estefi on 21/06/2016.
 */
public class NavigationMenuListener implements NavigationView.OnNavigationItemSelectedListener {

    private Context context;

    public NavigationMenuListener (Context context)
    {
        this.context = context;
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        String menu = item.getTitle().toString();

        Log.d(getClass().getCanonicalName(), "Ha tocado la opción " + menu);

        TextView texto = (TextView) ((Activity)context).findViewById(R.id.textView);
        texto.setText(menu);



        return true;

    }


}
