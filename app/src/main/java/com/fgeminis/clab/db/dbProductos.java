package com.fgeminis.clab.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class dbProductos extends DbHelper{

    Context context;

    public dbProductos(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertarContacto(String id, String nombre, String precio_publico, String existencias) {

        long identificador = 0;

        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("id", id);
            values.put("nombre", nombre);
            values.put("precio_publico", precio_publico);
            values.put("existencias", existencias);

            identificador = db.insert(TABLE_PRODUCTOS, null, values);
        } catch(Exception ex){
            ex.toString();
        }
        return identificador;
    }
}
