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
        VistaADevolver = Inflador.inflate(R.layout.detalle_prof, GrupoActual, false);
        ImageView IMG = (ImageView)VistaADevolver.findViewById(R.id.Img);
        TextView Texto = (TextView)VistaADevolver.findViewById(R.id.id);
        Log.d("Debug", "Infla la lista");
        Profesionales Prof = getItem(PosicionActual);
        Log.d("Debug", Prof._Nombre + Prof._Apellido);
        Glide.with(Contexto)
                .load("http://integrapp.azurewebsites.net/azure/imagenes/" + Prof._Id  + ".jpg")
                .into(IMG);
        Texto.setText(String.valueOf(Prof._Id));
        return VistaADevolver;

    }
}
