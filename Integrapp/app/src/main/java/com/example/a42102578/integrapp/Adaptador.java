package com.example.a42102578.integrapp;

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
    public Adaptador(ArrayList<Usuarios>List)
    {
        ListaUsuario = List;
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
        return VistaADevolver;
    }

}
