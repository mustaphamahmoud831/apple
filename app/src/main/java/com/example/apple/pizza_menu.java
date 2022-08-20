package com.example.apple;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class pizza_menu extends AppCompatActivity {


    ListView listView;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza);

        listView = findViewById(R.id.ls_menu_pizza);
        save = findViewById(R.id.pizza_menu_layout_save);

        ArrayList<com.example.apple.menu> menus = new ArrayList<>();

        menus.add(new com.example.apple.menu(R.drawable.magrita, getString(R.string.pizza_menu_layout_Margherita_Pizza), "24"));
        menus.add(new com.example.apple.menu(R.drawable.stchkin, getString(R.string.pizza_menu_layout_Chicken_Pizza), "35"));
        menus.add(new com.example.apple.menu(R.drawable.meat, getString(R.string.pizza_menu_layout_Meat_Pizza), "31"));
        menus.add(new com.example.apple.menu(R.drawable.chesse, getString(R.string.pizza_menu_layout_Cheese_Pizza), "29"));
        menus.add(new com.example.apple.menu(R.drawable.tona, getString(R.string.pizza_menu_layout_Tuna_pizza), "33"));
        menus.add(new com.example.apple.menu(R.drawable.ganabary, getString(R.string.pizza_menu_layout_Shrimp_pizza), "43"));


        MenuListView myadptar = new MenuListView(this, R.layout.menu_row, menus);
        listView.setAdapter(myadptar);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent to_result = new Intent(pizza_menu.this, com.example.apple.finish.class);
                startActivity(to_result);
            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i) {
                    case 0:


                        com.example.apple.finish.result_menus.add(new com.example.apple.menu(R.drawable.magrita, getString(R.string.pizza_menu_layout_Margherita_Pizza), "24"));

                        View v = LayoutInflater.from(pizza_menu.this).inflate(R.layout.custom_toast, null, false);

                        Toast t = new Toast(pizza_menu.this);
                        t.setView(v);
                        t.setDuration(Toast.LENGTH_SHORT);
                        t.setGravity(Gravity.CENTER, 0, 0);
                        t.show();

                        break;


                    case 1:


                        com.example.apple.finish.result_menus.add(new com.example.apple.menu(R.drawable.stchkin, getString(R.string.pizza_menu_layout_Chicken_Pizza), "35"));

                        View v1 = LayoutInflater.from(pizza_menu.this).inflate(R.layout.custom_toast, null, false);
                        Toast t1 = new Toast(pizza_menu.this);
                        t1.setView(v1);
                        t1.setDuration(Toast.LENGTH_SHORT);
                        t1.setGravity(Gravity.CENTER, 0, 0);
                        t1.show();


                        break;

                    case 2:

                        com.example.apple.finish.result_menus.add(new com.example.apple.menu(R.drawable.meat, getString(R.string.pizza_menu_layout_Meat_Pizza), "31"));

                        View v2 = LayoutInflater.from(pizza_menu.this).inflate(R.layout.custom_toast, null, false);
                        Toast t2 = new Toast(pizza_menu.this);
                        t2.setView(v2);
                        t2.setDuration(Toast.LENGTH_SHORT);
                        t2.setGravity(Gravity.CENTER, 0, 0);
                        t2.show();

                        break;

                    case 3:

                        com.example.apple.finish.result_menus.add(new com.example.apple.menu(R.drawable.chesse, getString(R.string.pizza_menu_layout_Cheese_Pizza), "29"));

                        View v3 = LayoutInflater.from(pizza_menu.this).inflate(R.layout.custom_toast, null, false);
                        Toast t3 = new Toast(pizza_menu.this);
                        t3.setView(v3);
                        t3.setDuration(Toast.LENGTH_SHORT);
                        t3.setGravity(Gravity.CENTER, 0, 0);
                        t3.show();

                        break;

                    case 4:


                        com.example.apple.finish.result_menus.add(new com.example.apple.menu(R.drawable.tona, getString(R.string.pizza_menu_layout_Tuna_pizza), "33"));

                        View v4 = LayoutInflater.from(pizza_menu.this).inflate(R.layout.custom_toast, null, false);
                        Toast t4 = new Toast(pizza_menu.this);
                        t4.setView(v4);
                        t4.setDuration(Toast.LENGTH_SHORT);
                        t4.setGravity(Gravity.CENTER, 0, 0);
                        t4.show();

                        break;

                    case 5:

                        com.example.apple.finish.result_menus.add(new com.example.apple.menu(R.drawable.ganabary, getString(R.string.pizza_menu_layout_Shrimp_pizza), "43"));

                        View v5 = LayoutInflater.from(pizza_menu.this).inflate(R.layout.custom_toast, null, false);
                        Toast t5 = new Toast(pizza_menu.this);
                        t5.setView(v5);
                        t5.setDuration(Toast.LENGTH_SHORT);
                        t5.setGravity(Gravity.CENTER, 0, 0);
                        t5.show();

                        break;


                }
            }
        });

    }
}