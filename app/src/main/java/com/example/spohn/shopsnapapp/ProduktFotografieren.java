package com.example.spohn.shopsnapapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ProduktFotografieren extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produkt_fotografieren);
    }

    public void buttonclick5 (View aView) {
        Intent intent = new Intent(this,ProduktAnzeigen.class);
        startActivity(intent);
    }
}
