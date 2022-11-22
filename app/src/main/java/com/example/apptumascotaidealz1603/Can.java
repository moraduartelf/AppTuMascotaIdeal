    package com.example.apptumascotaidealz1603;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.example.apptumascotaidealz1603.db.DbCrearMascota;
import java.util.ArrayList;

    /**
 * A simple {@link Fragment} subclass.
 * Use the {@link Can#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Can extends Fragment {
    //llamo la informacion del can con el RecyclerView.
    RecyclerView listaCan;
    //Muestro la informacion del can con el ArrayList.
    ArrayList<Tabla_mascotas> ArrayCan;

    //Creamos en el fragmento las variable de tipo ImageView...
    private ImageView botonCan;
    private boolean en_uso;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Can() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Can.
     */
    // TODO: Rename and change types and number of parameters
    public static Can newInstance(String param1, String param2) {
        Can fragment = new Can();
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
        // Inflate the layout for this fragment; lo cambiamos por un View fragment...
        View fragCan=  inflater.inflate(R.layout.fragment_can, container, false);
        listaCan = fragCan.findViewById(R.id.listacan);
        listaCan.setLayoutManager(new LinearLayoutManager(getActivity()));
        //Ahora hago la conexion de la DB para traer la info.
        DbCrearMascota dbCan = new DbCrearMascota(getActivity());
        ArrayCan = new ArrayList<>();
        ItemCan itemCan = new ItemCan(dbCan.mostrarMascotaCan());
        listaCan.setAdapter(itemCan);

       /* botonCan = (ImageView) fragCan.findViewById(R.id.can);
        botonCan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (en_uso) {
                    botonEnMenuMascotas();
                    en_uso=false;
                }
                else {
                    botonEnCrearMascota();
                    en_uso= true;
                }
            }
        });*/

        return fragCan;
    }
    public void botonEnMenuMascotas(){
        botonCan.setImageResource(R.drawable.can_print);
    }
    public void botonEnCrearMascota(){
        botonCan.setImageResource(R.drawable.can);
    }

}