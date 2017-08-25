package com.example.a42102578.integrapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class activity_cuchas extends AppCompatActivity {

    String IDs;
    Boolean listoParaAgregar;
    int[] VectorRandom = new int[10];
    ImageButton Cucha1;
    ImageButton Cucha2;
    ImageButton Cucha3;
    ImageButton Cucha4;
    ImageButton Cucha5;
    ImageButton Cucha6;
    ImageButton Cucha7;
    ImageButton Cucha8;
    ImageButton Cucha9;
    ImageButton Cucha10;
    TextView Puntaje;
    TextView Vida;
    TextView Proximo;
    int Contador;
    int Puntos;
    int Vidas;
    int Suma;
    String fecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuchas);
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        fecha = date.format(new Date());
        Cucha1 = (ImageButton) findViewById(R.id.CuchaUno);
        Cucha2 = (ImageButton) findViewById(R.id.CuchaDos);
        Cucha3 = (ImageButton) findViewById(R.id.CuchaTres);
        Cucha4 = (ImageButton) findViewById(R.id.CuchaCuatro);
        Cucha5 = (ImageButton) findViewById(R.id.CuchaCinco);
        Cucha6 = (ImageButton) findViewById(R.id.CuchaSeis);
        Cucha7 = (ImageButton) findViewById(R.id.CuchaSiete);
        Cucha8 = (ImageButton) findViewById(R.id.CuchaOcho);
        Cucha9 = (ImageButton) findViewById(R.id.CuchaNueve);
        Cucha10 = (ImageButton) findViewById(R.id.CuchaDiez);
        Puntaje = (TextView) findViewById(R.id.Puntos);
        Vida = (TextView) findViewById(R.id.Vidas);
        Proximo = (TextView) findViewById(R.id.Proximo);
        for (int i = 1; i < 11; i++) {
            int j = i - 1;
            VectorRandom[j] = i;
        }
        Random Azar = new Random();
        for (int i = 0; i < 10; i++) {
            int Random = Azar.nextInt(10);
            int Auxiliar;
            Auxiliar = VectorRandom[i];
            VectorRandom[i] = VectorRandom[Random];
            VectorRandom[Random] = Auxiliar;
        }
        Contador = 0;
        Puntos = 0;
        Vidas = 3;
        Proximo.setText(String.valueOf(VectorRandom[Contador]));
        Vida.setText(String.valueOf(Vidas));
        Bundle ID = getIntent().getExtras();
        IDs = ID.getString("id");
    }

    public void Adivinar(View Boton) {
        Suma = Integer.parseInt(String.valueOf(Boton.getTag())) + 1;
        if (Suma == VectorRandom[Contador])
        {
            Contador++;
            Puntos = Puntos + 5;
            Ganar();
            Log.d("Te agrandamo el cuarto", "");
            Proximo.setText(String.valueOf(VectorRandom[Contador]));
            Puntaje.setText(String.valueOf(Puntos));
        }
        else
        {
            Puntos = Puntos - 3;
            Vidas--;
            Ganar();
            Proximo.setText(String.valueOf(VectorRandom[Contador]));
            Puntaje.setText(String.valueOf(Puntos));
            Vida.setText(String.valueOf(Vidas));
        }
    }

    public void Ganar() {
        Log.d("Zeta", "Leogato1");
        if (Vidas > 0) {
            Log.d("Zeta", "Leogato2");
            if (Contador > 9) {
                Log.d("Zeta", "Leogato3");
                listoParaAgregar = false;
                String Juego = "4";
                String IDD = String.valueOf(IDs);
                enviarPuntaje(new String[]{Juego, IDD ,String.valueOf(Puntaje), fecha});
                Log.d("Zeta", "Leogato4");
            }

        } else {
            Intent aPerdiste = new Intent(this, Perder.class);
            startActivity(aPerdiste);
            finish();
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
