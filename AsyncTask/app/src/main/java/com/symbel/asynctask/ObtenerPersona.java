package com.symbel.asynctask;


import android.os.AsyncTask;
import android.util.Log;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by estefi on 12/07/2016.
 */
public class ObtenerPersona extends AsyncTask<String, Void, Persona> {

    protected Persona doInBackground(String... params){

        String nombre_persona = null;
        URL dir_obtener_persona = null;
        HttpURLConnection httpURLConnection = null;

        try{
            dir_obtener_persona = new URL(Constantes.URL_DIRECCION_PERSONA);
            httpURLConnection = (HttpURLConnection)dir_obtener_persona.openConnection();
            httpURLConnection.setRequestMethod("POST");//Vamos a enviar informacion en el cuerpo


            OutputStreamWriter osw = new OutputStreamWriter(httpURLConnection.getOutputStream());
            nombre_persona = params[0];
            osw.write(nombre_persona);
            osw.close();

            int resp_code = httpURLConnection.getResponseCode();

            if (resp_code == HttpURLConnection.HTTP_CREATED);
            persona = null;

            httpURLConnection.disconnect();


        }catch (Throwable t){
            Log.d(getClass().getCanonicalName(), "Error al ObtenerPersona", t);
        }



        return persona;

    }
}
