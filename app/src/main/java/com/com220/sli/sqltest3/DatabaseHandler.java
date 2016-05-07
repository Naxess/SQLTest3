package com.com220.sli.sqltest3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper
{
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "CacheJar.db";                   //Name of the database

    //MEMORY TABLE
    public static final String TABLE_MEMORIES = "memory_table";                 //Name of the memory table
    public static final String MEMORY_ID = "memory_id";
    //public static final String MEMORY_JARID = "memory_jarid";
    public static final String MEMORY_FILEPATH = "memory_filepath";
    //public static final String MEMORY_FILE = "memory_file";
    //public static final String MEMORY_MEMORYTYPE = "memory_memorytype";
    public static final String MEMORY_LOCATION = "memory_location";
    public static final String MEMORY_DESCRIPTION = "memory_description";
    public static final String MEMORY_CREATEDDATE = "memory_createddate";

    //JAR TABLE
    public static final String TABLE_JARS = "jar_table";                        //Name of the jar table
    public static final String JAR_ID = "jar_id";
    public static final String JAR_OPENDATE = "jar_opendate";
    //public static final String JAR_MEMORIES = "jar_memories";
    public static final String JAR_NAME = "jar_name";
    public static final String JAR_COLOR = "jar_color";
    public static final String JAR_LOCATION = "jar_location";
    //public static final String JAR_JARSTATUS = "jar_jarstatus";
    public static final String JAR_OPENLOCATION = "jar_openlocation";

    //CREATE TABLE STRINGS
    private static final String CREATE_JAR_TABLE = "CREATE TABLE " + TABLE_JARS + "(" 
            + JAR_ID + " INTEGER,"
            + JAR_OPENDATE + " DATE,"
            + JAR_NAME + " TEXT,"
            + JAR_COLOR + " TEXT,"
            + JAR_LOCATION + " CHAR,"
            + JAR_OPENLOCATION + " CHAR,"
            + ")";
    private static final String CREATE_MEM_TABLE = "CREATE TABLE " + TABLE_MEMORIES + "(" 
            + MEMORY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
            + JAR_ID + " INTEGER,"
            + MEMORY_FILEPATH + " CHAR,"
            + MEMORY_LOCATION + " CHAR,"
            + MEMORY_DESCRIPTION + " TEXT,"
            + MEMORY_CREATEDDATE + " DATE"
            + ")";


    public DatabaseHandler(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(CREATE_JAR_TABLE);
        db.execSQL(CREATE_MEM_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_JARS);
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_MEMORIES);
    }
}
