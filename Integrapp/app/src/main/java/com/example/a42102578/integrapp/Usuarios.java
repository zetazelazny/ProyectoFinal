package com.example.a42102578.integrapp;

import android.app.DownloadManager;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 42300564 on 15/8/2017.
 */

public class Usuarios {
    String Nombre;
    String Apellido;

    public Usuarios(Usuarios Usu) {
        Usuarios Usuario = new Usuarios(Usu);
        Usuario.Nombre = Usuario.getNombre(Usu);
        Usuario.Apellido = Usuario.getApellido(Usu);
    }

    public Usuarios() {
    }

    public Usuarios (String Nombre, String Apellido)
    {
        Usuarios Usuario = new Usuarios();
        Usuario.Nombre = Nombre;
        Usuario.Apellido = Apellido;
    }

    public ArrayList<Usuarios> ObtenerUsuarios() {
        ArrayList<Usuarios> Lista = new ArrayList<Usuarios>();
        Log.d("Debug","Hasta aca llega");
        String URL ="https//integrapp.azurewebsites.net/azure/traerUsuarios.php";
        Log.d("Debug","Hasta aca tambien");
        new traerUsuarios().execute(URL);
        Log.d("Debug","Hasta aca llegamos");
        return Lista;
    }


    private String getNombre(Usuarios Usuario) {
        String Nom = Usuario.Nombre;
        return Nom;
    }

    private String getApellido(Usuarios Usuario) {
        String Ape = Usuario.Apellido;
        return Ape;
    }

    private class traerUsuarios extends AsyncTask<String, Void, ArrayList<Usuarios>>
    {
        protected void onPostExecute (ArrayList<Usuarios>Lista)
        {
            super.onPostExecute(Lista);
        }

        protected ArrayList<Usuarios> doInBackground (String...parametros)
        {
            String url = parametros[0];
            Log.d("Debug", "Llegamos");
            OkHttpClient client = new OkHttpClient();
            Request Request;
            Request = new Request.Builder()
                    .url("http://integrapp.azurewebsites.net/azure/traerUsuarios.php")
                    .build();

            try
            {
                Response response = client.newCall(Request).execute();
                String Resultado = response.body().string();
                ArrayList<Usuarios> Lista;
                try
                {
                    Lista = parsearResultado(Resultado);
                }
                catch (JSONException e)
                {
                    Log.d("Error", e.getMessage());
                };

            }
            catch (IOException e)
            {
                Log.d("Error", e.getMessage());
                return null;
            }
            return new ArrayList<Usuarios>();
        }
        public ArrayList<Usuarios> parsearResultado(String Result)throws JSONException
        {
            try
            {
                Usuarios Usu = new Usuarios();
                ArrayList<Usuarios> Usuarios = new ArrayList<Usuarios>();
                JSONArray jsonUsuarios = new JSONArray(Result);
                for (int i=0; i<jsonUsuarios.length(); i++)
                {
                    JSONObject jsonUsuario = jsonUsuarios.getJSONObject(i);
                    String Nombre = jsonUsuario.getString("nombre");
                    String Apellido = jsonUsuario.getString("apellido");
                    Usuarios Usuario = new Usuarios(Nombre, Apellido);
                    Usuarios.add(Usu);
                    Log.d("Debug",Usuario.Nombre + " " + Usuario.Apellido);
                }
                return Usuarios;
            }
            catch (JSONException e)
            {
                Log.d("Error", e.getMessage());
                return null;
            }
        }
    }
}