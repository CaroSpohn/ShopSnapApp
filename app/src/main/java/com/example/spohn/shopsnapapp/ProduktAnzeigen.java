package com.example.spohn.shopsnapapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ProduktAnzeigen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produkt_anzeigen);
    }

    public void buttonclick6 (View aView) {
        Intent intent = new Intent(this, Einkaufsliste.class);
        startActivity(intent);
    }
    public void buttonclick7 (View aView) {
        Intent intent = new Intent(this, ProduktFotografieren.class);
        startActivity(intent);
    }
}
