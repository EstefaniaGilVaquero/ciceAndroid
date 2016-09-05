package com.symbel.asynctask;


import android.app.DialogFragment;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(getClass().getCanonicalName(), "oncreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(UtilInternet.isNetworkAvailable(this)){
            Log.d(getClass().getCanonicalName(), "SI HAY INTERNET");
            new ObtenerPersona().execute("Paco");
        }else{
            Log.d(getClass().getCanonicalName(), "NO HAY INTERNET");
            FragmentManager fm = this.getFragmentManager();
            DialogFragment dialogo = new DialogFragment();
            dialogo.show(fm, "aviso");
        }
    }

}
