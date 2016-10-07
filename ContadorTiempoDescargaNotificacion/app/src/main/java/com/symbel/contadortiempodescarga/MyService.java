package com.symbel.contadortiempodescarga;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.IBinder;
import android.util.Log;

import java.io.ByteArrayOutputStream;
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

    //Metodo para comprimir imagen descargada
    private byte [] comprimirBitMap(Bitmap bitmap){
        byte [] imag_zip;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        imag_zip = baos.toByteArray();
        return imag_zip;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Long tiempoFinal;

        Intent intent_reciver = new Intent("SERVICIO_TERMINADO");
        tiempoFinal = calculo.getTiempoFinal();
        intent_reciver.putExtra("TIME", tiempoFinal);


        //Para poder pasar un bitmap por un intent hay que comprimir la imagen

        byte[] fotoArray = comprimirBitMap(bitmap);

        intent_reciver.putExtra("BITMAP", fotoArray);
        sendBroadcast(intent_reciver);
    }
}
