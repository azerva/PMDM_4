package com.example.tarea04pmdmzervamorenoalexandre.entidades;


/**
 * Objeto que usaremos para guardar las coordenadas y la información que vayamos generando
 */
public class Pincel {
    private float posX;
    private float posY;
    private int tipoPincel;


    public Pincel(float posX, float posY, int tipoPincel)
    {
        this.posX = posX;
        this.posY = posY;
        this.tipoPincel = tipoPincel;
    }

    public float GetPosX()
    {
        return posX;
    }

    public float GetPosY()
    {
        return posY;
    }

    public int GetTipoPincel()
    {
        return tipoPincel;
    }
}
