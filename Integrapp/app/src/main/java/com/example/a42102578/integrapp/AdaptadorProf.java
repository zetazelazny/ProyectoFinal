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
    private ArrayList<Profesionales> ListaProf;
    private Context Contexto;
    public AdaptadorProf(ArrayList<Profesionales>List, Context ContextoAUsar)
    {
        ListaProf = List;
        Contexto = ContextoAUsar;
    }

    public void setDatos(ArrayList<Profesionales> ListaP) {
        this.ListaProf = ListaP;
    }
    public int getCount()
    {
        return ListaProf.size();
    }

    public Profesionales getItem(int Posicion)
    {
        Profesionales ProfADevoler;
        ProfADevoler = ListaProf.get(Posicion);
        return ProfADevoler;
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
        Profesionales Prof = getItem(PosicionActual);
        Log.d("Debug", Prof._Nombre + Prof._Apellido);
        TextView Nombre;
        Nombre = (TextView)VistaADevolver.findViewById(R.id.TextNombre);
        TextView Apellido;
        Apellido = (TextView)VistaADevolver.findViewById(R.id.TextApellido);
        TextView Id;
        Id = (TextView)VistaADevolver.findViewById(R.id.TextId);
        Nombre.setText(Prof.getNombre());
        Apellido.setText(Prof.getApellido());
        Id.setText(String.valueOf(Prof.getID()));
        Log.d("Debug",Prof.getNombre() + Prof.getApellido() + Prof.getID());
        return VistaADevolver;

    }
}
