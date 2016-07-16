package com.example.androidall.sqlite_database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseWrapper extends SQLiteOpenHelper {

    public static final String STUDENTS = "Students";
    public static final String STUDENT_ID = "_id";
    public static final String STUDENT_NAME = "_name";

    private static final String DATABASE_NAME = "Students.db";
    private static final int DATABASE_VERSION = 1;

    // creation SQLite statement
    private static final String DATABASE_CREATE = "create table " + STUDENTS
            + "(" + STUDENT_ID + " integer primary key autoincrement, "
            + STUDENT_NAME + " text not null);";

    public DataBaseWrapper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // you should do some logging in here
        // ..

        db.execSQL("DROP TABLE IF EXISTS " + STUDENTS);
        onCreate(db);
    }

}
