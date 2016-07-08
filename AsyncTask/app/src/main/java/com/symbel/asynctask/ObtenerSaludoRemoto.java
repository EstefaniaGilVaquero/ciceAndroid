package com.symbel.asynctask;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by estefi on 07/07/2016.
 */
public class ObtenerSaludoRemoto extends AsyncTask<Void, Void, String> {


    @Override
    protected String doInBackground(Void ... params) {

        String saludo = null;

        try{
            Log.d(this.getClass().getCanonicalName(), "Llamado a ObtenerSaludoRemoto");
            URL serveUrl = new URL(Constantes.URL_SERVICIO_SALUDO);
            HttpURLConnection httpCon = (HttpURLConnection) serveUrl.openConnection();

            if(httpCon.getResponseCode() == HttpURLConnection.HTTP_OK){
                InputStreamReader isr = new InputStreamReader(httpCon.getInputStream());
                BufferedReader br = new BufferedReader(isr);
                saludo = br.readLine();
                br.close();
                isr.close();
            }
            httpCon.disconnect();
        }catch (Exception e){
            Log.e(getClass().getCanonicalName(), "ups, la conexion con el servidor no ha ido bien", e);
        }

        return saludo;
    }
}
