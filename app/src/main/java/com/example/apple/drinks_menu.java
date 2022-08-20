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

public class drinks_menu extends AppCompatActivity {

    ListView listView;
    Button save;
    private Object drinks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);


        listView = findViewById(R.id.lss_menu);
        save = findViewById(R.id.drink_menu_layout_save);

        ArrayList<drink> drinks = new ArrayList<>();


        drinks.add(new drink(R.drawable.coffee, getString(R.string.coffee), "25"));
        drinks.add(new drink(R.drawable.hotchoclet, getString(R.string.hotchoclet), "30"));
        drinks.add(new drink(R.drawable.icedcoffee, getString(R.string.icedcoffee), "30"));
        drinks.add(new drink(R.drawable.iceoreo, getString(R.string.iceoreo), "20"));
        drinks.add(new drink(R.drawable.lemon, getString(R.string.lemon), "20"));
        drinks.add(new drink(R.drawable.late, getString(R.string.latee), "25"));
        drinks.add(new drink(R.drawable.mokheto, getString(R.string.mokhito), "20"));
        drinks.add(new drink(R.drawable.orange, getString(R.string.orange), "30"));
        drinks.add(new drink(R.drawable.smozi, getString(R.string.smozi), "20"));


        com.example.apple.drinks myadptar = new com.example.apple.drinks(this, R.layout.row, drinks);
        listView.setAdapter(myadptar);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent to_result = new Intent(drinks_menu.this, com.example.apple.finish.class);
                startActivity(to_result);
            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i) {
                    case 0:


                        com.example.apple.finish.result_men.add(new drink(R.drawable.icedcoffee, getString(R.string.icedcoffee), "30"));

                        View v = LayoutInflater.from(drinks_menu.this).inflate(R.layout.custom_toast, null, false);
                        Toast t = new Toast(drinks_menu.this);
                        t.setView(v);
                        t.setDuration(Toast.LENGTH_SHORT);
                        t.setGravity(Gravity.CENTER, 0, 0);
                        t.show();

                        break;
                    case 1:

                        com.example.apple.finish.result_men.add(new drink(R.drawable.hotchoclet, getString(R.string.hotchoclet), "30"));

                        View v1 = LayoutInflater.from(drinks_menu.this).inflate(R.layout.custom_toast, null, false);
                        Toast t1 = new Toast(drinks_menu.this);
                        t1.setView(v1);
                        t1.setDuration(Toast.LENGTH_SHORT);
                        t1.setGravity(Gravity.CENTER, 0, 0);
                        t1.show();

                        break;


                    case 2:

                        com.example.apple.finish.result_men.add(new drink(R.drawable.mokheto, getString(R.string.mokhito), "20"));

                        View v2 = LayoutInflater.from(drinks_menu.this).inflate(R.layout.custom_toast, null, false);
                        Toast t2 = new Toast(drinks_menu.this);
                        t2.setView(v2);
                        t2.setDuration(Toast.LENGTH_SHORT);
                        t2.setGravity(Gravity.CENTER, 0, 0);
                        t2.show();

                        break;


                    case 3:

                        com.example.apple.finish.result_men.add(new drink(R.drawable.late, getString(R.string.latee), "25"));

                        View v3 = LayoutInflater.from(drinks_menu.this).inflate(R.layout.custom_toast, null, false);
                        Toast t3 = new Toast(drinks_menu.this);
                        t3.setView(v3);
                        t3.setDuration(Toast.LENGTH_SHORT);
                        t3.setGravity(Gravity.CENTER, 0, 0);
                        t3.show();

                        break;


                    case 4:

                        com.example.apple.finish.result_men.add(new drink(R.drawable.iceoreo, getString(R.string.iceoreo), "20"));

                        View v4 = LayoutInflater.from(drinks_menu.this).inflate(R.layout.custom_toast, null, false);
                        Toast t4 = new Toast(drinks_menu.this);
                        t4.setView(v4);
                        t4.setDuration(Toast.LENGTH_SHORT);
                        t4.setGravity(Gravity.CENTER, 0, 0);
                        t4.show();

                        break;


                    case 5:

                        com.example.apple.finish.result_men.add(new drink(R.drawable.orange, getString(R.string.orange), "30"));

                        View v5 = LayoutInflater.from(drinks_menu.this).inflate(R.layout.custom_toast, null, false);
                        Toast t5 = new Toast(drinks_menu.this);
                        t5.setView(v5);
                        t5.setDuration(Toast.LENGTH_SHORT);
                        t5.setGravity(Gravity.CENTER, 0, 0);
                        t5.show();
                        break;
                    case 6:

                        com.example.apple.finish.result_men.add(new drink(R.drawable.smozi, getString(R.string.smozi), "20"));

                        View v6 = LayoutInflater.from(drinks_menu.this).inflate(R.layout.custom_toast, null, false);
                        Toast t6 = new Toast(drinks_menu.this);
                        t6.setView(v6);
                        t6.setDuration(Toast.LENGTH_SHORT);
                        t6.setGravity(Gravity.CENTER, 0, 0);
                        t6.show();

                        break;


                    case 7:

                        com.example.apple.finish.result_men.add(new drink(R.drawable.coffee, getString(R.string.coffee), "25"));

                        View v7 = LayoutInflater.from(drinks_menu.this).inflate(R.layout.custom_toast, null, false);
                        Toast t7 = new Toast(drinks_menu.this);
                        t7.setView(v7);
                        t7.setDuration(Toast.LENGTH_SHORT);
                        t7.setGravity(Gravity.CENTER, 0, 0);
                        t7.show();
                        break;
                    case 8:

                        com.example.apple.finish.result_men.add(new drink(R.drawable.lemon, getString(R.string.lemon), "20"));

                        View v8 = LayoutInflater.from(drinks_menu.this).inflate(R.layout.custom_toast, null, false);
                        Toast t8 = new Toast(drinks_menu.this);
                        t8.setView(v8);
                        t8.setDuration(Toast.LENGTH_SHORT);
                        t8.setGravity(Gravity.CENTER, 0, 0);
                        t8.show();
                        break;


                }
            }
        });

    }
}