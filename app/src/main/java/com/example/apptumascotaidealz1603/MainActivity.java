package com.example.apptumascotaidealz1603;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button salir= findViewById(R.id.btnSalir);
        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
                alerta.setMessage("Desea salir de la App?")
                        .setPositiveButton("SI", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        })
                        .setCancelable(false);
                alerta.show();
            }
        });

    }

    public void ejectaLogin(View view){
        Intent i = new Intent(this, Aplicar.class);
        startActivity(i);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.iniciosesion:
                Intent a = new Intent(MainActivity.this, Login.class);
                startActivity(a);
                Toast.makeText(this,"Inicio Sesión", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.aplicar:
                Intent b = new Intent(MainActivity.this, Aplicar.class);
                startActivity(b);
                Toast.makeText(this,"Aplicar", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menuMascotas:
                Intent c = new Intent(MainActivity.this, Menu_mascotas.class);
                startActivity(c);
                Toast.makeText(this,"Menú Mascotas", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.crearmascota:
                Intent d = new Intent(MainActivity.this, CrearMascota.class);
                startActivity(d);
                Toast.makeText(this,"Crear Mascota", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.favoritos:
                Toast.makeText(this,"Favoritos",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.salir:
                Toast.makeText(this,"Salir",Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
    public void salirApp(View view){


        /*AlertDialog titulo = alerta.create();
        titulo.setTitle("");
        titulo.show();*/

    }

}