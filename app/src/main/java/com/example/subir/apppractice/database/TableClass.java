package com.example.subir.apppractice.database;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.subir.apppractice.utils.Constants;

public class TableClass extends SQLiteOpenHelper {

    Context context;

    String query = "Create table if not exists "+ Constants.BOOK_TABlE+"("+
            Constants.ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+Constants.BOOK_NAME+
            " TEXT, "+Constants.BOOK_AUTHOR+" TEXT, "+Constants.BOOK_ID+" TEXT);";

    public TableClass(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        context.deleteDatabase(Constants.DATABASE_NAME);
        onCreate(db);
    }
}
