package com.example.a42102578.integrapp;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.EventLog;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ImageView;

import org.cocos2d.actions.interval.Animate;
import org.cocos2d.actions.interval.MoveTo;
import org.cocos2d.actions.interval.ScaleBy;
import org.cocos2d.layers.Layer;
import org.cocos2d.nodes.Animation;
import org.cocos2d.nodes.Director;
import org.cocos2d.nodes.Label;
import org.cocos2d.nodes.Scene;
import org.cocos2d.nodes.Sprite;
import org.cocos2d.opengl.CCGLSurfaceView;
import org.cocos2d.types.CCColor3B;
import org.cocos2d.types.CCSize;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by 42102517 on 18/7/2017.
 */

/*Primer problema: PelotaTocada, no encuenra el tag.
  Segundo " : NumeroMenor y NumeroMAyor tienen el mismo valor
 */

public class clsPelotas {
    CCGLSurfaceView _VistaPelotas;
    CCSize PantallaDelDispositivo;
    Sprite Perro;
    Sprite ImagenFondo;
    Sprite Pelota1;
    Sprite Pelota2;
    Sprite Pelota3;
    Sprite Pelota4;
    Sprite Pelota5;
    Sprite Pelota6;
    Sprite Pelota7;
    Sprite Pelota8;
    Sprite Pelota9;
    Sprite Pelota10;
    Sprite PelotaTocada;

    float[] VecPosX = new float[11];
    float[] VecPosY = new float[11];
    boolean[] PelotasElegidas = new boolean[11];
    int CantPelotasElegidas = 0;

    Label lblHueso;
    Integer NumeroObjetoTocado = 0;
    Integer NumeroHueso;
    int vidas = 6;
    int contaciertos = 0;
    Context _Contexto;
    String[] _Vector;
    public Boolean listoParaAgregar = false;


    public clsPelotas(CCGLSurfaceView VistaPelotas, Context Contexto, String[]Vector) {
        _VistaPelotas = VistaPelotas;
        _Contexto = Contexto;
        _Vector = Vector;
        //NumeroObjetoTocado = 0;
        //super.schedule("InterseccionEntreSprites", 0.1f);

    }

    public void ComenzarJuego() {
        //comienza el juego
        Director.sharedDirector().attachInView(_VistaPelotas);
        PantallaDelDispositivo = Director.sharedDirector().displaySize();
        //ejecucion de la escena
        Director.sharedDirector().runWithScene(EscenaDePelotas());

        //random perros
        Random generadorAzar;
        generadorAzar = new Random();
        Integer delal10;
        delal10 = generadorAzar.nextInt(11);

    }

    private Scene EscenaDePelotas() {
        //Declaro e instancio la escena
        Scene EscenaADevolver;
        EscenaADevolver = Scene.node();

        //capa con la imagen de fondo
        CapaDelFondo MiCapaFondo;
        MiCapaFondo = new CapaDelFondo();

        CapaPelotas MiCapaPelotas;
        MiCapaPelotas = new CapaPelotas();

        //capa del perrito
        CapaDelPerro MiCapaPerro;
        MiCapaPerro = new CapaDelPerro();


        //Agrego a la escena la capa del fondo mas atras y la del perro mas adelante
        EscenaADevolver.addChild(MiCapaFondo, -10);
        EscenaADevolver.addChild(MiCapaPerro, 10);
        EscenaADevolver.addChild(MiCapaPelotas, 20);

        return EscenaADevolver;
    }

    //-----------------FONDO--------------------------
    class CapaDelFondo extends Layer {
        public CapaDelFondo() {
            PonerImagenFondo();
        }

        private void PonerImagenFondo() {
            ImagenFondo = Sprite.sprite("fondoperro.jpg");
            ImagenFondo.setPosition(PantallaDelDispositivo.width / 2, PantallaDelDispositivo.height / 2);
            //escalando el fondo de la app
            ImagenFondo.runAction(ScaleBy.action(0.01f, 2.0f, 2.0f));
            super.addChild(ImagenFondo);
        }
    }

