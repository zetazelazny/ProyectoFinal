package com.example.a42102578.integrapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

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
        ListaUsuario = List;
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
        return VistaADevolver;
    }

}
