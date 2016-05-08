package com.com220.sli.sqltest3;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper
{
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "CacheJar.db";                   //Name of the database

    //JAR TABLE
    public static final String TABLE_JARS = "jar_table";                        //Name of the jar table
    public static final String JAR_ID = "jar_id";
    public static final String JAR_OPENDATE = "jar_opendate";
    public static final String JAR_MEMORIES = "jar_memories";
    public static final String JAR_NAME = "jar_name";
    public static final String JAR_COLOR = "jar_color";
    public static final String JAR_LOCATION = "jar_location";
    public static final String JAR_JARSTATUS = "jar_jarstatus";
    public static final String JAR_OPENLOCATION = "jar_openlocation";

    //MEMORY TABLE
    public static final String TABLE_MEMORIES = "memory_table";                 //Name of the memory table
    public static final String MEMORY_FILEPATH = "memory_filepath";
    public static final String MEMORY_FILE = "memory_file";
    public static final String MEMORY_MEMORYTYPE = "memory_memorytype";
    public static final String MEMORY_LOCATION = "memory_location";
    public static final String MEMORY_DESCRIPTION = "memory_description";
    public static final String MEMORY_CREATEDDATE = "memory_createddate";

    //MEMORY AND JAR "REFERENCE" TABLE (for assigning one or many memories to each jar)
    public static final String REF_TABLE = "ref_table";
    public static final String REF_JAR = "ref_jar";
    public static final String REF_MEM = "ref_mem";


    //CREATE TABLE STRINGS
    private static final String CREATE_JAR_TABLE = "CREATE TABLE " + TABLE_JARS + "("
            + JAR_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
            + JAR_OPENDATE + " TEXT,"
            + JAR_MEMORIES + " TEXT,"
            + JAR_NAME + " TEXT,"
            + JAR_COLOR + " TEXT,"
            + JAR_LOCATION + " TEXT,"
            + JAR_JARSTATUS + " TEXT,"
            + JAR_OPENLOCATION + " TEXT,"
            + ")";
    private static final String CREATE_MEM_TABLE = "CREATE TABLE " + TABLE_MEMORIES + "("
            + JAR_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
            + MEMORY_FILEPATH + " TEXT,"
            + MEMORY_FILE + " TEXT,"
            + MEMORY_MEMORYTYPE + " TEXT,"
            + MEMORY_LOCATION + " TEXT,"
            + MEMORY_DESCRIPTION + " TEXT,"
            + MEMORY_CREATEDDATE + " TEXT"
            + ")";
    private static final String CREATE_REF_TABLE = "CREATE TABLE " + REF_TABLE + "("
            + JAR_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
            + REF_JAR + " INTEGER,"
            + REF_MEM + " INTEGER"
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
        db.execSQL(CREATE_REF_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_JARS);
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_MEMORIES);
    }

    //Create a jar in the jar table
    public long createJar(Jar aJar)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(JAR_OPENDATE, aJar.getOpendate());
        cv.put(JAR_MEMORIES, aJar.getMemories());
        cv.put(JAR_NAME, aJar.getName());
        cv.put(JAR_COLOR, aJar.getColor());                               //WHAT DATATYPE IS THIS? A TEXT, INTEGER, OR WHAT?
        cv.put(JAR_LOCATION, aJar.getLocation());                         //WHAT DATATYPE IS THIS? A TEXT, INTEGER, OR WHAT?
        cv.put(JAR_JARSTATUS, aJar.getJarStatus());                       //WHAT DATATYPE IS THIS? A TEXT, INTEGER, OR WHAT?
        cv.put(JAR_OPENLOCATION, aJar.getOpenLocation());                 //WHAT DATATYPE IS THIS? A TEXT, INTEGER, OR WHAT?

        long id = db.insert(TABLE_JARS, null, cv);

        return id;
    }

    public long createMemory(Memory mem, long[] memIds)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(MEMORY_FILEPATH, mem.getFilepath());
        cv.put(MEMORY_FILE, mem.getFile());
        cv.put(MEMORY_MEMORYTYPE, mem.getMemoryType());
        cv.put(MEMORY_LOCATION, mem.getLocation());
        cv.put(MEMORY_DESCRIPTION, mem.getDescripton());
        cv.put(MEMORY_CREATEDDATE, mem.getCreateddate());

        for(long memId : memIds)
        {
            //create
        }

        long id = db.insert(TABLE_MEMORIES, null, cv);

        return id;
    }
}

