package com.example.a42102578.integrapp;

import android.util.EventLog;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ImageView;

import org.cocos2d.actions.interval.MoveTo;
import org.cocos2d.actions.interval.ScaleBy;
import org.cocos2d.layers.Layer;
import org.cocos2d.nodes.Director;
import org.cocos2d.nodes.Label;
import org.cocos2d.nodes.Scene;
import org.cocos2d.nodes.Sprite;
import org.cocos2d.opengl.CCGLSurfaceView;
import org.cocos2d.types.CCColor3B;
import org.cocos2d.types.CCSize;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by 42102517 on 18/7/2017.
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

    float PosInicialX1;
    float PosInicialY1;
    float PosInicialX2;
    float PosInicialY2;
    float PosInicialX3;
    float PosInicialY3;
    float PosInicialX4;
    float PosInicialY4;
    float PosInicialX5;
    float PosInicialY5;
    float PosInicialX6;
    float PosInicialY6;
    float PosInicialX7;
    float PosInicialY7;
    float PosInicialX8;
    float PosInicialY8;
    float PosInicialX9;
    float PosInicialY9;
    float PosInicialX10;
    float PosInicialY10;

    Label lblHueso;
    Integer NumeroObjetoTocado;


    public clsPelotas(CCGLSurfaceView VistaPelotas) {
        _VistaPelotas = VistaPelotas;
        NumeroObjetoTocado = 0;
    }

    public void ComenzarJuego() {
        //comienza el juego
        Director.sharedDirector().attachInView(_VistaPelotas);
        PantallaDelDispositivo = Director.sharedDirector().displaySize();
        //ejecucion de la escena
        Director.sharedDirector().runWithScene(EscenaDePelotas());

      /*  //random perros
        Random generadorAzar;
        generadorAzar = new Random();
        Integer delal10;
        delal10 = generadorAzar.nextInt(11);*/

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

        private void PonerImagenFondo()
        {
            ImagenFondo = Sprite.sprite("fondoperro.jpg");
            ImagenFondo.setPosition(PantallaDelDispositivo.width / 2, PantallaDelDispositivo.height / 2);
            //escalando el fondo de la app
            ImagenFondo.runAction(ScaleBy.action(0.01f, 2.0f, 2.0f));
            super.addChild(ImagenFondo);
        }
    }

    class CapaDelPerro extends Layer {
        public CapaDelPerro()
        {
            PonerCapaDelPerro();
            PonerNumeroInicial();
        }
        private void PonerCapaDelPerro()
        {
            Perro = Sprite.sprite("perrito.png");
            Perro.setPosition(PantallaDelDispositivo.width / 2, Perro.getHeight() / 2);
            super.addChild(Perro);
        }

        private void PonerNumeroInicial()
        {
            Random numeroazar;
            numeroazar = new Random();
            int numazar = numeroazar.nextInt(11);
            String numero = "";
            numero = String.valueOf(numazar);
            lblHueso = Label.label(numero, "Comic Sans", 50);
            lblHueso.setPosition(PantallaDelDispositivo.getWidth() * 0.50f, Perro.getHeight() / 8);
            CCColor3B colornumero = new CCColor3B(37, 37, 132);
            lblHueso.setColor(colornumero);
            super.addChild(lblHueso);
        }

     /*   private void PonerNumero() {
            Random numeroazar;
            numeroazar = new Random();
            int numazar = numeroazar.nextInt(11);
            //int numerojugar = 5;
            lblHueso = Label.label("", "Comic Sans", 50);
            lblHueso.setPosition(PantallaDelDispositivo.getWidth()* 0.50f, Perro.getHeight()/8);
            CCColor3B colornumero = new CCColor3B(37, 37, 132);
            lblHueso.setColor(colornumero);

            while (numazar!=0)
            {
                lblHueso.setString("" + numazar);
            }while (numazar!=0);
            super.addChild(lblHueso);
        }*/
    }

    //-----------------PELOTA 1----------------------
    class CapaPelotas extends Layer
    {
        public CapaPelotas()
        {
            PonerPelotas();
            this.setIsTouchEnabled(true);
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
            //List<Sprite> listaSprites = Arrays.asList(Pelota1,Pelota2,Pelota3,Pelota4,Pelota5,Pelota6,Pelota7,Pelota8,Pelota9, Pelota10);

            //primera fila
            float PosicionInicialX, PosicionInicialY;

            PosInicialX1= PantallaDelDispositivo.width * 0.20f;
            PosInicialY1 = PantallaDelDispositivo.height - PantallaDelDispositivo.height * 0.1f;
            Pelota1.setPosition(PosInicialX1, PosInicialY1);

            float PosicionInicialX2 = PantallaDelDispositivo.width * 0.40f;
            float PosicionInicialY2 = PantallaDelDispositivo.height - PantallaDelDispositivo.height * 0.1f;
            Pelota2.setPosition(PosicionInicialX2, PosicionInicialY2);

            float PosicionInicialX3 = PantallaDelDispositivo.width * 0.60f;
            float PosicionInicialY3 = PantallaDelDispositivo.height - PantallaDelDispositivo.height * 0.1f;
            Pelota3.setPosition(PosicionInicialX3, PosicionInicialY3);

            float PosicionInicialX4 = PantallaDelDispositivo.width * 0.80f;
            float PosicionInicialY4 = PantallaDelDispositivo.height - PantallaDelDispositivo.height * 0.1f;
            Pelota4.setPosition(PosicionInicialX4, PosicionInicialY4);

            //segunda fila
           float PosicionInicialX5 = PantallaDelDispositivo.width * 0.30f;
           float PosicionInicialY5 = PantallaDelDispositivo.height - PantallaDelDispositivo.height * 0.2f;
            Pelota5.setPosition(PosicionInicialX5, PosicionInicialY5);

            float PosicionInicialX6 = PantallaDelDispositivo.width * 0.50f;
            float PosicionInicialY6 = PantallaDelDispositivo.height - PantallaDelDispositivo.height * 0.2f;
            Pelota6.setPosition(PosicionInicialX6, PosicionInicialY6);

            float PosicionInicialX7 = PantallaDelDispositivo.width * 0.70f;
            float PosicionInicialY7 = PantallaDelDispositivo.height - PantallaDelDispositivo.height * 0.2f;
            Pelota7.setPosition(PosicionInicialX7, PosicionInicialY7);

            //tercera fila
            float PosicionInicialX8 = PantallaDelDispositivo.width * 0.40f;
            float PosicionInicialY8 = PantallaDelDispositivo.height - PantallaDelDispositivo.height * 0.3f;
            Pelota8.setPosition(PosicionInicialX8, PosicionInicialY8);

            float PosicionInicialX9 = PantallaDelDispositivo.width * 0.60f;
            float PosicionInicialY9 = PantallaDelDispositivo.height - PantallaDelDispositivo.height * 0.3f;
            Pelota9.setPosition(PosicionInicialX9, PosicionInicialY9);

            //cuarta fila
            float PosicionInicialX10 = PantallaDelDispositivo.width * 0.50f;
            float PosicionInicialY10 = PantallaDelDispositivo.height - PantallaDelDispositivo.height * 0.4f;
            Pelota10.setPosition(PosicionInicialX10, PosicionInicialY10);

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

            Log.d("EstaTocando", "BI: "+bordeizquierdo + " - BD: "+bordederecho+" - BInf: "+bordeinferior+" - BS: "+bordesuperior);


            if (posicionXtocada > bordeizquierdo && posicionXtocada < bordederecho && posicionYtocada < bordesuperior && posicionYtocada > bordeinferior) {
                estatocando = true;
            } else {
                estatocando = false;
            }

            return estatocando;
        }

        //-----------------------MOVIMIENTOS-------------------------------------

        public boolean ccTouchesBegan(MotionEvent event)
        {
            float posX = event.getX();
            float posY = PantallaDelDispositivo.getHeight() - event.getY();
            Log.d("Toque comienza", "X: "+ posX+" -Y: " +posY);

            if (EstaTocandoElObjeto(posX, posY, Pelota1)) {
                Log.d("EstaTocando", "Esta tocando la 1");
                NumeroObjetoTocado = 1;
            }else {
                if (EstaTocandoElObjeto(posX,posY,Pelota2)) {
                    Log.d("EstaTocando", "Esta tocando la 2");
                    NumeroObjetoTocado = 2;
                }
                else {
                    if (EstaTocandoElObjeto(posX, posY, Pelota3))
                    {
                        Log.d("EstaTocando", "Esta tocando la 3");
                        NumeroObjetoTocado = 3;
                    }
                    else
                    {
                        if (EstaTocandoElObjeto(posX,posY,Pelota4))
                        {
                            Log.d("EstaTocando", "Esta tocando la 4");
                            NumeroObjetoTocado = 4;
                        }
                        else
                        {
                            if (EstaTocandoElObjeto(posX, posY, Pelota5))
                            {
                                Log.d("EstaTocando", "Esta tocando la 5");
                                NumeroObjetoTocado = 5;
                            }
                            else
                            {
                                if (EstaTocandoElObjeto(posX, posY, Pelota6))
                                {
                                    Log.d("EstaTocando", "Esta tocando la 6");
                                    NumeroObjetoTocado = 6;
                                }
                                else
                                {
                                    if (EstaTocandoElObjeto(posX,posY,Pelota7))
                                    {
                                        Log.d("EstaTocando", "Esta tocando la 7");
                                        NumeroObjetoTocado = 7;
                                    }
                                    else
                                    {
                                        if (EstaTocandoElObjeto(posX, posY,Pelota8))
                                        {
                                            Log.d("EstaTocando", "Esta tocando la 8");
                                            NumeroObjetoTocado = 8;
                                        }
                                        else
                                        {
                                            if (EstaTocandoElObjeto(posX, posY, Pelota9))
                                            {
                                                Log.d("EstaTocando", "Esta tocando la 9");
                                                NumeroObjetoTocado = 9;
                                            }
                                            else
                                            {
                                                if (EstaTocandoElObjeto(posX,posY,Pelota10))
                                                {
                                                    Log.d("EstaTocando", "Esta tocando la 10");
                                                    NumeroObjetoTocado = 10;
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

        public boolean ccTouchesMoved (MotionEvent event)
        {
            float posX = event.getX();
            float posY = PantallaDelDispositivo.getHeight() - event.getY();
            Log.d("Toque comienza", "X: "+ posX+" -Y: " +posY);

           /* if (NumeroObjetoTocado == 1)
            {
                Pelota1.setPosition(posX, posY);
            }*/
           switch (NumeroObjetoTocado)
           {
               case 1:
                   Pelota1.setPosition(posX, posY);
                   break;
               case 2:
                   Pelota2.setPosition(posX, posY);
                   break;
               case 3:
                   Pelota3.setPosition(posX, posY);
                   break;
               case 4:
                   Pelota4.setPosition(posX, posY);
                   break;
               case 5:
                   Pelota5.setPosition(posX, posY);
                   break;
               case 6:
                   Pelota6.setPosition(posX, posY);
                   break;
               case 7:
                   Pelota7.setPosition(posX, posY);
                   break;
               case 8:
                   Pelota8.setPosition(posX, posY);
                   break;
               case 9:
                   Pelota9.setPosition(posX, posY);
                   break;
               case 10:
                   Pelota10.setPosition(posX, posY);
                   break;
           }

            //Log.d("EstaMoviendo", "Esta moviendo la pelota1");
            return true;
        }

        public boolean ccTouchesEnded (MotionEvent event)
        {
            Pelota1.runAction(MoveTo.action(1.0f, PosInicialX1,PosInicialY1));
            Log.d("Toque Termino", "solto el objeto");
            Pelota2.runAction(MoveTo.action(1.0f, PosInicialX2,PosInicialY2));
            Log.d("Toque Termino", "solto el objeto");
            Pelota3.runAction(MoveTo.action(1.0f, PosInicialX3,PosInicialY3));
            Log.d("Toque Termino", "solto el objeto");
            Pelota4.runAction(MoveTo.action(1.0f, PosInicialX4,PosInicialY4));
            Log.d("Toque Termino", "solto el objeto");
            Pelota5.runAction(MoveTo.action(1.0f, PosInicialX5,PosInicialY5));
            Log.d("Toque Termino", "solto el objeto");
            Pelota6.runAction(MoveTo.action(1.0f, PosInicialX6,PosInicialY6));
            Log.d("Toque Termino", "solto el objeto");
            Pelota7.runAction(MoveTo.action(1.0f, PosInicialX7,PosInicialY7));
            Log.d("Toque Termino", "solto el objeto");
            Pelota8.runAction(MoveTo.action(1.0f, PosInicialX8,PosInicialY8));
            Log.d("Toque Termino", "solto el objeto");
            Pelota9.runAction(MoveTo.action(1.0f, PosInicialX9,PosInicialY9));
            Log.d("Toque Termino", "solto el objeto");
            Pelota10.runAction(MoveTo.action(1.0f, PosInicialX10,PosInicialY10));
            Log.d("Toque Termino", "solto el objeto");
            return true;
        }



    }


}


