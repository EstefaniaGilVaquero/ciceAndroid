package com.val.intentando;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

/**
 * Clase que representa el Modelo; es decir, las acciones a llevar a cabo por nuestra aplicación.
 *
 * @author Val
 */
public class Accion {

    private final static String PREFIJO_URI_BUSCA_GOOGLE = "http://www.google.com/#q=";
    private static Intent intent = null;

    /**
     *Lanza una nueva ventana del navegador con la búsqueda del usuario introducida
     *
     * @param context La actividad donde será lanzada la búsqueda
     * @param cadena_busqueda El término de búsqueda a consultar
     */
    public static void buscarEnGoogle (Context context, String cadena_busqueda)
    {
        String url = null;
        Activity a = null;

        Uri uri = null;

            Log.d(Accion.class.getCanonicalName(), "Preparando la búsqueda");

            url = PREFIJO_URI_BUSCA_GOOGLE + cadena_busqueda;//Compongo la cadena
            uri = Uri.parse(url);//y Su URI
            intent = new Intent(Intent.ACTION_VIEW, uri); //creo el intent
            a = (Activity) context; //Subcasting (De clase Padre a hija)

            Log.d(Accion.class.getCanonicalName(), "Lanzando el intent de búsqueda");
            a.startActivity(intent);//lanzo la actividad - INTENT IMPLÍCITO (describo la acción de forma general)

    }

    public static void compartirWasApp (Context context, String cadena_busqueda)
    {
        Log.d(Accion.class.getCanonicalName(), "Preparando compartir wasapp");
        Activity a = (Activity) context; //Subcasting (De clase Padre a hija)

        intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, cadena_busqueda);
        intent.setType("text/plain");
        intent.setPackage("com.whatsapp");

        Log.d(Accion.class.getCanonicalName(), "Lanzando el intent de conpartir");
        a.startActivity(intent);

    }
}
