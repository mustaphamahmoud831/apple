package com.example.apple;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public static final String TABLE_NAME = "userdata";
    public static final int DBVER = 1;
    public static final String COL1 = "ID";
    public static final String COL2 = "NAME";
    public static final String COL3 = "MAIL";
    public static final String COL4 = "PASSWORD";
    public static final String COL5 = "PHONE";
    private static final String DBNAME = "Data";
    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + COL1 + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            "" + COL2 + " TEXT NOT NULL, " + COL3 + " TEXT ," + COL4 + " TEXT ," + COL5 + " INTEGER);";

    public DBHelper(Context context) {

        super(context, DBNAME, null, DBVER);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {


    }

    public Boolean checkusermailpassword(String user, String password) {
        return null;
    }
}

