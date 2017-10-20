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

import java.net.IDN;
import java.util.ArrayList;

public class SeleccionProfesionales extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_seleccion_profesionales);
            Log.d("Debug","Entra a la vista");
            ArrayList<Profesionales> ListaProf = new ArrayList<Profesionales>();
            final Profesionales Prof = new Profesionales();
            //ListaUsuarios = Usuarios.ObtenerUsuarios()
            Log.d("Debug","Lista size: " + ListaProf.size());
            final ListView ListViewProf;
            ListViewProf = (ListView)findViewById(R.id.ListProf);
            AdaptadorProf Adapter;
            Adapter = new AdaptadorProf(ListaProf, this);
            Log.d("Debug","Creo adapter" );
            ListViewProf.setAdapter(Adapter);
            Log.d("Debug","Seteo adapter" );
            Prof.ObtenerProfesionales(Adapter);

            ListViewProf.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Object o = ListViewProf.getItemAtPosition(position);
                    Profesionales Profesional = (Profesionales) (o);
                    Log.d("Casteando", Profesional._Nombre +"Putoelquelee" + Profesional._Apellido + Profesional._Id);
                    Intent aPrincipal = new Intent(getApplicationContext(), SeleccionUsuarios.class);
                    String Id = String.valueOf(Profesional._Id);
                    aPrincipal.putExtra("id", Id);
                    Log.d("ID", Id);
                    startActivity(aPrincipal);
                }
            });
        }

        public void Invitado(View Vista)
        {
            String ID = "null";
            Intent aPrincipal = new Intent(getApplicationContext(), MenuPrincipal.class);
            aPrincipal.putExtra("id", ID);
            startActivity(aPrincipal);
        }
    }
