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

public class _menu extends AppCompatActivity {

    ListView listView;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainmenu);


        listView = findViewById(R.id.gl);
        save = findViewById(R.id.button);

        ArrayList<dessertmenu> menus = new ArrayList<>();


        menus.add(new dessertmenu(R.drawable.moltencake, getString(R.string.dessert_menu_moltencake), "40"));
        menus.add(new dessertmenu(R.drawable.chocolatecake, getString(R.string.dessert_menu_chocolatecake), "50"));
        menus.add(new dessertmenu(R.drawable.cupcake, getString(R.string.dessert_menu_cupcake), "35"));
        menus.add(new dessertmenu(R.drawable.muffincake, getString(R.string.dessert_menu_muffincake), "45"));
        menus.add(new dessertmenu(R.drawable.redvelvetcake, getString(R.string.dessert_menu_redvelvetcake), "39"));
        menus.add(new dessertmenu(R.drawable.travelcake, getString(R.string.dessert_menu_travelcake), "47"));
        menus.add(new dessertmenu(R.drawable.cinabon, getString(R.string.dessert_menu_cinabon), "40"));
        menus.add(new dessertmenu(R.drawable.coffeedessert, getString(R.string.dessert_menu_cofeedessert), "37"));
        menus.add(new dessertmenu(R.drawable.cookies, getString(R.string.dessert_menu_cookies), "35"));
        menus.add(new dessertmenu(R.drawable.cremecaramel, getString(R.string.dessert_menu_cremecaramel), "35"));
        menus.add(new dessertmenu(R.drawable.donuts, getString(R.string.dessert_menu_donuts), "20"));
        menus.add(new dessertmenu(R.drawable.eklerek, getString(R.string.dessert_menu_eklereke), "41"));
        menus.add(new dessertmenu(R.drawable.macaron, getString(R.string.dessert_menu_macaron), "100"));
        menus.add(new dessertmenu(R.drawable.millefeuille, getString(R.string.dessert_menu_millefeuille), "39"));
        menus.add(new dessertmenu(R.drawable.waffle, getString(R.string.dessert_menu_wafel), "35"));


        com.example.apple.DessertAdapter myadptar = new com.example.apple.DessertAdapter(this, R.layout.menurow, menus);
        listView.setAdapter(myadptar);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent to_result = new Intent(_menu.this, com.example.apple.finish.class);
                startActivity(to_result);
            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i) {
                    case 0:


                        com.example.apple.finish.result_menu.add(new dessertmenu(R.drawable.moltencake, getString(R.string.dessert_menu_moltencake), "40"));

                        View v = LayoutInflater.from(_menu.this).inflate(R.layout.tost, null, false);
                        Toast t = new Toast(_menu.this);
                        t.setView(v);
                        t.setDuration(Toast.LENGTH_SHORT);
                        t.setGravity(Gravity.CENTER, 0, 0);
                        t.show();

                        break;
                    case 1:

                        com.example.apple.finish.result_menu.add(new dessertmenu(R.drawable.chocolatecake, getString(R.string.dessert_menu_chocolatecake), "50"));

                        View v1 = LayoutInflater.from(_menu.this).inflate(R.layout.tost, null, false);
                        Toast t1 = new Toast(_menu.this);
                        t1.setView(v1);
                        t1.setDuration(Toast.LENGTH_SHORT);
                        t1.setGravity(Gravity.CENTER, 0, 0);
                        t1.show();

                        break;


                    case 2:

                        com.example.apple.finish.result_menu.add(new dessertmenu(R.drawable.cupcake, getString(R.string.dessert_menu_cupcake), "35"));

                        View v2 = LayoutInflater.from(_menu.this).inflate(R.layout.tost, null, false);
                        Toast t2 = new Toast(_menu.this);
                        t2.setView(v2);
                        t2.setDuration(Toast.LENGTH_SHORT);
                        t2.setGravity(Gravity.CENTER, 0, 0);
                        t2.show();

                        break;


                    case 3:

                        com.example.apple.finish.result_menu.add(new dessertmenu(R.drawable.muffincake, getString(R.string.dessert_menu_muffincake), "45"));

                        View v3 = LayoutInflater.from(_menu.this).inflate(R.layout.tost, null, false);
                        Toast t3 = new Toast(_menu.this);
                        t3.setView(v3);
                        t3.setDuration(Toast.LENGTH_SHORT);
                        t3.setGravity(Gravity.CENTER, 0, 0);
                        t3.show();

                        break;


                    case 4:

                        com.example.apple.finish.result_menu.add(new dessertmenu(R.drawable.redvelvetcake, getString(R.string.dessert_menu_redvelvetcake), "39"));

                        View v4 = LayoutInflater.from(_menu.this).inflate(R.layout.tost, null, false);
                        Toast t4 = new Toast(_menu.this);
                        t4.setView(v4);
                        t4.setDuration(Toast.LENGTH_SHORT);
                        t4.setGravity(Gravity.CENTER, 0, 0);
                        t4.show();

                        break;


                    case 5:

                        com.example.apple.finish.result_menu.add(new dessertmenu(R.drawable.travelcake, getString(R.string.dessert_menu_travelcake), "47"));

                        View v5 = LayoutInflater.from(_menu.this).inflate(R.layout.tost, null, false);
                        Toast t5 = new Toast(_menu.this);
                        t5.setView(v5);
                        t5.setDuration(Toast.LENGTH_SHORT);
                        t5.setGravity(Gravity.CENTER, 0, 0);
                        t5.show();
                        break;

                    case 6:

                        com.example.apple.finish.result_menu.add(new dessertmenu(R.drawable.cinabon, getString(R.string.dessert_menu_cinabon), "40"));

                        View v6 = LayoutInflater.from(_menu.this).inflate(R.layout.tost, null, false);
                        Toast t6 = new Toast(_menu.this);
                        t6.setView(v6);
                        t6.setDuration(Toast.LENGTH_SHORT);
                        t6.setGravity(Gravity.CENTER, 0, 0);
                        t6.show();
                        break;

                    case 7:

                        com.example.apple.finish.result_menu.add(new dessertmenu(R.drawable.coffeedessert, getString(R.string.dessert_menu_cofeedessert), "37"));

                        View v7 = LayoutInflater.from(_menu.this).inflate(R.layout.tost, null, false);
                        Toast t7 = new Toast(_menu.this);
                        t7.setView(v7);
                        t7.setDuration(Toast.LENGTH_SHORT);
                        t7.setGravity(Gravity.CENTER, 0, 0);
                        t7.show();
                        break;

                    case 8:

                        com.example.apple.finish.result_menu.add(new dessertmenu(R.drawable.cookies, getString(R.string.dessert_menu_cookies), "35"));

                        View v8 = LayoutInflater.from(_menu.this).inflate(R.layout.tost, null, false);
                        Toast t8 = new Toast(_menu.this);
                        t8.setView(v8);
                        t8.setDuration(Toast.LENGTH_SHORT);
                        t8.setGravity(Gravity.CENTER, 0, 0);
                        t8.show();
                        break;

                    case 9:

                        com.example.apple.finish.result_menu.add(new dessertmenu(R.drawable.cremecaramel, getString(R.string.dessert_menu_cremecaramel), "35"));

                        View v9 = LayoutInflater.from(_menu.this).inflate(R.layout.tost, null, false);
                        Toast t9 = new Toast(_menu.this);
                        t9.setView(v9);
                        t9.setDuration(Toast.LENGTH_SHORT);
                        t9.setGravity(Gravity.CENTER, 0, 0);
                        t9.show();
                        break;

                    case 10:

                        com.example.apple.finish.result_menu.add(new dessertmenu(R.drawable.donuts, getString(R.string.dessert_menu_donuts), "20"));

                        View v10 = LayoutInflater.from(_menu.this).inflate(R.layout.tost, null, false);
                        Toast t10 = new Toast(_menu.this);
                        t10.setView(v10);
                        t10.setDuration(Toast.LENGTH_SHORT);
                        t10.setGravity(Gravity.CENTER, 0, 0);
                        t10.show();
                        break;

                    case 11:

                        com.example.apple.finish.result_menu.add(new dessertmenu(R.drawable.eklerek, getString(R.string.dessert_menu_eklereke), "41"));

                        View v11 = LayoutInflater.from(_menu.this).inflate(R.layout.tost, null, false);
                        Toast t11 = new Toast(_menu.this);
                        t11.setView(v11);
                        t11.setDuration(Toast.LENGTH_SHORT);
                        t11.setGravity(Gravity.CENTER, 0, 0);
                        t11.show();
                        break;

                    case 12:

                        com.example.apple.finish.result_menu.add(new dessertmenu(R.drawable.macaron, getString(R.string.dessert_menu_macaron), "100"));

                        View v12 = LayoutInflater.from(_menu.this).inflate(R.layout.tost, null, false);
                        Toast t12 = new Toast(_menu.this);
                        t12.setView(v12);
                        t12.setDuration(Toast.LENGTH_SHORT);
                        t12.setGravity(Gravity.CENTER, 0, 0);
                        t12.show();
                        break;

                    case 13:

                        com.example.apple.finish.result_menu.add(new dessertmenu(R.drawable.millefeuille, getString(R.string.dessert_menu_millefeuille), "39"));

                        View v13 = LayoutInflater.from(_menu.this).inflate(R.layout.tost, null, false);
                        Toast t13 = new Toast(_menu.this);
                        t13.setView(v13);
                        t13.setDuration(Toast.LENGTH_SHORT);
                        t13.setGravity(Gravity.CENTER, 0, 0);
                        t13.show();
                        break;

                    case 14:

                        com.example.apple.finish.result_menu.add(new dessertmenu(R.drawable.waffle, getString(R.string.dessert_menu_wafel), "35"));

                        View v14 = LayoutInflater.from(_menu.this).inflate(R.layout.tost, null, false);
                        Toast t14 = new Toast(_menu.this);
                        t14.setView(v14);
                        t14.setDuration(Toast.LENGTH_SHORT);
                        t14.setGravity(Gravity.CENTER, 0, 0);
                        t14.show();
                        break;


                }

            }
        });


    }
}

