package com.example.a42102578.integrapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Demo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_demo);
    }

    public void Demo ()
    {
        TraerResultados.start();
    }

    Thread TraerResultados = new Thread()
    {
        @Override
        public void run() {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                String RutaServidor, NombreBase, NombreUsuario, PasswordUsuario, CadenaCompleta;
                int Puerto;
                RutaServidor = "ACA LA RUTA";
                Puerto = 1;//ACA EL PUERTO
                NombreBase = "NOMBRE BASE";
                NombreUsuario = "USUARIO";
                PasswordUsuario = "PASS";
                CadenaCompleta = "jdbc:mysql://" + RutaServidor + ":" + Puerto + "/" + NombreBase;
                Connection Conexion = DriverManager.getConnection(CadenaCompleta, NombreUsuario, PasswordUsuario);
                Statement Instruccion = Conexion.createStatement();
                String SQLdeLectura = "select campos from tabla"; //ACA HAY QUE METER TABLA DE RANKINGS (PARA LA DEMO NADA MAS)
                ResultSet Resultados = Instruccion.executeQuery(SQLdeLectura);
                if (Resultados.first()) {
                    while (Resultados.next()) {

                    }
                } else {
                    //NO trajo nada
                }
            }catch (ClassNotFoundException error)
            {

            }
            catch (SQLException error) {

            }
        }
    };

}
