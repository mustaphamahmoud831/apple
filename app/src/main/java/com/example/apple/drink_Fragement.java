package com.example.apple;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class drink_Fragement extends Fragment {


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public drink_Fragement() {

        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment food_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static drink_Fragement newInstance(String param1, String param2) {
        drink_Fragement fragment = new drink_Fragement();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public void setArguments(Bundle args) {
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
        View V = inflater.inflate(R.layout.fragment_drink, container, false);
        final ListView listView = V.findViewById(R.id.gl);

        ArrayList<drink> drinks = new ArrayList<>();

        drinks.add(new drink(R.drawable.iceoreo, getString(R.string.iceoreo)));

        drinks.add(new drink(R.drawable.icedcoffee, getString(R.string.icedcoffee)));
        drinks.add(new drink(R.drawable.smozi, getString(R.string.smozi)));
        drinks.add(new drink(R.drawable.mokheto, getString(R.string.mokhito)));


        drinks adptar = new drinks(getActivity(), R.layout.card_layout, drinks);
        listView.setAdapter(adptar);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i) {

                    case 0:

                        Intent intent = new Intent(getActivity(), drinks_menu.class);

                }
            }

        });


        return V;

    }
}
