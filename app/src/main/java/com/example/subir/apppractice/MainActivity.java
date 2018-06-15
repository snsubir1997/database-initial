package com.example.subir.apppractice;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.subir.apppractice.database.DBHelper;
import com.example.subir.apppractice.database.TableClass;
import com.example.subir.apppractice.utils.Constants;

public class MainActivity extends AppCompatActivity {

    String[] book_name = {"Inferno",
            "The Monk who Sold his Ferrari",
            "My Experiments with Truth"};

    String[] book_author = {"Dan Brown",
            "Robin Sharma",
            "Mahatma Gandhi"};

    String[] book_id = {"32451",
            "97556",
            "12746"};

    DBHelper db_helper;
    ArrayAdapter<String> myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db_helper = DBHelper.getInstance(this);
        int count = db_helper.getFullContent(Constants.BOOK_TABlE, null);

        if (count == 0) {
            insertBookData();
            Toast.makeText(getApplicationContext(),"DataInsertedSuccessfully for"+
                    db_helper.getFullContent(Constants.BOOK_TABlE, null)+" rows",
                    Toast.LENGTH_SHORT).show();

        }
        else{
            Toast.makeText(getApplicationContext(),"Data present for "+
                    db_helper.getFullContent(Constants.BOOK_TABlE,null)+ " rows",
            Toast.LENGTH_SHORT).show();
        }
    }

    private  void insertBookData() {

        for (int i=0;i<book_name.length;i++)
        {
            ContentValues cv = new ContentValues();
            cv.put(Constants.BOOK_ID,book_id[i]);
            cv.put(Constants.BOOK_NAME,book_name[i]);
            cv.put(Constants.BOOK_AUTHOR,book_author[i]);

            db_helper.insertContentValues(Constants.BOOK_TABlE, cv);
        }
    }


}