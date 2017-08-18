package com.example.a42102578.integrapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;
import java.util.Vector;

public class activity_cuchas extends AppCompatActivity {

    int[] VectorRandom = new int[10];
    ImageButton Cucha1;
    ImageButton Cucha2;
    ImageButton Cucha3;
    ImageButton Cucha4;
    ImageButton Cucha5;
    ImageButton Cucha6;
    ImageButton Cucha7;
    ImageButton Cucha8;
    ImageButton Cucha9;
    ImageButton Cucha10;
    TextView Puntaje;
    TextView Vida;
    TextView Proximo;
    int Contador;
    int Puntos;
    int Vidas;
    int Suma;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuchas);

        Cucha1 = (ImageButton) findViewById(R.id.CuchaUno);
        Cucha2 = (ImageButton) findViewById(R.id.CuchaDos);
        Cucha3 = (ImageButton) findViewById(R.id.CuchaTres);
        Cucha4 = (ImageButton) findViewById(R.id.CuchaCuatro);
        Cucha5 = (ImageButton) findViewById(R.id.CuchaCinco);
        Cucha6 = (ImageButton) findViewById(R.id.CuchaSeis);
        Cucha7 = (ImageButton) findViewById(R.id.CuchaSiete);
        Cucha8 = (ImageButton) findViewById(R.id.CuchaOcho);
        Cucha9 = (ImageButton) findViewById(R.id.CuchaNueve);
        Cucha10 = (ImageButton) findViewById(R.id.CuchaDiez);
        Puntaje = (TextView) findViewById(R.id.Puntos);
        Vida = (TextView) findViewById(R.id.Vidas);
        Proximo = (TextView) findViewById(R.id.Proximo);
        for (int i = 1; i < 11; i++) {
            int j = i-1;
            VectorRandom[j] = i;
        }
        Random Azar = new Random();
        for (int i = 0; i < 10; i++) {
            int Random = Azar.nextInt(10);
            int Auxiliar;
            Auxiliar = VectorRandom[i];
            VectorRandom[i] = VectorRandom[Random];
            VectorRandom[Random] = Auxiliar;
        }
        Contador = 0;
        Puntos = 0;
        Vidas = 3;
        Proximo.setText(String.valueOf(VectorRandom[Contador]));
        Vida.setText(String.valueOf(Vidas));
    }
    public void Adivinar(View Boton)
    {
        Suma = Integer.parseInt(String.valueOf(Boton.getTag()) )+ 1;
        if (Suma == VectorRandom[Contador])
        {
            Contador++;
            Puntos = Puntos + 5;
            Ganar();
            Proximo.setText(String.valueOf(VectorRandom[Contador]));
            Puntaje.setText(String.valueOf(Puntos));

        }
        else
        {
            Contador++;
            Puntos = Puntos - 3;
            Vidas--;
            Ganar();
            Proximo.setText(String.valueOf(VectorRandom[Contador]));
            Puntaje.setText(String.valueOf(Puntos));
            Vida.setText(String.valueOf(Vidas));
        }
    }

    public void Ganar ()
    {
        if (Vidas > 0)
        {
            if(Contador > 9)
            {
                Intent aGanar = new Intent(this, Gano.class);
                startActivity(aGanar);
                finish();
            }
        }
        else
        {
            Intent aPerdiste = new Intent(this, Perder.class);
            startActivity(aPerdiste);
            finish();
        }
    }
}
