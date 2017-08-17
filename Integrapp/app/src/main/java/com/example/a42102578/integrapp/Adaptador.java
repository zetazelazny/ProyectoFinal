package com.example.a42102578.integrapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 42300564 on 15/8/2017.
 */
public class Adaptador extends BaseAdapter
{
    private ArrayList<Usuarios> ListaUsuario;
    private Context Contexto;
    public Adaptador(ArrayList<Usuarios>List, Context ContextoAUsar)
    {
        List = ListaUsuario;
        ContextoAUsar = Contexto;
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
        VistaADevolver = null;
        LayoutInflater Inflador;
        Inflador = (LayoutInflater)Contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        VistaADevolver = Inflador.inflate(R.layout.detalle_usuarios, GrupoActual, false);
        Log.d("Debug", "Infla la lista");
        Usuarios Usu = new Usuarios(getItem(PosicionActual));
        Log.d("Debug","Trajo un usuario" );
        TextView Nombre;
        Nombre = (TextView)VistaADevolver.findViewById(R.id.TextNombre);
        TextView Apellido;
        Apellido = (TextView)VistaADevolver.findViewById(R.id.TextApellido);
        Nombre.setText(Usu.Nombre);
        Apellido.setText(Usu.Apellido);
        Log.d("Debug",Usu.Nombre + Usu.Apellido );
        return VistaADevolver;
    }

}
