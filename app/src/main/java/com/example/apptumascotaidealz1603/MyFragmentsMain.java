package com.example.apptumascotaidealz1603;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

//Implementamos la clase con comunicaMenu y debemos implementar los metodos.
public class MyFragmentsMain extends AppCompatActivity implements ComunicaMenu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_fragments);

    }

    @Override
    public void menu(int cualBoton) {
        Intent in = new Intent(this, MyFragmentsMain.class);
        in.putExtra("BOTONPUSADO", cualBoton);
        startActivity(in);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.iniciosesion:
                Intent a = new Intent(MyFragmentsMain.this, Login.class);
                startActivity(a);
                Toast.makeText(this, "Inicio Sesión", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.aplicar:
                Intent b = new Intent(MyFragmentsMain.this, Aplicar.class);
                startActivity(b);
                Toast.makeText(this, "Aplicar", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menuMascotas:
                Intent c = new Intent(MyFragmentsMain.this, Menu_mascotas.class);
                startActivity(c);
                Toast.makeText(this, "Menú Mascotas", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.crearmascota:
                Intent d = new Intent(MyFragmentsMain.this, CrearMascota.class);
                startActivity(d);
                Toast.makeText(this, "Crear Mascota", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.favoritos:
                Toast.makeText(this, "Favoritos", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.salir:
                Toast.makeText(this, "Salir", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}