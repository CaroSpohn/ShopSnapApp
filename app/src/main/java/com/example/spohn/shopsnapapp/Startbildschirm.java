package com.example.spohn.shopsnapapp;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;

public class Startbildschirm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        setContentView(R.layout.activity_startbildschirm);

    }
    public void buttonclick1 (View aView) {
        Intent intent = new Intent(this, ProduktFotografieren.class);
        startActivity(intent);
    }

    public void buttonclick2 (View aView) {
        Intent intent = new Intent(this, Einkaufsliste.class);
        startActivity(intent);
    }


    public void buttonclick3 (View aView) {
        Intent intent = new Intent(this, Historie.class);
        startActivity(intent);
    }


    public void buttonclick4 (View aView) {
        Intent intent = new Intent(this, Einstellungen.class);
        startActivity(intent);
    }



}
