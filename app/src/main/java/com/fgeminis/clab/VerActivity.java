package com.fgeminis.clab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.fgeminis.clab.db.DbProductos;
import com.fgeminis.clab.entidades.Productos;

public class VerActivity extends AppCompatActivity {

    EditText txtId, txtNombre, txtPrecioPublico, txtExistencias;
    Button btnGuarda;

    Productos producto;
    int id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver);

        txtId = findViewById(R.id.txtId);
        txtNombre = findViewById(R.id.txtNombre);
        txtPrecioPublico = findViewById(R.id.txtPrecioPublico);
        txtExistencias = findViewById(R.id.txtExistencias);
        btnGuarda = findViewById(R.id.btnGuardar);

        if(savedInstanceState == null){
            Bundle extras = getIntent().getExtras();
            if(extras == null){
                id = Integer.parseInt(null);
            } else {
                id = extras.getInt("ID");
            }
        } else {
            id = (int) savedInstanceState.getSerializable("ID");
        }

        DbProductos dbProductos = new DbProductos(VerActivity.this);
        producto = dbProductos.verProductos(id);

        if (producto != null){
            txtId.setText(producto.getId());
            txtNombre.setText(producto.getNombre());
            txtPrecioPublico.setText(producto.getPrecio_publico());
            txtExistencias.setText(producto.getExistencias());
            btnGuarda.setVisibility(View.INVISIBLE);
            txtId.setInputType(InputType.TYPE_NULL);
            txtNombre.setInputType(InputType.TYPE_NULL);
            txtPrecioPublico.setInputType(InputType.TYPE_NULL);
            txtExistencias.setInputType(InputType.TYPE_NULL);
        }
    }
}