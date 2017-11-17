package com.example.a42102578.integrapp;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.CountDownTimer;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Handler;

import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Conceptos extends AppCompatActivity {
    Bundle ID;
    String IDs;
    String[] VectorDrawable = new String[7];
    int[] VectorRandom = new int[7];
    Boolean[] VectorBienMal = new Boolean[7];
    int[] VectorNoRepetir = new int[7];
    int Contador = 0;
    int contjugadas = 1;
    public Boolean listoParaAgregar = false;
    String fecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conceptos);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ID = getIntent().getExtras();
        IDs = ID.getString("id");
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        fecha = date.format(new Date());
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
        if (Contador == 7) {
            if (Boton.getId() == R.id.Bien) {
                if (VectorBienMal[numero]) {
                    Contador++;
                } else {
                    contjugadas++;
                    final Toast toast = Toast.makeText(getBaseContext(), "Respuesta incorrecta", Toast.LENGTH_SHORT);
                    toast.show();
                    new CountDownTimer(500, 1000) {
                        public void onTick(long millisUntilFinished) {
                            toast.show();
                        }

                        public void onFinish() {
                            toast.cancel();
                        }
                    }.start();
                }
            } else {
                if (!VectorBienMal[numero]) {
                    Contador++;
                } else {
                    contjugadas++;
                    final Toast toast = Toast.makeText(getBaseContext(), "Respuesta incorrecta", Toast.LENGTH_SHORT);
                    toast.show();
                    new CountDownTimer(500, 1000) {
                        public void onTick(long millisUntilFinished) {
                            toast.show();
                        }

                        public void onFinish() {
                            toast.cancel();
                        }
                    }.start();
                }
            }
        }
        if (Contador == 8) {
            Log.d("ID", "Entra al IF");
            Log.d("Fecha", fecha);
            if (IDs.equals(null)) {
                Intent Gano = new Intent(getApplicationContext(), Gano.class);
                startActivity(Gano);
                finish();
            }
            else
            {
                listoParaAgregar = false;
                String Juego = "2";
                String IDD = String.valueOf(IDs);
                enviarPuntaje(new String[]{Juego, IDD ,String.valueOf(Contador),fecha });
            }
        }
        if (Contador < 7) {
            if (Boton.getId() == R.id.Bien) {
                if (VectorBienMal[numero]) {
                    final Toast toast = Toast.makeText(getBaseContext(), "Respuesta correcta", Toast.LENGTH_SHORT);
                    toast.show();
                    new CountDownTimer(500, 1000) {
                        public void onTick(long millisUntilFinished) {
                            toast.show();
                        }

                        public void onFinish() {
                            toast.cancel();
                        }
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
                    final Toast toast = Toast.makeText(getBaseContext(), "Respuesta incorrecta", Toast.LENGTH_SHORT);
                    toast.show();
                    new CountDownTimer(500, 1000) {
                        public void onTick(long millisUntilFinished) {
                            toast.show();
                        }

                        public void onFinish() {
                            toast.cancel();
                        }
                    }.start();
                }
            } else {
                if (!VectorBienMal[numero]) {
                    final Toast toast = Toast.makeText(getBaseContext(), "Respuesta correcta", Toast.LENGTH_SHORT);
                    toast.show();
                    new CountDownTimer(500, 1000) {
                        public void onTick(long millisUntilFinished) {
                            toast.show();
                        }

                        public void onFinish() {
                            toast.cancel();
                        }
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
                    final Toast toast = Toast.makeText(getBaseContext(), "Respuesta incorrecta", Toast.LENGTH_SHORT);
                    toast.show();
                    new CountDownTimer(500, 1000) {
                        public void onTick(long millisUntilFinished) {
                            toast.show();
                        }

                        public void onFinish() {
                            toast.cancel();
                        }
                    }.start();

                }
            }
        }
    }

    public void btnJugarCon(View VistaR) {
        finish();
        startActivity(getIntent());
    }

    public void Magia(int Numero, ImageView Imagen, int NumeroParametro) {
        switch (VectorRandom[Numero]) {
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
                Intent Gano = new Intent(getApplicationContext(), Gano.class);
                startActivity(Gano);
                finish();
            }
        }

        @Override
        protected String doInBackground(String... parametros) {
            Log.d("Juego", "1");
            if (new HttpHandler(getApplicationContext()).hasActiveInternetConnection()) {
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
