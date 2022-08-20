package com.example.apple;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class choices extends AppCompatActivity {

    Button btn_drink, btn_food, btn_addition, btn_pay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_pay = findViewById(R.id.btn_pay);
        btn_drink = findViewById(R.id.btn_drink);
        btn_addition = findViewById(R.id.btn_addition);
        btn_food = findViewById(R.id.btn_food);


        btn_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(choices.this, com.example.apple.finish.class);
                startActivity(intent);

            }


        });
        btn_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(choices.this, com.example.apple.food.class);
                startActivity(intent);

            }
        });


        btn_drink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(choices.this, drink.class);
                startActivity(intent);

            }
        });


        btn_addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(choices.this, com.example.apple.sandwitch_menu.class);
                startActivity(intent);

            }
        });

    }
}