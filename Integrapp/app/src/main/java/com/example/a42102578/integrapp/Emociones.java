package com.example.a42102578.integrapp;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.Image;
import android.opengl.Visibility;
import android.os.AsyncTask;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import org.cocos2d.opengl.CCGLSurfaceView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Emociones extends AppCompatActivity {

    boolean listoParaAgregar;
    Bundle ID;
    String IDs;
    String fecha;
    String[] VectorEmocion;
    int[] VectorRandom;
    TextView Texto;
    ImageView Cabeza;
    int A = 0;
    int Contador = 0;
    int ContadorVictorias = 0;
    int Vidas = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emociones);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        ID = getIntent().getExtras();
        IDs = ID.getString("id");
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        fecha = date.format(new Date());
        VectorRandom = new int[5];
        VectorEmocion = new String[5];
        Cabeza = (ImageView) findViewById(R.id.cabeza);
        Texto = (TextView) findViewById(R.id.Txt);
        for (int i = 0; i < 5; i++) {
            VectorRandom[i] = i;
        }

        for (int i = 0; i < 5; i++) {
            int Aux;
            Random Azar = new Random();
            int R = Azar.nextInt(5);
            Aux = VectorRandom[i];
            VectorRandom[i] = VectorRandom[R];
            VectorRandom[R] = Aux;
        }

        VectorEmocion[0] = "sorprendido";
        VectorEmocion[1] = "triste";
        VectorEmocion[2] = "contento";
        VectorEmocion[3] = "enojado";
        VectorEmocion[4] = "llorando";
        int B = VectorRandom[0];
        Texto.setText(VectorEmocion[B]);
    }

    public void Tocar(View Vista) {
        ImageButton Boton = (ImageButton) Vista;
        int Tag = Integer.parseInt(String.valueOf(Boton.getTag()));
        switch (Tag) {
            case 1:
                if (A == 0) {
                    Cabeza.setImageResource(R.drawable.cabezaojosabiertos);
                    A++;
                    break;
                }
                if (A == 1) {
                    Log.d("Validando", "Entra a 'A==1'");
                    if (Cabeza.getDrawable().getConstantState() == ContextCompat.getDrawable(this, R.drawable.cabezabocacontento).getConstantState()) {
                        Log.d("Validando", "Entra al if de boca contento");
                        Cabeza.setImageResource(R.drawable.cabezacontentocompleto);
                        if (VectorEmocion[VectorRandom[Contador]] == "contento") {
                            if (Contador == 4) {
                                if (IDs.equals(null)) {
                                    Intent Gano = new Intent(getApplicationContext(), Gano.class);
                                    startActivity(Gano);
                                    finish();
                                } else {
                                    listoParaAgregar = false;
                                    String Juego = "4";
                                    String IDD = String.valueOf(IDs);
                                    enviarPuntaje(new String[]{Juego, IDD, String.valueOf(Contador), fecha});
                                }
                            } else {
                                Contador++;
                                int B = VectorRandom[Contador];
                                Texto.setText(VectorEmocion[B]);
                                final Timer Reloj = new Timer();
                                TimerTask Tarea = new TimerTask() {
                                    @Override
                                    public void run() {
                                        runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                AA();
                                                Reloj.cancel();
                                            }
                                        });
                                    }
                                };
                                Reloj.schedule(Tarea, 2000, 6000);
                            }
                        }
                        A = 0;
                    }
                    if (Cabeza.getDrawable().getConstantState() == ContextCompat.getDrawable(this, R.drawable.cabezabocasorprendido).getConstantState()) {
                        Log.d("Validando", "Entra al if de boca sorprendido");
                        Cabeza.setImageResource(R.drawable.cabezasorprendidocompleto);
                        if (VectorEmocion[VectorRandom[Contador]] == "sorprendido") {
                            if (Contador == 4) {
                                if (IDs.equals(null)) {
                                    Intent Gano = new Intent(getApplicationContext(), Gano.class);
                                    startActivity(Gano);
                                    finish();
                                } else {
                                    listoParaAgregar = false;
                                    String Juego = "4";
                                    String IDD = String.valueOf(IDs);
                                    enviarPuntaje(new String[]{Juego, IDD, String.valueOf(Contador), fecha});
                                }
                            } else {
                                Contador++;
                                int B = VectorRandom[Contador];
                                Texto.setText(VectorEmocion[B]);
                                final Timer Reloj = new Timer();
                                TimerTask Tarea = new TimerTask() {
                                    @Override
                                    public void run() {
                                        runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                AA();
                                                Reloj.cancel();
                                            }
                                        });
                                    }
                                };
                                Reloj.schedule(Tarea, 2000, 6000);
                            }
                        }
                        A = 0;
                    }
                    if (Cabeza.getDrawable().getConstantState() == ContextCompat.getDrawable(this, R.drawable.cabezabocaenojado).getConstantState()) {
                        Log.d("Validando", "Entra al if de boca enojado");
                        Cabeza.setImageResource(R.drawable.cabezaenojadocompleto);
                        if (VectorEmocion[VectorRandom[Contador]] == "enojado") {
                            if (Contador == 4) {
                                if (IDs.equals(null)) {
                                    Intent Gano = new Intent(getApplicationContext(), Gano.class);
                                    startActivity(Gano);
                                    finish();
                                } else {
                                    listoParaAgregar = false;
                                    String Juego = "4";
                                    String IDD = String.valueOf(IDs);
                                    enviarPuntaje(new String[]{Juego, IDD, String.valueOf(Contador), fecha});
                                }
                            } else {
                                Contador++;
                                int B = VectorRandom[Contador];
                                Texto.setText(VectorEmocion[B]);
                                final Timer Reloj = new Timer();
                                TimerTask Tarea = new TimerTask() {
                                    @Override
                                    public void run() {
                                        runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                AA();
                                                Reloj.cancel();
                                            }
                                        });
                                    }
                                };
                                Reloj.schedule(Tarea, 2000, 6000);
                            }
                        }
                        A = 0;
                    }
                    if (Cabeza.getDrawable().getConstantState() == ContextCompat.getDrawable(this, R.drawable.cabezabocatriste).getConstantState()) {
                        Log.d("Validando", "Entra al if de boca contento");
                        Vidas--;
                        if (Vidas == 0) {
                            Intent Perdio = new Intent(this, Perder.class);
                            startActivity(Perdio);
                        }
                        Cabeza.setImageResource(R.drawable.cabeza);
                        A = 0;
                    }
                    if (Cabeza.getDrawable().getConstantState() == ContextCompat.getDrawable(this, R.drawable.cabezabocallanto).getConstantState()) {
                        Log.d("Validando", "Entra al if de boca contento");
                        Vidas--;
                        if (Vidas == 0) {
                            Intent Perdio = new Intent(this, Perder.class);
                            startActivity(Perdio);
                        }
                        Cabeza.setImageResource(R.drawable.cabeza);
                        A = 0;
                    }
                }
                break;
            case 2:
                if (A == 0) {
                    Cabeza.setImageResource(R.drawable.cabezaojoscerrados);
                    A++;
                    break;
                }
                if (A == 1) {
                    Log.d("Validando", "Entra a 'A==1'");
                    if (Cabeza.getDrawable().getConstantState() == ContextCompat.getDrawable(this, R.drawable.cabezabocatriste).getConstantState()) {
                        Log.d("Validando", "Entra al if de boca contento");
                        Cabeza.setImageResource(R.drawable.cabezatristecompleto);
                        if (VectorEmocion[VectorRandom[Contador]] == "triste") {
                            if (Contador == 4) {
                                if (IDs.equals(null)) {
                                    Intent Gano = new Intent(getApplicationContext(), Gano.class);
                                    startActivity(Gano);
                                    finish();
                                } else {
                                    listoParaAgregar = false;
                                    String Juego = "4";
                                    String IDD = String.valueOf(IDs);
                                    enviarPuntaje(new String[]{Juego, IDD, String.valueOf(Contador), fecha});
                                }
                            } else {
                                Contador++;
                                int B = VectorRandom[Contador];
                                Texto.setText(VectorEmocion[B]);
                                final Timer Reloj = new Timer();
                                TimerTask Tarea = new TimerTask() {
                                    @Override
                                    public void run() {
                                        runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                AA();
                                                Reloj.cancel();
                                            }
                                        });
                                    }
                                };
                                Reloj.schedule(Tarea, 2000, 6000);
                            }
                        }
                        A = 0;
                    }
                    if (Cabeza.getDrawable().getConstantState() == ContextCompat.getDrawable(this, R.drawable.cabezabocallanto).getConstantState()) {
                        Log.d("Validando", "Entra al if de boca sorprendido");
                        Cabeza.setImageResource(R.drawable.cabezallantocompleto);
                        if (VectorEmocion[VectorRandom[Contador]] == "llorando") {
                            if (Contador == 4) {
                                if (IDs.equals(null)) {
                                    Intent Gano = new Intent(getApplicationContext(), Gano.class);
                                    startActivity(Gano);
                                    finish();
                                } else {
                                    listoParaAgregar = false;
                                    String Juego = "4";
                                    String IDD = String.valueOf(IDs);
                                    enviarPuntaje(new String[]{Juego, IDD, String.valueOf(Contador), fecha});
                                }
                            } else {
                                Contador++;
                                int B = VectorRandom[Contador];
                                Texto.setText(VectorEmocion[B]);
                                final Timer Reloj = new Timer();
                                TimerTask Tarea = new TimerTask() {
                                    @Override
                                    public void run() {
                                        runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                AA();
                                                Reloj.cancel();
                                            }
                                        });
                                    }
                                };
                                Reloj.schedule(Tarea, 2000, 6000);
                            }
                        }
                        A = 0;
                    }

                    if (Cabeza.getDrawable().getConstantState() == ContextCompat.getDrawable(this, R.drawable.cabezabocacontento).getConstantState()) {
                        Log.d("Validando", "Entra al if de boca contento");
                        Vidas--;
                        if (Vidas == 0) {
                            Intent Perdio = new Intent(this, Perder.class);
                            startActivity(Perdio);
                        }
                        Cabeza.setImageResource(R.drawable.cabeza);
                        A = 0;
                    }
                    if (Cabeza.getDrawable().getConstantState() == ContextCompat.getDrawable(this, R.drawable.cabezabocasorprendido).getConstantState()) {
                        Log.d("Validando", "Entra al if de boca contento");
                        Vidas--;
                        if (Vidas == 0) {
                            Intent Perdio = new Intent(this, Perder.class);
                            startActivity(Perdio);
                        }
                        Cabeza.setImageResource(R.drawable.cabeza);
                        A = 0;
                    }
                    if (Cabeza.getDrawable().getConstantState() == ContextCompat.getDrawable(this, R.drawable.cabezabocaenojado).getConstantState()) {
                        Log.d("Validando", "Entra al if de boca contento");
                        Vidas--;
                        if (Vidas == 0) {
                            Intent Perdio = new Intent(this, Perder.class);
                            startActivity(Perdio);
                        }
                        Cabeza.setImageResource(R.drawable.cabeza);
                        A = 0;
                    }
                }
                break;
            case 3:
                if (A == 0) {
                    Cabeza.setImageResource(R.drawable.cabezabocacontento);
                    A++;
                    break;
                }
                if (A == 1) {
                    if (Cabeza.getDrawable().getConstantState() == ContextCompat.getDrawable(this, R.drawable.cabezaojosabiertos).getConstantState()) {
                        if (VectorEmocion[VectorRandom[Contador]] == "contento") {
                            if (Contador == 4) {
                                if (IDs.equals(null)) {
                                    Intent Gano = new Intent(getApplicationContext(), Gano.class);
                                    startActivity(Gano);
                                    finish();
                                } else {
                                    listoParaAgregar = false;
                                    String Juego = "4";
                                    String IDD = String.valueOf(IDs);
                                    enviarPuntaje(new String[]{Juego, IDD, String.valueOf(Contador), fecha});
                                }
                            } else {
                                Contador++;
                                int B = VectorRandom[Contador];
                                Texto.setText(VectorEmocion[B]);
                                final Timer Reloj = new Timer();
                                TimerTask Tarea = new TimerTask() {
                                    @Override
                                    public void run() {
                                        runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                AA();
                                                Reloj.cancel();
                                            }
                                        });
                                    }
                                };
                                Reloj.schedule(Tarea, 2000, 6000);
                            }
                        }
                        A = 0;
                    }
                    if (Cabeza.getDrawable().getConstantState() == ContextCompat.getDrawable(this, R.drawable.cabezaojoscerrados).getConstantState()) {
                        Log.d("Validando", "Entra al if de boca contento");
                        Vidas--;
                        if (Vidas == 0) {
                            Intent Perdio = new Intent(this, Perder.class);
                            startActivity(Perdio);
                        }
                        Cabeza.setImageResource(R.drawable.cabeza);
                        A = 0;
                    }
                }
                break;
            case 4:
                if (A == 0) {
                    Cabeza.setImageResource(R.drawable.cabezabocaenojado);
                    A++;
                    break;
                }
                if (A == 1) {
                    if (Cabeza.getDrawable().getConstantState() == ContextCompat.getDrawable(this, R.drawable.cabezaojosabiertos).getConstantState()) {
                        if (VectorEmocion[VectorRandom[Contador]] == "enojado") {
                            if (Contador == 4) {
                                if (IDs.equals(null)) {
                                    Intent Gano = new Intent(getApplicationContext(), Gano.class);
                                    startActivity(Gano);
                                    finish();
                                } else {
                                    listoParaAgregar = false;
                                    String Juego = "4";
                                    String IDD = String.valueOf(IDs);
                                    enviarPuntaje(new String[]{Juego, IDD, String.valueOf(Contador), fecha});
                                }
                            } else {
                                Contador++;
                                int B = VectorRandom[Contador];
                                Texto.setText(VectorEmocion[B]);
                                final Timer Reloj = new Timer();
                                TimerTask Tarea = new TimerTask() {
                                    @Override
                                    public void run() {
                                        runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                AA();
                                                Reloj.cancel();
                                            }
                                        });
                                    }
                                };
                                Reloj.schedule(Tarea, 2000, 6000);
                            }

                        }
                        A = 0;
                    }
                    if (Cabeza.getDrawable().getConstantState() == ContextCompat.getDrawable(this, R.drawable.cabezaojoscerrados).getConstantState()) {
                        Log.d("Validando", "Entra al if de boca contento");
                        Vidas--;
                        if (Vidas == 0) {
                            Intent Perdio = new Intent(this, Perder.class);
                            startActivity(Perdio);
                        }
                        Cabeza.setImageResource(R.drawable.cabeza);
                        A = 0;
                    }
                }
                break;
            case 5:
                if (A == 0) {
                    Cabeza.setImageResource(R.drawable.cabezabocallanto);
                    A++;
                    break;
                }
                if (A == 1) {
                    if (Cabeza.getDrawable().getConstantState() == ContextCompat.getDrawable(this, R.drawable.cabezaojosabiertos).getConstantState()) {
                        Log.d("Validando", "Entra al if de boca contento");
                        Vidas--;
                        if (Vidas == 0) {
                            Intent Perdio = new Intent(this, Perder.class);
                            startActivity(Perdio);
                        }
                        Cabeza.setImageResource(R.drawable.cabeza);
                        A = 0;
                    }
                    if (Cabeza.getDrawable().getConstantState() == ContextCompat.getDrawable(this, R.drawable.cabezaojoscerrados).getConstantState()) {
                        if (VectorEmocion[VectorRandom[Contador]] == "llorando") {
                            if (Contador == 4) {
                                if (IDs.equals(null)) {
                                    Intent Gano = new Intent(getApplicationContext(), Gano.class);
                                    startActivity(Gano);
                                    finish();
                                } else {
                                    listoParaAgregar = false;
                                    String Juego = "4";
                                    String IDD = String.valueOf(IDs);
                                    enviarPuntaje(new String[]{Juego, IDD, String.valueOf(Contador), fecha});
                                }
                            } else {
                                Contador++;
                                int B = VectorRandom[Contador];
                                Texto.setText(VectorEmocion[B]);
                                final Timer Reloj = new Timer();
                                TimerTask Tarea = new TimerTask() {
                                    @Override
                                    public void run() {
                                        runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                AA();
                                                Reloj.cancel();
                                            }
                                        });
                                    }
                                };
                                Reloj.schedule(Tarea, 2000, 6000);
                            }
                        }
                        A = 0;
                    }
                }
                break;
            case 6:
                if (A == 0) {
                    Cabeza.setImageResource(R.drawable.cabezabocasorprendido);
                    A++;
                    break;
                }
                if (A == 1) {
                    if (Cabeza.getDrawable().getConstantState() == ContextCompat.getDrawable(this, R.drawable.cabezaojosabiertos).getConstantState()) {
                        if (VectorEmocion[VectorRandom[Contador]] == "sorprendido") {
                            if (Contador == 4) {
                                if (IDs.equals(null)) {
                                    Intent Gano = new Intent(getApplicationContext(), Gano.class);
                                    startActivity(Gano);
                                    finish();
                                } else {
                                    listoParaAgregar = false;
                                    String Juego = "4";
                                    String IDD = String.valueOf(IDs);
                                    enviarPuntaje(new String[]{Juego, IDD, String.valueOf(Contador), fecha});
                                }
                            } else {
                                Contador++;
                                int B = VectorRandom[Contador];
                                Texto.setText(VectorEmocion[B]);
                                final Timer Reloj = new Timer();
                                TimerTask Tarea = new TimerTask() {
                                    @Override
                                    public void run() {
                                        runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                AA();
                                                Reloj.cancel();
                                            }
                                        });
                                    }
                                };
                                Reloj.schedule(Tarea, 2000, 6000);
                            }
                        }
                        A = 0;
                    }
                    if (Cabeza.getDrawable().getConstantState() == ContextCompat.getDrawable(this, R.drawable.cabezaojoscerrados).getConstantState()) {
                        Log.d("Validando", "Entra al if de boca contento");
                        Vidas--;
                        if (Vidas == 0) {
                            Intent Perdio = new Intent(this, Perder.class);
                            startActivity(Perdio);
                        }
                        Cabeza.setImageResource(R.drawable.cabeza);
                        A = 0;
                    }
                }
                break;
            case 7:
                if (A == 0) {
                    Cabeza.setImageResource(R.drawable.cabezabocatriste);
                    A++;
                    break;
                }
                if (A == 1) {
                    if (Cabeza.getDrawable().getConstantState() == ContextCompat.getDrawable(this, R.drawable.cabezaojosabiertos).getConstantState()) {
                        Log.d("Validando", "Entra al if de boca contento");
                        Vidas--;
                        if (Vidas == 0) {
                            Intent Perdio = new Intent(this, Perder.class);
                            startActivity(Perdio);
                        }
                        Cabeza.setImageResource(R.drawable.cabeza);
                        A = 0;
                    }
                    if (Cabeza.getDrawable().getConstantState() == ContextCompat.getDrawable(this, R.drawable.cabezaojoscerrados).getConstantState()) {
                        if (VectorEmocion[VectorRandom[Contador]] == "triste") {
                            ContadorVictorias++;
                            Contador++;
                            if (Contador == 4) {
                                if (IDs.equals(null)) {
                                    Intent Gano = new Intent(getApplicationContext(), Gano.class);
                                    startActivity(Gano);
                                    finish();
                                } else {
                                    listoParaAgregar = false;
                                    String Juego = "4";
                                    String IDD = String.valueOf(IDs);
                                    enviarPuntaje(new String[]{Juego, IDD, String.valueOf(Contador), fecha});
                                }
                            } else {
                                Contador++;
                                int B = VectorRandom[Contador];
                                Texto.setText(VectorEmocion[B]);
                                final Timer Reloj = new Timer();
                                TimerTask Tarea = new TimerTask() {
                                    @Override
                                    public void run() {
                                        runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                AA();
                                                Reloj.cancel();
                                            }
                                        });
                                    }
                                };
                                Reloj.schedule(Tarea, 2000, 6000);
                            }
                        }
                        A = 0;
                    }
                }
                break;
        }
    }

    private void enviarPuntaje(String[] params) {
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
    public void AA()
    {
        Cabeza.setImageResource(R.drawable.cabeza);
    }
}

