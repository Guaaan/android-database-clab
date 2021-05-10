package com.fgeminis.clab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.fgeminis.clab.db.DbProductos;

public class NuevoActivity extends AppCompatActivity {

    EditText txtId, txtNombre, txtPrecioPublico, txtExistencias;
    Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo);

        txtId = findViewById(R.id.txtId);
        txtNombre = findViewById(R.id.txtNombre);
        txtPrecioPublico = findViewById(R.id.txtPrecioPublico);
        txtExistencias = findViewById(R.id.txtExistencias);
        btnGuardar = findViewById(R.id.btnGuardar);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DbProductos dbProductos = new DbProductos(NuevoActivity.this);
                long id = dbProductos.insertarContacto(txtId.getText().toString(), txtNombre.getText().toString(), txtPrecioPublico.getText().toString(), txtExistencias.getText().toString());

                if (id > 0) {
                    Toast.makeText(NuevoActivity.this, "REGISTRO GUARDADO", Toast.LENGTH_LONG).show();
                    limpiar();
                } else {
                    Toast.makeText(NuevoActivity.this, "ERROR AL GUARDAR REGISTRO", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void  limpiar(){
        txtId.setText("");
        txtNombre.setText("");
        txtPrecioPublico.setText("");
        txtExistencias.setText("");
    }

}