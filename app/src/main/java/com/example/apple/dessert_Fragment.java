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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link dessert_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class dessert_Fragment extends Fragment {


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public dessert_Fragment() {

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
    public static dessert_Fragment newInstance(String param1, String param2) {
        dessert_Fragment fragment = new dessert_Fragment();
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
        View V = inflater.inflate(R.layout.fragment, container, false);
        final ListView listView = V.findViewById(R.id.gl);

        ArrayList<dessertmenu> dessert = new ArrayList<>();


        dessert.add(new dessertmenu(R.drawable.donuts, getString(R.string.text_name)));


        com.example.apple.DessertAdapter adptard = new com.example.apple.DessertAdapter(getActivity(), R.layout.mainmenu, dessert);
        listView.setAdapter(adptard);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(getActivity(), dessertmenu.class);
                startActivity(intent);

            }
        });

        return V;

    }
}