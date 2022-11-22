package com.example.apptumascotaidealz1603.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.Nullable;

import com.example.apptumascotaidealz1603.TAplicar;
import com.example.apptumascotaidealz1603.Tabla_mascotas;

import java.util.ArrayList;

public class DbCrearMascota extends DbHelper{
    Context context;
    public DbCrearMascota(@Nullable Context context) {
        super(context);
        this.context = context;
    }
    public long insertarDatosMascota(String nombreMascota, String tipoMascota,String sexoMascota, String raza, String edad, String vacunas){
        long id = 0;
        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            // Función para insertar registro.
            ContentValues values =new ContentValues();
            values.put("tipo", tipoMascota);
            values.put("nombre", nombreMascota);
            values.put("sexo", sexoMascota);
            values.put("raza", raza);
            values.put("edad", edad);
            values.put("vacunas", vacunas);

            id =db.insert(TABLE_MASCOTAS, null,values);
        }
        catch (Exception e){
            e.toString();
        }
        return id;
    }
    public ArrayList<Tabla_mascotas> mostrarMascotaCan(){
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String can = "can";
        //Array para guardar todos los usuarios
        ArrayList<Tabla_mascotas> lista_mascotas = new ArrayList<>();
        //creamos los usuarios separados.
        Tabla_mascotas mascotas = null;
        //Cursor para traer la bd.
        Cursor cursorUsuario = null;
        cursorUsuario = db.rawQuery("select nombre,tipo, sexo, raza, edad, vacunas from " + TABLE_MASCOTAS + " where tipo = 'Perro' ",null);

        //Recorrer la info que nos trae.
        if(cursorUsuario.moveToFirst()){
            do {
                mascotas = new Tabla_mascotas();
                mascotas.setNombreMascota(cursorUsuario.getString(0));
                mascotas.setTipo(cursorUsuario.getString(1));
                mascotas.setSexoMascota(cursorUsuario.getString(2));
                mascotas.setRaza(cursorUsuario.getString(3));
                mascotas.setEdad(cursorUsuario.getString(4));
                mascotas.setVacunas(cursorUsuario.getString(5));
                lista_mascotas.add(mascotas);

            }while(cursorUsuario.moveToNext());
        }
        //Cerramos la base de datos
        cursorUsuario.close();
        return lista_mascotas;
    }
    public ArrayList<Tabla_mascotas> mostrarMascotaCat(){
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String cat = "cat";
        //Array para guardar todos los usuarios
        ArrayList<Tabla_mascotas> lista_mascotas = new ArrayList<>();
        //creamos los usuarios separados.
        Tabla_mascotas mascotas = null;
        //Cursor para traer la bd.
        Cursor cursorUsuario = null;
        cursorUsuario = db.rawQuery("select nombre,tipo, sexo, raza, edad, vacunas from " + TABLE_MASCOTAS + " where tipo = 'Gato' ",null);
        //Recorrer la info que nos trae.
        if(cursorUsuario.moveToFirst()){
            do {
                mascotas = new Tabla_mascotas();
                mascotas.setNombreMascota(cursorUsuario.getString(0));
                mascotas.setTipo(cursorUsuario.getString(1));
                mascotas.setSexoMascota(cursorUsuario.getString(2));
                mascotas.setRaza(cursorUsuario.getString(3));
                mascotas.setEdad(cursorUsuario.getString(4));
                mascotas.setVacunas(cursorUsuario.getString(5));
                lista_mascotas.add(mascotas);
            }while(cursorUsuario.moveToNext());
        }
        //Cerramos la base de datos
        cursorUsuario.close();
        return lista_mascotas;
    }
    public ArrayList<Tabla_mascotas> mostrarMascotaAves() {
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String aves = "aves";
        //Array para guardar todos los usuarios
        ArrayList<Tabla_mascotas> lista_mascotas = new ArrayList<>();
        //creamos los usuarios separados.
        Tabla_mascotas mascotas = null;
        //Cursor para traer la bd.
        Cursor cursorUsuario = null;
        cursorUsuario = db.rawQuery("select nombre,tipo, sexo, raza, edad, vacunas from " + TABLE_MASCOTAS + " where tipo = 'Ave' ", null);
        //Recorrer la info que nos trae.
        if (cursorUsuario.moveToFirst()) {
            do {
                mascotas = new Tabla_mascotas();
                mascotas.setNombreMascota(cursorUsuario.getString(0));
                mascotas.setTipo(cursorUsuario.getString(1));
                mascotas.setSexoMascota(cursorUsuario.getString(2));
                mascotas.setRaza(cursorUsuario.getString(3));
                mascotas.setEdad(cursorUsuario.getString(4));
                mascotas.setVacunas(cursorUsuario.getString(5));
                lista_mascotas.add(mascotas);
            } while (cursorUsuario.moveToNext());
        }
        //Cerramos la base de datos
        cursorUsuario.close();
        return lista_mascotas;
    }
    public ArrayList<Tabla_mascotas> mostrarMascotaOtros() {
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String otros = "otros";
        //Array para guardar todos los usuarios
        ArrayList<Tabla_mascotas> lista_mascotas = new ArrayList<>();
        //creamos los usuarios separados.
        Tabla_mascotas mascotas = null;
        //Cursor para traer la bd.
        Cursor cursorUsuario = null;
        cursorUsuario = db.rawQuery("select nombre,tipo, sexo, raza, edad, vacunas from " + TABLE_MASCOTAS + " where tipo = 'Otro' ", null);
        //Recorrer la info que nos trae.
        if (cursorUsuario.moveToFirst()) {
            do {
                mascotas = new Tabla_mascotas();
                mascotas.setNombreMascota(cursorUsuario.getString(0));
                mascotas.setTipo(cursorUsuario.getString(1));
                mascotas.setSexoMascota(cursorUsuario.getString(2));
                mascotas.setRaza(cursorUsuario.getString(3));
                mascotas.setEdad(cursorUsuario.getString(4));
                mascotas.setVacunas(cursorUsuario.getString(5));
                lista_mascotas.add(mascotas);
            } while (cursorUsuario.moveToNext());
        }
        //Cerramos la base de datos
        cursorUsuario.close();
        return lista_mascotas;
    }

}
