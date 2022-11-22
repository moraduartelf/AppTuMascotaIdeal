package com.example.apptumascotaidealz1603;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.apptumascotaidealz1603.db.DbLogin;

public class Aplicar extends AppCompatActivity {
    TextView nombres, apellidos, numeroDocumento, telefono, correo, password;
    Button guardar;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.iniciosesion:
                Intent a = new Intent(Aplicar.this, Login.class);
                startActivity(a);
                Toast.makeText(this,"Inicio Sesión", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.aplicar:
                Intent b = new Intent(Aplicar.this, Aplicar.class);
                startActivity(b);
                Toast.makeText(this,"Aplicar", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menuMascotas:
                Intent c = new Intent(Aplicar.this, Menu_mascotas.class);
                startActivity(c);
                Toast.makeText(this,"Menú Mascotas", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.crearmascota:
                Intent d = new Intent(Aplicar.this, CrearMascota.class);
                startActivity(d);
                Toast.makeText(this,"Crear Mascota", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.favoritos:
                Toast.makeText(this,"Favoritos",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.salir:
                Toast.makeText(this,"Salir",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aplicar);
        //Asignamos los text view a las variables para conectarlos
        nombres= findViewById(R.id.etNombres);
        apellidos= findViewById(R.id.etApellidos);
        numeroDocumento= findViewById(R.id.etDocumento);
        telefono= findViewById(R.id.etTelefono);
        correo= findViewById(R.id.etCorreo);
        password= findViewById(R.id.etPassword);

        guardar = findViewById(R.id.btnaplicar);
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Aplicar.this, "Aplicación exitosa",Toast.LENGTH_SHORT).show();

                DbLogin dbLogin = new DbLogin(Aplicar.this);
                long id = dbLogin.insertarContactos(nombres.getText().toString(),apellidos.getText().toString(),numeroDocumento.getText().toString()
                , telefono.getText().toString(), correo.getText().toString(), password.getText().toString());

                if(id>0){
                    Toast.makeText(Aplicar.this, "Agregado a la Base de Datos",Toast.LENGTH_SHORT).show();
                    limpiar();
             //Cambio de actividad del registro al login
                    Intent cambio = new Intent(Aplicar.this, Login.class);
                    startActivity(cambio);
                }
                else{
                    Toast.makeText(Aplicar.this,"Error al registrar",Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
    private void limpiar(){
        nombres.setText("");
        apellidos.setText("");
        numeroDocumento.setText("");
        telefono.setText("");
        correo.setText("");
        password.setText("");
    }

}
