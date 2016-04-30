package com.learn.wiratmoko11.movieapps.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.learn.wiratmoko11.movieapps.data.MoviesContract.MoviesEntry;

/**
 * Created by wiratmoko11 on 4/28/2016.
 */
public class MoviesDBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
   static final String DATABASE_NAME = "movies.db";
    public MoviesDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_MOVIES_TABLE = "CREATE TABLE "+ MoviesEntry.TABLE_NAME +"("
                + MoviesEntry._ID + " INTEGER PRIMARY KEY "+
                MoviesEntry.COLUMN_POSTER_PATH +" TEXT NOT NULL"+
                MoviesEntry.COLUMN_ADULT + " INTEGER NOT NULL"+
                ");";
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + MoviesEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
