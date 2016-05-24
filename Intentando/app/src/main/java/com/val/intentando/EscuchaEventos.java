package com.val.intentando;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

/**
 * Clase que implementa el listener de la aplicación y se dedica únicamente a
 * recibir las peticiones del usuario y a invocar al método correspondiente (MODELO)
 *
 * En la óptica MVC, sería nuestro CONTROLADOR, por ser el mero intermediario
 * entre Vista y Modelo. No debería desarrollarse por tanto aquí, ningua funcionalidad,
 * que deberían codificarse en clases separadas
 *
 * @author Val
 *
 */
public class EscuchaEventos implements View.OnClickListener {

    Context context;

    //Idealmente, está función podría localizarse en otra clase (dedicada a recuperar textos de
    //las vistas, por ejemplo). Para no liar mucho, es suficiente con que se haga en un método privado a parte

    public EscuchaEventos (Context context)
    {
        this.context = context;
    }


    /**
     *
     * @return La cadena de búsqueda introducida por el usuario
     */
    private String obtenerCadenaDeBusqueda ()
    {
        String cadena_buqueda = null;
        Activity a = null;
        EditText caja_texto = null;

            a = (Activity)context; //Casting Context a Activity, para poder obtener referencia los objetos
            caja_texto = (EditText) a.findViewById(R.id.caja_texto_busqueda); //obtengo la caja de texto
            cadena_buqueda = caja_texto.getText().toString();//extraigo su contenido, el término de búsqueda

        return cadena_buqueda;
    }

    /**
     * Método principal de la clase, que será invocado a modo de callback cuando los objetos
     * de la interfaz de usuario sean seleccioandos
     *
     * @param vista_seleccioanda El obejto visual que ha recibido el click
     */

    @Override
    public void onClick(View vista_seleccioanda)
    {
        int id_vista_seleccionada = vista_seleccioanda.getId(); //obtengo el Id de la vista, para poder saber qué elemento Visual (View) ha sido seleccionado por el usuario

        Log.d(getClass().getCanonicalName(), "El usuario ha tocado un botón");


        switch (id_vista_seleccionada)
        {
            case R.id.botonbuscarengoogle:
                Log.d(getClass().getCanonicalName(), "El usuario ha tocado el botón de buscar en Google");
                String termino_busqueda = obtenerCadenaDeBusqueda();
                Accion.buscarEnGoogle(context, termino_busqueda);
            break;
        }

    }
}
