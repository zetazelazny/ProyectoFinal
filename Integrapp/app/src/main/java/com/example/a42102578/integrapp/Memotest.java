package com.example.a42102578.integrapp;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Memotest extends AppCompatActivity {
    int[] VectorRandom = new int[16];
    boolean[] VectorEstado = new boolean[16];
    ImageButton[] VectorBotones = new ImageButton[16];
    boolean[] Adivinados = new boolean[16];
    int ContadorValidar = 0;
    int ContPuntos = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memotest);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        Random Azar = new Random();
        ImageButton Bot;
        int Contador1 = 0;
        int Contador2 = 0;
        int Contador3 = 0;
        int Contador4 = 0;
        int Contador5 = 0;
        int Contador6 = 0;
        int Contador7 = 0;
        int Contador8 = 0;
            do {
                Contador1 = 0;
                Contador2 = 0;
                Contador3 = 0;
                Contador4 = 0;
                Contador5 = 0;
                Contador6 = 0;
                Contador7 = 0;
                Contador8 = 0;
                for (int Index = 0;Index < 16; Index++)
                    {
                     /*   VectorEstado[Index] = false;*/
                        int NumeroRandom = Azar.nextInt(8);
                        switch (Index)
                            {
                                case (0):
                                    Bot = (ImageButton)findViewById(R.id.BotonUno);
                                    VectorBotones[0] = Bot;
                                    if (NumeroRandom == 0)
                                        {
                                            Contador1++;
                                            VectorRandom[Index] = NumeroRandom;
                                        }
                                    else
                                        {
                                            if (NumeroRandom == 1)
                                                {
                                                    Contador2++;
                                                    VectorRandom[Index] = NumeroRandom;
                                                }
                                                else
                                                {
                                                    if (NumeroRandom == 2)
                                                        {
                                                            Contador3++;
                                                            VectorRandom[Index] = NumeroRandom;
                                                        }
                                                        else
                                                        {
                                                            if (NumeroRandom == 3)
                                                            {
                                                                Contador4++;
                                                                VectorRandom[Index] = NumeroRandom;
                                                            }
                                                                else
                                                            {
                                                                if (NumeroRandom == 4)
                                                                {
                                                                    Contador5++;
                                                                    VectorRandom[Index] = NumeroRandom;
                                                                }
                                                                else
                                                                {
                                                                    if (NumeroRandom == 5)
                                                                    {
                                                                        Contador6++;
                                                                        VectorRandom[Index] = NumeroRandom;
                                                                    }
                                                                    else
                                                                    {
                                                                        if (NumeroRandom == 6)
                                                                        {
                                                                            Contador7++;
                                                                            VectorRandom[Index] = NumeroRandom;
                                                                        }
                                                                        else
                                                                        {
                                                                            if (NumeroRandom == 7)
                                                                            {
                                                                                Contador8++;
                                                                                VectorRandom[Index] = NumeroRandom;
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                }
                                        }
                                    break;
                                case (1):
                                    Bot = (ImageButton)findViewById(R.id.BotonDos);
                                    VectorBotones[1] = Bot;
                                    if (NumeroRandom == 0)
                                    {
                                        Contador1++;
                                        VectorRandom[Index] = NumeroRandom;
                                    }
                                    else
                                    {
                                        if (NumeroRandom == 1)
                                        {
                                            Contador2++;
                                            VectorRandom[Index] = NumeroRandom;
                                        }
                                        else
                                        {
                                            if (NumeroRandom == 2)
                                            {
                                                Contador3++;
                                                VectorRandom[Index] = NumeroRandom;
                                            }
                                            else
                                            {
                                                if (NumeroRandom == 3)
                                                {
                                                    Contador4++;
                                                    VectorRandom[Index] = NumeroRandom;
                                                }
                                                else
                                                {
                                                    if (NumeroRandom == 4)
                                                    {
                                                        Contador5++;
                                                        VectorRandom[Index] = NumeroRandom;
                                                    }
                                                    else
                                                    {
                                                        if (NumeroRandom == 5)
                                                        {
                                                            Contador6++;
                                                            VectorRandom[Index] = NumeroRandom;
                                                        }
                                                        else
                                                        {
                                                            if (NumeroRandom == 6)
                                                            {
                                                                Contador7++;
                                                                VectorRandom[Index] = NumeroRandom;
                                                            }
                                                            else
                                                            {
                                                                if (NumeroRandom == 7)
                                                                {
                                                                    Contador8++;
                                                                    VectorRandom[Index] = NumeroRandom;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    break;
                                case (2):
                                    Bot = (ImageButton)findViewById(R.id.BotonTres);
                                    VectorBotones[2] = Bot;
                                    if (NumeroRandom == 0)
                                    {
                                        Contador1++;
                                        VectorRandom[Index] = NumeroRandom;
                                    }
                                    else
                                    {
                                        if (NumeroRandom == 1)
                                        {
                                            Contador2++;
                                            VectorRandom[Index] = NumeroRandom;
                                        }
                                        else
                                        {
                                            if (NumeroRandom == 2)
                                            {
                                                Contador3++;
                                                VectorRandom[Index] = NumeroRandom;
                                            }
                                            else
                                            {
                                                if (NumeroRandom == 3)
                                                {
                                                    Contador4++;
                                                    VectorRandom[Index] = NumeroRandom;
                                                }
                                                else
                                                {
                                                    if (NumeroRandom == 4)
                                                    {
                                                        Contador5++;
                                                        VectorRandom[Index] = NumeroRandom;
                                                    }
                                                    else
                                                    {
                                                        if (NumeroRandom == 5)
                                                        {
                                                            Contador6++;
                                                            VectorRandom[Index] = NumeroRandom;
                                                        }
                                                        else
                                                        {
                                                            if (NumeroRandom == 6)
                                                            {
                                                                Contador7++;
                                                                VectorRandom[Index] = NumeroRandom;
                                                            }
                                                            else
                                                            {
                                                                if (NumeroRandom == 7)
                                                                {
                                                                    Contador8++;
                                                                    VectorRandom[Index] = NumeroRandom;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    break;
                                case (3):
                                    Bot = (ImageButton)findViewById(R.id.BotonCuatro);
                                    VectorBotones[3] = Bot;
                                    if (NumeroRandom == 0)
                                    {
                                        Contador1++;
                                        VectorRandom[Index] = NumeroRandom;
                                    }
                                    else
                                    {
                                        if (NumeroRandom == 1)
                                        {
                                            Contador2++;
                                            VectorRandom[Index] = NumeroRandom;
                                        }
                                        else
                                        {
                                            if (NumeroRandom == 2)
                                            {
                                                Contador3++;
                                                VectorRandom[Index] = NumeroRandom;
                                            }
                                            else
                                            {
                                                if (NumeroRandom == 3)
                                                {
                                                    Contador4++;
                                                    VectorRandom[Index] = NumeroRandom;
                                                }
                                                else
                                                {
                                                    if (NumeroRandom == 4)
                                                    {
                                                        Contador5++;
                                                        VectorRandom[Index] = NumeroRandom;
                                                    }
                                                    else
                                                    {
                                                        if (NumeroRandom == 5)
                                                        {
                                                            Contador6++;
                                                            VectorRandom[Index] = NumeroRandom;
                                                        }
                                                        else
                                                        {
                                                            if (NumeroRandom == 6)
                                                            {
                                                                Contador7++;
                                                                VectorRandom[Index] = NumeroRandom;
                                                            }
                                                            else
                                                            {
                                                                if (NumeroRandom == 7)
                                                                {
                                                                    Contador8++;
                                                                    VectorRandom[Index] = NumeroRandom;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    break;
                                case (4):
                                    Bot = (ImageButton)findViewById(R.id.BotonCinco);
                                    VectorBotones[4] = Bot;
                                    if (NumeroRandom == 0)
                                    {
                                        Contador1++;
                                        VectorRandom[Index] = NumeroRandom;
                                    }
                                    else
                                    {
                                        if (NumeroRandom == 1)
                                        {
                                            Contador2++;
                                            VectorRandom[Index] = NumeroRandom;
                                        }
                                        else
                                        {
                                            if (NumeroRandom == 2)
                                            {
                                                Contador3++;
                                                VectorRandom[Index] = NumeroRandom;
                                            }
                                            else
                                            {
                                                if (NumeroRandom == 3)
                                                {
                                                    Contador4++;
                                                    VectorRandom[Index] = NumeroRandom;
                                                }
                                                else
                                                {
                                                    if (NumeroRandom == 4)
                                                    {
                                                        Contador5++;
                                                        VectorRandom[Index] = NumeroRandom;
                                                    }
                                                    else
                                                    {
                                                        if (NumeroRandom == 5)
                                                        {
                                                            Contador6++;
                                                            VectorRandom[Index] = NumeroRandom;
                                                        }
                                                        else
                                                        {
                                                            if (NumeroRandom == 6)
                                                            {
                                                                Contador7++;
                                                                VectorRandom[Index] = NumeroRandom;
                                                            }
                                                            else
                                                            {
                                                                if (NumeroRandom == 7)
                                                                {
                                                                    Contador8++;
                                                                    VectorRandom[Index] = NumeroRandom;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    break;
                                case (5):
                                    Bot = (ImageButton)findViewById(R.id.BotonSeis);
                                    VectorBotones[5] = Bot;
                                    if (NumeroRandom == 0)
                                    {
                                        Contador1++;
                                        VectorRandom[Index] = NumeroRandom;
                                    }
                                    else
                                    {
                                        if (NumeroRandom == 1)
                                        {
                                            Contador2++;
                                            VectorRandom[Index] = NumeroRandom;
                                        }
                                        else
                                        {
                                            if (NumeroRandom == 2)
                                            {
                                                Contador3++;
                                                VectorRandom[Index] = NumeroRandom;
                                            }
                                            else
                                            {
                                                if (NumeroRandom == 3)
                                                {
                                                    Contador4++;
                                                    VectorRandom[Index] = NumeroRandom;
                                                }
                                                else
                                                {
                                                    if (NumeroRandom == 4)
                                                    {
                                                        Contador5++;
                                                        VectorRandom[Index] = NumeroRandom;
                                                    }
                                                    else
                                                    {
                                                        if (NumeroRandom == 5)
                                                        {
                                                            Contador6++;
                                                            VectorRandom[Index] = NumeroRandom;
                                                        }
                                                        else
                                                        {
                                                            if (NumeroRandom == 6)
                                                            {
                                                                Contador7++;
                                                                VectorRandom[Index] = NumeroRandom;
                                                            }
                                                            else
                                                            {
                                                                if (NumeroRandom == 7)
                                                                {
                                                                    Contador8++;
                                                                    VectorRandom[Index] = NumeroRandom;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    break;
                                case (6):
                                    Bot = (ImageButton)findViewById(R.id.BotonSiete);
                                    VectorBotones[6] = Bot;
                                    if (NumeroRandom == 0)
                                    {
                                        Contador1++;
                                        VectorRandom[Index] = NumeroRandom;
                                    }
                                    else
                                    {
                                        if (NumeroRandom == 1)
                                        {
                                            Contador2++;
                                            VectorRandom[Index] = NumeroRandom;
                                        }
                                        else
                                        {
                                            if (NumeroRandom == 2)
                                            {
                                                Contador3++;
                                                VectorRandom[Index] = NumeroRandom;
                                            }
                                            else
                                            {
                                                if (NumeroRandom == 3)
                                                {
                                                    Contador4++;
                                                    VectorRandom[Index] = NumeroRandom;
                                                }
                                                else
                                                {
                                                    if (NumeroRandom == 4)
                                                    {
                                                        Contador5++;
                                                        VectorRandom[Index] = NumeroRandom;
                                                    }
                                                    else
                                                    {
                                                        if (NumeroRandom == 5)
                                                        {
                                                            Contador6++;
                                                            VectorRandom[Index] = NumeroRandom;
                                                        }
                                                        else
                                                        {
                                                            if (NumeroRandom == 6)
                                                            {
                                                                Contador7++;
                                                                VectorRandom[Index] = NumeroRandom;
                                                            }
                                                            else
                                                            {
                                                                if (NumeroRandom == 7)
                                                                {
                                                                    Contador8++;
                                                                    VectorRandom[Index] = NumeroRandom;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    break;
                                case (7):
                                    Bot = (ImageButton)findViewById(R.id.BotonOcho);
                                    VectorBotones[7] = Bot;
                                    if (NumeroRandom == 0)
                                    {
                                        Contador1++;
                                        VectorRandom[Index] = NumeroRandom;
                                    }
                                    else
                                    {
                                        if (NumeroRandom == 1)
                                        {
                                            Contador2++;
                                            VectorRandom[Index] = NumeroRandom;
                                        }
                                        else
                                        {
                                            if (NumeroRandom == 2)
                                            {
                                                Contador3++;
                                                VectorRandom[Index] = NumeroRandom;
                                            }
                                            else
                                            {
                                                if (NumeroRandom == 3)
                                                {
                                                    Contador4++;
                                                    VectorRandom[Index] = NumeroRandom;
                                                }
                                                else
                                                {
                                                    if (NumeroRandom == 4)
                                                    {
                                                        Contador5++;
                                                        VectorRandom[Index] = NumeroRandom;
                                                    }
                                                    else
                                                    {
                                                        if (NumeroRandom == 5)
                                                        {
                                                            Contador6++;
                                                            VectorRandom[Index] = NumeroRandom;
                                                        }
                                                        else
                                                        {
                                                            if (NumeroRandom == 6)
                                                            {
                                                                Contador7++;
                                                                VectorRandom[Index] = NumeroRandom;
                                                            }
                                                            else
                                                            {
                                                                if (NumeroRandom == 7)
                                                                {
                                                                    Contador8++;
                                                                    VectorRandom[Index] = NumeroRandom;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    break;
                                case (8):
                                    Bot = (ImageButton)findViewById(R.id.BotonNueve);
                                    VectorBotones[8] = Bot;
                                    if (NumeroRandom == 0)
                                    {
                                        Contador1++;
                                        VectorRandom[Index] = NumeroRandom;
                                    }
                                    else
                                    {
                                        if (NumeroRandom == 1)
                                        {
                                            Contador2++;
                                            VectorRandom[Index] = NumeroRandom;
                                        }
                                        else
                                        {
                                            if (NumeroRandom == 2)
                                            {
                                                Contador3++;
                                                VectorRandom[Index] = NumeroRandom;
                                            }
                                            else
                                            {
                                                if (NumeroRandom == 3)
                                                {
                                                    Contador4++;
                                                    VectorRandom[Index] = NumeroRandom;
                                                }
                                                else
                                                {
                                                    if (NumeroRandom == 4)
                                                    {
                                                        Contador5++;
                                                        VectorRandom[Index] = NumeroRandom;
                                                    }
                                                    else
                                                    {
                                                        if (NumeroRandom == 5)
                                                        {
                                                            Contador6++;
                                                            VectorRandom[Index] = NumeroRandom;
                                                        }
                                                        else
                                                        {
                                                            if (NumeroRandom == 6)
                                                            {
                                                                Contador7++;
                                                                VectorRandom[Index] = NumeroRandom;
                                                            }
                                                            else
                                                            {
                                                                if (NumeroRandom == 7)
                                                                {
                                                                    Contador8++;
                                                                    VectorRandom[Index] = NumeroRandom;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    break;
                                case (9):
                                    Bot = (ImageButton)findViewById(R.id.BotonDiez);
                                    VectorBotones[9] = Bot;
                                    if (NumeroRandom == 0)
                                    {
                                        Contador1++;
                                        VectorRandom[Index] = NumeroRandom;
                                    }
                                    else
                                    {
                                        if (NumeroRandom == 1)
                                        {
                                            Contador2++;
                                            VectorRandom[Index] = NumeroRandom;
                                        }
                                        else
                                        {
                                            if (NumeroRandom == 2)
                                            {
                                                Contador3++;
                                                VectorRandom[Index] = NumeroRandom;
                                            }
                                            else
                                            {
                                                if (NumeroRandom == 3)
                                                {
                                                    Contador4++;
                                                    VectorRandom[Index] = NumeroRandom;
                                                }
                                                else
                                                {
                                                    if (NumeroRandom == 4)
                                                    {
                                                        Contador5++;
                                                        VectorRandom[Index] = NumeroRandom;
                                                    }
                                                    else
                                                    {
                                                        if (NumeroRandom == 5)
                                                        {
                                                            Contador6++;
                                                            VectorRandom[Index] = NumeroRandom;
                                                        }
                                                        else
                                                        {
                                                            if (NumeroRandom == 6)
                                                            {
                                                                Contador7++;
                                                                VectorRandom[Index] = NumeroRandom;
                                                            }
                                                            else
                                                            {
                                                                if (NumeroRandom == 7)
                                                                {
                                                                    Contador8++;
                                                                    VectorRandom[Index] = NumeroRandom;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    break;
                                case (10):
                                    Bot = (ImageButton)findViewById(R.id.BotonOnce);
                                    VectorBotones[10] = Bot;
                                    if (NumeroRandom == 0)
                                    {
                                        Contador1++;
                                        VectorRandom[Index] = NumeroRandom;
                                    }
                                    else
                                    {
                                        if (NumeroRandom == 1)
                                        {
                                            Contador2++;
                                            VectorRandom[Index] = NumeroRandom;
                                        }
                                        else
                                        {
                                            if (NumeroRandom == 2)
                                            {
                                                Contador3++;
                                                VectorRandom[Index] = NumeroRandom;
                                            }
                                            else
                                            {
                                                if (NumeroRandom == 3)
                                                {
                                                    Contador4++;
                                                    VectorRandom[Index] = NumeroRandom;
                                                }
                                                else
                                                {
                                                    if (NumeroRandom == 4)
                                                    {
                                                        Contador5++;
                                                        VectorRandom[Index] = NumeroRandom;
                                                    }
                                                    else
                                                    {
                                                        if (NumeroRandom == 5)
                                                        {
                                                            Contador6++;
                                                            VectorRandom[Index] = NumeroRandom;
                                                        }
                                                        else
                                                        {
                                                            if (NumeroRandom == 6)
                                                            {
                                                                Contador7++;
                                                                VectorRandom[Index] = NumeroRandom;
                                                            }
                                                            else
                                                            {
                                                                if (NumeroRandom == 7)
                                                                {
                                                                    Contador8++;
                                                                    VectorRandom[Index] = NumeroRandom;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    break;
                                case (11):
                                    Bot = (ImageButton)findViewById(R.id.BotonDoce);
                                    VectorBotones[11] = Bot;
                                    if (NumeroRandom == 0)
                                    {
                                        Contador1++;
                                        VectorRandom[Index] = NumeroRandom;
                                    }
                                    else
                                    {
                                        if (NumeroRandom == 1)
                                        {
                                            Contador2++;
                                            VectorRandom[Index] = NumeroRandom;
                                        }
                                        else
                                        {
                                            if (NumeroRandom == 2)
                                            {
                                                Contador3++;
                                                VectorRandom[Index] = NumeroRandom;
                                            }
                                            else
                                            {
                                                if (NumeroRandom == 3)
                                                {
                                                    Contador4++;
                                                    VectorRandom[Index] = NumeroRandom;
                                                }
                                                else
                                                {
                                                    if (NumeroRandom == 4)
                                                    {
                                                        Contador5++;
                                                        VectorRandom[Index] = NumeroRandom;
                                                    }
                                                    else
                                                    {
                                                        if (NumeroRandom == 5)
                                                        {
                                                            Contador6++;
                                                            VectorRandom[Index] = NumeroRandom;
                                                        }
                                                        else
                                                        {
                                                            if (NumeroRandom == 6)
                                                            {
                                                                Contador7++;
                                                                VectorRandom[Index] = NumeroRandom;
                                                            }
                                                            else
                                                            {
                                                                if (NumeroRandom == 7)
                                                                {
                                                                    Contador8++;
                                                                    VectorRandom[Index] = NumeroRandom;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    break;
                                case (12):
                                    Bot = (ImageButton)findViewById(R.id.BotonTrece);
                                    VectorBotones[12] = Bot;
                                    if (NumeroRandom == 0)
                                    {
                                        Contador1++;
                                        VectorRandom[Index] = NumeroRandom;
                                    }
                                    else
                                    {
                                        if (NumeroRandom == 1)
                                        {
                                            Contador2++;
                                            VectorRandom[Index] = NumeroRandom;
                                        }
                                        else
                                        {
                                            if (NumeroRandom == 2)
                                            {
                                                Contador3++;
                                                VectorRandom[Index] = NumeroRandom;
                                            }
                                            else
                                            {
                                                if (NumeroRandom == 3)
                                                {
                                                    Contador4++;
                                                    VectorRandom[Index] = NumeroRandom;
                                                }
                                                else
                                                {
                                                    if (NumeroRandom == 4)
                                                    {
                                                        Contador5++;
                                                        VectorRandom[Index] = NumeroRandom;
                                                    }
                                                    else
                                                    {
                                                        if (NumeroRandom == 5)
                                                        {
                                                            Contador6++;
                                                            VectorRandom[Index] = NumeroRandom;
                                                        }
                                                        else
                                                        {
                                                            if (NumeroRandom == 6)
                                                            {
                                                                Contador7++;
                                                                VectorRandom[Index] = NumeroRandom;
                                                            }
                                                            else
                                                            {
                                                                if (NumeroRandom == 7)
                                                                {
                                                                    Contador8++;
                                                                    VectorRandom[Index] = NumeroRandom;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    break;
                                case (13):
                                    Bot = (ImageButton)findViewById(R.id.BotonCatorce);
                                    VectorBotones[13] = Bot;
                                    if (NumeroRandom == 0)
                                    {
                                        Contador1++;
                                        VectorRandom[Index] = NumeroRandom;
                                    }
                                    else
                                    {
                                        if (NumeroRandom == 1)
                                        {
                                            Contador2++;
                                            VectorRandom[Index] = NumeroRandom;
                                        }
                                        else
                                        {
                                            if (NumeroRandom == 2)
                                            {
                                                Contador3++;
                                                VectorRandom[Index] = NumeroRandom;
                                            }
                                            else
                                            {
                                                if (NumeroRandom == 3)
                                                {
                                                    Contador4++;
                                                    VectorRandom[Index] = NumeroRandom;
                                                }
                                                else
                                                {
                                                    if (NumeroRandom == 4)
                                                    {
                                                        Contador5++;
                                                        VectorRandom[Index] = NumeroRandom;
                                                    }
                                                    else
                                                    {
                                                        if (NumeroRandom == 5)
                                                        {
                                                            Contador6++;
                                                            VectorRandom[Index] = NumeroRandom;
                                                        }
                                                        else
                                                        {
                                                            if (NumeroRandom == 6)
                                                            {
                                                                Contador7++;
                                                                VectorRandom[Index] = NumeroRandom;
                                                            }
                                                            else
                                                            {
                                                                if (NumeroRandom == 7)
                                                                {
                                                                    Contador8++;
                                                                    VectorRandom[Index] = NumeroRandom;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    break;
                                case (14):
                                    Bot = (ImageButton)findViewById(R.id.BotonQuince);
                                    VectorBotones[14] = Bot;
                                    if (NumeroRandom == 0)
                                    {
                                        Contador1++;
                                        VectorRandom[Index] = NumeroRandom;
                                    }
                                    else
                                    {
                                        if (NumeroRandom == 1)
                                        {
                                            Contador2++;
                                            VectorRandom[Index] = NumeroRandom;
                                        }
                                        else
                                        {
                                            if (NumeroRandom == 2)
                                            {
                                                Contador3++;
                                                VectorRandom[Index] = NumeroRandom;
                                            }
                                            else
                                            {
                                                if (NumeroRandom == 3)
                                                {
                                                    Contador4++;
                                                    VectorRandom[Index] = NumeroRandom;
                                                }
                                                else
                                                {
                                                    if (NumeroRandom == 4)
                                                    {
                                                        Contador5++;
                                                        VectorRandom[Index] = NumeroRandom;
                                                    }
                                                    else
                                                    {
                                                        if (NumeroRandom == 5)
                                                        {
                                                            Contador6++;
                                                            VectorRandom[Index] = NumeroRandom;
                                                        }
                                                        else
                                                        {
                                                            if (NumeroRandom == 6)
                                                            {
                                                                Contador7++;
                                                                VectorRandom[Index] = NumeroRandom;
                                                            }
                                                            else
                                                            {
                                                                if (NumeroRandom == 7)
                                                                {
                                                                    Contador8++;
                                                                    VectorRandom[Index] = NumeroRandom;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    break;
                                case (15):
                                    Bot = (ImageButton)findViewById(R.id.BotonDieciseis);
                                    VectorBotones[15] = Bot;
                                    if (NumeroRandom == 0)
                                    {
                                        Contador1++;
                                        VectorRandom[Index] = NumeroRandom;
                                    }
                                    else
                                    {
                                        if (NumeroRandom == 1)
                                        {
                                            Contador2++;
                                            VectorRandom[Index] = NumeroRandom;
                                        }
                                        else
                                        {
                                            if (NumeroRandom == 2)
                                            {
                                                Contador3++;
                                                VectorRandom[Index] = NumeroRandom;
                                            }
                                            else
                                            {
                                                if (NumeroRandom == 3)
                                                {
                                                    Contador4++;
                                                    VectorRandom[Index] = NumeroRandom;
                                                }
                                                else
                                                {
                                                    if (NumeroRandom == 4)
                                                    {
                                                        Contador5++;
                                                        VectorRandom[Index] = NumeroRandom;
                                                    }
                                                    else
                                                    {
                                                        if (NumeroRandom == 5)
                                                        {
                                                            Contador6++;
                                                            VectorRandom[Index] = NumeroRandom;
                                                        }
                                                        else
                                                        {
                                                            if (NumeroRandom == 6)
                                                            {
                                                                Contador7++;
                                                                VectorRandom[Index] = NumeroRandom;
                                                            }
                                                            else
                                                            {
                                                                if (NumeroRandom == 7)
                                                                {
                                                                    Contador8++;
                                                                    VectorRandom[Index] = NumeroRandom;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    break;
                            }
                    }
            }while (Contador1 != 2 || Contador2 != 2 || Contador3 != 2 || Contador4 != 2 || Contador5 != 2 || Contador6 != 2 || Contador7 != 2 || Contador8 != 2);
    }

    public void Girar (View VistaR)
        {
            TextView Puntaje = (TextView) findViewById(R.id.Puntos);
            ImageButton Boton = (ImageButton)VistaR;
            boolean Estado;
            int Tag = Integer.parseInt(String.valueOf(Boton.getTag()));
            if (VectorRandom[Tag] == 0)
                {
                    ContadorValidar++;
                    if (ContadorValidar <= 2)
                    {   Boton.setImageResource(R.drawable.asustado);
                        VectorEstado[Tag] = true;
                        Estado = Validar(ContadorValidar);
                        if (Estado)
                        {
                            ContPuntos++;
                            Puntaje.setText(String.valueOf(ContPuntos));
                        }
                        else
                        {
                            if (ContadorValidar == 2)
                            {

                            }
                        }
                    }
                }
            if (VectorRandom[Tag] == 1)
            {
                ContadorValidar++;
                if (ContadorValidar <= 2)
                {
                    Boton.setImageResource(R.drawable.contento);
                    VectorEstado[Tag] = true;
                    Estado = Validar(ContadorValidar);
                    if (Estado)
                    {
                        ContPuntos++;
                        Puntaje.setText(String.valueOf(ContPuntos));
                    }
                }
            }
            if (VectorRandom[Tag] == 2)
            {
                ContadorValidar++;
                if (ContadorValidar <= 2)
                {
                    Boton.setImageResource(R.drawable.dormido);
                    VectorEstado[Tag] = true;
                    Estado = Validar(ContadorValidar);
                    if (Estado)
                    {
                        ContPuntos++;
                        Puntaje.setText(String.valueOf(ContPuntos));
                    }
                }
            }
            if (VectorRandom[Tag] == 3)
            {
                ContadorValidar++;
                if (ContadorValidar <= 2)
                {
                    Boton.setImageResource(R.drawable.enamorado);
                    VectorEstado[Tag] = true;
                    Estado = Validar(ContadorValidar);
                    if (Estado)
                    {
                        ContPuntos++;
                        Puntaje.setText(String.valueOf(ContPuntos));
                    }
                }
            }
            if (VectorRandom[Tag] == 4)
            {
                ContadorValidar++;
                if (ContadorValidar <= 2)
                {
                    Boton.setImageResource(R.drawable.enojado);
                    VectorEstado[Tag] = true;
                    Estado = Validar(ContadorValidar);
                    if (Estado)
                    {
                        ContPuntos++;
                        Puntaje.setText(String.valueOf(ContPuntos));
                    }
                }
            }
            if (VectorRandom[Tag] == 5)
            {
                ContadorValidar++;
                if (ContadorValidar <= 2)
                {
                    Boton.setImageResource(R.drawable.llorando);
                    VectorEstado[Tag] = true;
                    Estado = Validar(ContadorValidar);
                    if (Estado)
                    {
                        ContPuntos++;
                        Puntaje.setText(String.valueOf(ContPuntos));
                    }
                }
            }
            if (VectorRandom[Tag] == 6)
            {
                ContadorValidar++;
                if (ContadorValidar <= 2)
                {
                    Boton.setImageResource(R.drawable.sonriente);
                    VectorEstado[Tag] = true;
                    Estado = Validar(ContadorValidar);
                    if (Estado)
                    {
                        ContPuntos++;
                        Puntaje.setText(String.valueOf(ContPuntos));
                    }
                }
            }
            if (VectorRandom[Tag] == 7)
            {
                ContadorValidar++;
                if (ContadorValidar <= 2)
                {
                    Boton.setImageResource(R.drawable.sorprendido);
                    VectorEstado[Tag] = true;
                    Estado = Validar(ContadorValidar);
                    if (Estado)
                    {
                        ContPuntos++;
                        Puntaje.setText(String.valueOf(ContPuntos));
                    }
                }
            }

        }

        Boolean Validar (int Cont)
        {
            Boolean Validate = false;
            if (Cont == 2)
            {
                int[] VecImagenes = new int[2];
                int[] VecPos = new int[2];
                int Contador = 0;
                for (int i = 0; i < VectorEstado.length; i++)
                {
                    if (VectorEstado[i])
                    {
                        VecImagenes[Contador] = VectorRandom[i];
                        VecPos[Contador] = i;
                        Contador++;
                    }
                }
                if (VecImagenes[0] == VecImagenes[1])
                {
                    Validate = true;
                    for(int i = 0; i < VectorEstado.length; i++)
                    {
                        if(i != VecPos[0] && i != VecPos[1])
                        {
                            VectorEstado[i] = false;
                            VectorBotones[i].setImageResource(R.drawable.cuadrado);
                        }
                    }
                }
                else
                {
                    for (int i = 0; i < VectorEstado.length; i++)
                    {
                        VectorEstado[i] = false;
                        VectorBotones[i].setImageResource(R.drawable.cuadrado);
                    }
                }
                ContadorValidar = 0;
            }
            return Validate;
        }

}