    class CapaDelPerro extends Layer {
        public CapaDelPerro() {
            PonerCapaDelPerro();
        }

        private void PonerCapaDelPerro() {
            Perro = Sprite.sprite("perrito.png");
            Perro.setPosition(PantallaDelDispositivo.width / 2, Perro.getHeight() / 2);
            super.addChild(Perro);
        }

        /*private void PonerNumero() {
            Random numeroazar;
            numeroazar = new Random();
            int numazar = numeroazar.nextInt(11);
            int numerojugar = 5;
            lblHueso.setString("" + numerojugar);
        }*/
    }

    //-----------------PELOTA 1----------------------
    class CapaPelotas extends Layer {
        public CapaPelotas() {
            PonerPelotas();
            Log.d("CapaPelotas", "Inicio el timer");
            //super.schedule("InterseccionEntreSprites", 0.1f);
            this.setIsTouchEnabled(true);
            ElegirNumeroPelota();
            VaciarPelotasElegidas();
        }

        public void VaciarPelotasElegidas()
        {
            PelotasElegidas[0]=true;
            for(int i=0; i<11;i++)
            {
                PelotasElegidas[i]=false;
            }
        }
        public void ElegirNumeroPelota() {

            int numazar=0;
            while (PelotasElegidas[numazar] || numazar==0) {
                Random numeroazar;
                numeroazar = new Random();
                numazar = numeroazar.nextInt(10) + 1;
                String numero = "";
                numero = String.valueOf(numazar);
                lblHueso = Label.label(numero, "Comic Sans", 50);
                lblHueso.setPosition(PantallaDelDispositivo.getWidth() * 0.50f, 56

                );
                CCColor3B colornumero = new CCColor3B(37, 37, 132);
                lblHueso.setColor(colornumero);

                NumeroHueso = numazar;
            }

            super.addChild(lblHueso);
        }

