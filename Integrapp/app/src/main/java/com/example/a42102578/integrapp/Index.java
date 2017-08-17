package com.example.a42102578.integrapp;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import java.util.Timer;
import java.util.TimerTask;


public class Index extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    public void MenuPrincipal (View Vista)
    {
        Intent IrAMenuPrincipal = new Intent (this, MenuPrincipal.class);
        startActivity(IrAMenuPrincipal);

    }

    public void Demo(View Vista)
    {
        Intent irALista = new Intent (this, SeleccionUsuarios.class);
        startActivity(irALista);
        Log.d("Debug","Sale de la vista");
    }

  /*  public void Saludar (View Vista)
    {

        TimerTask Task;
        Task = new TimerTask() {
            @Override
            public void run() {
                ImageView Imagen = (ImageView) findViewById(R.id.imageView);
                if (Integer.parseInt(String.valueOf(Imagen.getTag()))==0)
                {
                    Imagen.setImageResource(R.drawable.nenebrazobajo);
                }
                else
                    {
                        if (Integer.parseInt(String.valueOf(Imagen.getTag()))==1)
                        {
                            Imagen.setImageResource(R.drawable.nenebrazobajo);
                        }
                    }
            }
        };
        Timer Timer;
        Timer = new Timer();
        Timer.scheduleAtFixedRate(Task, 0, 100);
    }
    */
}
