package com.juntcompany.godandgodsummer.Util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 이서현 on 2016-10-30.
 */

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context, String dbName, SQLiteDatabase.CursorFactory cursorFactory, int version) {
        super(context, dbName, cursorFactory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table friend_search (" +
        "friend text primary key);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
