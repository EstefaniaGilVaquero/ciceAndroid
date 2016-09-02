package com.symbel.contadortiempodescarga;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //
        try {

            Log.d(getClass().getCanonicalName(), "Servicio iniciado, voy a descargar la imagen");
            Calculo calculo = new Calculo(this);



        }
        catch (Throwable t)
        {
            Log.e(getClass().getCanonicalName(), "ERRORAZO", t);
        }

        return Service.START_NOT_STICKY;
    }



    @Override
    public void onDestroy() {
        super.onDestroy();

    /*    Log.d(getClass().getCanonicalName(), "Servicio Terminado");

        Intent intent_reciver = new Intent("SERVICIO_TERMINADO");

        intent_reciver.putExtra("Mensaje", mensaje_remoto);

        sendBroadcast(intent_reciver);*/
    }
}
