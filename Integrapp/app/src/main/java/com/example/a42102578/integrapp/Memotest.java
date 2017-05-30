package com.example.a42102578.integrapp;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Handler;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.LogRecord;

public class Memotest extends AppCompatActivity {
    int[] VectorRandom = new int[16];
    boolean[] VectorEstado = new boolean[16];
    ImageButton[] VectorBotones = new ImageButton[16];
    int[] VectorAdivinados = new int[16];
    int ContadorVec = 0;
    int ContadorValidar = 0;
    int ContPuntos = 0;
    public int I;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memotest);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        final TextView Texto = (TextView)findViewById(R.id.Timer);
        new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                Texto.setText(String.valueOf(millisUntilFinished / 1000));
            }

            public void onFinish() {
                //Texto.setText("mogul");
                for (int i = 0; i < 16; i++)
                {
                    VectorBotones[i].setEnabled(false);
                }
            }
        }.start();

        Random Azar = new Random();
        ImageButton Bot;
        for (int i = 0; i < 16; i++) {
            VectorAdivinados[i] = 50;
        }
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
            for (int Index = 0; Index < 16; Index++) {
                     /*   VectorEstado[Index] = false;*/
                int NumeroRandom = Azar.nextInt(8);
                switch (Index) {
                    case (0):
                        Bot = (ImageButton) findViewById(R.id.BotonUno);
                        VectorBotones[0] = Bot;
                        if (NumeroRandom == 0) {
                            Contador1++;
                            VectorRandom[Index] = NumeroRandom;
                        } else {
                            if (NumeroRandom == 1) {
                                Contador2++;
                                VectorRandom[Index] = NumeroRandom;
                            } else {
                                if (NumeroRandom == 2) {
                                    Contador3++;
                                    VectorRandom[Index] = NumeroRandom;
                                } else {
                                    if (NumeroRandom == 3) {
                                        Contador4++;
                                        VectorRandom[Index] = NumeroRandom;
                                    } else {
                                        if (NumeroRandom == 4) {
                                            Contador5++;
                                            VectorRandom[Index] = NumeroRandom;
                                        } else {
                                            if (NumeroRandom == 5) {
                                                Contador6++;
                                                VectorRandom[Index] = NumeroRandom;
                                            } else {
                                                if (NumeroRandom == 6) {
                                                    Contador7++;
                                                    VectorRandom[Index] = NumeroRandom;
                                                } else {
                                                    if (NumeroRandom == 7) {
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
                        Bot = (ImageButton) findViewById(R.id.BotonDos);
                        VectorBotones[1] = Bot;
                        if (NumeroRandom == 0) {
                            Contador1++;
                            VectorRandom[Index] = NumeroRandom;
                        } else {
                            if (NumeroRandom == 1) {
                                Contador2++;
                                VectorRandom[Index] = NumeroRandom;
                            } else {
                                if (NumeroRandom == 2) {
                                    Contador3++;
                                    VectorRandom[Index] = NumeroRandom;
                                } else {
                                    if (NumeroRandom == 3) {
                                        Contador4++;
                                        VectorRandom[Index] = NumeroRandom;
                                    } else {
                                        if (NumeroRandom == 4) {
                                            Contador5++;
                                            VectorRandom[Index] = NumeroRandom;
                                        } else {
                                            if (NumeroRandom == 5) {
                                                Contador6++;
                                                VectorRandom[Index] = NumeroRandom;
                                            } else {
                                                if (NumeroRandom == 6) {
                                                    Contador7++;
                                                    VectorRandom[Index] = NumeroRandom;
                                                } else {
                                                    if (NumeroRandom == 7) {
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
                        Bot = (ImageButton) findViewById(R.id.BotonTres);
                        VectorBotones[2] = Bot;
                        if (NumeroRandom == 0) {
                            Contador1++;
                            VectorRandom[Index] = NumeroRandom;
                        } else {
                            if (NumeroRandom == 1) {
                                Contador2++;
                                VectorRandom[Index] = NumeroRandom;
                            } else {
                                if (NumeroRandom == 2) {
                                    Contador3++;
                                    VectorRandom[Index] = NumeroRandom;
                                } else {
                                    if (NumeroRandom == 3) {
                                        Contador4++;
                                        VectorRandom[Index] = NumeroRandom;
                                    } else {
                                        if (NumeroRandom == 4) {
                                            Contador5++;
                                            VectorRandom[Index] = NumeroRandom;
                                        } else {
                                            if (NumeroRandom == 5) {
                                                Contador6++;
                                                VectorRandom[Index] = NumeroRandom;
                                            } else {
                                                if (NumeroRandom == 6) {
                                                    Contador7++;
                                                    VectorRandom[Index] = NumeroRandom;
                                                } else {
                                                    if (NumeroRandom == 7) {
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
                        Bot = (ImageButton) findViewById(R.id.BotonCuatro);
                        VectorBotones[3] = Bot;
                        if (NumeroRandom == 0) {
                            Contador1++;
                            VectorRandom[Index] = NumeroRandom;
                        } else {
                            if (NumeroRandom == 1) {
                                Contador2++;
                                VectorRandom[Index] = NumeroRandom;
                            } else {
                                if (NumeroRandom == 2) {
                                    Contador3++;
                                    VectorRandom[Index] = NumeroRandom;
                                } else {
                                    if (NumeroRandom == 3) {
                                        Contador4++;
                                        VectorRandom[Index] = NumeroRandom;
                                    } else {
                                        if (NumeroRandom == 4) {
                                            Contador5++;
                                            VectorRandom[Index] = NumeroRandom;
                                        } else {
                                            if (NumeroRandom == 5) {
                                                Contador6++;
                                                VectorRandom[Index] = NumeroRandom;
                                            } else {
                                                if (NumeroRandom == 6) {
                                                    Contador7++;
                                                    VectorRandom[Index] = NumeroRandom;
                                                } else {
                                                    if (NumeroRandom == 7) {
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
                        Bot = (ImageButton) findViewById(R.id.BotonCinco);
                        VectorBotones[4] = Bot;
                        if (NumeroRandom == 0) {
                            Contador1++;
                            VectorRandom[Index] = NumeroRandom;
                        } else {
                            if (NumeroRandom == 1) {
                                Contador2++;
                                VectorRandom[Index] = NumeroRandom;
                            } else {
                                if (NumeroRandom == 2) {
                                    Contador3++;
                                    VectorRandom[Index] = NumeroRandom;
                                } else {
                                    if (NumeroRandom == 3) {
                                        Contador4++;
                                        VectorRandom[Index] = NumeroRandom;
                                    } else {
                                        if (NumeroRandom == 4) {
                                            Contador5++;
                                            VectorRandom[Index] = NumeroRandom;
                                        } else {
                                            if (NumeroRandom == 5) {
                                                Contador6++;
                                                VectorRandom[Index] = NumeroRandom;
                                            } else {
                                                if (NumeroRandom == 6) {
                                                    Contador7++;
                                                    VectorRandom[Index] = NumeroRandom;
                                                } else {
                                                    if (NumeroRandom == 7) {
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
                        Bot = (ImageButton) findViewById(R.id.BotonSeis);
                        VectorBotones[5] = Bot;
                        if (NumeroRandom == 0) {
                            Contador1++;
                            VectorRandom[Index] = NumeroRandom;
                        } else {
                            if (NumeroRandom == 1) {
                                Contador2++;
                                VectorRandom[Index] = NumeroRandom;
                            } else {
                                if (NumeroRandom == 2) {
                                    Contador3++;
                                    VectorRandom[Index] = NumeroRandom;
                                } else {
                                    if (NumeroRandom == 3) {
                                        Contador4++;
                                        VectorRandom[Index] = NumeroRandom;
                                    } else {
                                        if (NumeroRandom == 4) {
                                            Contador5++;
                                            VectorRandom[Index] = NumeroRandom;
                                        } else {
                                            if (NumeroRandom == 5) {
                                                Contador6++;
                                                VectorRandom[Index] = NumeroRandom;
                                            } else {
                                                if (NumeroRandom == 6) {
                                                    Contador7++;
                                                    VectorRandom[Index] = NumeroRandom;
                                                } else {
                                                    if (NumeroRandom == 7) {
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
                        Bot = (ImageButton) findViewById(R.id.BotonSiete);
                        VectorBotones[6] = Bot;
                        if (NumeroRandom == 0) {
                            Contador1++;
                            VectorRandom[Index] = NumeroRandom;
                        } else {
                            if (NumeroRandom == 1) {
                                Contador2++;
                                VectorRandom[Index] = NumeroRandom;
                            } else {
                                if (NumeroRandom == 2) {
                                    Contador3++;
                                    VectorRandom[Index] = NumeroRandom;
                                } else {
                                    if (NumeroRandom == 3) {
                                        Contador4++;
                                        VectorRandom[Index] = NumeroRandom;
                                    } else {
                                        if (NumeroRandom == 4) {
                                            Contador5++;
                                            VectorRandom[Index] = NumeroRandom;
                                        } else {
                                            if (NumeroRandom == 5) {
                                                Contador6++;
                                                VectorRandom[Index] = NumeroRandom;
                                            } else {
                                                if (NumeroRandom == 6) {
                                                    Contador7++;
                                                    VectorRandom[Index] = NumeroRandom;
                                                } else {
                                                    if (NumeroRandom == 7) {
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
                        Bot = (ImageButton) findViewById(R.id.BotonOcho);
                        VectorBotones[7] = Bot;
                        if (NumeroRandom == 0) {
                            Contador1++;
                            VectorRandom[Index] = NumeroRandom;
                        } else {
                            if (NumeroRandom == 1) {
                                Contador2++;
                                VectorRandom[Index] = NumeroRandom;
                            } else {
                                if (NumeroRandom == 2) {
                                    Contador3++;
                                    VectorRandom[Index] = NumeroRandom;
                                } else {
                                    if (NumeroRandom == 3) {
                                        Contador4++;
                                        VectorRandom[Index] = NumeroRandom;
                                    } else {
                                        if (NumeroRandom == 4) {
                                            Contador5++;
                                            VectorRandom[Index] = NumeroRandom;
                                        } else {
                                            if (NumeroRandom == 5) {
                                                Contador6++;
                                                VectorRandom[Index] = NumeroRandom;
                                            } else {
                                                if (NumeroRandom == 6) {
                                                    Contador7++;
                                                    VectorRandom[Index] = NumeroRandom;
                                                } else {
                                                    if (NumeroRandom == 7) {
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
                        Bot = (ImageButton) findViewById(R.id.BotonNueve);
                        VectorBotones[8] = Bot;
                        if (NumeroRandom == 0) {
                            Contador1++;
                            VectorRandom[Index] = NumeroRandom;
                        } else {
                            if (NumeroRandom == 1) {
                                Contador2++;
                                VectorRandom[Index] = NumeroRandom;
                            } else {
                                if (NumeroRandom == 2) {
                                    Contador3++;
                                    VectorRandom[Index] = NumeroRandom;
                                } else {
                                    if (NumeroRandom == 3) {
                                        Contador4++;
                                        VectorRandom[Index] = NumeroRandom;
                                    } else {
                                        if (NumeroRandom == 4) {
                                            Contador5++;
                                            VectorRandom[Index] = NumeroRandom;
                                        } else {
                                            if (NumeroRandom == 5) {
                                                Contador6++;
                                                VectorRandom[Index] = NumeroRandom;
                                            } else {
                                                if (NumeroRandom == 6) {
                                                    Contador7++;
                                                    VectorRandom[Index] = NumeroRandom;
                                                } else {
                                                    if (NumeroRandom == 7) {
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
                        Bot = (ImageButton) findViewById(R.id.BotonDiez);
                        VectorBotones[9] = Bot;
                        if (NumeroRandom == 0) {
                            Contador1++;
                            VectorRandom[Index] = NumeroRandom;
                        } else {
                            if (NumeroRandom == 1) {
                                Contador2++;
                                VectorRandom[Index] = NumeroRandom;
                            } else {
                                if (NumeroRandom == 2) {
                                    Contador3++;
                                    VectorRandom[Index] = NumeroRandom;
                                } else {
                                    if (NumeroRandom == 3) {
                                        Contador4++;
                                        VectorRandom[Index] = NumeroRandom;
                                    } else {
                                        if (NumeroRandom == 4) {
                                            Contador5++;
                                            VectorRandom[Index] = NumeroRandom;
                                        } else {
                                            if (NumeroRandom == 5) {
                                                Contador6++;
                                                VectorRandom[Index] = NumeroRandom;
                                            } else {
                                                if (NumeroRandom == 6) {
                                                    Contador7++;
                                                    VectorRandom[Index] = NumeroRandom;
                                                } else {
                                                    if (NumeroRandom == 7) {
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
                        Bot = (ImageButton) findViewById(R.id.BotonOnce);
                        VectorBotones[10] = Bot;
                        if (NumeroRandom == 0) {
                            Contador1++;
                            VectorRandom[Index] = NumeroRandom;
                        } else {
                            if (NumeroRandom == 1) {
                                Contador2++;
                                VectorRandom[Index] = NumeroRandom;
                            } else {
                                if (NumeroRandom == 2) {
                                    Contador3++;
                                    VectorRandom[Index] = NumeroRandom;
                                } else {
                                    if (NumeroRandom == 3) {
                                        Contador4++;
                                        VectorRandom[Index] = NumeroRandom;
                                    } else {
                                        if (NumeroRandom == 4) {
                                            Contador5++;
                                            VectorRandom[Index] = NumeroRandom;
                                        } else {
                                            if (NumeroRandom == 5) {
                                                Contador6++;
                                                VectorRandom[Index] = NumeroRandom;
                                            } else {
                                                if (NumeroRandom == 6) {
                                                    Contador7++;
                                                    VectorRandom[Index] = NumeroRandom;
                                                } else {
                                                    if (NumeroRandom == 7) {
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
                        Bot = (ImageButton) findViewById(R.id.BotonDoce);
                        VectorBotones[11] = Bot;
                        if (NumeroRandom == 0) {
                            Contador1++;
                            VectorRandom[Index] = NumeroRandom;
                        } else {
                            if (NumeroRandom == 1) {
                                Contador2++;
                                VectorRandom[Index] = NumeroRandom;
                            } else {
                                if (NumeroRandom == 2) {
                                    Contador3++;
                                    VectorRandom[Index] = NumeroRandom;
                                } else {
                                    if (NumeroRandom == 3) {
                                        Contador4++;
                                        VectorRandom[Index] = NumeroRandom;
                                    } else {
                                        if (NumeroRandom == 4) {
                                            Contador5++;
                                            VectorRandom[Index] = NumeroRandom;
                                        } else {
                                            if (NumeroRandom == 5) {
                                                Contador6++;
                                                VectorRandom[Index] = NumeroRandom;
                                            } else {
                                                if (NumeroRandom == 6) {
                                                    Contador7++;
                                                    VectorRandom[Index] = NumeroRandom;
                                                } else {
                                                    if (NumeroRandom == 7) {
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
                        Bot = (ImageButton) findViewById(R.id.BotonTrece);
                        VectorBotones[12] = Bot;
                        if (NumeroRandom == 0) {
                            Contador1++;
                            VectorRandom[Index] = NumeroRandom;
                        } else {
                            if (NumeroRandom == 1) {
                                Contador2++;
                                VectorRandom[Index] = NumeroRandom;
                            } else {
                                if (NumeroRandom == 2) {
                                    Contador3++;
                                    VectorRandom[Index] = NumeroRandom;
                                } else {
                                    if (NumeroRandom == 3) {
                                        Contador4++;
                                        VectorRandom[Index] = NumeroRandom;
                                    } else {
                                        if (NumeroRandom == 4) {
                                            Contador5++;
                                            VectorRandom[Index] = NumeroRandom;
                                        } else {
                                            if (NumeroRandom == 5) {
                                                Contador6++;
                                                VectorRandom[Index] = NumeroRandom;
                                            } else {
                                                if (NumeroRandom == 6) {
                                                    Contador7++;
                                                    VectorRandom[Index] = NumeroRandom;
                                                } else {
                                                    if (NumeroRandom == 7) {
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
                        Bot = (ImageButton) findViewById(R.id.BotonCatorce);
                        VectorBotones[13] = Bot;
                        if (NumeroRandom == 0) {
                            Contador1++;
                            VectorRandom[Index] = NumeroRandom;
                        } else {
                            if (NumeroRandom == 1) {
                                Contador2++;
                                VectorRandom[Index] = NumeroRandom;
                            } else {
                                if (NumeroRandom == 2) {
                                    Contador3++;
                                    VectorRandom[Index] = NumeroRandom;
                                } else {
                                    if (NumeroRandom == 3) {
                                        Contador4++;
                                        VectorRandom[Index] = NumeroRandom;
                                    } else {
                                        if (NumeroRandom == 4) {
                                            Contador5++;
                                            VectorRandom[Index] = NumeroRandom;
                                        } else {
                                            if (NumeroRandom == 5) {
                                                Contador6++;
                                                VectorRandom[Index] = NumeroRandom;
                                            } else {
                                                if (NumeroRandom == 6) {
                                                    Contador7++;
                                                    VectorRandom[Index] = NumeroRandom;
                                                } else {
                                                    if (NumeroRandom == 7) {
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
                        Bot = (ImageButton) findViewById(R.id.BotonQuince);
                        VectorBotones[14] = Bot;
                        if (NumeroRandom == 0) {
                            Contador1++;
                            VectorRandom[Index] = NumeroRandom;
                        } else {
                            if (NumeroRandom == 1) {
                                Contador2++;
                                VectorRandom[Index] = NumeroRandom;
                            } else {
                                if (NumeroRandom == 2) {
                                    Contador3++;
                                    VectorRandom[Index] = NumeroRandom;
                                } else {
                                    if (NumeroRandom == 3) {
                                        Contador4++;
                                        VectorRandom[Index] = NumeroRandom;
                                    } else {
                                        if (NumeroRandom == 4) {
                                            Contador5++;
                                            VectorRandom[Index] = NumeroRandom;
                                        } else {
                                            if (NumeroRandom == 5) {
                                                Contador6++;
                                                VectorRandom[Index] = NumeroRandom;
                                            } else {
                                                if (NumeroRandom == 6) {
                                                    Contador7++;
                                                    VectorRandom[Index] = NumeroRandom;
                                                } else {
                                                    if (NumeroRandom == 7) {
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
                        Bot = (ImageButton) findViewById(R.id.BotonDieciseis);
                        VectorBotones[15] = Bot;
                        if (NumeroRandom == 0) {
                            Contador1++;
                            VectorRandom[Index] = NumeroRandom;
                        } else {
                            if (NumeroRandom == 1) {
                                Contador2++;
                                VectorRandom[Index] = NumeroRandom;
                            } else {
                                if (NumeroRandom == 2) {
                                    Contador3++;
                                    VectorRandom[Index] = NumeroRandom;
                                } else {
                                    if (NumeroRandom == 3) {
                                        Contador4++;
                                        VectorRandom[Index] = NumeroRandom;
                                    } else {
                                        if (NumeroRandom == 4) {
                                            Contador5++;
                                            VectorRandom[Index] = NumeroRandom;
                                        } else {
                                            if (NumeroRandom == 5) {
                                                Contador6++;
                                                VectorRandom[Index] = NumeroRandom;
                                            } else {
                                                if (NumeroRandom == 6) {
                                                    Contador7++;
                                                    VectorRandom[Index] = NumeroRandom;
                                                } else {
                                                    if (NumeroRandom == 7) {
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
        }
        while (Contador1 != 2 || Contador2 != 2 || Contador3 != 2 || Contador4 != 2 || Contador5 != 2 || Contador6 != 2 || Contador7 != 2 || Contador8 != 2);
    }

    public void Girar(View VistaR) {
        TextView Puntaje = (TextView) findViewById(R.id.Puntos);
        ImageButton Boton = (ImageButton) VistaR;
        boolean Estado;
        int Tag = Integer.parseInt(String.valueOf(Boton.getTag()));
        if (VectorRandom[Tag] == 0) {
            Boton.setEnabled(false);
            ContadorValidar++;
            if (ContadorValidar <= 2) {
                Boton.setImageResource(R.drawable.asustado);
                VectorEstado[Tag] = true;
                Estado = Validar(ContadorValidar);
                if (Estado) {
                    ContPuntos++;
                    Puntaje.setText(String.valueOf(ContPuntos));
                } /*else {
                    if (ContadorValidar == 2) {

                    }
                }*/
            }
        }
        if (VectorRandom[Tag] == 1) {
            Boton.setEnabled(false);
            ContadorValidar++;
            if (ContadorValidar <= 2) {
                Boton.setImageResource(R.drawable.contento);
                VectorEstado[Tag] = true;
                Estado = Validar(ContadorValidar);
                if (Estado) {
                    ContPuntos++;
                    Puntaje.setText(String.valueOf(ContPuntos));
                }
            }
        }
        if (VectorRandom[Tag] == 2) {
            Boton.setEnabled(false);
            ContadorValidar++;
            if (ContadorValidar <= 2) {
                Boton.setImageResource(R.drawable.dormido);
                VectorEstado[Tag] = true;
                Estado = Validar(ContadorValidar);
                if (Estado) {
                    ContPuntos++;
                    Puntaje.setText(String.valueOf(ContPuntos));
                }
            }
        }
        if (VectorRandom[Tag] == 3) {
            Boton.setEnabled(false);
            ContadorValidar++;
            if (ContadorValidar <= 2) {
                Boton.setImageResource(R.drawable.enamorado);
                VectorEstado[Tag] = true;
                Estado = Validar(ContadorValidar);
                if (Estado) {
                    ContPuntos++;
                    Puntaje.setText(String.valueOf(ContPuntos));
                }
            }
        }
        if (VectorRandom[Tag] == 4) {
            Boton.setEnabled(false);
            ContadorValidar++;
            if (ContadorValidar <= 2) {
                Boton.setImageResource(R.drawable.enojado);
                VectorEstado[Tag] = true;
                Estado = Validar(ContadorValidar);
                if (Estado) {
                    ContPuntos++;
                    Puntaje.setText(String.valueOf(ContPuntos));
                }
            }
        }
        if (VectorRandom[Tag] == 5) {
            Boton.setEnabled(false);
            ContadorValidar++;
            if (ContadorValidar <= 2) {
                Boton.setImageResource(R.drawable.llorando);
                VectorEstado[Tag] = true;
                Estado = Validar(ContadorValidar);
                if (Estado) {
                    ContPuntos++;
                    Puntaje.setText(String.valueOf(ContPuntos));
                }
            }
        }
        if (VectorRandom[Tag] == 6) {
            Boton.setEnabled(false);
            ContadorValidar++;
            if (ContadorValidar <= 2) {
                Boton.setImageResource(R.drawable.sonriente);
                VectorEstado[Tag] = true;
                Estado = Validar(ContadorValidar);
                if (Estado) {
                    ContPuntos++;
                    Puntaje.setText(String.valueOf(ContPuntos));
                }
            }
        }
        if (VectorRandom[Tag] == 7) {
            Boton.setEnabled(false);
            ContadorValidar++;
            if (ContadorValidar <= 2) {
                Boton.setImageResource(R.drawable.sorprendido);
                VectorEstado[Tag] = true;
                Estado = Validar(ContadorValidar);
                if (Estado) {
                    ContPuntos++;
                    Puntaje.setText(String.valueOf(ContPuntos));
                }
            }
        }

    }

        Boolean Validar(int Cont) {
        Boolean Validate = false;
        int[] VecImagenes = new int[2];
        int[] VecPos = new int[2];
        int Contador = 0;
        if (Cont == 2) {
            for (int i = 0; i < VectorEstado.length; i++) {
                if (VectorEstado[i] == true && i != VectorAdivinados[0] && i != VectorAdivinados[1] && i != VectorAdivinados[2] && i != VectorAdivinados[3] && i != VectorAdivinados[4] && i != VectorAdivinados[5] && i != VectorAdivinados[6] && i != VectorAdivinados[7] && i != VectorAdivinados[8] && i != VectorAdivinados[9] && i != VectorAdivinados[10] && i != VectorAdivinados[11] && i != VectorAdivinados[12] && i != VectorAdivinados[13] && i != VectorAdivinados[14] && i != VectorAdivinados[15]) {
                    VecImagenes[Contador] = VectorRandom[i];
                    VecPos[Contador] = i;
                    Contador++;
                }
                else
                {
                    if (VectorEstado[i] == false)
                    {
                        VectorBotones[i].setEnabled(false);
                    }
                }
            }
            if (VecImagenes[0] == VecImagenes[1]) {
                Validate = true;
                for (int i = 0; i < 2; i++) {
                    VectorAdivinados[ContadorVec] = VecPos[i];
                    ContadorVec++;
                }
                for (int i = 0; i < VectorEstado.length; i++) {
                    VectorEstado[i] = false;
                    VectorBotones[i].setEnabled(true);
                }
            }
            else
            {
                final Timer Reloj = new Timer();
                TimerTask Tarea = new TimerTask() {
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                A();
                                Reloj.cancel();
                            }
                        });
                    }
                };
                Reloj.schedule(Tarea, 500, 6000);
            }
            ContadorValidar = 0;
        }
        return Validate;
    }
    public void A()
    {
        for (I = 0; I < VectorEstado.length; I++)
        {
            if (I != VectorAdivinados[0] && I != VectorAdivinados[1] && I != VectorAdivinados[2] && I != VectorAdivinados[3] && I != VectorAdivinados[4] && I != VectorAdivinados[5] && I != VectorAdivinados[6] && I != VectorAdivinados[7] && I != VectorAdivinados[8] && I != VectorAdivinados[9] && I != VectorAdivinados[10] && I != VectorAdivinados[11] && I != VectorAdivinados[12] && I != VectorAdivinados[13] && I != VectorAdivinados[14] && I != VectorAdivinados[15]) {

                VectorEstado[I] = false;
                VectorBotones[I].setEnabled(true);
                VectorBotones[I].setImageResource(R.drawable.reverso);
            }
        }
    }

    Boolean Ganar() {
        boolean Gano = false;
        if (VectorEstado[0] && VectorEstado[1] &&VectorEstado[2] && VectorEstado[3] &&VectorEstado[4] && VectorEstado[5] &&VectorEstado[6] && VectorEstado[7] &&VectorEstado[8] && VectorEstado[9] &&VectorEstado[10] && VectorEstado[11] &&VectorEstado[12] && VectorEstado[13] &&VectorEstado[14] && VectorEstado[15])
        {
            Gano = true;
        }
        return Gano;
    }
}
