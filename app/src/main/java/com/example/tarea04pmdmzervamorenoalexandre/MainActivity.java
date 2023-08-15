package com.example.tarea04pmdmzervamorenoalexandre;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Seleccionar canal de audio
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);

        //Reproducimos el archivo mp3 de la carpeta res/raw
        mp = MediaPlayer.create(this,R.raw.musica_fondo_main);
        mp.start();
    }



    /**
     * Cambiamos de pantalla al pulsar en el boton y paramos la música que suena de fondo
     * @param view Cambio de pantalla
     */
    public void goPaint(View view) {
        Intent i = new Intent(MainActivity.this, PaintActivity.class);
        mp.stop();
        startActivity(i);
    }

    /**
     * Paramos la musica al situar en segundo plano la aplicación
     */
    @Override
    protected void onPause() {
        super.onPause();
        mp.stop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mp = MediaPlayer.create(this, R.raw.musica_fondo_main);
        mp.start();
    }
}