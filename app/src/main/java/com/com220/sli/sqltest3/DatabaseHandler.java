package com.com220.sli.sqltest3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper
{
    public static final String DATABASE_NAME = "CacheJar.db";       //Name of the database

    public static final String TABLE_MEMORIES = "memory_table";     //Name of the memory table
    public static final String ID = "id";                           //
    public static final String JAR_ID = "jarid";                    //
    public static final String FILEPATH = "filepath";               //
    public static final String DESCRIPTION = "description";         //
    public static final String CREATEDDATE = "createddate";         //

    public static final String TABLE_JARS = "jar_table";            //Name of the jar table
    public static final String OPENDATE = "jar_opendate";           //
    public static final String JAR_NAME = "jar_name";               //
    public static final String JAR_COLOR = "jar_color";             //

    public DatabaseHandler(Context context)
    {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("CREATE TABLE " + TABLE_JARS + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }
}
