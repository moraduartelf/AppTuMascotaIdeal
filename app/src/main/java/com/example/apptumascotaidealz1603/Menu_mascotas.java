package com.example.apptumascotaidealz1603;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;

public class Menu_mascotas extends AppCompatActivity implements ComunicaMenu{
    Fragment[] misfragmentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_mascotas);
        //Inicializamos los fragmentos...
        misfragmentos= new Fragment[4];
        misfragmentos [0]= new Can();
        misfragmentos [1]= new Cat();
        misfragmentos [2]= new Aves();
        misfragmentos [3]= new Otros();

        //Dentro del onCreate creamos un Bundle para entregar paquetes de una activity a otro.
       /* Bundle extras = getIntent().getExtras();
        menu(extras.getInt("BOTONPULSADO"));*/
    }

    @Override
    public void menu(int cualBoton) {
        FragmentManager miManager = getSupportFragmentManager();
        FragmentTransaction miTransaccion = miManager.beginTransaction();
        //Agregamos la informacion de tipo Fragment para que se cargue la imagen iluminada del menu.
        Fragment menuIluminado= new Menu();
        //Bundle enviamos info de un lado a otro y le samos un valor (clave/valor)
        Bundle datos = new Bundle();
        datos.putInt("BOTONPULSADO", cualBoton);
        menuIluminado.setArguments(datos);
        /* con esta linea vamos a realizar el cambio por el menu iluminado.. (y vamos a Menu.java)
        al onCreateView*/
        miTransaccion.replace(R.id.menu, menuIluminado);

        miTransaccion.replace(R.id.menuMascotas, misfragmentos [cualBoton]);
        //Con este commit se ejecuta.
        miTransaccion.commit();
    }

}