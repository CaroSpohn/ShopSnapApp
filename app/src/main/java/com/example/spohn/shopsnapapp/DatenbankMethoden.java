package com.example.spohn.shopsnapapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.HashMap;

public class DatenbankMethoden {
    private DBHelper dbHelper;

    public DatenbankMethoden(Context context) {
        dbHelper = new DBHelper(context);
    }

    public int insert(DatenbankLabels item) {

        //Open connection to write data
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DatenbankLabels.KEY_ID, item.student_ID);
        values.put(DatenbankLabels.KEY_name,item.name);
        /*values.put(DatenbankLabels.KEY_preis, item.preis);
        values.put(DatenbankLabels.KEY_anzahl, item.KEY_anzahl);
        values.put(DatenbankLabels.KEY_bild,item.KEY_bild);
        values.put(DatenbankLabels.KEY_eingefügtam, item.KEY_bild);
        values.put(DatenbankLabels.KEY_aktion, item.KEY_aktion);*/

        // Inserting Row
        long Id = db.insert(DatenbankLabels.TABLE, null, values);
        db.close(); // Closing database connection
        return (int) Id;
    }

    public void delete(int student_Id) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        // It's a good practice to use parameter ?, instead of concatenate string
        db.delete(DatenbankLabels.TABLE, DatenbankLabels.KEY_ID + "= ?", new String[] { String.valueOf(student_Id) });
        db.close(); // Closing database connection
    }

    public void update(DatenbankLabels student) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(DatenbankLabels.KEY_ID, student.student_ID);
        values.put(DatenbankLabels.KEY_name,student.name);
       /* values.put(DatenbankLabels.KEY_preis, student.preis);
        values.put(DatenbankLabels.KEY_anzahl, student.KEY_anzahl);
        values.put(DatenbankLabels.KEY_bild,student.KEY_bild);
        values.put(DatenbankLabels.KEY_eingefügtam, student.KEY_bild);
        values.put(DatenbankLabels.KEY_aktion, student.KEY_aktion);*/

        // It's a good practice to use parameter ?, instead of concatenate string
        db.update(DatenbankLabels.TABLE, values, DatenbankLabels.KEY_ID + "= ?", new String[] { String.valueOf(student.student_ID) });
        db.close(); // Closing database connection
    }

    public ArrayList<HashMap<String, String>> getStudentList() {
        //Open connection to read only
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                DatenbankLabels.KEY_ID + "," +
                DatenbankLabels.KEY_name + /*"," +
               DatenbankLabels.KEY_preis + "," +
                DatenbankLabels.KEY_anzahl + "," +
                DatenbankLabels.KEY_bild + "," +
                DatenbankLabels.KEY_eingefügtam + "," +
                DatenbankLabels.KEY_aktion +*/
                " FROM " + DatenbankLabels.TABLE;

        //Student student = new Student();
        ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();

        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> student = new HashMap<String, String>();
                student.put("id", cursor.getString(cursor.getColumnIndex(DatenbankLabels.KEY_ID)));
                student.put("name", cursor.getString(cursor.getColumnIndex(DatenbankLabels.KEY_name)));
               /* student.put("preis", cursor.getString(cursor.getColumnIndex(DatenbankLabels.KEY_preis)));
                student.put("anzahl", cursor.getString(cursor.getColumnIndex(DatenbankLabels.KEY_anzahl)));
                student.put("bild", cursor.getString(cursor.getColumnIndex(DatenbankLabels.KEY_bild)));
                student.put("eingefügtam", cursor.getString(cursor.getColumnIndex(DatenbankLabels.KEY_eingefügtam)));
                student.put("aktion", cursor.getString(cursor.getColumnIndex(DatenbankLabels.KEY_aktion))); */

                list.add(student);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return list;

    }

    public DatenbankLabels getStudentById(int Id){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                DatenbankLabels.KEY_ID + "," +
                DatenbankLabels.KEY_name + "," +
                DatenbankLabels.KEY_preis + /* "," +
                DatenbankLabels.KEY_anzahl + "," +
                DatenbankLabels.KEY_bild + "," +
                DatenbankLabels.KEY_eingefügtam + "," +
                DatenbankLabels.KEY_aktion + */
                " FROM " + DatenbankLabels.TABLE
                + " WHERE " +
                DatenbankLabels.KEY_ID + "=?";// It's a good practice to use parameter ?, instead of concatenate string

        int iCount =0;
        DatenbankLabels item = new DatenbankLabels();

        Cursor cursor = db.rawQuery(selectQuery, new String[] { String.valueOf(Id) } );

        if (cursor.moveToFirst()) {
            do {
                item.student_ID =cursor.getInt(cursor.getColumnIndex(DatenbankLabels.KEY_ID));
                item.name =cursor.getString(cursor.getColumnIndex(DatenbankLabels.KEY_name));
               /* item.preis  =cursor.getString(cursor.getColumnIndex(DatenbankLabels.KEY_preis));
                item.anzahl =cursor.getInt(cursor.getColumnIndex(DatenbankLabels.KEY_anzahl));
                item.bild  =cursor.getString(cursor.getColumnIndex(DatenbankLabels.KEY_bild));
                item.eingefügtam =cursor.getInt(cursor.getColumnIndex(DatenbankLabels.KEY_eingefügtam));
                item.aktion =cursor.getInt(cursor.getColumnIndex(DatenbankLabels.KEY_aktion)); */

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return item;
    }

}