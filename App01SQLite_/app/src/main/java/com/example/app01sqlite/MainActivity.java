package com.example.app01sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickIngresar(View view) {
        Intent pantIngresar = new Intent(this, ActivityIngresar.class);
        startActivity(pantIngresar);
    }

    public void clickConsulta(View view) {
        Intent pantConsulta = new Intent(this, ActivityConsulta.class);
        startActivity(pantConsulta);
    }

    public void clickLista(View view) {
        Intent pantallaLista = new Intent(this, ActivityListView.class);
        startActivity(pantallaLista);
    }

    public void clickMapa(View view) {
        Intent pantMapa = new Intent(this, MapsActivity.class);
        startActivity(pantMapa);
    }

    public void clickCombo(View view) {
        Intent pantCombo = new Intent(this, ActivityCombo.class);
        startActivity(pantCombo);
    }

    public void clickPhoto(View view) {
        Intent pantPhoto = new Intent(this, ActivityPhoto.class);
        startActivity(pantPhoto);
    }

    public void clickVideo(View view) {
        Intent pantVideo = new Intent(this, ActivityVideo.class);
        startActivity(pantVideo);
    }

}