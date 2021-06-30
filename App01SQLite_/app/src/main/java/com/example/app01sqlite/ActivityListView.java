package com.example.app01sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.app01sqlite.tablas.Persona;
import com.example.app01sqlite.transacciones.Transacciones;

import java.util.ArrayList;

public class ActivityListView extends AppCompatActivity {

    SQLiteConexion conexion;
    ListView listapersonas;
    ArrayList<Persona> lista;
    ArrayList<String> arregloPersona;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        conexion = new SQLiteConexion(this, Transacciones.NameDataBase, null, 1);
        listapersonas = (ListView) findViewById(R.id.listaPersonas);
        ObtenerListaPersonas();
        ArrayAdapter adp = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arregloPersona);
        listapersonas.setAdapter(adp);

        listapersonas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String informacion = "ID " + lista.get(position).getId();
                informacion += "Nombre : " + lista.get(position).getNombres();

                Intent Compartir = new Intent();
                Compartir.setAction(Intent.ACTION_SEND);
                Compartir.putExtra(Intent.EXTRA_TEXT, informacion);
                Compartir.setType("text/plain");

                Intent Share = Intent.createChooser(Compartir, null);
                startActivity(Share);

                Toast.makeText(getApplicationContext(), informacion, Toast.LENGTH_LONG).show();
            }
        });
    }

    private void ObtenerListaPersonas(){
        SQLiteDatabase db = conexion.getReadableDatabase();
        Persona listaPersona = null;
        lista = new ArrayList<Persona>();
        Cursor cursor = db.rawQuery("SELECT * FROM "+Transacciones.tablaPersona, null);
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

        fillList();
    }

    private void fillList(){
        arregloPersona = new ArrayList<String>();
        for(int i = 0; i<lista.size(); i++){
            arregloPersona.add(lista.get(i).getId()+".-  "+lista.get(i).getNombres()+" "+lista.get(i).getApellidos());
        }

    }
}