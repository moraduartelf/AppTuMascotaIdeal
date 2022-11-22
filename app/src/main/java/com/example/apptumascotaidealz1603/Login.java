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

import java.util.ArrayList;


public class Login extends AppCompatActivity {
    TextView email, password;
    Button guardarRegistro;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.iniciosesion:
                Intent a = new Intent(Login.this, Login.class);
                startActivity(a);
                Toast.makeText(this,"Inicio Sesión", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.aplicar:
                Intent b = new Intent(Login.this, Aplicar.class);
                startActivity(b);
                Toast.makeText(this,"Aplicar", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menuMascotas:
                Intent c = new Intent(Login.this, Menu_mascotas.class);
                startActivity(c);
                Toast.makeText(this,"Menú Mascotas", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.crearmascota:
                Intent d = new Intent(Login.this, CrearMascota.class);
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        email = findViewById(R.id.etEmail);
        password = findViewById(R.id.etContraseña);
        guardarRegistro = findViewById(R.id.btningresar);

        guardarRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /* Toast.makeText(Login.this, "Inició sesión exitoso",Toast.LENGTH_SHORT).show();

                DbLogin dbLogin = new DbLogin(Login.this);
                long id = dbLogin.insertarContactos(email.getText().toString(),password.getText().toString());

                if(id>0){
                    Toast.makeText(Login.this, "Agregado a la Base de Datos",Toast.LENGTH_SHORT).show();
                    limpiar();
                }
                else{
                    Toast.makeText(Login.this,"Error al registrar",Toast.LENGTH_SHORT).show();

                }*/
                DbLogin dbLogin = new DbLogin(Login.this);
                ArrayList<TAplicar> usuarios = dbLogin.mostrarUsuarios();
                Boolean validar = false;
                //Extraer la info de los Texview

                String correo = email.getText().toString();
                String contraseña = password.getText().toString();

                for(TAplicar u: usuarios){
                    if(correo.equals(u.getCorreo()) && contraseña.equals(u.getContraseña()) ){
                        validar = true;
                    }
                }
                if(validar){
                    Intent intent = new Intent(Login.this, CrearMascota.class);
                    startActivity(intent);
                    limpiar();
                }else{
                    Toast.makeText(Login.this,"Error de registro", Toast.LENGTH_LONG).show();
                }
            }
        });

        }
        private void limpiar(){
        email.setText("");
        password.setText("");

    }

}
