package com.example.a42102578.integrapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class SeleccionUsuarios extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion_usuarios);
        Log.d("Debug","Entra a la vista");
        ArrayList<Usuarios> ListaUsuarios = new ArrayList<Usuarios>();
        Usuarios Usuarios = new Usuarios();
        ListaUsuarios = Usuarios.ObtenerUsuarios();
        Log.d("Debug","Obtuvo Usuarios" );
        ListView ListViewUsuarios;
        ListViewUsuarios = (ListView)findViewById(R.id.ListUsuarios);
        Adaptador Adapter;
        Adapter = new Adaptador(ListaUsuarios, this);
        Log.d("Debug","Creo adapter" );
        ListViewUsuarios.setAdapter(Adapter);
        Log.d("Debug","Seteo adapter" );
    }
}


