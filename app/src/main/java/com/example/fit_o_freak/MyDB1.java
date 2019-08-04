package com.example.fit_o_freak;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static android.content.ContentValues.TAG;

public class MyDB1 extends SQLiteOpenHelper {
    //private static final String TABLE_NAME = "people_table";
    private static final String TABLE_NAME = "exercise";
    private static final String TABLE_NAME1 = "abs";
    private static final String TABLE_NAME2 = "legs";
    private static final String TABLE_NAME3 = "arms";
    private static final String TABLE_NAME4 = "back";

   /* private static final String COL1 = "ID";
    private static final String COL2 = "date";
    private static final String COL3 = "bmi";*/
    private static final String COLa = "name";
    private static final String COLb = "videoID";
    private static final String COLc = "reps";

    public MyDB1(Context context) {
        super(context, TABLE_NAME, null, 1);
    }
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLa +" TEXT, " + COLb+ " TEXT)";
        db.execSQL(createTable);
        String createTable1 = "CREATE TABLE " + TABLE_NAME1 + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLa +" TEXT, " + COLb+ " TEXT)";
        db.execSQL(createTable1);
        String createTable2 = "CREATE TABLE " + TABLE_NAME2 + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLa +" TEXT, " + COLb+ " TEXT)";
        db.execSQL(createTable2);
        String createTable3 = "CREATE TABLE " + TABLE_NAME3 + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLa +" TEXT, " + COLb+ " TEXT)";
        db.execSQL(createTable3);
        String createTable4 = "CREATE TABLE " + TABLE_NAME4 + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLa +" TEXT, " + COLb+ " TEXT)";
        db.execSQL(createTable4);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP IF TABLE EXISTS " + TABLE_NAME);
        db.execSQL("DROP IF TABLE EXISTS " + TABLE_NAME1);
        db.execSQL("DROP IF TABLE EXISTS " + TABLE_NAME2);
        db.execSQL("DROP IF TABLE EXISTS " + TABLE_NAME3);
        db.execSQL("DROP IF TABLE EXISTS " + TABLE_NAME4);
        onCreate(db);
    }
    public boolean addDataexer(String exer, String vID) {
        SQLiteDatabase db1 = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLa, exer);
        contentValues.put(COLb, vID);

        //Log.d(TAG, "addData: Adding " + bmi + " to " + TABLE_NAME);

        long result = db1.insert(TABLE_NAME, null, contentValues);



        //if date as inserted incorrectly it will return -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
    public boolean addDataexer1(String exer, String vID) {
        SQLiteDatabase db1 = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLa, exer);
        contentValues.put(COLb, vID);

        //Log.d(TAG, "addData: Adding " + bmi + " to " + TABLE_NAME);

        long result = db1.insert(TABLE_NAME1, null, contentValues);



        //if date as inserted incorrectly it will return -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
    public boolean addDataexer2(String exer, String vID) {
        SQLiteDatabase db1 = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLa, exer);
        contentValues.put(COLb, vID);

        //Log.d(TAG, "addData: Adding " + bmi + " to " + TABLE_NAME);

        long result = db1.insert(TABLE_NAME2, null, contentValues);



        //if date as inserted incorrectly it will return -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
    public boolean addDataexer3(String exer, String vID) {
        SQLiteDatabase db1 = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLa, exer);
        contentValues.put(COLb, vID);

        //Log.d(TAG, "addData: Adding " + bmi + " to " + TABLE_NAME);

        long result = db1.insert(TABLE_NAME3, null, contentValues);



        //if date as inserted incorrectly it will return -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
    public boolean addDataexer4(String exer, String vID) {
        SQLiteDatabase db1 = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLa, exer);
        contentValues.put(COLb, vID);

        //Log.d(TAG, "addData: Adding " + bmi + " to " + TABLE_NAME);

        long result = db1.insert(TABLE_NAME4, null, contentValues);



        //if date as inserted incorrectly it will return -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
    public Cursor getDataexer(){
        SQLiteDatabase db1 = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor data = db1.rawQuery(query, null);
        return data;
    }
    public Cursor getDataexer1(){
        SQLiteDatabase db1 = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME1;
        Cursor data = db1.rawQuery(query, null);
        return data;
    }
    public Cursor getDataexer2(){
        SQLiteDatabase db1 = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME2;
        Cursor data = db1.rawQuery(query, null);
        return data;
    }
    public Cursor getDataexer3(){
        SQLiteDatabase db1 = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME3;
        Cursor data = db1.rawQuery(query, null);
        return data;
    }
    public Cursor getDataexer4(){
        SQLiteDatabase db1 = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME4;
        Cursor data = db1.rawQuery(query, null);
        return data;
    }
}
