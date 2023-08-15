package com.example.tarea04pmdmzervamorenoalexandre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class PaintActivity extends AppCompatActivity implements View.OnClickListener {

    Lienzo lienzo;
    ImageButton negro,rojo,oro,star,cara;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paint);

        negro = findViewById(R.id.paint_black);
        rojo= findViewById(R.id.paint_red);
        oro = findViewById(R.id.paint_yellow);
        star = findViewById(R.id.paint_star);
        cara = findViewById(R.id.paint_face);
        lienzo = findViewById(R.id.lienzo);

        //Listeners para cada uno de los botones de herramientas
        negro.setOnClickListener(this);
        rojo.setOnClickListener(this);
        oro.setOnClickListener(this);
        star.setOnClickListener(this);
        cara.setOnClickListener(this);

        // Por defecto el pincel es el circulo amarillo
        negro.setBackgroundColor(Color.GRAY);


    }

    public void goMainActivity(View view) {
        startActivity(new Intent(PaintActivity.this,MainActivity.class));
    }

    public void cleanPaint(View view) {
        lienzo.clean();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.paint_black:
                lienzo.setPincel(1);
                negro.setBackgroundColor(Color.GRAY);
                rojo.setBackgroundColor(Color.DKGRAY);
                oro.setBackgroundColor(Color.DKGRAY);
                star.setBackgroundColor(Color.DKGRAY);
                cara.setBackgroundColor(Color.DKGRAY);
                break;
            case R.id.paint_red:
                lienzo.setPincel(2);
                negro.setBackgroundColor(Color.DKGRAY);
                rojo.setBackgroundColor(Color.GRAY);
                oro.setBackgroundColor(Color.DKGRAY);
                star.setBackgroundColor(Color.DKGRAY);
                cara.setBackgroundColor(Color.DKGRAY);
                break;
            case R.id.paint_yellow:
                lienzo.setPincel(3);
                negro.setBackgroundColor(Color.DKGRAY);
                rojo.setBackgroundColor(Color.DKGRAY);
                oro.setBackgroundColor(Color.DKGRAY);
                star.setBackgroundColor(Color.DKGRAY);
                cara.setBackgroundColor(Color.DKGRAY);
                break;

            case R.id.paint_star:
                lienzo.setPincel(4);
                negro.setBackgroundColor(Color.DKGRAY);
                rojo.setBackgroundColor(Color.DKGRAY);
                oro.setBackgroundColor(Color.DKGRAY);
                star.setBackgroundColor(Color.GRAY);
                cara.setBackgroundColor(Color.DKGRAY);
                break;
            case R.id.paint_face:
                lienzo.setPincel(5);
                negro.setBackgroundColor(Color.DKGRAY);
                rojo.setBackgroundColor(Color.DKGRAY);
                oro.setBackgroundColor(Color.DKGRAY);
                star.setBackgroundColor(Color.DKGRAY);
                cara.setBackgroundColor(Color.GRAY);
                break;
            default:
                break;
        }

    }
}