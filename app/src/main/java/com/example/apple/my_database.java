package com.example.apple;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class my_database extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "register";
    public static final String TABLE_NAME = "users";
    public static final String USER_ID = "id";
    public static final String USER_NAME = "name";
    public static final String USER_EMAIL = "email";
    public static final String USER_PHONE = "phone";
    public static final String USER_PASS = "password";


    my_database(Context c) {
        super(c, "register", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE users (id INTEGER PRIMARY KEY AUTOINCREMENT , name TEXT , email TEXT , phone TEXT , password TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists users");
        onCreate(sqLiteDatabase);
    }


    public boolean insert_user(com.example.apple.user user) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("name", user.getName());
        values.put("email", user.getEmail());
        values.put("phone", user.getPhone());
        values.put("password", user.getPass());

        // insert method return -1 if it no added and positive number if added

        long result = db.insert("users", null, values);
        db.close();

        return result != -1;

    }


    public boolean check_user_login(String user_mail, String user_pass) {

        SQLiteDatabase db = getReadableDatabase();


        Cursor cursor = db.rawQuery("SELECT * FROM users WHERE email =? and password =? ", new String[]{user_mail, user_pass});

        return cursor.getCount() != 0;

    }


    public boolean check_mail(String user_mail) {
        SQLiteDatabase db = getReadableDatabase();


        Cursor cursor = db.rawQuery("SELECT * FROM users WHERE email =? ", new String[]{user_mail});

        return cursor.getCount() != 0;
    }


    public boolean check_pass(String user_pass) {

        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM users WHERE password =? ", new String[]{user_pass});

        return cursor.getCount() != 0;
    }


    public long get_count() {
        SQLiteDatabase db = getWritableDatabase();

        return DatabaseUtils.queryNumEntries(db, TABLE_NAME);
    }

}
