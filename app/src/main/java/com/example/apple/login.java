package com.example.apple;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class login extends AppCompatActivity {

    static boolean check = false;
    CheckBox check_password;
    TextView create_tv;
    EditText edt_mail_login, edt_password_login;
    Button sign_in_btn;
    my_database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Toolbar toolbar;
        toolbar = findViewById(R.id.toolbar_main);
        edt_mail_login = findViewById(R.id.edt_mail_login);
        edt_password_login = findViewById(R.id.edt_password_login);
        setSupportActionBar(toolbar);


        id();
        db = new my_database(this);


        //----- login layout ( check box ) remember me  code -------------------

        check_password.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (!check) {
                    edt_password_login.setInputType(InputType.TYPE_CLASS_TEXT);
                    check = true;

                } else {
                    edt_password_login.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    check = false;
                }
            }
        });


        //------- login layout (text view) create account code -------------------

        create_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent create_page = new Intent(login.this, creat_activity.class);

                startActivity(create_page);
            }
        });


        //------- login layout (button) create account code -------------------

        sign_in_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String mail = edt_mail_login.getText().toString().trim();
                String pass = edt_password_login.getText().toString().trim();

                boolean res_mail = db.check_mail(mail);
                boolean res_pass = db.check_pass(pass);
                boolean rec_check = db.check_user_login(mail, pass);


                if (rec_check == true) {
                    Toast.makeText(login.this, "login success ", Toast.LENGTH_LONG).show();
                    Intent to_home = new Intent(login.this, choices.class);
                    edt_mail_login.setText("");
                    edt_password_login.setText("");
                    startActivity(to_home);
                } else if (res_mail == false) {
                    Toast.makeText(login.this, " Incorrect Email", Toast.LENGTH_LONG).show();
                    edt_mail_login.setText("");
                    edt_password_login.setText("");
                } else if (res_pass == false) {
                    Toast.makeText(login.this, "Incorrect password", Toast.LENGTH_LONG).show();
                    edt_password_login.setText("");
                } else {
                    Toast.makeText(login.this, "Account not Exist", Toast.LENGTH_LONG).show();
                    edt_mail_login.setText("");
                    edt_password_login.setText("");
                }


            }
        });

    }


    private void id() {
        check_password = findViewById(R.id.login_layout_show_pass_cb);
        create_tv = findViewById(R.id.login_layout_create_account_tv);
        edt_mail_login = findViewById(R.id.edt_mail_login);
        edt_password_login = findViewById(R.id.edt_password_login);
        sign_in_btn = findViewById(R.id.Gotomenu_btn);
    }

}