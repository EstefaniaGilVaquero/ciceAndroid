package com.val.intentando;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.d(getClass().getCanonicalName(), "Se inicia la actividad principal");

        //SE DIBUJA LA ACTIVIDAD
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //CREO EL OBJETO LISTENER, ENCARGADO DE "ESCUCHAR" Y RECIBIR
        //LOS CALLBACK
        View.OnClickListener objeto_escuchador = new EscuchaEventos(this);

        //CAPTURO EL BOTÓN Y LE ASOCIO EL LISTENER
        //RECORDAD QUE TAMBIÉN SE PUEDE HACER EN EL XML
        Button boton_busqueda = (Button)findViewById(R.id.botonbuscarengoogle);
        boton_busqueda.setOnClickListener(objeto_escuchador);

        Log.d(getClass().getCanonicalName(), "Listener instanciados y asociados");


    }
}
