package com.example.a42102578.integrapp;

import android.app.DownloadManager;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.BaseAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 42300564 on 15/8/2017.
 */

public class Profesionales {
    int _Id;
    String _Nombre;
    String _Apellido;
    Boolean esperar;
    ArrayList<Profesionales> Lista;
    AdaptadorProf a;

   /* public Usuarios(Usuarios Usu) {
        Usuarios Usuario = new Usuarios(Usu);
        Usuario.Nombre = Usuario.getNombre(Usu);
        Usuario.Apellido = Usuario.getApellido(Usu);
    }*/

    public Profesionales() {
    }

    public Profesionales (String Nombre, String Apellido, int ID)
    {
        _Nombre = Nombre;
        _Apellido = Apellido;
        _Id = ID;

    }

    public void ObtenerProfesionales(AdaptadorProf a) {
        Lista = new ArrayList<Profesionales>();
        Log.d("Debug","Hasta aca llega");
        String URL ="https//integrapp.azurewebsites.net/azure/traerProfesionales.php";
        Log.d("Debug","Hasta aca tambien");
        new traerUsuarios().execute(URL);
        Log.d("Debug","Hasta aca llegamos");
        Log.d("Debug Lista", Lista.size() + "");
        this.a = a;
        //return Lista;
    }


    public String getNombre() {
        return _Nombre;
    }

    public String getApellido() {
        return _Apellido;
    }

    public int getID()
    {
        return _Id;
    }

    public class traerUsuarios extends AsyncTask<String, Void, ArrayList<Profesionales>>
    {
        protected void onPostExecute (ArrayList<Profesionales>parametroLista)
        {
            Log.d("Debug postEx", "onPostExecute:" + parametroLista.size() + "");
            //Lista = parametroLista;
            super.onPostExecute(Lista);
            a.setDatos(parametroLista);
            a.notifyDataSetChanged();
        }

        protected ArrayList<Profesionales> doInBackground (String...parametros)
        {
            ArrayList<Profesionales> returnList = null;

            String url = parametros[0];
            Log.d("Debug", "Llegamos");
            OkHttpClient client = new OkHttpClient();
            Request Request;
            Request = new Request.Builder()
                    .url("http://integrapp.azurewebsites.net/azure/traerProfesionales.php")
                    .build();

            try
            {
                Response response = client.newCall(Request).execute();
                String Resultado = response.body().string();
                Log.d("Debug", "Resultado: " + Resultado);
                try
                {
                    returnList = parsearResultado(Resultado);
                    Log.d("Debug", "doInBackground: " + returnList.size() + "");
                }
                catch (JSONException e)
                {
                    Log.d("Error", e.getMessage());
                };
            }
            catch (IOException e)
            {
                Log.d("Error", e.getMessage());
            }
            return returnList ;
        }

        public ArrayList<Profesionales> parsearResultado(String Result)throws JSONException
        {
            ArrayList<Profesionales> returnList = null;
            try{
                returnList = new ArrayList<Profesionales>();
                JSONArray jsonUsuarios = new JSONArray(Result);
                Log.d("Debug", "json: " + Result);
                for (int i=0; i<jsonUsuarios.length(); i++)
                {
                    JSONObject jsonUsuario = jsonUsuarios.getJSONObject(i);
                    String Nombre = jsonUsuario.getString("nombre");
                    String Apellido = jsonUsuario.getString("apellido");
                    int ID = jsonUsuario.getInt("id");
                    returnList.add(new Profesionales(Nombre, Apellido, ID));
                    Log.d("Debug", "parsearResultado: " + returnList.size()+ "");
                }

            }
            catch (JSONException e)
            {
                Log.d("Error", e.getMessage());

            }
            return returnList;
        }
    }
}