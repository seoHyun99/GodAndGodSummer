package com.juntcompany.godandgodsummer.Util;

import android.annotation.TargetApi;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.icu.util.Calendar;
import android.os.Build;

import com.juntcompany.godandgodsummer.Data.Message;

/**
 * Created by EOM on 2016-07-28.
 */
public class DataManager extends SQLiteOpenHelper {

    private static DataManager instance;
    public static DataManager getInstance() {
        if (instance == null) {
            instance = new DataManager();
        }
        return instance;
    }

    private static final String DB_NAME = "chattingRoom";
    private static final int DB_VERSION = 1;
    ContentValues values = new ContentValues();

    public DataManager() {
        super(GodAndGod.getContext(), DB_NAME, null, DB_VERSION);
    }
///////////////////////////
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE" + DBContants.ChattingRoom.TABLE_NAME+"(" +
                DBContants.ChattingRoom._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                DBContants.ChattingRoom.COLUMN_NAME+ " TEXT NOT NULL," +

                ");";
        db.execSQL(sql);

        String messageTable = "CREATE TABLE " + DBContants.MessageTable.TABLE_NAME + "(" +
                DBContants.MessageTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                DBContants.MessageTable.COLUMN_USER + " INTEGER," +
                DBContants.MessageTable.COLUMN_MESSAGE + " TEXT," +
                DBContants.MessageTable.COLUMN_TYPE + " INTEGER," +
                DBContants.MessageTable.COLUMN_CREATED_DATE + " DATETIME" +
                ");";
        db.execSQL(messageTable);
        // 현재 테이블 두개, 방정보와 메시지 정보

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public Cursor getMessageList(long roomId){
        String[] columns = {DBContants.MessageTable.TABLE_NAME + "." + DBContants.MessageTable._ID,
                            DBContants.ChattingRoom.COLUMN_NAME,
                            DBContants.MessageTable.COLUMN_MESSAGE,
                            DBContants.MessageTable.COLUMN_TYPE,
                            DBContants.MessageTable.COLUMN_CREATED_DATE
                        };
        String tableName = DBContants.MessageTable.TABLE_NAME + " INNER JOIN " + DBContants.ChattingRoom.TABLE_NAME +
                " ON " + DBContants.MessageTable.TABLE_NAME + "."+DBContants.MessageTable.COLUMN_USER +
                " = " + DBContants.ChattingRoom.TABLE_NAME + "." + DBContants.ChattingRoom._ID;

        String selection = DBContants.MessageTable.COLUMN_USER + " = ?";
        String[] selectionArgs = {"" + roomId};
        String orderBy = DBContants.MessageTable.COLUMN_CREATED_DATE + " ASC";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.query(tableName, columns, selection, selectionArgs, null, null, orderBy);
        return c;
    }

    @TargetApi(Build.VERSION_CODES.N)
    public void insertMessage(long roomId, String message, int type){
        SQLiteDatabase db = getWritableDatabase();
        try {
            db.beginTransaction();
            values.clear();
            values.put(DBContants.MessageTable.COLUMN_USER, roomId);
            values.put(DBContants.MessageTable.COLUMN_MESSAGE, message);
            values.put(DBContants.MessageTable.COLUMN_TYPE, type);
            Calendar calendar = Calendar.getInstance();
            values.put(DBContants.MessageTable.COLUMN_CREATED_DATE, calendar.getTimeInMillis());

            long messageid = db.insert(DBContants.MessageTable.TABLE_NAME, null, values);

            if (type == Message.TYPE_MESSAGE_SEND || type == Message.TYPE_MESSAGE_RECEIVE) {
                values.clear();
                values.put(DBContants.ChattingRoom.COLUMN_LAST_MESSAGE_ID, messageid);
                String where = DBContants.ChattingRoom._ID + " = ?";
                String[] args = {"" + roomId};
                db.update(DBContants.ChattingRoom.TABLE_NAME, values, where, args);
            }
            db.setTransactionSuccessful();
        }
        finally {
            db.endTransaction();
        }
    }




}
