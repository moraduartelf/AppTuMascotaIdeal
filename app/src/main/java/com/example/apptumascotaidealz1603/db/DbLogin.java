package com.example.apptumascotaidealz1603.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.Nullable;

import com.example.apptumascotaidealz1603.TAplicar;

import java.util.ArrayList;

public class DbLogin extends DbHelper{
    Context context;

    public DbLogin(@Nullable Context context) {
        super(context);
        this.context = context;
    }
    public long insertarContactos(String nombres, String apellidos, String numeroDocumento, String telefono, String correo, String contraseña){
        long id = 0;
        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
        // Función para insertar registro.
            ContentValues values =new ContentValues();
            values.put("nombre", nombres);
            values.put("apellido", apellidos);
            values.put("numeroDocumento", numeroDocumento);
            values.put("correo", correo);
            values.put("telefono", telefono);
            values.put("contraseña", contraseña);

            id =db.insert(TABLE_CONTACTOS, null,values);
        }
        catch (Exception e){
            e.toString();
        }
        return id;
    }
    public ArrayList<TAplicar> mostrarUsuarios(){
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
     //Array para guardar todos los usuarios
        ArrayList<TAplicar> usuarios = new ArrayList<>();
     //creamos los usuarios separados.
     TAplicar usuario = null;
     //Cursor para traer la bd.
        Cursor cursorUsuario = null;
        cursorUsuario = db.rawQuery("select correo, contraseña from TAplicar",null);

      //Recorrer la info que nos trae.
      if(cursorUsuario.moveToFirst()){
          do {
              usuario = new TAplicar();
              usuario.setCorreo(cursorUsuario.getString(0));
              usuario.setContraseña(cursorUsuario.getString(1));
              usuarios.add(usuario);

          }while(cursorUsuario.moveToNext());
      }
      //Cerramos la base de datos
      cursorUsuario.close();
        return usuarios;

    }

}
