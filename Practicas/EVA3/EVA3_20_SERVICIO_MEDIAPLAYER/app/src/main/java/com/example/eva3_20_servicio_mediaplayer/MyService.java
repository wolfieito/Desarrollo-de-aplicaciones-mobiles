package com.example.eva3_20_servicio_mediaplayer;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    MediaPlayer mediaPlayer = null;
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = MediaPlayer.create(this, R.raw.acdc_back_in_black);
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        if(mediaPlayer != null)
            mediaPlayer.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mediaPlayer != null)
            mediaPlayer.stop();
    }
}

//un servicio envia la informacion a todos las aplicaciones
//por los filtros las aplicaciones escuchan los filtros de los servidores
//un servicio puede enviar a multiples aplicaciones y aplicaciones pueden escuchar a multiples servicios