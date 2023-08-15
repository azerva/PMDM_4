package com.example.tarea04pmdmzervamorenoalexandre;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.tarea04pmdmzervamorenoalexandre.entidades.Pincel;

import java.util.ArrayList;

public class Lienzo extends View {
    /*
    Guardamos el pincel actual que por defecto contendrá el color negro
     */
    private int tipopincel = 1;

    /**
     * Array para el almacenamiento del trazado del pincel
     */
    private ArrayList<Pincel> recorridoPincel;

    /**
     * Tipos de pincel
     */
    private Paint paint;
    private Bitmap paintStar;
    private Bitmap paintFotoCara;

    public Lienzo(Context context, AttributeSet attrs) {
        super(context,attrs);
        /**
         * Iniciamos el array para guardar el recorrido del pincel
         */
        recorridoPincel = new ArrayList<>();

        /**
         * Iniciamos los pinceles para diujar en el lienzo
         */
        paint = new Paint();
        paintFotoCara = BitmapFactory.decodeResource(context.getResources(),R.drawable.foto_cara);
        paintStar = BitmapFactory.decodeResource(context.getResources(),R.drawable.star);

    }
    /**
     * Método que recoge los eventos que se realizan durante la pulsación y el moviemiento
     * reazlizados en el lienzo.
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if(event.getAction()==MotionEvent.ACTION_DOWN || event.getAction()==MotionEvent.ACTION_MOVE)
        {
            // Registramos las coordenadas X Y
            float touchX = event.getX();
            float touchY = event.getY();
            // Guardamos el tipo de pincel seleccionado en las coordenadas XY
            Pincel punto = new Pincel(touchX,touchY,tipopincel);
            // Añadimos el recorrido para posteriormente pintarlo en el lienzo
            recorridoPincel.add(punto);
            // Repintamos el lienzo
            this.invalidate();
        }
        return true;
    }

    /**
     * Pintamos la vista
     */
    @Override
    protected void onDraw(Canvas canvas)
    {
        /*
            Primero limpiamos el lienzo y lo pintamos entero de color blanco, aunque no es
            preciso realizar esta acción.
         */
        //canvas.drawColor(Color.TRANSPARENT);

        if(recorridoPincel.isEmpty()==false)
        {
            /**
             * Si el vector no está vacío, lo recorremos entero
             */
            for (int i = 0; i < recorridoPincel.size(); i++)
            {
                Pincel p = recorridoPincel.get(i);

                /**
                 * Para cada punto de pintura comprobamos el tipo de pincel y lo pintamos en las
                 * coordenadas XY correspondientes
                 */

                switch (p.GetTipoPincel()) {
                    case 1:
                        paint.setColor(Color.BLACK);
                        canvas.drawCircle(p.GetPosX(), p.GetPosY(), 15, paint);
                        break;
                    case 2:
                        paint.setColor(Color.RED);
                        canvas.drawCircle(p.GetPosX(), p.GetPosY(), 15, paint);
                        break;
                    case 3:
                        paint.setColor(Color.parseColor("#ffca18"));
                        canvas.drawCircle(p.GetPosX(), p.GetPosY(), 15, paint);
                        break;
                    case 4:
                        canvas.drawBitmap(paintStar, p.GetPosX(), p.GetPosY(), null);
                        break;
                    case 5:
                        canvas.drawBitmap(paintFotoCara, p.GetPosX(), p.GetPosY(), null);
                        break;
                }
            }
        }
    }

    /**
     * Método para cambiar el pincel
     * @param tipoPincel Cambiamos de pincel
     */
    public void setPincel(int tipoPincel)
    {
        this.tipopincel = tipoPincel;
    }

    /**
     * Limpiamos el dibujo del lienzo
     */
    public void clean()
    {
        // Primero vaciamos el vector de pintura
        recorridoPincel.clear();
        // Repintamos el lienzo con el vector vacío
        this.invalidate();
    }
}
