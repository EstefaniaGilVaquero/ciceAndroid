package com.example.vale.sanckfab;

import android.support.design.widget.Snackbar;
import android.view.View;

/**
 * Created by vale on 6/06/16.
 */
public class ListenerFAB implements View.OnClickListener {
    @Override
    public void onClick(View v) {

        Snackbar.make(v, "Se presionó el FAB", Snackbar.LENGTH_LONG).show();
        /**
         * OTROS MÉTODOS INTERESANTES DEL SNACKBAR
         *
         * setAction (String, Listener) // para llamar a una acción cuando se toque
         * setActionTextColor (int) // para modificar el color del String anterior
         * setCallback (SnackBar.Callback) //para ser invocada cuando cambia la visibilidad del snackbar
         */

    }
}
