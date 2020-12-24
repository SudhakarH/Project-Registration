package com.example.a20171cse0155;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDB extends SQLiteOpenHelper {
    String table_name= "Project";
    String col1 = "id";
    String col2 = "name";
    String col3 = "title";
    String col4 = "fund";
    String col5 = "guide";


    //context - Activity , name - name of the Database
    public MyDB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    //constructor
    //called when there is no DB, and its creating a new one
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table "+table_name/*or "product" */+"(id INTEGER , "+col2+" TEXT, "+col3+" TEXT, "+col4+" TEXT, "+col5+" TEXT)");
    }

    //version number
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }
    //insertData() - call this method from MainActivity.
    //For performing DB operations - insert, we need to open the database connection.
    //getWriteableDatabase
    public void insertData(int Id, String Name, String Title, String Fund, String Guide){
        SQLiteDatabase sqDb = this.getWritableDatabase();

        //to put a set of values.
        ContentValues contentValues = new ContentValues();
        contentValues.put(col1,Id);
        contentValues.put(col2,Name);
        contentValues.put(col3,Title);
        contentValues.put(col4,Fund);
        contentValues.put(col5,Guide);

        //To insert
        sqDb.insert(table_name,null,contentValues);
        sqDb.close();
    }

    //To get the data
    public String getData(){
        String result="";
        SQLiteDatabase sqDb = this.getReadableDatabase();

        Cursor cursor = sqDb.rawQuery("select * from Project",null);

        while(cursor.moveToNext()){
            int Id = cursor.getInt(0);
            String Name = cursor.getString(1);
            String Title = cursor.getString(2);
            String Fund = cursor.getString(3);
            String Guide = cursor.getString(4);


            result+=Id+"\t\t"+Name+"\t\t"+Title+"\t\t"+Fund+"\t\t"+Guide+"\n";
        }
        sqDb.close();
        return result;
    }
    public String getPerticularData() {
        String result = "";
        SQLiteDatabase sqDb = this.getReadableDatabase();

        Cursor cursor = sqDb.rawQuery("select count(id),guide from Project where id Group by guide", null);

        while (cursor.moveToNext()) {
            int Id = cursor.getInt(0);
            String Guide = cursor.getString(1);




            result += Guide +"\t\t"+ Id + "\n" ;
        }
        sqDb.close();
        return result;
    }
}
