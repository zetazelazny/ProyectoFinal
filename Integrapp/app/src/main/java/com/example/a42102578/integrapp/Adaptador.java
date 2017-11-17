package com.example.a42102578.integrapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.bumptech.glide.Glide;

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
        VistaADevolver = Inflador.inflate(R.layout.detalle_prof, GrupoActual, false);
        ImageView IMG = (ImageView)VistaADevolver.findViewById(R.id.Img);
        TextView Texto = (TextView)VistaADevolver.findViewById(R.id.id);
        Log.d("Debug", "Infla la lista");
        Usuarios Usu= getItem(PosicionActual);
        Log.d("Debug", Usu._Nombre + Usu._Apellido);
        Glide.with(Contexto)
                .load("http://integrapp.azurewebsites.net/azure/imagenesPac/" + Usu._Id  + ".jpg")
                .into(IMG);
        Texto.setText(String.valueOf(Usu._Id));
        return VistaADevolver;

    }
}
