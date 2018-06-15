package com.example.subir.apppractice.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.subir.apppractice.utils.Constants;

public class DBHelper {

    private SQLiteDatabase db;
    private final Context context;
    private final TableClass tableClass;
    private static DBHelper db_helper;

    private  DBHelper (Context context) {
        this.context = context;
        tableClass = new TableClass(context, Constants.DATABASE_NAME, null, Constants.DATABASE_VERSION);
    }

    public static DBHelper getInstance(Context context)
    {
        if (db_helper == null)
        {
            db_helper = new DBHelper(context);
            db_helper.open();
        }
        return db_helper;
    }

    public void open()
    {
        try {
            db = tableClass.getWritableDatabase();
        }catch (Exception e) {
            e.printStackTrace();
            db = tableClass.getReadableDatabase();
        }
    }
    public void close()
    {
        if (db.isOpen())
            db.close();
    }
    public long insertContentValues(String tableName, ContentValues cv)//check it out
    {
        long id = 0;
        try {
            db.beginTransaction();
            id = db.insert(tableName, null, cv);
            db.setTransactionSuccessful();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            db.endTransaction();
        }
        return id;
    }
    public int getFullContent(String tabName, String where)
    {
        int rowCount = 0;
        Cursor c = db.query(false, tabName, null, where, null, null, null, null, null);

        try{
            c.moveToFirst();
            if (c != null){
                rowCount = c.getCount();
            }
        }finally {
            c.close();
        }
        return rowCount;
    }

    public void deleteRecord(String tabName, String where, String [] whereArgs)
    {
        try {
            db.beginTransaction();
            db.delete(tabName,where,whereArgs);
            db.setTransactionSuccessful();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            db.endTransaction();
        }
    }

    public int updateRecord(String tabName,ContentValues cv,String where , String [] whereArgs){

        int rowCount = 0;
        try{
            db.beginTransaction();
            rowCount = db.update(tabName,cv,where,whereArgs);
            db.setTransactionSuccessful();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            db.endTransaction();
        }

        return  rowCount;
    }
}
