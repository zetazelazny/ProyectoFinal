package com.example.a42102578.integrapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Random;

import static com.example.a42102578.integrapp.R.drawable.feliz;

public class Memotest extends AppCompatActivity {
    int[] VectorRandom = new int[16];
    boolean[] VectorEstado = new boolean[16];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memotest);
        Random Azar = new Random();
        int Contador1 = 0;
        int Contador2 = 0;
        int Contador3 = 0;
        int Contador4 = 0;
            do {
                Contador1 = 0;
                Contador2 = 0;
                Contador3 = 0;
                Contador4 = 0;
                for (int Index = 0;Index < 16; Index++)
                    {
                     /*   VectorEstado[Index] = false;*/
                        int NumeroRandom = Azar.nextInt(4);
                        switch (Index)
                            {
                                case (0):
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
                                                        }
                                                }
                                        }
                                    break;
                                case (1):
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
                                            }

                                        }
                                    }
                                    break;
                                case (2):
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
                                            }

                                        }
                                    }
                                    break;
                                case (3):
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
                                            {if (NumeroRandom == 3)
                                            {
                                                Contador4++;
                                                VectorRandom[Index] = NumeroRandom;
                                            }
                                            }
                                        }
                                    }
                                    break;
                                case (4):
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
                                            }

                                        }
                                    }
                                    break;
                                case (5):
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
                                            }

                                        }
                                    }
                                    break;
                                case (6):
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
                                            }

                                        }
                                    }
                                    break;
                                case (7):
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
                                            }

                                        }
                                    }
                                    break;
                                case (8):
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

                                            }

                                        }
                                    }
                                    break;
                                case (9):
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
                                            }

                                        }
                                    }
                                    break;
                                case (10):
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
                                            }

                                        }
                                    }
                                    break;
                                case (11):
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
                                            }

                                        }
                                    }
                                    break;
                                case (12):
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
                                            }

                                        }
                                    }
                                    break;
                                case (13):
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
                                            }

                                        }
                                    }
                                    break;
                                case (14):
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
                                            }

                                        }
                                    }
                                    break;
                                case (15):
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
                                            }
                                        }
                                    }
                                    break;
                            }
                    }
            }while (Contador1 != 4 || Contador2 != 4 || Contador3 != 4 || Contador4 != 4);
    }

    public void Girar (View VistaR)
        {
            ImageButton Boton = (ImageButton)VistaR;
            int Tag =(Integer)Boton.getTag();
            if (VectorRandom[Tag] == 0)
                {
                    VectorEstado[Tag] = true;
                    Boton.setImageResource(R.drawable.feliz);
                }
            if (VectorRandom[Tag] == 1)
                {
                    VectorEstado[Tag] = true;
                    Boton.setImageResource(R.drawable.feliz);
                }
            if (VectorRandom[Tag] == 2)
                {

                    VectorEstado[Tag] = true;
                    Boton.setImageResource(R.drawable.feliz);
                }
            if (VectorRandom[Tag] == 3)
                {
                    VectorEstado[Tag] = true;
                    Boton.setImageResource(R.drawable.feliz);
                }
        }
}
