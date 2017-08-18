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
    int Aplaude = View.INVISIBLE;

    String estados="parpadeo";

    //timers
    Timer timerparpadeo = new Timer();
    Timer timersaludo = new Timer();
    Timer timerrisa = new Timer();
    Timer timerllanto = new Timer();
    Timer timeraplauso = new Timer();

    Bundle ID = getIntent().getExtras();
    int IDs = ID.getInt("id");
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
                FuncionParpadeo();
            }
        },0, 500);
    }

    //boton que va a juegos
    public void IrAMenuJuegos (View Vista)
    {
        Intent MenuJuegos = new Intent (this, MenuJuegos.class);
        MenuJuegos.putExtra("id", IDs);
        startActivity(MenuJuegos);
    }

    // ---------------------PARPADEO-------------------
    public void FuncionParpadeo()
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
    public void Saludar (View Vista) {
        //oculto las imagenes del parpadeo
        ImageView nenedefault = (ImageView) findViewById(R.id.nenedefault);
        nenedefault.setVisibility(View.INVISIBLE);
        ImageView neneojoscerrados = (ImageView) findViewById(R.id.neneojoscerrados);
        neneojoscerrados.setVisibility(View.INVISIBLE);
        //oculto las imagenes de risa
        ImageView neneriendo1 = (ImageView) findViewById(R.id.nenerie);
        neneriendo1.setVisibility(View.INVISIBLE);
        ImageView neneriendo2 = (ImageView) findViewById(R.id.nenerie2);
        neneriendo2.setVisibility(View.INVISIBLE);
        //oculto las imagenes de llanto
        ImageView nenellorandoabajo = (ImageView) findViewById(R.id.nenellorandobajo);
        nenellorandoabajo.setVisibility(View.INVISIBLE);
        ImageView nenellorandoarriba = (ImageView) findViewById(R.id.nenellorandoarriba);
        nenellorandoarriba.setVisibility(View.INVISIBLE);
        //oculto las imagenes de aplauso
        ImageView neneaplauso;
        neneaplauso = (ImageView) findViewById(R.id.neneaplauso);
        neneaplauso.setVisibility(View.INVISIBLE);


        //stop a los timers
        /*timerllanto.cancel();
        timerparpadeo.cancel();
        timerrisa.cancel();*/
        //timertask

        switch (estados)
        {
            case "parpadeo":
                timerparpadeo.cancel();
                break;
            case "risa":
                timerrisa.cancel();
                break;
            case "llanto":
                timerllanto.cancel();
                break;
            case "saludo":
                timersaludo.cancel();
                break;
            case "aplauso":
                timeraplauso.cancel();
                break;
        }
        estados = "saludo";
        timersaludo = new Timer();
        timersaludo.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                FuncionSaludo();
            }
        }, 0, 500);
    }

    public void FuncionSaludo()
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
        //oculto las imagenes del parpadeo
        ImageView nenedefault = (ImageView) findViewById(R.id.nenedefault);
        nenedefault.setVisibility(View.INVISIBLE);
        ImageView neneojoscerrados = (ImageView) findViewById(R.id.neneojoscerrados);
        neneojoscerrados.setVisibility(View.INVISIBLE);
        //oculto las imagenes de saludo
        ImageView nenesenialando = (ImageView) findViewById(R.id.nenesenialando);
        nenesenialando.setVisibility(View.INVISIBLE);
        ImageView nenesaludando = (ImageView) findViewById(R.id.nenesaludando);
        nenesaludando.setVisibility(View.INVISIBLE);
        //oculto las imagenes de llanto
        ImageView nenellorandoabajo = (ImageView) findViewById(R.id.nenellorandobajo);
        nenellorandoabajo.setVisibility(View.INVISIBLE);
        ImageView nenellorandoarriba = (ImageView) findViewById(R.id.nenellorandoarriba);
        nenellorandoarriba.setVisibility(View.INVISIBLE);
        //oculto las imagenes de aplauso
        ImageView neneaplauso;
        neneaplauso = (ImageView) findViewById(R.id.neneaplauso);
        neneaplauso.setVisibility(View.INVISIBLE);

        //stop a los timers
        switch (estados)
        {
            case "parpadeo":
                timerparpadeo.cancel();
                break;
            case "risa":
                timerrisa.cancel();
                break;
            case "llanto":
                timerllanto.cancel();
                break;
            case "saludo":
                timersaludo.cancel();
                break;
            case "aplauso":
                timeraplauso.cancel();
                break;
        }
        estados = "risa";

        //timertask
        timerrisa = new Timer();
        timerrisa.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run()
            {
                FuncionRisa();
            }
        }, 0, 500);
    };

    public void FuncionRisa()
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
        //oculto las imagenes del parpadeo
        ImageView nenedefault = (ImageView) findViewById(R.id.nenedefault);
        nenedefault.setVisibility(View.INVISIBLE);
        ImageView neneojoscerrados = (ImageView) findViewById(R.id.neneojoscerrados);
        neneojoscerrados.setVisibility(View.INVISIBLE);
        //oculto las imagenes de saludo
        ImageView nenesenialando = (ImageView) findViewById(R.id.nenesenialando);
        nenesenialando.setVisibility(View.INVISIBLE);
        ImageView nenesaludando = (ImageView) findViewById(R.id.nenesaludando);
        nenesaludando.setVisibility(View.INVISIBLE);
        //oculto las imagenes de risa
        ImageView neneriendo1 = (ImageView) findViewById(R.id.nenerie);
        neneriendo1.setVisibility(View.INVISIBLE);
        ImageView neneriendo2 = (ImageView) findViewById(R.id.nenerie2);
        neneriendo2.setVisibility(View.INVISIBLE);
        //oculto las imagenes de aplauso
        ImageView neneaplauso;
        neneaplauso = (ImageView) findViewById(R.id.neneaplauso);
        neneaplauso.setVisibility(View.INVISIBLE);

        //stop a los timers
       /*
        timerparpadeo.cancel();
        timersaludo.cancel();*/
        switch (estados)
        {
            case "parpadeo":
                timerparpadeo.cancel();
                break;
            case "risa":
                timerrisa.cancel();
                break;
            case "llanto":
                timerllanto.cancel();
                break;
            case "saludo":
                timersaludo.cancel();
                break;
            case "aplauso":
                timeraplauso.cancel();
                break;
        }
        estados = "llanto";
        timerllanto=new Timer();
        timerllanto.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run()
            {
                FuncionLlanto();
            }
        }, 0, 500);

    }

    public void FuncionLlanto()
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

    //-------------------------APLAUSO--------------------------
    public void Aplaudir (View Vista)
    {
    //oculto las imagenes del parpadeo
    ImageView neneojoscerrados = (ImageView) findViewById(R.id.neneojoscerrados);
        neneojoscerrados.setVisibility(View.INVISIBLE);
    //oculto las imagenes de saludo
    ImageView nenesenialando = (ImageView) findViewById(R.id.nenesenialando);
        nenesenialando.setVisibility(View.INVISIBLE);
    ImageView nenesaludando = (ImageView) findViewById(R.id.nenesaludando);
        nenesaludando.setVisibility(View.INVISIBLE);
    //oculto las imagenes de risa
    ImageView neneriendo1 = (ImageView) findViewById(R.id.nenerie);
        neneriendo1.setVisibility(View.INVISIBLE);
    ImageView neneriendo2 = (ImageView) findViewById(R.id.nenerie2);
        neneriendo2.setVisibility(View.INVISIBLE);
        //oculto las imagenes de llanto
        ImageView nenellorandoabajo = (ImageView) findViewById(R.id.nenellorandobajo);
        nenellorandoabajo.setVisibility(View.INVISIBLE);
        ImageView nenellorandoarriba = (ImageView) findViewById(R.id.nenellorandoarriba);
        nenellorandoarriba.setVisibility(View.INVISIBLE);

        switch (estados)
    {
        case "parpadeo":
            timerparpadeo.cancel();
            break;
        case "risa":
            timerrisa.cancel();
            break;
        case "llanto":
            timerllanto.cancel();
            break;
        case "saludo":
            timersaludo.cancel();
            break;
        case "aplauso":
            timeraplauso.cancel();
            break;
    }
    estados = "aplauso";
    timeraplauso=new Timer();
        timeraplauso.scheduleAtFixedRate(new TimerTask() {
        @Override
        public void run()
        {
            FuncionAplauso();
        }
    }, 0, 500);

}

    public void FuncionAplauso()
    {
        OjosAbiertos = (OjosAbiertos== View.VISIBLE ? View.INVISIBLE: View.VISIBLE);
        Aplaude  = (Aplaude == View.VISIBLE ? View.INVISIBLE: View.VISIBLE);
        this.runOnUiThread(Aplauso);
    }

    private Runnable Aplauso = new Runnable() {
        @Override
        public void run()
        {
            ImageView nenedefault;
            nenedefault = (ImageView) findViewById(R.id.nenedefault);
            nenedefault.setVisibility(OjosAbiertos);
            ImageView neneaplauso;
            neneaplauso = (ImageView) findViewById(R.id.neneaplauso);
            neneaplauso.setVisibility(Aplaude);
        }
    };


}

