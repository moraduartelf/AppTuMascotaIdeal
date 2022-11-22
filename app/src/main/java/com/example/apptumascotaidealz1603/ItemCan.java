package com.example.apptumascotaidealz1603;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ItemCan extends RecyclerView.Adapter<ItemCan.ListaCanHolder> {

    ArrayList<Tabla_mascotas> listaMascotas;

    public ItemCan(ArrayList<Tabla_mascotas> listaMascotas) {
        this.listaMascotas = listaMascotas;
    }

    @NonNull
    @Override
    public ItemCan.ListaCanHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Para traerme la lista de los items (textview)
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item_can, null, false);
        return new ListaCanHolder(view);
    }
    //Asignamos el valor a las variables de la clase ListaCanHolder
    @Override
    public void onBindViewHolder(@NonNull ListaCanHolder holder, int position) {
        holder.nombre.setText("Nombre: "+listaMascotas.get(position).getNombreMascota());
        holder.tipo.setText("Tipo: "+listaMascotas.get(position).getTipo());
        holder.raza.setText("Raza: "+listaMascotas.get(position).getRaza());
        holder.sexo.setText("Sexo: "+listaMascotas.get(position).getSexoMascota());
        holder.edad.setText("Edad: "+listaMascotas.get(position).getEdad());
        holder.vacunas.setText("Vacunas: "+listaMascotas.get(position).getVacunas());
        holder.can.setImageResource(R.drawable.can);

    }
    @Override
    public int getItemCount() {
        return listaMascotas.size();
    }

    //Creamos la clase para asignarle los campos
    public class ListaCanHolder extends RecyclerView.ViewHolder{
        ImageView can;
        TextView nombre,tipo,sexo,raza,edad,vacunas;
        public ListaCanHolder(@NonNull View itemView) {
            super(itemView);
            //Asignamos los textview
            can = itemView.findViewById(R.id.imCan);
            nombre = itemView.findViewById(R.id.nombre);
            tipo = itemView.findViewById(R.id.tipo);
            raza = itemView.findViewById(R.id.raza);
            sexo = itemView.findViewById(R.id.sexo);
            edad = itemView.findViewById(R.id.edad);
            vacunas = itemView.findViewById(R.id.vacunas);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context= view.getContext();
                    AlertDialog.Builder alerta = new AlertDialog.Builder(context)
                            .setMessage("¿Deseas adoptarme?")
                            .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Toast.makeText(context, "¡Gracias por adoptarme!", Toast.LENGTH_SHORT).show();
                                }
                            })
                            .setNegativeButton("Rechazar", null);
                            alerta.show();
                }
            });
        }
    }
}