package com.example.a42102578.integrapp;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class MenuPrincipal extends AppCompatActivity {

    int OjosAbiertos = View.INVISIBLE;
    int OjosCerrados = View.VISIBLE;
    int Seniala = View.VISIBLE;
    int Saluda = View.INVISIBLE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuprincipal);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Timer timerparpadeo = new Timer();
        timerparpadeo.scheduleAtFixedRate(new TimerTask()
        {
            @Override
            public void run()
            {
                FuncionParaEsteHilo();
            }
        },0, 500);
    }

    public void IrAMenuJuegos (View Vista)
    {
        Intent MenuJuegos = new Intent (this, MenuJuegos.class);
        startActivity(MenuJuegos);
    }
    // ---------------------PARPADEO-------------------
     public void FuncionParaEsteHilo()
    {
        OjosAbiertos = (OjosAbiertos== View.VISIBLE ? View.INVISIBLE: View.VISIBLE);
        OjosCerrados = (OjosCerrados== View.VISIBLE ? View.INVISIBLE: View.VISIBLE);
        this.runOnUiThread(Parpadeo);
    }

    private Runnable Parpadeo = new Runnable()
    {
        public void run()

        {   ImageView nenedefault;
            nenedefault = (ImageView) findViewById(R.id.nenedefault);
            nenedefault.setVisibility(OjosAbiertos);
            ImageView neneojoscerrados;
            neneojoscerrados = (ImageView) findViewById(R.id.neneojoscerrados);
            neneojoscerrados.setVisibility(OjosCerrados);
        }
    };
    // ---------------------FIN PARPADEO-------------------
    //---------------------SALUDO--------------------------
    public void Saludar (View Vista)
    {
        ImageView nenedefault;
        nenedefault = (ImageView) findViewById(R.id.nenedefault);
        nenedefault.setVisibility(View.INVISIBLE);
        Timer timersaludo = new Timer();
        timersaludo.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run()
            {
                FuncionParaEsteHiloSaludo();
            }
        }, 0, 500);
    }

    public void FuncionParaEsteHiloSaludo()
    {
        Seniala = (Seniala== View.VISIBLE ? View.INVISIBLE: View.VISIBLE);
        Saluda  = (Saluda== View.VISIBLE ? View.INVISIBLE: View.VISIBLE);
        this.runOnUiThread(Saludo);
    }

    private Runnable Saludo = new Runnable() {
        @Override
        public void run()
        {
            ImageView neneseniala;
            neneseniala = (ImageView) findViewById(R.id.nenesenialando);
            neneseniala.setVisibility(Seniala);
            ImageView nenesaluda;
            nenesaluda = (ImageView) findViewById(R.id.nenesaludando);
            nenesaluda.setVisibility(Saluda);
        }
    };
    //-----------------FIN SALUDO---------------------------


}

