package com.example.app01sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.app01sqlite.transacciones.Transacciones;

public class ActivityConsulta extends AppCompatActivity {

    SQLiteConexion conexion;
    EditText id, nombres, apellidos, edades, correos, direcciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);

        conexion = new SQLiteConexion(this, Transacciones.NameDataBase, null, 1 );

        Button btnConsultar = (Button) findViewById(R.id.botonConsultar);
        Button btnActualizar = (Button) findViewById(R.id.botonActualizar);
        Button btnEliminar = (Button) findViewById(R.id.botonEliminar);

        id = (EditText) findViewById(R.id.textID);
        nombres = (EditText) findViewById(R.id.textNombres);
        apellidos = (EditText) findViewById(R.id.textApellidos);
        edades = (EditText) findViewById(R.id.textEdades);
        correos = (EditText) findViewById(R.id.textCorreos);
        direcciones = (EditText) findViewById(R.id.textDirecciones);

        btnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Buscar();
            }
        });

        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Actualizar();
            }
        });

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Eliminar();
            }
        });
    }

    private void Buscar() {
        SQLiteDatabase db = conexion.getWritableDatabase();
        String [] params = {id.getText().toString()}; //PARAMETRO DE LA BÚSQUEDA
        String [] fields = {Transacciones.nombres, Transacciones.apellidos, Transacciones.edades, Transacciones.correos, Transacciones.direcciones};
        String wherecond = Transacciones.id + "=?";
        try{
            Cursor cdata = db.query(Transacciones.tablaPersona, fields, wherecond, params, null, null, null);
            cdata.moveToFirst();
            nombres.setText(cdata.getString(0));
            apellidos.setText(cdata.getString(1));
            edades.setText(cdata.getString(2));
            correos.setText(cdata.getString(3));
            direcciones.setText(cdata.getString(4));
            Toast.makeText(getApplicationContext(), "CONSULTA CON ÉXITO", Toast.LENGTH_SHORT).show();
        }catch (Exception ex){
            clearScreen();
            Toast.makeText(getApplicationContext(), "ELEMENTO NO ENCONTRADO", Toast.LENGTH_SHORT).show();
        }
    }

    private void Actualizar() {
        SQLiteDatabase db = conexion.getWritableDatabase();
        String [] params = {id.getText().toString()};
        ContentValues valores = new ContentValues();
        valores.put(Transacciones.nombres, nombres.getText().toString());
        valores.put(Transacciones.apellidos, apellidos.getText().toString());
        valores.put(Transacciones.edades, edades.getText().toString());
        valores.put(Transacciones.correos, correos.getText().toString());
        valores.put(Transacciones.direcciones, direcciones.getText().toString());
        db.update(Transacciones.tablaPersona, valores, Transacciones.id + "=?", params);
        Toast.makeText(getApplicationContext(), "ELEMENTO ACTUALIZADO", Toast.LENGTH_SHORT).show();
        clearScreen();
    }

    private void Eliminar() {
        SQLiteDatabase db = conexion.getWritableDatabase();
        String [] params = {id.getText().toString()};
        String wherecond = Transacciones.id + "=?";
        db.delete(Transacciones.tablaPersona, wherecond, params);
        Toast.makeText(getApplicationContext(), "ELEMENTO ELIMINADO", Toast.LENGTH_SHORT).show();
        clearScreen();
    }

    private void clearScreen(){
        nombres.setText("");
        apellidos.setText("");
        edades.setText("");
        correos.setText("");
        direcciones.setText("");
    }
}