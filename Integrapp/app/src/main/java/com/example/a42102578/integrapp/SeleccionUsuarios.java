package com.example.a42102578.integrapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
        final Usuarios Usuarios = new Usuarios();
        //ListaUsuarios = Usuarios.ObtenerUsuarios()
        Log.d("Debug","Lista size: " + ListaUsuarios.size());
        final ListView ListViewUsuarios;
        ListViewUsuarios = (ListView)findViewById(R.id.ListUsuarios);
        Adaptador Adapter;
        Adapter = new Adaptador(ListaUsuarios, this);
        Log.d("Debug","Creo adapter" );
        ListViewUsuarios.setAdapter(Adapter);
        Log.d("Debug","Seteo adapter" );
        Usuarios.ObtenerUsuarios(Adapter);

        ListViewUsuarios.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object o = ListViewUsuarios.getItemAtPosition(position);
                Usuarios Usuario = (Usuarios) (o);
                Log.d("Casteando", Usuario._Nombre +"Putoelquelee" + Usuario._Apellido + Usuario._Id);
                Intent aPrincipal = new Intent(getApplicationContext(), MenuPrincipal.class);
                String Id = String.valueOf(Usuario._Id);
                aPrincipal.putExtra("id", Id);
                startActivity(aPrincipal);
            }
        });
    }
}


