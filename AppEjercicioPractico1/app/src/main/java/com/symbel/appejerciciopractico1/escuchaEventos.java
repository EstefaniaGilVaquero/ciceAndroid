package com.symbel.appejerciciopractico1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;

/**
 * Created by estefi on 09/06/2016.
 */
public class escuchaEventos implements View.OnClickListener{

    Context context;

    displayImages mostrarImagenes = new displayImages();

    public escuchaEventos(Context context){this.context = context;}


    @Override
    public void onClick(View vista_seleccioanda)
    {
        //obtengo el Id de la vista
        int id_vista_seleccionada = vista_seleccioanda.getId();

        Log.d(getClass().getCanonicalName(), "Ha pulsado un boton");

        switch (id_vista_seleccionada)
        {
            case R.id.OK_BTN:
                Log.d(getClass().getCanonicalName(), "Ha pulsado boton OK de login");

                //Intent para llamar a la actividad displayImages

                Intent intent1 = new Intent(context, displayImages.class);
                Activity a = (Activity) context;
                a.startActivity(intent1);

                break;
            case R.id.siBTN:
                Log.d(getClass().getCanonicalName(), "Ha pulsado boton SI");
                //TODO: Guardar en un map la imagen y la respuesta
                //mostrarImagenes.guardarEleccion(R.id.siBTN);
                mostrarImagenes.nextImgae();

                break;

            case R.id.noBTN:
                Log.d(getClass().getCanonicalName(), "Ha pulsado boton NO");
                //TODO: Guardar en un map la imagen y la respuesta
                //mostrarImagenes.guardarEleccion(R.id.noBTN);
                mostrarImagenes.nextImgae();
                break;


        }


    }
}