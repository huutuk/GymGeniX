package com.example.gymgenix;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.gymgenix.SeanceStringUtils.ExoEntry;
import com.example.gymgenix.SeanceStringUtils.SeanceEntry;

public class SeanceDBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "seance.db";
    public static final int DATABASE_VERSION = 2;

    public SeanceDBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_SEANCELIST_TABLE = "CREATE TABLE " +
                SeanceEntry.TABLE_SEANCE_NAME + " (" +
                SeanceEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                SeanceEntry.COLUMN_SEANCE_NAME + " TEXT NOT NULL" +
                ");";
        db.execSQL(SQL_CREATE_SEANCELIST_TABLE);

        final String SQL_CREATE_EXOLIST_TABLE = "CREATE TABLE " +
                ExoEntry.TABLE_EXO_NAME + " (" +
                ExoEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ExoEntry.COLUMN_EXO_NAME + " TEXT NOT NULL, " +
                ExoEntry.COLUMN_EXO_REP + " INTEGER NOT NULL, " +
                ExoEntry.COLUMN_EXO_WEIGHT + " INTEGER NOT NULL, " +
                ExoEntry.COLUMN_EXO_SEANCENAME + " TEXT NOT NULL" +
                ");";
        db.execSQL(SQL_CREATE_EXOLIST_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + SeanceEntry.TABLE_SEANCE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + ExoEntry.TABLE_EXO_NAME);
        onCreate(db);
    }

    public boolean insertSeance(String seanceName) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(SeanceEntry.COLUMN_SEANCE_NAME, seanceName);

        long result = db.insert(SeanceEntry.TABLE_SEANCE_NAME, null, cv);
        return result != -1;
    }

    public Cursor viewSeance() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "select * from " + SeanceEntry.TABLE_SEANCE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        return cursor;
    }

    public void deleteSeance(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + SeanceEntry.TABLE_SEANCE_NAME +
                " WHERE " + SeanceEntry.COLUMN_SEANCE_NAME + " = '" + name + "';";
        db.execSQL(query);
    }
}
