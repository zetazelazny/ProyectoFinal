package com.example.a42102578.integrapp;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;


public class Gano extends AppCompatActivity
{

    int Festejo1 = View.INVISIBLE;
    int Festejo2 = View.VISIBLE;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gano);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_USER_PORTRAIT);
        //FESTEJO
        Timer timerfestejo = new Timer();
        timerfestejo.scheduleAtFixedRate(new TimerTask()
        {
            @Override
            public void run()
            {
                FuncionParaEsteHilo();
            }
        },0, 500);
    }

    public void FuncionParaEsteHilo()
    {
        Festejo1 = (Festejo1==View.VISIBLE? View.INVISIBLE : View.VISIBLE);
        Festejo2 = (Festejo2==View.VISIBLE? View.INVISIBLE : View.VISIBLE);
        this.runOnUiThread(Festejo);
    }
    private Runnable Festejo = new Runnable()
    {
        @Override
        public void run()
        {
            ImageView pose1;
            pose1 = (ImageView) findViewById(R.id.nenefestejo);
            pose1.setVisibility(Festejo1);
            ImageView pose2;
            pose2 = (ImageView) findViewById(R.id.nenebrazosextendidos);
            pose2.setVisibility(Festejo2);
        }
    };
}