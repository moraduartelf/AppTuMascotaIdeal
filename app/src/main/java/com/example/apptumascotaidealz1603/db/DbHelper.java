package com.example.apptumascotaidealz1603.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION= 1;
    private static final String DATABASE_NOMBRE= "agenda.db";
    public static final String TABLE_CONTACTOS= "TAplicar";
    public static final String TABLE_MASCOTAS= "Tabla_mascotas";

    public DbHelper(@Nullable Context context){
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+ TABLE_CONTACTOS + "(" +
                "id integer primary key autoincrement," +
                "nombre text not null," +
                "apellido text not null," +
                "numeroDocumento text not null," +
                "correo text not null," +
                "telefono text not null," +
                "contraseña text not null)");

        //Creamos la nueva tabla de información de mascotas.
        sqLiteDatabase.execSQL("CREATE TABLE "+ TABLE_MASCOTAS + "(" +
                "id integer primary key autoincrement," +
                "nombre text not null," +
                "tipo text not null," +
                "sexo text not null," +
                "raza text not null," +
                "edad text not null," +
                "vacunas text not null)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table " + TABLE_CONTACTOS);
        onCreate(sqLiteDatabase);

    }
}
