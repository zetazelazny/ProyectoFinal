package com.example.a42102578.integrapp;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;
import java.util.Vector;

public class Decisiones extends AppCompatActivity {
    String[] VectorDrawable = new String[7];
    int[] VectorRandom = new int[7];
    Boolean[] VectorBienMal = new Boolean[7];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decisiones);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Drawable.ConstantState CodigoImagenAbrazar = ContextCompat.getDrawable(this, R.drawable.abrazar).getConstantState();
        Drawable.ConstantState CodigoImagenBesar = ContextCompat.getDrawable(this, R.drawable.besar).getConstantState();
        Drawable.ConstantState CodigoImagenEscupir = ContextCompat.getDrawable(this, R.drawable.escupir).getConstantState();
        Drawable.ConstantState CodigoImagenGolpear = ContextCompat.getDrawable(this, R.drawable.golpear).getConstantState();
        Drawable.ConstantState CodigoImagenGuiar = ContextCompat.getDrawable(this, R.drawable.guiar).getConstantState();
        Drawable.ConstantState CodigoImagenInsultar = ContextCompat.getDrawable(this, R.drawable.insultar).getConstantState();
        Drawable.ConstantState CodigoImagenPintar = ContextCompat.getDrawable(this, R.drawable.pintar).getConstantState();
        String ImagenAbrazar = String.valueOf(CodigoImagenAbrazar);
        String ImagenBesar = String.valueOf(CodigoImagenBesar);
        String ImagenEscupir = String.valueOf(CodigoImagenEscupir);
        String ImagenGolpear = String.valueOf(CodigoImagenGolpear);
        String ImagenGuiar = String.valueOf(CodigoImagenGuiar);
        String ImagenInsultar = String.valueOf(CodigoImagenInsultar);
        String ImagenPintar = String.valueOf(CodigoImagenPintar);
        VectorDrawable[0] = (ImagenAbrazar);
        VectorDrawable[1] = (ImagenBesar);
        VectorDrawable[2] = (ImagenEscupir);
        VectorDrawable[3] = (ImagenGolpear);
        VectorDrawable[4] = (ImagenGuiar);
        VectorDrawable[5] = (ImagenInsultar);
        VectorDrawable[6] = (ImagenPintar);
        VectorBienMal[0] = true;
        VectorBienMal[1] = true;
        VectorBienMal[2] = false;
        VectorBienMal[3] = false;
        VectorBienMal[4] = true;
        VectorBienMal[5] = false;
        VectorBienMal[6] = true;
        for (int i = 0; i < 7; i++)
        {
            VectorRandom[i] = i;
        }
        Random Azar = new Random();
        for (int i = 0; i < 7; i++)
        {
            int Random = Azar.nextInt(7);
            int Auxiliar;
            Auxiliar = VectorRandom[i];
            VectorRandom[i] = VectorRandom[Random];
            VectorRandom[Random] = Auxiliar;
        }
        ImageView Imagen = (ImageView)findViewById(R.id.Imagen);
        switch (VectorRandom[0])
        {
            case (0):
                Imagen.setImageResource(R.drawable.abrazar);
                break;

            case (1):
                Imagen.setImageResource(R.drawable.besar);
                break;

            case (2):
                Imagen.setImageResource(R.drawable.escupir);
                break;

            case (3):
                Imagen.setImageResource(R.drawable.golpear);
                break;

            case (4):
                Imagen.setImageResource(R.drawable.guiar);
                break;

            case (5):
                Imagen.setImageResource(R.drawable.insultar);
                break;

            case (6):
                Imagen.setImageResource(R.drawable.pintar);
                break;
        }
    }

    public void Verificar (View Vista)
    {

    }


}
