package com.symbel.contadortiempodescarga;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.Log;

public class MyReceiver extends BroadcastReceiver {
    private Context context;
    private byte [] img_zip;

    public MyReceiver() {
        this.context = context;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(getClass().getCanonicalName(), "Me han llamado desde un service!");

        //Obtenemos los extras del intent
        this.img_zip = intent.getExtras().getByteArray("BITMAP");
        Long time = intent.getLongExtra("TIME",0);

        //Intent de llamada a la actividad detalle
        Intent intent2 = new Intent(context,Main2Activity.class);

        //Metemos datos en el intent
        intent2.putExtra("TIME", time);
        intent2.putExtra("BITMAP", this.img_zip);

        //Lanzamos nueva actividad
        context.startActivity(intent2);
    }
}
