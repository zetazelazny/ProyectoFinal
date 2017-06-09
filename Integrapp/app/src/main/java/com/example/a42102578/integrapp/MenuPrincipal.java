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

    //ints de visibilidad
    int OjosAbiertos = View.INVISIBLE;
    int OjosCerrados = View.VISIBLE;
    int Seniala = View.INVISIBLE;
    int Saluda = View.VISIBLE;
    int Llora1 = View.INVISIBLE;
    int Llora2 = View.VISIBLE;
    int Rie1 = View.INVISIBLE;
    int Rie2 = View.VISIBLE;

    //timers
    Timer timerparpadeo = new Timer();
    Timer timersaludo = new Timer();
    Timer timerrisa = new Timer();
    Timer timerllanto = new Timer();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuprincipal);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
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
       /* ImageView nenedefault;
        nenedefault = (ImageView) findViewById(R.id.nenedefault);
        nenedefault.setVisibility(View.INVISIBLE);
        ImageView neneojoscerrados;
        neneojoscerrados = (ImageView) findViewById(R.id.neneojoscerrados);
        neneojoscerrados.setVisibility(View.INVISIBLE);
        ImageView nenellorandoabajo;
        nenellorandoabajo = (ImageView) findViewById(R.id.nenellorandobajo);
        nenellorandoabajo.setVisibility(View.INVISIBLE);
        ImageView nenellorandoarriba;
        nenellorandoarriba = (ImageView) findViewById(R.id.nenellorandoarriba);
        nenellorandoarriba.setVisibility(View.INVISIBLE);
        ImageView neneriendo1;
        neneriendo1 = (ImageView) findViewById(R.id.nenerie);
        neneriendo1.setVisibility(View.INVISIBLE);
        ImageView neneriendo2;
        neneriendo2 = (ImageView) findViewById(R.id.nenerie2);
        neneriendo2.setVisibility(View.INVISIBLE); */

       /* timerparpadeo.cancel();
        timerllanto.cancel();
        timerrisa.cancel();*/


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

    //------------------RISA---------------------------------
    public void Reir (View Vista)
    {
       /* ImageView nenedefault;
        nenedefault = (ImageView) findViewById(R.id.nenedefault);
        nenedefault.setVisibility(View.INVISIBLE);
        ImageView neneojoscerrados;
        neneojoscerrados = (ImageView) findViewById(R.id.neneojoscerrados);
        neneojoscerrados.setVisibility(View.INVISIBLE);
        ImageView neneseniala;
        neneseniala = (ImageView) findViewById(R.id.nenesenialando);
        neneseniala.setVisibility(View.INVISIBLE);
        ImageView nenesaluda;
        nenesaluda = (ImageView) findViewById(R.id.nenesaludando);
        nenesaluda.setVisibility(View.INVISIBLE);
        ImageView nenellorandoabajo;
        nenellorandoabajo = (ImageView) findViewById(R.id.nenellorandobajo);
        nenellorandoabajo.setVisibility(View.INVISIBLE);
        ImageView nenellorandoarriba;
        nenellorandoarriba = (ImageView) findViewById(R.id.nenellorandoarriba);
        nenellorandoarriba.setVisibility(View.INVISIBLE); */

        /*timerparpadeo.cancel();
        timersaludo.cancel();
        timerllanto.cancel();*/

        timerrisa.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run()
            {
                FuncionParaEsteHiloRisa();
            }
        }, 0, 500);
    }

    public void FuncionParaEsteHiloRisa()
    {
        Rie1 = (Rie1== View.VISIBLE ? View.INVISIBLE: View.VISIBLE);
        Rie2  = (Rie2== View.VISIBLE ? View.INVISIBLE: View.VISIBLE);
        this.runOnUiThread(Risa);
    }

    private Runnable Risa = new Runnable() {
        @Override
        public void run()
        {
            ImageView neneriendo1;
            neneriendo1 = (ImageView) findViewById(R.id.nenerie);
            neneriendo1.setVisibility(Rie1);
            ImageView neneriendo2;
            neneriendo2 = (ImageView) findViewById(R.id.nenerie2);
            neneriendo2.setVisibility(Rie2);
        }
    };

    //------------------FIN RISA-----------------------------

    //----------------LLANTO----------------------------------
    public void Llorar (View Vista)
    {
        /*ImageView nenedefault;
        nenedefault = (ImageView) findViewById(R.id.nenedefault);
        nenedefault.setVisibility(View.INVISIBLE);
        ImageView neneojoscerrados;
        neneojoscerrados = (ImageView) findViewById(R.id.neneojoscerrados);
        neneojoscerrados.setVisibility(View.INVISIBLE);
        ImageView neneseniala;
        neneseniala = (ImageView) findViewById(R.id.nenesenialando);
        neneseniala.setVisibility(View.INVISIBLE);
        ImageView nenesaluda;
        nenesaluda = (ImageView) findViewById(R.id.nenesaludando);
        nenesaluda.setVisibility(View.INVISIBLE);
        ImageView neneriendo1;
        neneriendo1 = (ImageView) findViewById(R.id.nenerie);
        neneriendo1.setVisibility(View.INVISIBLE);
        ImageView neneriendo2;
        neneriendo2 = (ImageView) findViewById(R.id.nenerie2);
        neneriendo2.setVisibility(View.INVISIBLE); */

        /*timerparpadeo.cancel();
        timersaludo.cancel();
        timerrisa.cancel();*/

        timerllanto.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run()
            {
                FuncionParaEsteHiloLlanto();
            }
        }, 0, 500);
    }

    public void FuncionParaEsteHiloLlanto()
    {
        Llora1 = (Llora1== View.VISIBLE ? View.INVISIBLE: View.VISIBLE);
        Llora2  = (Llora2 == View.VISIBLE ? View.INVISIBLE: View.VISIBLE);
        this.runOnUiThread(Llanto);
    }

    private Runnable Llanto = new Runnable() {
        @Override
        public void run()
        {
            ImageView nenellorandoabajo;
            nenellorandoabajo = (ImageView) findViewById(R.id.nenellorandobajo);
            nenellorandoabajo.setVisibility(Llora1);
            ImageView nenellorandoarriba;
            nenellorandoarriba = (ImageView) findViewById(R.id.nenellorandoarriba);
            nenellorandoarriba.setVisibility(Llora2);
        }
    };
    //--------------------------FIN LLANTO----------------------


}

