package com.ml.newyorktechtalent;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by lucic on 12/28/2017.
 */



public class DatabaseHelper extends SQLiteOpenHelper{
    public static final String DATABASE_NAME="jobs.db";
    public static final String TABLE_NAME="jobs_table";
    public static final String COL1="ID";
    public static final String COL2="COMPANY";
    public static final String COL3="POSITION";
    public static final String COL4="DESCRIPTION";
    public static final String COL5="LINK";
    private android.database.sqlite.SQLiteDatabase db;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTable="CREATE TABLE" + TABLE_NAME +"(ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " COMPANY TEXT, POSITION TEXT, DESCRIPTION TEXT, LINK TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        db.execSQL("DROP IF TABLE EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    public boolean submitJob(String company, String position, String description, String link){
       SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put(COL2,company);
        contentValues.put(COL3,position);
        contentValues.put(COL4,description);
        contentValues.put(COL5,link);

        long result=db.insert(TABLE_NAME,null,contentValues);
        if(result==-1){
            return false;
        }else {
            return true;
        }
    }
}
