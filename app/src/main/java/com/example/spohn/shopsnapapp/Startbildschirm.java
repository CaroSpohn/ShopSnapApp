package com.example.spohn.shopsnapapp;

import android.Manifest;
import android.app.ActionBar;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.widget.ImageView;

public class Startbildschirm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        setContentView(R.layout.activity_startbildschirm);
        if (ContextCompat.checkSelfPermission(getBaseContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE}, 001);}

    }
    public void buttonclick1 (View aView) {
        if (ContextCompat.checkSelfPermission(getBaseContext(), Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.CAMERA}, 002); }
            else{
        Intent intent = new Intent(this, ProduktFotografieren.class);
        startActivity(intent);}
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