//public class DatabaseHandler extends SQLiteOpenHelper
//{
//    public static final int DATABASE_VERSION = 1;
//    public static final String DATABASE_NAME = "CacheJar.db";                   //Name of the database
//
//    //JAR TABLE
//    public static final String TABLE_JARS = "jar_table";                        //Name of the jar table
//    public static final String JAR_ID = "jar_id";
//    public static final String JAR_OPENDATE = "jar_opendate";
//    //public static final String JAR_MEMORIES = "jar_memories";
//    public static final String JAR_NAME = "jar_name";
//    public static final String JAR_COLOR = "jar_color";
//    public static final String JAR_LOCATION = "jar_location";
//    //public static final String JAR_JARSTATUS = "jar_jarstatus";
//    public static final String JAR_OPENLOCATION = "jar_openlocation";
//
//    //MEMORY TABLE
//    public static final String TABLE_MEMORIES = "memory_table";                 //Name of the memory table
//    public static final String MEMORY_ID = "memory_id";
//    //public static final String MEMORY_JARID = "memory_jarid";
//    public static final String MEMORY_FILEPATH = "memory_filepath";
//    //public static final String MEMORY_FILE = "memory_file";
//    //public static final String MEMORY_MEMORYTYPE = "memory_memorytype";
//    public static final String MEMORY_LOCATION = "memory_location";
//    public static final String MEMORY_DESCRIPTION = "memory_description";
//    public static final String MEMORY_CREATEDDATE = "memory_createddate";
//
//    //MEMORY AND JAR "REFERENCE" TABLE (for assigning one or many memories to each jar)
//    public static final String REF_TABLE = "ref_table";
//
//
//    //CREATE TABLE STRINGS
//    private static final String CREATE_JAR_TABLE = "CREATE TABLE " + TABLE_JARS + "("
//            + JAR_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
//            + JAR_OPENDATE + " TEXT,"
//            + JAR_NAME + " TEXT,"
//            + JAR_COLOR + " TEXT,"
//            + JAR_LOCATION + " CHAR,"
//            + JAR_OPENLOCATION + " CHAR,"
//            + ")";
//    private static final String CREATE_MEM_TABLE = "CREATE TABLE " + TABLE_MEMORIES + "("
//            + MEMORY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
//            + JAR_ID + " INTEGER,"
//            + MEMORY_FILEPATH + " CHAR,"
//            + MEMORY_LOCATION + " CHAR,"
//            + MEMORY_DESCRIPTION + " TEXT,"
//            + MEMORY_CREATEDDATE + " TEXT"
//            + ")";
//    //private static final String CREATE_REF_TABLE = "CREATE TABLE ";
//
//
//    public DatabaseHandler(Context context)
//    {
//        super(context, DATABASE_NAME, null, DATABASE_VERSION);
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase db)
//    {
//        db.execSQL(CREATE_JAR_TABLE);
//        db.execSQL(CREATE_MEM_TABLE);
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
//    {
//        db.execSQL("DROP TABLE IF EXISTS" + TABLE_JARS);
//        db.execSQL("DROP TABLE IF EXISTS" + TABLE_MEMORIES);
//    }
//
//    //Create a jar in the jar table
//    public long createJar(Jar aJar)
//    {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues cv = new ContentValues();
//        cv.put(JAR_OPENDATE, aJar.getOpendate());
//        cv.put(JAR_NAME, aJar.getName());
//        //cv.put(JAR_COLOR, aJar.getColor());                               //WHAT DATATYPE IS THIS? A TEXT, INTEGER, OR WHAT?
//        //cv.put(JAR_LOCATION, aJar.getLocation());                         //WHAT DATATYPE IS THIS? A TEXT, INTEGER, OR WHAT?
//        //cv.put(JAR_OPENLOCATION, aJar.getOpenLocation());                 //WHAT DATATYPE IS THIS? A TEXT, INTEGER, OR WHAT?
//
//        long id = db.insert(TABLE_JARS, null, cv);
//
//        return id;
//    }
//}
