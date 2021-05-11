package com.fgeminis.clab.adaptadores;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fgeminis.clab.R;
import com.fgeminis.clab.VerActivity;
import com.fgeminis.clab.entidades.Productos;

import java.util.ArrayList;

public class ListaProductosAdapter extends RecyclerView.Adapter<ListaProductosAdapter.ProductoViewHolder> {

    ArrayList<Productos> listaProductos;

    public ListaProductosAdapter(ArrayList<Productos> listaContactos){
        this.listaProductos = listaContactos;
    }


    @NonNull
    @Override
    public ProductoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_producto, null, false);
    return new ProductoViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ProductoViewHolder holder, int position) {
    holder.viewNombre.setText(listaProductos.get(position).getNombre());
    holder.viewPrecio.setText(listaProductos.get(position).getPrecio_publico());
    holder.viewExistencias.setText(listaProductos.get(position).getExistencias());



    }

    @Override
    public int getItemCount() {
        return listaProductos.size();

    }

    public class ProductoViewHolder extends RecyclerView.ViewHolder {

        TextView viewNombre, viewPrecio, viewExistencias;

        public ProductoViewHolder(@NonNull View itemView) {
            super(itemView);

            viewNombre = itemView.findViewById(R.id.viewNombre);
            viewPrecio = itemView.findViewById(R.id.viewPrecio);
            viewExistencias = itemView.findViewById(R.id.viewExistencias);

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    Context context = view.getContext();
                    Intent intent = new Intent(context, VerActivity.class);
                    intent.putExtra("ID", listaProductos.get(getAdapterPosition()).getId());
                    context.startActivity(intent);
                }
            });
        }
    }
}
