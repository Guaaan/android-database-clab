package com.fgeminis.clab.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.fgeminis.clab.entidades.Productos;

import java.util.ArrayList;

public class DbProductos extends DbHelper{

    Context context;

    public DbProductos(@Nullable Context context) {
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
    public ArrayList<Productos> mostrarProductos(){
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ArrayList<Productos> listaProductos = new ArrayList<>();
        Productos producto = null;
        Cursor cursorProductos = null;

        cursorProductos = db.rawQuery("SELECT * FROM " + TABLE_PRODUCTOS, null );
        if(cursorProductos.moveToFirst()) {
            do{
                producto = new Productos();
                producto.setId(cursorProductos.getInt(0));
                producto.setNombre(cursorProductos.getString(1));
                producto.setPrecio_publico(cursorProductos.getString(2));
                producto.setExistencias(cursorProductos.getString(3));
                listaProductos.add(producto);
            } while (cursorProductos.moveToNext());
        }

        cursorProductos.close();

        return listaProductos;
    }
}
