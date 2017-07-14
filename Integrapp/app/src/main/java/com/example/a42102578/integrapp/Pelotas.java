package com.example.a42102578.integrapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.cocos2d.opengl.CCGLSurfaceView;

public class Pelotas extends AppCompatActivity {

    CCGLSurfaceView VistaPelotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        VistaPelotas= new CCGLSurfaceView(this);
        setContentView(VistaPelotas);
    }
}