        private void PonerPelotas() {
            //instancio el sprite
            Pelota1 = Sprite.sprite("pelota1.png");
            Pelota2 = Sprite.sprite("pelota2.png");
            Pelota3 = Sprite.sprite("pelota3.png");
            Pelota4 = Sprite.sprite("pelota4.png");
            Pelota5 = Sprite.sprite("pelota5.png");
            Pelota6 = Sprite.sprite("pelota6.png");
            Pelota7 = Sprite.sprite("pelota7.png");
            Pelota8 = Sprite.sprite("pelota8.png");
            Pelota9 = Sprite.sprite("pelota9.png");
            Pelota10 = Sprite.sprite("pelota10.png");
            PelotaTocada = Sprite.sprite("pelotavacia.png");

            //primera fila
            float PosicionInicialX, PosicionInicialY;
            VecPosX[1]= PantallaDelDispositivo.width * 0.20f;
            VecPosY[1]=PantallaDelDispositivo.height - PantallaDelDispositivo.height * 0.1f;
            Pelota1.setPosition(VecPosX[1], VecPosY[1]);

            VecPosX[2] = PantallaDelDispositivo.width * 0.40f;
            VecPosY[2] = PantallaDelDispositivo.height - PantallaDelDispositivo.height * 0.1f;
            Pelota2.setPosition(VecPosX[2], VecPosY[2]);

            VecPosX[3] = PantallaDelDispositivo.width * 0.60f;
            VecPosY[3] = PantallaDelDispositivo.height - PantallaDelDispositivo.height * 0.1f;
            Pelota3.setPosition(VecPosX[3], VecPosY[3]);

            VecPosX[4] = PantallaDelDispositivo.width * 0.80f;
            VecPosY[4] = PantallaDelDispositivo.height - PantallaDelDispositivo.height * 0.1f;
            Pelota4.setPosition(VecPosX[4], VecPosY[4]);

            //segunda fila
            VecPosX[5] = PantallaDelDispositivo.width * 0.30f;
            VecPosY[5] = PantallaDelDispositivo.height - PantallaDelDispositivo.height * 0.2f;
            Pelota5.setPosition(VecPosX[5], VecPosY[5]);

            VecPosX[6] = PantallaDelDispositivo.width * 0.50f;
            VecPosY[6] = PantallaDelDispositivo.height - PantallaDelDispositivo.height * 0.2f;
            Pelota6.setPosition(VecPosX[6],VecPosY[6]);

            VecPosX[7] = PantallaDelDispositivo.width * 0.70f;
            VecPosY[7] = PantallaDelDispositivo.height - PantallaDelDispositivo.height * 0.2f;
            Pelota7.setPosition(VecPosX[7],VecPosY[7]);

            //tercera fila
            VecPosX[8] = PantallaDelDispositivo.width * 0.40f;
            VecPosY[8] = PantallaDelDispositivo.height - PantallaDelDispositivo.height * 0.3f;
            Pelota8.setPosition(VecPosX[8], VecPosY[8]);

            VecPosX[9] = PantallaDelDispositivo.width * 0.60f;
            VecPosY[9]= PantallaDelDispositivo.height - PantallaDelDispositivo.height * 0.3f;
            Pelota9.setPosition(VecPosX[9], VecPosY[9]);

            //cuarta fila
            VecPosX[10] = PantallaDelDispositivo.width * 0.50f;
            VecPosY[10] = PantallaDelDispositivo.height - PantallaDelDispositivo.height * 0.4f;
            Pelota10.setPosition(VecPosX[10], VecPosY[10]);

            //lo agrego a la capa
            super.addChild(Pelota1); //preguntar
            super.addChild(Pelota2); //preguntar
            super.addChild(Pelota3); //preguntar
            super.addChild(Pelota4); //preguntar
            super.addChild(Pelota5); //preguntar
            super.addChild(Pelota6); //preguntar
            super.addChild(Pelota7); //preguntar
            super.addChild(Pelota8); //preguntar
            super.addChild(Pelota9); //preguntar
            super.addChild(Pelota10); //preguntar
        }

        Boolean EstaTocandoElObjeto(float posicionXtocada, float posicionYtocada, Sprite objtocado) {
            boolean estatocando;
            float bordeizquierdo = objtocado.getPositionX() - objtocado.getWidth() / 2;
            float bordederecho = objtocado.getPositionX() + objtocado.getWidth() / 2;
            float bordesuperior = objtocado.getPositionY() + objtocado.getHeight() / 2;
            float bordeinferior = objtocado.getPositionY() - objtocado.getHeight() / 2;

            Log.d("EstaTocando", "BI: " + bordeizquierdo + " - BD: " + bordederecho + " - BInf: " + bordeinferior + " - BS: " + bordesuperior);


            if (posicionXtocada > bordeizquierdo && posicionXtocada < bordederecho && posicionYtocada < bordesuperior && posicionYtocada > bordeinferior) {
                estatocando = true;
            } else {
                estatocando = false;
            }

            return estatocando;
        }

        //----------------------------MOVIMIENTOS----------------------------

