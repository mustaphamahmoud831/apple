package com.example.apple;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DBcontroller {
    com.example.apple.DBHelper DB;
    private SQLiteDatabase database;

    public DBcontroller(Context context) {
        DB = new com.example.apple.DBHelper(context);
    }

    public void open() {
        database = DB.getWritableDatabase();
    }


    public long insertuserdata(String NAME, String MAIL, String PASSWORD, String PHONE) {

        ContentValues values = new ContentValues();
        values.put(com.example.apple.DBHelper.COL2, NAME);
        values.put(com.example.apple.DBHelper.COL3, MAIL);
        values.put(com.example.apple.DBHelper.COL4, PASSWORD);
        values.put(com.example.apple.DBHelper.COL5, PHONE);

        return database.insert(com.example.apple.DBHelper.TABLE_NAME, null, values);
    }


    public int updateuserdata(int ID, String NAME, String MAIL, String PASSWORD, String PHONE) {

        ContentValues values = new ContentValues();
        values.put(com.example.apple.DBHelper.COL2, NAME);
        values.put(com.example.apple.DBHelper.COL3, MAIL);
        values.put(com.example.apple.DBHelper.COL4, PASSWORD);
        values.put(com.example.apple.DBHelper.COL5, PHONE);

        return database.update(com.example.apple.DBHelper.TABLE_NAME, values, com.example.apple.DBHelper.COL1 + "=" + ID, null);
    }


    public int deleteuserdata(int ID) {

        return database.delete(com.example.apple.DBHelper.TABLE_NAME, com.example.apple.DBHelper.COL1 + "=" + ID, null);
    }

    public userdata selectuserdata(int ID) {
        Cursor cursor = database.query(com.example.apple.DBHelper.TABLE_NAME, new String[]{com.example.apple.DBHelper.COL1, com.example.apple.DBHelper.COL2, com.example.apple.DBHelper.COL3, com.example.apple.DBHelper.COL4, com.example.apple.DBHelper.COL5}, com.example.apple.DBHelper.COL1 + "=" + ID, null, null, null, null);

        cursor.moveToFirst();
        return cursorTouserdata(cursor);
    }

    private userdata cursorTouserdata(Cursor cursor) {
        return new userdata(cursor.getInt(0), cursor.getString(1));
    }


    public ArrayList<userdata> selectalluserdata() {

        ArrayList<userdata> usersdata = new ArrayList<>();

        Cursor cursor = database.query(com.example.apple.DBHelper.TABLE_NAME, new String[]{com.example.apple.DBHelper.COL1, com.example.apple.DBHelper.COL2, com.example.apple.DBHelper.COL3, com.example.apple.DBHelper.COL4, com.example.apple.DBHelper.COL5}, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            usersdata.add(cursorTouserdata(cursor));
            cursor.moveToNext();
        }
        return usersdata;
    }

    public void close() {
        if (DB != null) {
            DB.close();
        }
    }
}
