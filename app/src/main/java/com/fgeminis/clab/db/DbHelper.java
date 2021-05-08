package com.fgeminis.clab.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NOMBRE = "farmacias.db";
    public static final String TABLE_PRODUCTOS= "t_productos";


    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_PRODUCTOS + "(" +
                "id TEXT NOT NULL PRIMARY KEY," +
                "nombre TEXT NOT NULL," +
                "precio_publico TEXT NOT NULL," +
                "existencias TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_PRODUCTOS);
        onCreate(sqLiteDatabase);


    }
}
