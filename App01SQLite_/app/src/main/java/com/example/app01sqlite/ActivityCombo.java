package com.example.app01sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.app01sqlite.tablas.Persona;
import com.example.app01sqlite.tablas.Persona;
import com.example.app01sqlite.transacciones.Transacciones;

import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class ActivityCombo extends AppCompatActivity {



    /*Variables Globales */
    SQLiteConexion conexion;
    Spinner comboPersonas;
    EditText txtnombre, txtapellidos, txtcorreo;

    ArrayList<String> ListaPersonas;
    ArrayList<Persona> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combo);

        conexion = new SQLiteConexion(this, Transacciones.NameDataBase, null, 1);
        comboPersonas = (Spinner)findViewById(R.id.comboPersona);
        txtnombre = (EditText) findViewById(R.id.txtNombres);
        txtapellidos = (EditText) findViewById(R.id.txtapellidos);
        txtcorreo = (EditText) findViewById(R.id.txtemail);

        ObtenerListaPersonas();

        ArrayAdapter<CharSequence> adp = new ArrayAdapter(this, android.R.layout.simple_spinner_item, ListaPersonas);
        comboPersonas.setAdapter(adp);

        comboPersonas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
                txtnombre.setText(lista.get(position).getNombres());
                txtapellidos.setText(lista.get(position).getApellidos());
                txtcorreo.setText(lista.get(position).getCorreos());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent){
            }
        });
    }
    private void ObtenerListaPersonas(){
        SQLiteDatabase db = conexion.getReadableDatabase();
        Persona listaPersona = null;
        lista = new ArrayList<Persona>();
        Cursor cursor = db.rawQuery("SELECT * FROM "+ Transacciones.tablaPersona, null);
        while (cursor.moveToNext()){
            listaPersona = new Persona();
            listaPersona.setId(cursor.getInt(0));
            listaPersona.setNombres(cursor.getString(1));
            listaPersona.setApellidos(cursor.getString(2));
            listaPersona.setEdades(cursor.getInt(3));
            listaPersona.setCorreos(cursor.getString(4));
            listaPersona.setDirecciones(cursor.getString(5));
            lista.add(listaPersona);
        }
        cursor.close();

        fillCombo();
    }

    private void fillCombo(){
        ListaPersonas = new ArrayList<String>();
        for(int i = 0; i<lista.size(); i++){
            ListaPersonas.add(lista.get(i).getId()+".-  "+lista.get(i).getNombres()+" "+lista.get(i).getApellidos());
        }
    }


}