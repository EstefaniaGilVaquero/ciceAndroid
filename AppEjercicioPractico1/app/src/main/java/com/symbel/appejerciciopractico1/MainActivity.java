package com.symbel.appejerciciopractico1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       //Listener
        View.OnClickListener objetoEscuchador = new escuchaEventos(this);

        //CAPTURO EL BOTÓN Y LE ASOCIO EL LISTENER
        Button botonOK = (Button)findViewById(R.id.OK_BTN);
        botonOK.setOnClickListener(objetoEscuchador);
        Button botonBorrar = (Button)findViewById(R.id.borrarBTN);
        botonBorrar.setOnClickListener(objetoEscuchador);
 }
}
