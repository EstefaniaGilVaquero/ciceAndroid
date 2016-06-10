package com.symbel.appejerciciopractico1;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.ImageView;

import java.util.HashMap;


public class displayImages extends AppCompatActivity {

    Context context;
    HashMap mapaEleccion = new HashMap();

    Integer contadorImagenes = 0;

    //private ImageView imagenBici;

    // Array de imagenes
    private Integer[] biciArray = {
            R.drawable.bici_carretera,
            R.drawable.bici_enduro,
            R.drawable.bici_paseo,
            R.drawable.bici_xcontry
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_images);

        //Listener
        View.OnClickListener objetoEscuchador = new escuchaEventos(this);

        //CAPTURO EL BOTÓN Y LE ASOCIO EL LISTENER
        Button botonSI = (Button)findViewById(R.id.siBTN);
        botonSI.setOnClickListener(objetoEscuchador);
        Button botonNO = (Button)findViewById(R.id.noBTN);
        botonNO.setOnClickListener(objetoEscuchador);


    }

    public void nextImgae(){

        Activity a = (Activity) context;

        ImageView imagenBici = (ImageView) a.findViewById(R.id.bicisView);

        if ( contadorImagenes < biciArray.length){
            contadorImagenes++;

        }else{
            contadorImagenes = 0;
        }

        imagenBici.setImageResource(R.drawable.bici_enduro);
      //  imagenBici.setImageResource(biciArray[contadorImagenes]);
    }

    public void guardarEleccion(View v){
        //TODO: Guarda la eleccion del usuario y el id de la foto

    }





}
