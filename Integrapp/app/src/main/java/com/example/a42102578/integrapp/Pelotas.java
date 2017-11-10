package com.example.a42102578.integrapp;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.cocos2d.opengl.CCGLSurfaceView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Pelotas extends AppCompatActivity {

    CCGLSurfaceView VistaPelotas;
    String IDs;
    String fecha;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        VistaPelotas= new CCGLSurfaceView(this);
        setContentView(VistaPelotas);
        Bundle ID = getIntent().getExtras();
        IDs = ID.getString("id");
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        fecha = date.format(new Date());
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        clsPelotas juegoPelotas;
        juegoPelotas = new clsPelotas (VistaPelotas, this, IDs, fecha);
        juegoPelotas.ComenzarJuego();

    }

    @Override
    public void onBackPressed()
    {
        finish();   // code here to show dialog
        super.onBackPressed();  // optional depending on your needs
    }

}