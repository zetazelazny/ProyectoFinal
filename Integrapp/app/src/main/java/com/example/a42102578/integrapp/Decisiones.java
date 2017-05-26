package com.example.a42102578.integrapp;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

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
        Drawable.ConstantState CodigoImagenBesar = ContextCompat.getDrawable(this, R.drawable.abrazar).getConstantState();
        Drawable.ConstantState CodigoImagenEscupir = ContextCompat.getDrawable(this, R.drawable.abrazar).getConstantState();
        Drawable.ConstantState CodigoImagenGolpear = ContextCompat.getDrawable(this, R.drawable.abrazar).getConstantState();
        Drawable.ConstantState CodigoImagenGuiar = ContextCompat.getDrawable(this, R.drawable.abrazar).getConstantState();
        Drawable.ConstantState CodigoImagenInsultar = ContextCompat.getDrawable(this, R.drawable.abrazar).getConstantState();
        Drawable.ConstantState CodigoImagenPintar = ContextCompat.getDrawable(this, R.drawable.abrazar).getConstantState();
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
        do {
            Random Azar = new Random();
            for (int i = 0; i < 7; i++)
            {
                int Random = Azar.nextInt(7);
                VectorRandom[i] = Random;
            }
        }while(VectorRandom[0] + VectorRandom[1] + VectorRandom[2] + VectorRandom[3] + VectorRandom[4] + VectorRandom[5] + VectorRandom[6] != 21);
        ImageView Imagen = (ImageView)findViewById(R.id.Imagen);
        Context c = getApplicationContext();
        int id = c.getResources().getIdentifier("drawable/"+ VectorDrawable[VectorRandom[0]], null, c.getPackageName());
        Imagen.setImageResource(id);
    }

    public void Verificar (View VistaR)
    {
        ImageButton Boton = (ImageButton) VistaR;
        ImageView Imagen = (ImageView) findViewById(R.id.Imagen);
        Drawable.ConstantState CodImagen = Imagen.getDrawable().getConstantState();
        String Codiguito = CodImagen.toString();
        int numero = 0;
        for (int i=0; i<7;i++)
        {
            if(Codiguito.equals(VectorDrawable[i]))
            {
                numero=i;
            }
        }
        if(Boton.getId()==R.id.Bien)
        {
            if(VectorBienMal[numero])
            {
                Toast.makeText(this, "Bien", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(this, "Mal", Toast.LENGTH_SHORT).show();
            }
        }
        else{

            if(!VectorBienMal[numero])
            {
                Toast.makeText(this, "Bien", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(this, "Mal", Toast.LENGTH_SHORT).show();
            }

        }
    }


}