        public boolean ccTouchesBegan(MotionEvent event) {
            float posX = event.getX();
            float posY = PantallaDelDispositivo.getHeight() - event.getY();
            Log.d("Toque comienza", "X: " + posX + " -Y: " + posY);

            if (EstaTocandoElObjeto(posX, posY, Pelota1)) {
                NumeroObjetoTocado = 1;
                PelotaTocada = Pelota1;
                //     Log.d("EstaTocando", "Esta tocando la: " + NumeroObjetoTocado + "La pelota es la : " +PelotaTocada);
            } else {
                if (EstaTocandoElObjeto(posX, posY, Pelota2)) {
                    NumeroObjetoTocado = 2;
                    PelotaTocada = Pelota2;
                    //       Log.d("EstaTocando", "Esta tocando la: " + NumeroObjetoTocado + "La pelota es la : " +PelotaTocada);
                } else {
                    if (EstaTocandoElObjeto(posX, posY, Pelota3)) {
                        NumeroObjetoTocado = 3;
                        PelotaTocada = Pelota3;
                        //         Log.d("EstaTocando", "Esta tocando la: " + NumeroObjetoTocado + "La pelota es la : " +PelotaTocada);
                    } else {
                        if (EstaTocandoElObjeto(posX, posY, Pelota4)) {
                            NumeroObjetoTocado = 4;
                            PelotaTocada = Pelota4;
                            //           Log.d("EstaTocando", "Esta tocando la: " + NumeroObjetoTocado + "La pelota es la : " +PelotaTocada);
                        } else {
                            if (EstaTocandoElObjeto(posX, posY, Pelota5)) {
                                NumeroObjetoTocado = 5;
                                PelotaTocada = Pelota5;
                                //             Log.d("EstaTocando", "Esta tocando la: " + NumeroObjetoTocado + "La pelota es la : " +PelotaTocada);
                            } else {
                                if (EstaTocandoElObjeto(posX, posY, Pelota6)) {
                                    NumeroObjetoTocado = 6;
                                    PelotaTocada = Pelota6;
                                    //               Log.d("EstaTocando", "Esta tocando la: " + NumeroObjetoTocado + "La pelota es la : " +PelotaTocada);
                                } else {
                                    if (EstaTocandoElObjeto(posX, posY, Pelota7)) {
                                        NumeroObjetoTocado = 7;
                                        PelotaTocada = Pelota7;
                                        //                 Log.d("EstaTocando", "Esta tocando la: " + NumeroObjetoTocado + "La pelota es la : " +PelotaTocada);
                                    } else {
                                        if (EstaTocandoElObjeto(posX, posY, Pelota8)) {
                                            NumeroObjetoTocado = 8;
                                            PelotaTocada = Pelota8;
                                            //                   Log.d("EstaTocando", "Esta tocando la: " + NumeroObjetoTocado + "La pelota es la : " +PelotaTocada);
                                        } else {
                                            if (EstaTocandoElObjeto(posX, posY, Pelota9)) {
                                                NumeroObjetoTocado = 9;
                                                PelotaTocada = Pelota9;
                                                //                     Log.d("EstaTocando", "Esta tocando la: " + NumeroObjetoTocado + "La pelota es la : " +PelotaTocada);
                                            } else {
                                                if (EstaTocandoElObjeto(posX, posY, Pelota10)) {
                                                    NumeroObjetoTocado = 10;
                                                    PelotaTocada = Pelota10;
                                                    //                       Log.d("EstaTocando", "Esta tocando la: " + NumeroObjetoTocado + "La pelota es la : " +PelotaTocada);
                                                } else {
                                                    NumeroObjetoTocado = 0;
                                                    //                     Log.d("EstaTocando", "No esta tocando nada " + NumeroObjetoTocado );
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }


            return true;
        }

        public boolean ccTouchesMoved(MotionEvent event) {
            float posX = event.getX();
            float posY = PantallaDelDispositivo.getHeight() - event.getY();
            // Log.d("Toque comienza", "X: " + posX + " -Y: " + posY);

            if (NumeroObjetoTocado == 1) {
                Pelota1.setPosition(posX, posY);
                // PelotaTocada = Pelota1;
            } else {
                if (NumeroObjetoTocado == 2) {
                    Pelota2.setPosition(posX, posY);
                    //   PelotaTocada = Pelota2;
                } else {
                    if (NumeroObjetoTocado == 3) {
                        Pelota3.setPosition(posX, posY);
                        //     PelotaTocada = Pelota3;
                    } else {
                        if (NumeroObjetoTocado == 4) {
                            Pelota4.setPosition(posX, posY);
                            //       PelotaTocada = Pelota4;
                        } else {
                            if (NumeroObjetoTocado == 5) {
                                Pelota5.setPosition(posX, posY);
                                //         PelotaTocada = Pelota5;
                            } else {
                                if (NumeroObjetoTocado == 6) {
                                    Pelota6.setPosition(posX, posY);
                                    //           PelotaTocada = Pelota6;
                                } else {
                                    if (NumeroObjetoTocado == 7) {
                                        Pelota7.setPosition(posX, posY);
                                        //             PelotaTocada = Pelota7;
                                    } else if (NumeroObjetoTocado == 8) {
                                        Pelota8.setPosition(posX, posY);
                                        //           PelotaTocada = Pelota8;
                                    } else {
                                        if (NumeroObjetoTocado == 9) {
                                            Pelota9.setPosition(posX, posY);
                                            //             PelotaTocada = Pelota9;
                                        } else {
                                            if (NumeroObjetoTocado == 10) {
                                                Pelota10.setPosition(posX, posY);
                                                //               PelotaTocada = Pelota10;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            //Log.d("EstaMoviendo", "Esta moviendo la pelota1");
            // InterseccionEntreSprites(PelotaTocada, Perro);
            return true;
        }

        public boolean ccTouchesEnded(MotionEvent event)
        {
            if (InterseccionEntreSprites(PelotaTocada, Perro))
            {
                Log.d("Entra al if", "Entra");
                Verifico(PelotaTocada, NumeroObjetoTocado, NumeroHueso);
            }
            float posX = event.getX();
            float posY = PantallaDelDispositivo.getHeight() - event.getY();

            if (NumeroObjetoTocado == NumeroHueso) {
                if (posX > 545 && posX < 660 && posY > 50 && posY < 91) {
                    // desaparece
                    PelotaTocada.setVisible(false);
                    CantPelotasElegidas++;
                    if (CantPelotasElegidas<10)
                    {
                        super.removeChild(lblHueso, true);
                        PelotasElegidas[NumeroHueso] = true;
                        ElegirNumeroPelota();
                    }
                    else
                    {
                        //Pantalla GANE
                    }
                } else {
                    // vuelve arriba
                    Log.d("EstaMoviendo", "Esta moviendo la pelota ");
                    PelotaTocada.runAction(MoveTo.action(1.0f, VecPosX[NumeroObjetoTocado], VecPosY[NumeroObjetoTocado]));

                }
            } else {
                // vuelve arriba
                PelotaTocada.runAction(MoveTo.action(1.0f, VecPosX[NumeroObjetoTocado], VecPosY[NumeroObjetoTocado]));
            }

            return true;
        }
        //------------------ TERMINAN MOVIMIENTOS---------------------------------------------

        boolean InterseccionEntreSprites(Sprite primersprite, Sprite segundosprite) {
            boolean Devolver;
            Devolver = false;

            PelotaTocada = primersprite;
           /* switch (NumeroObjetoTocado)
            {
                case 1:
                    Pelota1 = primersprite;
                    break;
                case 2:
                    Pelota2 = primersprite;
                    break;
                case 3:
                    Pelota3 = primersprite;
                    break;
                case 4:
                    Pelota4 = primersprite;
                    break;
                case 5:
                    Pelota5 = primersprite;
                    break;
                case 6:
                    Pelota6 = primersprite;
                    break;
                case 7:
                    Pelota7 = primersprite;
                    break;
                case 8:
                    Pelota8 = primersprite;
                     break;
                case 9:
                    Pelota9 = primersprite;
                    break;
                case 10:
                    Pelota10 = primersprite;
                    break;
            }*/
            Perro = segundosprite;

            int Sprite1Izquierda, Sprite1Derecha, Sprite1Abajo, Sprite1Arriba;
            int Sprite2Izquierda, Sprite2Derecha, Sprite2Abajo, Sprite2Arriba;


            Sprite1Izquierda = (int) (primersprite.getPositionX() - primersprite.getWidth() / 2);
            Sprite1Derecha = (int) (primersprite.getPositionX() - primersprite.getWidth() / 2);
            Sprite1Abajo = (int) (primersprite.getPositionY() - primersprite.getHeight() / 2);
            Sprite1Arriba = (int) (primersprite.getPositionY() - primersprite.getHeight() / 2);

            Sprite2Izquierda = (int) (segundosprite.getPositionX() - segundosprite.getWidth() / 2);
            Sprite2Derecha = (int) (segundosprite.getPositionX() - segundosprite.getWidth() / 2);
            Sprite2Abajo = (int) (segundosprite.getPositionY() - segundosprite.getHeight() / 2);
            Sprite2Arriba = (int) (segundosprite.getPositionY() - segundosprite.getHeight() / 2);

            //Borde izq y borde inf de Sprite 1 está dentro de Sprite 2
            if (EstaEntre(Sprite1Izquierda, Sprite2Izquierda, Sprite2Derecha) &&
                    EstaEntre(Sprite1Abajo, Sprite2Abajo, Sprite2Arriba)) {
                Log.d("Interseccion", "1");
                Devolver = true;
                if (Devolver == true) {
                    Verifico(PelotaTocada, NumeroObjetoTocado, NumeroHueso);
                } else {
                    Log.d("Interseccion", "no toca");
                }
            }

            //Borde izq y borde sup de Sprite 1 está dentro de Sprite 2
            if (EstaEntre(Sprite1Izquierda, Sprite2Izquierda, Sprite2Derecha) &&
                    EstaEntre(Sprite1Arriba, Sprite2Abajo, Sprite2Arriba)) {
                Log.d("Interseccion", "2");
                Devolver = true;
                if (Devolver == true) {
                    Verifico(PelotaTocada, NumeroObjetoTocado, NumeroHueso);
                } else {
                    Log.d("Interseccion", "no toca");
                }
            }

            //Borde der y borde sup de Sprite 1 está dentro de Sprite 2
            if (EstaEntre(Sprite1Derecha, Sprite2Izquierda, Sprite2Derecha) &&
                    EstaEntre(Sprite1Arriba, Sprite2Abajo, Sprite2Arriba)) {
                Log.d("Interseccion", "3");
                Devolver = true;
                if (Devolver == true) {
                    Verifico(PelotaTocada, NumeroObjetoTocado, NumeroHueso);
                } else {
                    Log.d("Interseccion", "no toca");
                }
            }

            //Borde der y borde inf de Sprite 1 está dentro de Sprite 2
            if (EstaEntre(Sprite1Derecha, Sprite2Izquierda, Sprite2Derecha) &&
                    EstaEntre(Sprite1Abajo, Sprite2Abajo, Sprite2Arriba)) {
                Log.d("Interseccion", "4");
                Devolver = true;
                if (Devolver == true) {
                    Verifico(PelotaTocada, NumeroObjetoTocado, NumeroHueso);
                } else {
                    Log.d("Interseccion", "no toca");
                }
            }

            //Borde izq y borde inf de Sprite 2 está dentro de Sprite 1
            if (EstaEntre(Sprite2Izquierda, Sprite1Izquierda, Sprite1Derecha) &&
                    EstaEntre(Sprite2Abajo, Sprite1Abajo, Sprite1Arriba)) {
                Log.d("Interseccion", "5");
                Devolver = true;
                if (Devolver == true) {
                    Verifico(PelotaTocada, NumeroObjetoTocado, NumeroHueso);
                } else {
                    Log.d("Interseccion", "no toca");
                }
            }

            //Borde izq y borde sup de Sprite 1 está dentro de Sprite 1
            if (EstaEntre(Sprite2Izquierda, Sprite1Izquierda, Sprite1Derecha) &&
                    EstaEntre(Sprite2Arriba, Sprite1Abajo, Sprite1Arriba)) {
                Log.d("Interseccion", "6");
                Devolver = true;
                if (Devolver == true) {
                    Verifico(PelotaTocada, NumeroObjetoTocado, NumeroHueso);
                } else {
                    Log.d("Interseccion", "no toca");
                }
            }

            //Borde der y borde sup de Sprite 2 está dentro de Sprite 1
            if (EstaEntre(Sprite2Derecha, Sprite1Izquierda, Sprite1Derecha) &&
                    EstaEntre(Sprite2Arriba, Sprite1Abajo, Sprite1Arriba)) {
                Log.d("Interseccion", "7");
                Devolver = true;
                if (Devolver == true) {
                    Verifico(PelotaTocada, NumeroObjetoTocado, NumeroHueso);
                } else {
                    Log.d("Interseccion", "no toca");
                }
            }

            //Borde der y borde inf de Sprite 2 está dentro de Sprite 1
            if (EstaEntre(Sprite2Derecha, Sprite1Izquierda, Sprite1Derecha) &&
                    EstaEntre(Sprite2Abajo, Sprite1Abajo, Sprite1Arriba)) {
                Log.d("Interseccion", "8");
                Devolver = true;
                if (Devolver == true) {
                    Verifico(PelotaTocada, NumeroObjetoTocado, NumeroHueso);
                } else {
                    Log.d("Interseccion", "no toca");
                }
            }

            return Devolver;
        }

        boolean EstaEntre(int NumeroAComparar, int NumeroMenor, int NumeroMayor) {
            boolean Devolver;

            Log.d("EstaEntre", "Numero menor: " + NumeroMenor + "Numero mayor: " + NumeroMayor);

            if (NumeroMenor > NumeroMayor) {
                Log.d("EstaEntre", "Me los mandaron invertidos, los ordeno");
                int Auxiliar = NumeroMayor;
                NumeroMayor = NumeroMenor;
                NumeroMenor = Auxiliar;
            }
            if (NumeroAComparar >= NumeroMenor && NumeroAComparar <= NumeroMayor) {
                Devolver = true;
            } else {
                Devolver = false;
            }
            return Devolver;
        }

        public void Verifico(Sprite primersprite, Integer NumObjeto, Integer NumHueso) {
            switch (NumObjeto) {
                case 1:
                    Pelota1 = primersprite;
                    break;
                case 2:
                    Pelota2 = primersprite;
                    break;
                case 3:
                    Pelota3 = primersprite;
                    break;
                case 4:
                    Pelota4 = primersprite;
                    break;
                case 5:
                    Pelota5 = primersprite;
                    break;
                case 6:
                    Pelota6 = primersprite;
                    break;
                case 7:
                    Pelota7 = primersprite;
                    break;
                case 8:
                    Pelota8 = primersprite;
                    break;
                case 9:
                    Pelota9 = primersprite;
                    break;
                case 10:
                    Pelota10 = primersprite;
                    break;
            }
            // super.unschedule("InterseccionEntreSprites");
            //     Log.d("Timer", "Termino el timer");
            if (NumObjeto == NumHueso) {
                Log.d("Coinciden", "Si, coinciden");
                PerroFesteja();
                Log.d("Coinciden", "Hago invisible el sprite");
                PelotaTocada.setVisible(false);
                contaciertos++;
                if (contaciertos >= 9) {
                    Log.d("Gano", "Deberia mostrar la pantalla ganar");
                    String Juego = "3";
                    String Puntaje = String.valueOf(contaciertos);
                    enviarPuntaje(new String[]{Juego, _Vector[0] ,Puntaje,_Vector[1] });
                    String gana = "¡Ganaste!";
                    lblHueso = Label.label(gana, "Comic Sans", 50);
                    lblHueso.setPosition(PantallaDelDispositivo.getWidth() * 0.50f, Perro.getHeight() / 8);
                    CCColor3B colornumero = new CCColor3B(37, 37, 132);
                    lblHueso.setColor(colornumero);
                    super.addChild(lblHueso);

                }
            } else {
                Log.d("Coinciden", "No coinciden");
                vidas--;
                if (vidas == 0) {
                    Log.d("Perdio", "Deberia mostrar la pantalla perder");
                        /*Intent Intento = new Intent(this, Perder.class);
                        startActivity(Intento);*/
                    String perdio = "¡Perdiste!";
                    lblHueso = Label.label(perdio, "Comic Sans", 50);
                    lblHueso.setPosition(PantallaDelDispositivo.getWidth() * 0.50f, Perro.getHeight() / 8);
                    CCColor3B colornumero = new CCColor3B(37, 37, 132);
                    lblHueso.setColor(colornumero);
                    super.addChild(lblHueso);
                } else {
                    PerroTriste();
                    vidas--;
                }
            }
        }

        public void PerroFesteja() {
            Log.d("PerroFesteja", "Festeja");
            Animation AnimacionSecuencia;
            AnimacionSecuencia = new Animation("Anim", 0.2f, "perrito.png", "perrocontento.png");
            Perro.runAction(Animate.action(AnimacionSecuencia));
        }

        public void PerroTriste() {
            Log.d("PerroTriste", "Se equivoco");
            Animation AnimacionSecuencia2;
            AnimacionSecuencia2 = new Animation("Anim2", 0.2f, "perrito.png", "perrotriste.png");
            Perro.runAction(Animate.action(AnimacionSecuencia2));
        }

    }

    private void enviarPuntaje(String[] params){
        new enviarPuntos().execute(params[0], params[1], params[2], params[3]);
    }


    private class enviarPuntos extends AsyncTask<String, Void, String> {

        protected void onPostExecute(String datos) {
            super.onPostExecute(datos);

            if (datos.equals("error")) {
                //Toast.makeText(getActivity(), "Comprueba tu conexión a Internet", Toast.LENGTH_SHORT).show();

            } else if (datos.equals("error2")) {
                // El token está mal, asi que a borrarloo y que vuelva al inicio
                //Toast.makeText(getActivity(), "Sesión expirada, vuelve a iniciar sesion.", Toast.LENGTH_SHORT).show();
            } else if (datos.equals("faltanDatos")) {

            } else {
                //ok
            }

            if (listoParaAgregar) {
                Intent Gano = new Intent(_Contexto, Gano.class);
                _Contexto.startActivity(Gano);
            }
        }

        @Override
        protected String doInBackground(String... parametros) {
            Log.d("Juego", "1");
            if (new HttpHandler(_Contexto).hasActiveInternetConnection()) {
                OkHttpClient client = new OkHttpClient();
                client.newBuilder().connectTimeout(10, TimeUnit.SECONDS)
                        .readTimeout(10, TimeUnit.SECONDS).build();
                Log.d("Juego", "2");
                if (parametros[0].trim().length() > 0) {
                    Log.d("Juego", "3");

                    RequestBody requestBody = new MultipartBody.Builder()
                            .setType(MultipartBody.FORM)
                            .addFormDataPart("id_juego", parametros[0])
                            .addFormDataPart("id_usuario", parametros[1])
                            .addFormDataPart("puntaje", parametros[2])
                            .addFormDataPart("fechaJuego", parametros[3])
                            .build();
                    Log.d("Juego", "4");

                    listoParaAgregar = true;

                    Log.d("Juego", "5");

                    Request request = new Request.Builder()
                            .url("http://integrapp.azurewebsites.net/azure/insertpuntos.php")
                            .method("POST", RequestBody.create(null, new byte[0]))
                            .post(requestBody)
                            .build();

                    Log.d("Juego", "6");

                    try {
                        Response response = client.newCall(request).execute();
                        String resultado = response.body().string();
                        Log.d("Juego", "7");
                        return resultado;
                    } catch (Exception e) {
                        Log.d("Debug", e.getMessage());
                        //mostrarError(e.getMessage()); // Error de Network
                        return "error";
                    }
                } else {
                    return "faltanDatos";
                }
            } else {
                return "error";
            }
        }
    }
}