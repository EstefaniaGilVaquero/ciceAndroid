package com.symbel.contadortiempodescarga;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

    public class MyReceiver extends BroadcastReceiver {
    private Context context;
    private byte [] img_zip;
    private Long time;

    public MyReceiver(Context context) {
        this.context = context;
    }

    private void lanzarNotificacion (String mensaje)
    {

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this.context)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("¡Imagen Descargada!")
                        .setContentText(mensaje)
                        .setAutoCancel(true)
                        .setDefaults(Notification.DEFAULT_ALL);

        Intent resultIntent = new Intent(this.context, Main2Activity.class);
        resultIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        resultIntent.putExtra("mensaje", mensaje);
        resultIntent.putExtra("TIME", this.time);
        resultIntent.putExtra("BITMAP", this.img_zip);



        PendingIntent resultPendingIntent = PendingIntent.getActivity (context, (int) System.currentTimeMillis(), resultIntent, PendingIntent.FLAG_ONE_SHOT);

        mBuilder.setContentIntent(resultPendingIntent);
        NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(537, mBuilder.build());//537 id de la noti: único en la app!

    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(getClass().getCanonicalName(), "Me han llamado desde un service!");

        //Obtenemos los extras del intent
        this.img_zip = intent.getExtras().getByteArray("BITMAP");
        this.time = intent.getLongExtra("TIME",0);



        lanzarNotificacion("La imagen se ha descargado fenomenal");
        
    }
}
