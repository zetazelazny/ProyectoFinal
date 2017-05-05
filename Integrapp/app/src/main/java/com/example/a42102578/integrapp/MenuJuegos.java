package com.example.a42102578.integrapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuJuegos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_juegos);
    }

    public void IrAMemoTest(View VistaR)
    {
        Intent IrAMemoTest = new Intent(this, Memotest.class);
        startActivity(IrAMemoTest);
    }

    public void IrADecisiones(View VistaR)
    {
        Intent IrADecisiones = new Intent(this, Decisiones.class);
        startActivity(IrADecisiones);
    }

}
