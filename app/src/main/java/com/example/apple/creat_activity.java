package com.example.apple;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class creat_activity extends AppCompatActivity {

    ArrayList<String> users_data = new ArrayList<>();
    com.example.apple.DBcontroller dBcontroller;

    Button button_menu;
    EditText name, mail, phone, pass;
    com.example.apple.DBHelper DB;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creat);

        name = (EditText) findViewById(R.id.name_text);

        mail = (EditText) findViewById(R.id._creat_mail_text);

        phone = (EditText) findViewById(R.id.phone_text);

        pass = (EditText) findViewById(R.id._creat_pass_text);

        button_menu = (Button) findViewById(R.id.Gotomenu_btn);

        checkCrededentials();

        DB = new com.example.apple.DBHelper(this);

        sqLiteDatabase = DB.getWritableDatabase();

        dBcontroller.open();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), R.layout.activity_creat, users_data);

        get_users_data();

        button_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(creat_activity.this, choices.class));
                dBcontroller.insertuserdata(name.getText().toString(), mail.getText().toString(), pass.getText().toString(), phone.getText().toString());
                name.setText("");
                mail.setText("");
                pass.setText("");
                phone.setText("");
                get_users_data();
                adapter.notifyDataSetChanged();
            }
        });

    }

    private void checkCrededentials() {
        String name_text = name.getText().toString();
        String _creat_mail_text = mail.getText().toString();
        String _create_pass_text = pass.getText().toString();
        String phone_text = phone.getText().toString();


        if (name_text.isEmpty()) {
            showError(name, " You Should Enter Your Name");
        } else if (_creat_mail_text.isEmpty()) {
            showError(mail, " You Should Enter Your Mail");
        } else if (_create_pass_text.isEmpty() || pass.length() < 8) {
            showError(pass, " You Should Enter Valid Password");
        } else if (phone_text.isEmpty()) {
            showError(phone, " You Should Enter Your Phone Number");
        } else {
            Toast.makeText(this, "Successful Registration", Toast.LENGTH_SHORT).show();
        }

    }

    private void showError(EditText input, String s) {
        input.setError(s);
        input.requestFocus();

    }


    private void get_users_data() {

        users_data.clear();

        for (userdata data : dBcontroller.selectalluserdata()) {
            users_data.add(users_data.toString());
        }

    }

    protected void onDestroy() {
        super.onDestroy();
        dBcontroller.close();
    }
}