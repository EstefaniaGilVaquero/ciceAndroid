package com.symbel.contadortiempodescarga;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.IBinder;
import android.util.Log;

import java.util.concurrent.ExecutionException;

public class MyService extends Service {

    private Bitmap bitmap = null;
    private Calculo calculo;

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        calculo = new Calculo();
        try {
            bitmap = calculo.execute(MainActivity.mURL).get();
            stopSelf();//finalizo
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return Service.START_REDELIVER_INTENT; //Si el servicio se destruye se reinicia el intent original
    }



    @Override
    public void onDestroy() {
        super.onDestroy();

        Intent intent_reciver = new Intent("SERVICIO_TERMINADO");
        intent_reciver.putExtra("TIME", calculo.getTiempoFinal());
        intent_reciver.putExtra("BITMAP", bitmap);
        sendBroadcast(intent_reciver);
    }
}
