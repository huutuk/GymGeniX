package com.example.gymgenix;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseManager extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Seance.db";

    private static final int DATABASE_VERSION = 1;

    public DatabaseManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String strSql = "create table Seance ("
                + "id integer primary key autoincrement,"
                + "name text not null"
                + ")";
        db.execSQL(strSql);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public ArrayList<Seance> getAllSeances() {
        ArrayList<Seance> seancesList = new ArrayList<Seance>();

        String strSql = "select * from Seances";
        Cursor cursor = this.getWritableDatabase().rawQuery(strSql, null);

        if (cursor.moveToFirst()) {
            while (cursor.isAfterLast()) {
                int id = cursor.getInt(cursor.getColumnIndex("id"));
                String name = cursor.getString(cursor.getColumnIndex("name"));
                name = name.replace("((%))", "'");

                Seance seance = new Seance();
                seance.setId(id);
                seance.setName(name);
                seancesList.add(seance);

                cursor.moveToNext();
            }
        }
        return seancesList;
    }

    public void insertSeance(String seanceName) {
        String name = seanceName.replace("'", "((%))");
        String strSql = "insert into Seance"
                + "(name) VALUES ('"
                + name + "')";
        this.getWritableDatabase().execSQL(strSql);
    }
}
