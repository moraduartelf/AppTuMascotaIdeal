package com.example.apptumascotaidealz1603;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;

public class ItemAves extends RecyclerView.Adapter<ItemAves.ListaAvesHolder> {

    ArrayList<Tabla_mascotas> listaMascotas;

    public ItemAves(ArrayList<Tabla_mascotas> listaMascotas) {
        this.listaMascotas = listaMascotas;
    }

    @NonNull
    @Override
    public ItemAves.ListaAvesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Para traerme la lista de los items (textview)
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item_aves, null, false);
        return new ListaAvesHolder(view);
    }
    //Asignamos el valor a las variables de la clase ListaCanHolder
    @Override
    public void onBindViewHolder(@NonNull ListaAvesHolder holder, int position) {
        holder.nombre.setText("Nombre: "+listaMascotas.get(position).getNombreMascota());
        holder.tipo.setText("Tipo: "+listaMascotas.get(position).getTipo());
        holder.raza.setText("Raza: "+listaMascotas.get(position).getRaza());
        holder.sexo.setText("Sexo: "+listaMascotas.get(position).getSexoMascota());
        holder.edad.setText("Edad: "+listaMascotas.get(position).getEdad());
        holder.vacunas.setText("Vacunas: "+listaMascotas.get(position).getVacunas());

    }
    @Override
    public int getItemCount() {
        return listaMascotas.size();
    }

    //Creamos la clase para asignarle los campos
    public class ListaAvesHolder extends RecyclerView.ViewHolder{
        TextView nombre,tipo,sexo,raza,edad,vacunas;
        public ListaAvesHolder(@NonNull View itemView) {
            super(itemView);
            //Asignamos los textview
            nombre = itemView.findViewById(R.id.nombre);
            tipo = itemView.findViewById(R.id.tipo);
            raza = itemView.findViewById(R.id.raza);
            sexo = itemView.findViewById(R.id.sexo);
            edad = itemView.findViewById(R.id.edad);
            vacunas = itemView.findViewById(R.id.vacunas);

        }
    }
}