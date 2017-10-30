package com.tunerandomizer.philippe.tunerandomizer;

import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Philippe on 2017-10-29.
 */

public class DBConnectionClass extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "TuneRandomizerDB.db";

    public static final String TABLE_ARTISTS = "artists";
    public static final String ARTISTS_COLUMN_ID = "id";
    public static final String ARTISTS_COLUMN_NAME = "name";

    public static final String TABLE_ALBUMS = "albums";
    public static final String ALBUMS_COLUMN_ID = "id";
    public static final String ALBUMS_COLUMN_NAME = "name";

    public static final String TABLE_SONGS = "songs";
    public static final String SONGS_COLUMN_ID = "id";
    public static final String SONGS_COLUMN_NAME = "name";

    private HashMap hp;

    public DBConnectionClass(Context context) {
        super(context, DATABASE_NAME , null, 1);
    }

    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(
                "create table contacts " +
                        "(id integer primary key, name text,phone text,email text, street text,place text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
