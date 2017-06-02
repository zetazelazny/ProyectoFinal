package com.example.a42102578.integrapp;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class Perder extends AppCompatActivity {

    int Perdio1 = View.INVISIBLE;
    int Perdio2 = View.VISIBLE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perder);
        Timer timerfestejo = new Timer();
        timerfestejo.scheduleAtFixedRate(new TimerTask()
        {
            @Override
            public void run()
            {
                FuncionParaEsteHilo();
            }
        },0, 500);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    public void FuncionParaEsteHilo()
    {
        Perdio1 = (Perdio1==View.VISIBLE? View.INVISIBLE : View.VISIBLE);
        Perdio2 = (Perdio2==View.VISIBLE? View.INVISIBLE : View.VISIBLE);
        this.runOnUiThread(Perdio);
    }
    private Runnable Perdio = new Runnable()
    {
        @Override
        public void run()
        {
            ImageView pose1;
            pose1 = (ImageView) findViewById(R.id.ojosabiertos);
            pose1.setVisibility(Perdio1);
            ImageView pose2;
            pose2 = (ImageView) findViewById(R.id.ojoscerrados);
            pose2.setVisibility(Perdio2);
        }
    };
}
