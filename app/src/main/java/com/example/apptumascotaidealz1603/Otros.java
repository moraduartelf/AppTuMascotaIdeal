package com.example.apptumascotaidealz1603;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.apptumascotaidealz1603.db.DbCrearMascota;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Otros#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Otros extends Fragment {
    //llamo la informacion del can con el RecyclerView.
    RecyclerView listaOtros;
    //Muestro la informacion del can con el ArrayList.
    ArrayList<Tabla_mascotas> ArrayOtros;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Otros() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Otros.
     */
    // TODO: Rename and change types and number of parameters
    public static Otros newInstance(String param1, String param2) {
        Otros fragment = new Otros();
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
        // Inflate the layout for this fragment
        View fragOtros= inflater.inflate(R.layout.fragment_otros, container, false);
        listaOtros = fragOtros.findViewById(R.id.listaOtros);
        listaOtros.setLayoutManager(new LinearLayoutManager(getActivity()));
        //Ahora hago la conexion de la DB para traer la info.
        DbCrearMascota dbOtros = new DbCrearMascota(getActivity());
        ArrayOtros = new ArrayList<>();
        ItemOtros itemOtros = new ItemOtros(dbOtros.mostrarMascotaOtros());
        listaOtros.setAdapter(itemOtros);

        return fragOtros;
    }
}