package net.penguincoders.doit;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DBhelper extends SQLiteOpenHelper {
    private Context context;

    public DBhelper(Context context) {

        super(context, "userdata.db", null, 1);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table userdetails(username TEXT primary key, name TEXT, password TEXT, phoneno TEXT, age TEXT, email TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop Table if exists userdetails");
    }

    void insertuserdata(String username, String name, String password, String phoneno, String age, String email) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("name", name);
        contentValues.put("password", password);
        contentValues.put("phoneno", phoneno);
        contentValues.put("age", age);
        contentValues.put("email", email);
        long result = DB.insert("userdetails", null, contentValues);
        if (result == -1) {
            Toast.makeText(context,"Failed",Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context,"Data Added Successfully",Toast.LENGTH_SHORT).show();
        }
    }


    public boolean getdata(String username, String password) {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("SELECT username, password FROM userdetails WHERE username = ? and password = ? ",new String[]{username,password});
        if(cursor.getCount()>0)
        {
            return true;
        }else
        {
            return false;
        }
    }
    public Cursor prof(String username, String password) {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("SELECT * FROM userdetails WHERE username = ? and password = ? ",new String[]{username,password});
        return cursor;

    }
}
