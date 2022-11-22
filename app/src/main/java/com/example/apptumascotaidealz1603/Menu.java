package com.example.apptumascotaidealz1603;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Menu#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Menu extends Fragment {
    private final int [] botonesMenu = {R.id.can,R.id.cat,R.id.aves,R.id.otros};
    //Agregamos el arreglo de los botones con las imagenes iluminadas para saber donde estamos.
    private final int [] botonesIluminados = {R.drawable.can_print,R.drawable.cat_print,R.drawable.aves_print,R.drawable.otros_print};
    private int boton = -1;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Menu() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Menu.
     */
    // TODO: Rename and change types and number of parameters
    public static Menu newInstance(String param1, String param2) {
        Menu fragment = new Menu();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment, lo modificamos por un View para poder trabajar con el arreglo.
        View miMenu = inflater.inflate(R.layout.fragment_menu, container, false);
        //Creamos un condicional para el menu iluminado
        if(getArguments() != null){
            boton = getArguments().getInt("BOTONPULSADO");
        }
        //creamos la variable ImageButton (ya que asi se crearon en el menu).
        ImageButton botonMenu;
        //Creamos un cliclo for para que donde se de click se envie que boton se ejecuto.
        for(int i=0;i<botonesMenu.length; i++){
            botonMenu = (ImageButton) miMenu.findViewById(botonesMenu[i]);
        //Creamos un condicional para que setee las imagenes del boton iluminado.
            if(boton==i){
                botonMenu.setImageResource(botonesIluminados[i]);
            }

            final int queBoton= i;
            botonMenu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Creamos una actividad para que se identifique el boton que se usa.
                    Activity estaActividad = getActivity();
                    ((ComunicaMenu)estaActividad).menu(queBoton);
                }
            });
        }

        return miMenu;
    }
}