package com.example.a42102578.integrapp;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuJuegos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_juegos);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    public void IrAMemoTest(View VistaR)
    {
        Intent IrAMemoTest = new Intent(this, Memotest.class);
        startActivity(IrAMemoTest);
    }

    public void IrADecisiones(View VistaR)
    {
        Intent IrADecisiones = new Intent(this, Conceptos.class);
        startActivity(IrADecisiones);
    }

    public void IrACocos (View VistaR)
    {
        Intent IrACocos = new Intent(this, Pelotas.class);
        startActivity(IrACocos);
    }

    public void IrACuchas (View Vista)
    {
        Intent IrACuchas = new Intent(this, activity_cuchas.class);
        startActivity(IrACuchas);
    }

}
