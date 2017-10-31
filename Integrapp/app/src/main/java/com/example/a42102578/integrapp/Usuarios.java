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

import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by 42300564 on 15/8/2017.
 */

public class Usuarios {
    int _Id;
    String _Nombre;
    String _Apellido;
    int _IDProf;
    Boolean esperar;
    ArrayList<Usuarios> Lista;
    Adaptador a;

   /* public Usuarios(Usuarios Usu) {
        Usuarios Usuario = new Usuarios(Usu);
        Usuario.Nombre = Usuario.getNombre(Usu);
        Usuario.Apellido = Usuario.getApellido(Usu);
    }*/

    public Usuarios() {
    }

    public Usuarios (String Nombre, String Apellido, int ID, int IDProf)
    {
        _Nombre = Nombre;
        _Apellido = Apellido;
        _Id = ID;
        _IDProf = IDProf;
    }

    /*public ArrayList<Usuarios> Traer (String ID)
    {
        Lista = new ArrayList<Usuarios>();
        String URL ="https"
    }*/

    public ArrayList<Usuarios> Filtrar(ArrayList<Usuarios> List, int ID)
    {
        ArrayList<Usuarios>ListaA = new ArrayList<Usuarios>();
        ListaA = List;
        for (int i = 0; i < ListaA.size(); i++)
        {
            Usuarios Usuario = ListaA.get(i);
            if (Usuario._IDProf == ID)
            {
                ListaA.add(Usuario);
            }
        }
        return ListaA;
    }
    public void ObtenerUsuarios(Adaptador a, String ID)
    {
        _IDProf = Integer.parseInt(ID);
        Lista = new ArrayList<Usuarios>();
        Log.d("Debug","Hasta aca llega");
        String URL ="http://integrapp.azurewebsites.net/azure/traerUsuarios.php";
        Log.d("Debug","Hasta aca tambien");
        new traerUsuarios().execute(URL, ID);
        Log.d("ID", ID);
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

    public class traerUsuarios extends AsyncTask<String, Void, ArrayList<Usuarios>>
    {
        protected void onPostExecute (ArrayList<Usuarios>parametroLista)
        {
            Log.d("Debug postEx", "onPostExecute:" + parametroLista.size() + "");
            //Lista = parametroLista;
            Log.d("Debug postEx", "Tamaño" + Lista.size());
            super.onPostExecute(Lista);
            a.setDatos(parametroLista);
            a.notifyDataSetChanged();
        }

        protected ArrayList<Usuarios> doInBackground (String...parametros)
        {
            ArrayList<Usuarios> returnList = null;

            String url = parametros[0];
            String ID = parametros[1];
            Log.d("Debug", "Llegamos");
            OkHttpClient client = new OkHttpClient();
            Request Request;
            RequestBody requestBody = new MultipartBody.Builder()
                    .setType(MultipartBody.FORM)
                    .addFormDataPart("id_profesional", ID)
                    .build();

            Log.d("ID Valor", ID);

            Request = new Request.Builder()
                    .url("http://integrapp.azurewebsites.net/azure/insertpuntos.php")
                    .method("POST", RequestBody.create(null, new byte[0]))
                    .post(requestBody)
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

        public ArrayList<Usuarios> parsearResultado(String Result)throws JSONException
        {
            ArrayList<Usuarios> returnList = null;
            try{
                returnList = new ArrayList<Usuarios>();
                JSONArray jsonUsuarios = new JSONArray(Result);
                Log.d("Debug", "json: " + Result);
                for (int i=0; i<jsonUsuarios.length(); i++)
                {
                    JSONObject jsonUsuario = jsonUsuarios.getJSONObject(i);
                    String Nombre = jsonUsuario.getString("nombre");
                    String Apellido = jsonUsuario.getString("apellido");
                    int ID = jsonUsuario.getInt("id");
                    int IDProf = jsonUsuario.getInt("id_profesional");
                    returnList.add(new Usuarios(Nombre, Apellido, ID, IDProf));
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