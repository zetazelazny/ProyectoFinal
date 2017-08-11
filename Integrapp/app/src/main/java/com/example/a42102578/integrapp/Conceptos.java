package com.example.a42102578.integrapp;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.logging.Handler;

public class Conceptos extends AppCompatActivity {
    String[] VectorDrawable = new String[7];
    int[] VectorRandom = new int[7];
    Boolean[] VectorBienMal = new Boolean[7];
    int[] VectorNoRepetir = new int[7];
    int Contador = 0;
    int contjugadas=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conceptos);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Drawable.ConstantState CodigoImagenAbrazar = ContextCompat.getDrawable(this, R.drawable.abrazar).getConstantState();
        Drawable.ConstantState CodigoImagenBesar = ContextCompat.getDrawable(this, R.drawable.besar).getConstantState();
        Drawable.ConstantState CodigoImagenEscupir = ContextCompat.getDrawable(this, R.drawable.escupir).getConstantState();
        Drawable.ConstantState CodigoImagenGolpear = ContextCompat.getDrawable(this, R.drawable.golpear).getConstantState();
        Drawable.ConstantState CodigoImagenGuiar = ContextCompat.getDrawable(this, R.drawable.guiar).getConstantState();
        Drawable.ConstantState CodigoImagenInsultar = ContextCompat.getDrawable(this, R.drawable.insultar).getConstantState();
        Drawable.ConstantState CodigoImagenPintar = ContextCompat.getDrawable(this, R.drawable.pintar).getConstantState();
        String ImagenAbrazar = String.valueOf(CodigoImagenAbrazar);
        String ImagenBesar = String.valueOf(CodigoImagenBesar);
        String ImagenEscupir = String.valueOf(CodigoImagenEscupir);
        String ImagenGolpear = String.valueOf(CodigoImagenGolpear);
        String ImagenGuiar = String.valueOf(CodigoImagenGuiar);
        String ImagenInsultar = String.valueOf(CodigoImagenInsultar);
        String ImagenPintar = String.valueOf(CodigoImagenPintar);
        VectorDrawable[0] = (ImagenAbrazar);
        VectorDrawable[1] = (ImagenBesar);
        VectorDrawable[2] = (ImagenEscupir);
        VectorDrawable[3] = (ImagenGolpear);
        VectorDrawable[4] = (ImagenGuiar);
        VectorDrawable[5] = (ImagenInsultar);
        VectorDrawable[6] = (ImagenPintar);
        VectorBienMal[0] = true;
        VectorBienMal[1] = true;
        VectorBienMal[2] = false;
        VectorBienMal[3] = false;
        VectorBienMal[4] = true;
        VectorBienMal[5] = false;
        VectorBienMal[6] = true;
        for (int i = 0; i < 7; i++) {
            VectorRandom[i] = i;
        }
        Random Azar = new Random();
        for (int i = 0; i < 7; i++) {
            int Random = Azar.nextInt(7);
            int Auxiliar;
            Auxiliar = VectorRandom[i];
            VectorRandom[i] = VectorRandom[Random];
            VectorRandom[Random] = Auxiliar;
        }
        ImageView Imagen = (ImageView) findViewById(R.id.Imagen);
        Magia(0, Imagen, Contador);
        Contador++;
    }

    public void Verificar(View VistaR) {
        ImageButton Boton = (ImageButton) VistaR;
        ImageView Imagen = (ImageView) findViewById(R.id.Imagen);
        Drawable.ConstantState CodImagen = Imagen.getDrawable().getConstantState();
        String Codiguito = CodImagen.toString();

        int numero = 0;
        for (int i = 0; i < 7; i++) {
            if (Codiguito.equals(VectorDrawable[i])) {
                numero = i;
            }
        }
        if (Contador == 7)
        {
            if (Boton.getId() == R.id.Bien) {
                if (VectorBienMal[numero]) {
                   Contador++;
                } else {
                    contjugadas++;
                    final Toast toast = Toast.makeText(getBaseContext(), "Respuesta incorrecta",Toast.LENGTH_SHORT);
                    toast.show();
                    new CountDownTimer(500, 1000)
                    {
                        public void onTick(long millisUntilFinished) {toast.show();}
                        public void onFinish() {toast.cancel();}
                    }.start();
                }
            }
            else
            {
                if (!VectorBienMal[numero]) {
                  Contador++;
                } else {
                    contjugadas++;
                    final Toast toast = Toast.makeText(getBaseContext(), "Respuesta incorrecta",Toast.LENGTH_SHORT);
                    toast.show();
                    new CountDownTimer(500, 1000)
                    {
                        public void onTick(long millisUntilFinished) {toast.show();}
                        public void onFinish() {toast.cancel();}
                    }.start();
                }
            }
        }
        if (Contador == 8)
        {
            Intent Gano = new Intent(this, Gano.class);
            startActivity(Gano);
            finish();
        }
        if (Contador < 7)
        {
            if (Boton.getId() == R.id.Bien) {
                if (VectorBienMal[numero]) {
                    final Toast toast = Toast.makeText(getBaseContext(), "Respuesta correcta",Toast.LENGTH_SHORT);
                    toast.show();
                    new CountDownTimer(500, 1000)
                    {
                        public void onTick(long millisUntilFinished) {toast.show();}
                        public void onFinish() {toast.cancel();}
                    }.start();
                    contjugadas++;
                    Random Azar = new Random();
                    int Random;
                    do {
                        Random = Azar.nextInt(7);
                    }
                    while (Random == VectorNoRepetir[0] || Random == VectorNoRepetir[1] || Random == VectorNoRepetir[2] || Random == VectorNoRepetir[3] || Random == VectorNoRepetir[4] || Random == VectorNoRepetir[5] || Random == VectorNoRepetir[6]);
                    Magia(Random, Imagen, Contador);
                    Contador++;
                } else {
                    contjugadas++;
                    final Toast toast = Toast.makeText(getBaseContext(), "Respuesta incorrecta",Toast.LENGTH_SHORT);
                    toast.show();
                    new CountDownTimer(500, 1000)
                    {
                        public void onTick(long millisUntilFinished) {toast.show();}
                        public void onFinish() {toast.cancel();}
                    }.start();
                }
            }
            else
            {
                if (!VectorBienMal[numero]) {
                    final Toast toast = Toast.makeText(getBaseContext(), "Respuesta correcta",Toast.LENGTH_SHORT);
                    toast.show();
                    new CountDownTimer(500, 1000)
                    {
                        public void onTick(long millisUntilFinished) {toast.show();}
                        public void onFinish() {toast.cancel();}
                    }.start();
                    contjugadas++;
                    Random Azar = new Random();
                    int Random;
                    do {
                        Random = Azar.nextInt(7);
                    }
                    while (Random == VectorNoRepetir[0] || Random == VectorNoRepetir[1] || Random == VectorNoRepetir[2] || Random == VectorNoRepetir[3] || Random == VectorNoRepetir[4] || Random == VectorNoRepetir[5] || Random == VectorNoRepetir[6]);
                    Magia(Random, Imagen, Contador);
                    Contador++;
                } else {
                    contjugadas++;
                    final Toast toast = Toast.makeText(getBaseContext(), "Respuesta incorrecta",Toast.LENGTH_SHORT);
                    toast.show();
                    new CountDownTimer(500, 1000)
                    {
                        public void onTick(long millisUntilFinished) {toast.show();}
                        public void onFinish() {toast.cancel();}
                    }.start();

                }
            }
        }
    }

    public void btnJugarCon(View VistaR)
    {
        finish();
        startActivity(getIntent());
    }

    public void Magia (int Numero, ImageView Imagen, int NumeroParametro)
    {
        switch (VectorRandom[Numero])
        {
            case (0):
                Imagen.setImageResource(R.drawable.abrazar);
                VectorNoRepetir[NumeroParametro] = Numero;
                break;

            case (1):
                Imagen.setImageResource(R.drawable.besar);
                VectorNoRepetir[NumeroParametro] = Numero;
                break;

            case (2):
                Imagen.setImageResource(R.drawable.escupir);
                VectorNoRepetir[NumeroParametro] = Numero;
                break;

            case (3):
                Imagen.setImageResource(R.drawable.golpear);
                VectorNoRepetir[NumeroParametro] = Numero;
                break;

            case (4):
                Imagen.setImageResource(R.drawable.guiar);
                VectorNoRepetir[NumeroParametro] = Numero;
                break;

            case (5):
                Imagen.setImageResource(R.drawable.insultar);
                VectorNoRepetir[NumeroParametro] = Numero;
                break;

            case (6):
                Imagen.setImageResource(R.drawable.pintar);
                VectorNoRepetir[NumeroParametro] = Numero;
                break;
        }
    }
    public void SubirResult()
    {
        Subir.start();
    }

    Thread Subir = new Thread()
    {
        @Override
        public void run() {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                String RutaServidor, NombreBase, NombreUsuario, PasswordUsuario, CadenaCompleta;
                int Puerto;
                RutaServidor = "ACA LA RUTA";
                Puerto = 1;//ACA EL PUERTO
                NombreBase = "NOMBRE BASE";
                NombreUsuario = "USUARIO";
                PasswordUsuario = "PASS";
                CadenaCompleta = "jdbc:mysql://" + RutaServidor + ":" + Puerto + "/" + NombreBase;
                Connection Conexion = DriverManager.getConnection(CadenaCompleta, NombreUsuario, PasswordUsuario);
                Statement Instruccion = Conexion.createStatement();
                String SQLdeLectura = "insert into tabla values juego incorrectas"; //ACA HAY QUE METER TABLA DE RANKINGS (PARA LA DEMO NADA MAS)
                ResultSet Resultados = Instruccion.executeQuery(SQLdeLectura);
                if (Resultados.first()) {
                    while (Resultados.next()) {

                    }
                } else {
                    //NO trajo nada
                }
            }catch (ClassNotFoundException error)
            {

            }
            catch (SQLException error) {

            }
        }
    };

}
