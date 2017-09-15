package com.example.a42102578.integrapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 42300564 on 15/8/2017.
 */
public class AdaptadorProf extends BaseAdapter
{
    private ArrayList<Usuarios> ListaUsuario;
    private Context Contexto;
    public AdaptadorProf(ArrayList<Usuarios>List, Context ContextoAUsar)
    {
        ListaUsuario = List;
        Contexto = ContextoAUsar;
    }

    public void setDatos(ArrayList<Usuarios> ListaUsuario) {
        this.ListaUsuario = ListaUsuario;
    }
    public int getCount()
    {
        return ListaUsuario.size();
    }

    public Usuarios getItem(int Posicion)
    {
        Usuarios UsuarioADevoler;
        UsuarioADevoler = ListaUsuario.get(Posicion);
        return UsuarioADevoler;
    }

    public long getItemId (int PosicionAObtener)
    {
        return PosicionAObtener;
    }

    public View getView(int PosicionActual, View VistaActual, ViewGroup GrupoActual)
    {
        View VistaADevolver;
        LayoutInflater Inflador;
        Inflador = (LayoutInflater)Contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        VistaADevolver = Inflador.inflate(R.layout.detalle_usuarios, GrupoActual, false);
        Log.d("Debug", "Infla la lista");
        Usuarios Usu = getItem(PosicionActual);
        Log.d("Debug", Usu._Nombre + Usu._Apellido);
        TextView Nombre;
        Nombre = (TextView)VistaADevolver.findViewById(R.id.TextNombre);
        TextView Apellido;
        Apellido = (TextView)VistaADevolver.findViewById(R.id.TextApellido);
        TextView Id;
        Id = (TextView)VistaADevolver.findViewById(R.id.TextId);
        Nombre.setText(Usu.getNombre());
        Apellido.setText(Usu.getApellido());
        Id.setText(String.valueOf(Usu.getID()));
        Log.d("Debug",Usu.getNombre() + Usu.getApellido() + Usu.getID());
        return VistaADevolver;

    }
}
