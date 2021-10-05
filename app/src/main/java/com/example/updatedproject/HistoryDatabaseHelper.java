package com.example.updatedproject;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.updatedproject.Fragments.HistoryFragment;

import java.util.ArrayList;

public class HistoryDatabaseHelper extends SQLiteOpenHelper {
    Context context;
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Contacts";
    private static final String TABLE_NAME = "Contacts";
    private static final String COLUMN_ID = "_id";
    private static final String Bus_NAME = "busName";
    private static final String Bus_Number = "busNumber";
    private static final String START_NODE = "busStart";
    private static final String END_NODE = "busEnd";
    private static final String DATE = "busDate";
    private static final String TIME = "busTime";
    public HistoryDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = " Create Table "+ TABLE_NAME +
                "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , "
                + Bus_NAME + " TEXT ,"
                + Bus_Number + " TEXT , "
                + START_NODE + " TEXT,"
                + END_NODE + " TEXT,"
                + DATE + " TEXT,"
                + TIME + " TEXT);";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    public void addHistory(String busName, String busNo, String start, String end, String date, String time){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(Bus_NAME,busName);
        cv.put(Bus_Number,busNo);
        cv.put(START_NODE,start);
        cv.put(END_NODE,end);
        cv.put(DATE,date);
        cv.put(TIME,time);

        long result= db.insert(TABLE_NAME,null, cv);

        if(result == -1)
            Toast.makeText(context, "Failed to insert", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(context, "Succesfully Inserted", Toast.LENGTH_SHORT).show();
    }
    public  Cursor readAllHistory()
    {

        String query = "SELECT "+ COLUMN_ID + "," + Bus_NAME + "," + Bus_Number + "," + START_NODE + "," + END_NODE + "," + DATE + "," + TIME + " FROM " + TABLE_NAME +" ORDER BY "+ COLUMN_ID + " DESC ";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null)
        {
            cursor  = db.rawQuery(query,null);
        }

        return cursor;
    }


    public void deleteContact(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, COLUMN_ID + " = ?", new String[]{String.valueOf(id)});


    }
}
