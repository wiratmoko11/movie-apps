package com.learn.wiratmoko11.movieapps.data;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by wiratmoko11 on 4/27/2016.
 */
public class MoviesContract {
    public static final String CONTENT_AUTHORITY = "com.learn.wiratmoko11.movieapps";

    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    public static final class MoviesEntry implements BaseColumns{
        //Nama Table
        public  static final String TABLE_NAME = "movies";
        //kolom poster
        public static  final String COLUMN_POSTER_PATH = "poster_path";
        //kolom adult
        public static  final String COLUMN_ADULT ="adult";
    }
}
