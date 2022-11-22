package com.example.apptumascotaidealz1603;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.apptumascotaidealz1603.db.DbCrearMascota;


public class CrearMascota extends AppCompatActivity {
    TextView nombre, tipo, sexo, raza, edad, vacunas;
    Button guardar;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.iniciosesion:
                Intent a = new Intent(CrearMascota.this, Login.class);
                startActivity(a);
                Toast.makeText(this, "Inicio Sesión", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.aplicar:
                Intent b = new Intent(CrearMascota.this, Aplicar.class);
                startActivity(b);
                Toast.makeText(this, "Aplicar", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menuMascotas:
                Intent c = new Intent(CrearMascota.this, Menu_mascotas.class);
                startActivity(c);
                Toast.makeText(this,"Menú Mascotas", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.crearmascota:
                Intent d = new Intent(CrearMascota.this, CrearMascota.class);
                startActivity(d);
                Toast.makeText(this,"Crear Mascota", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.favoritos:
                Toast.makeText(this, "Favoritos", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.salir:
                Toast.makeText(this, "Salir", Toast.LENGTH_SHORT).show();
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
        setContentView(R.layout.crear_mascota);
        //Asignamos los text view a las variables para conectarlos
        nombre = findViewById(R.id.etNombreMascota);
        tipo = findViewById(R.id.etTipoMascota);
        sexo = findViewById(R.id.etSexoMascota);
        raza = findViewById(R.id.etRaza);
        edad = findViewById(R.id.etEdad);
        vacunas = findViewById(R.id.etVacunas);

        guardar = findViewById(R.id.btnInfoPett);
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CrearMascota.this, "Mascota creada con éxito", Toast.LENGTH_SHORT).show();

                DbCrearMascota dbCrearMascota = new DbCrearMascota(CrearMascota.this);
                long id = dbCrearMascota.insertarDatosMascota(nombre.getText().toString(),tipo.getText().toString(), sexo.getText().toString(), raza.getText().toString(), edad.getText().toString(), vacunas.getText().toString());

                if (id > 0) {
                    Toast.makeText(CrearMascota.this, "Agregado a la Base de Datos", Toast.LENGTH_SHORT).show();
                    limpiar();
                } else {
                    Toast.makeText(CrearMascota.this, "Error al registrar", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
    private void limpiar() {
        nombre.setText("");
        tipo.setText("");
        sexo.setText("");
        raza.setText("");
        edad.setText("");
        vacunas.setText("");
    }

}
