package com.example.app01sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.app01sqlite.transacciones.Transacciones;

public class ActivityIngresar extends AppCompatActivity {

    EditText nombre, apellido, edad, correo, direccion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar);

        Button boton = (Button) findViewById(R.id.botonAgregar);
        nombre = (EditText) findViewById(R.id.textNombre);
        apellido = (EditText) findViewById(R.id.textApellido);
        edad = (EditText) findViewById(R.id.textEdad);
        correo = (EditText) findViewById(R.id.textCorreo);
        direccion = (EditText) findViewById(R.id.textDirección);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AgregarPersona();
            }
        });

    }

    private void AgregarPersona() {
        SQLiteConexion conexion = new SQLiteConexion(getApplicationContext(), Transacciones.NameDataBase, null, 1 );
        SQLiteDatabase db = conexion.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put(Transacciones.nombres, nombre.getText().toString());
        valores.put(Transacciones.apellidos, apellido.getText().toString());
        valores.put(Transacciones.edades, edad.getText().toString());
        valores.put(Transacciones.correos, correo.getText().toString());
        valores.put(Transacciones.direcciones, direccion.getText().toString());
        Long resultado = db.insert(Transacciones.tablaPersona, Transacciones.id, valores);
        Toast.makeText(getApplicationContext(), "REGISTRO COMPLETADO", Toast.LENGTH_LONG).show();
        db.close();
        clearScreen();
    }

    private void clearScreen(){
        nombre.setText("");
        apellido.setText("");
        edad.setText("");
        correo.setText("");
        direccion.setText("");
    }
}