package com.example.a42102578.integrapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
        ArrayList<Usuarios> ListaUsuarios = new ArrayList<Usuarios>();
        Usuarios Usuarios = new Usuarios();
        ListaUsuarios = Usuarios.ObtenerUsuarios();
        ListView ListViewUsuarios;
        ListViewUsuarios = (ListView)findViewById(R.id.ListUsuarios);
    }
}


