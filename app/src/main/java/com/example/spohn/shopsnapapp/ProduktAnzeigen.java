package com.example.spohn.shopsnapapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.NumberPicker;

public class ProduktAnzeigen extends AppCompatActivity {

    ImageView imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produkt_anzeigen);

        Intent intent=getIntent();
        Uri file= Uri.parse(intent.getStringExtra("file"));



        NumberPicker numberPicker = (NumberPicker) findViewById(R.id.numberPicker2);

        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(20);
        numberPicker.setWrapSelectorWheel(true);

        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int oldValue, int newValue) {

            }
        });

        imageView2.setImageURI(file);


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
