package com.symbel.contadortiempodescarga;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class AlarmaReceiver extends BroadcastReceiver {
    public AlarmaReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.d(getClass().getCanonicalName(), "Alarma ejecutándose");
        Log.d(getClass().getCanonicalName(), "Lanzando el servicio");

        Intent intent_serv = new Intent(context, MyService.class);
        context.startService(intent_serv);

    }
}
