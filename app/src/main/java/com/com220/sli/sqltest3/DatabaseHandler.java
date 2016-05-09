package com.com220.sli.sqltest3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

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
    public static final String REF_TABLE = "ref_table";                         //Name of reference table
    public static final String REFID_JAR = "ref_jar";
    public static final String REFID_MEM = "ref_mem";


    //CREATE TABLE STRINGS
    private static final String CREATE_JAR_TABLE = "CREATE TABLE " + TABLE_JARS + "("
            + JAR_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
            + JAR_OPENDATE + " TEXT,"
            + JAR_MEMORIES + " TEXT,"
            + JAR_NAME + " TEXT,"
            + JAR_COLOR + " TEXT,"
            + JAR_LOCATION + " TEXT,"
            + JAR_JARSTATUS + " TEXT,"
            + JAR_OPENLOCATION + " TEXT"
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
            + REFID_JAR + " INTEGER,"
            + REFID_MEM + " INTEGER"
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

    //(7) CREATE A JAR
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

    //(8) FETCH ALL THE JARS
    public List<Jar> getAllJars()
    {
        List<Jar> jarList = new ArrayList<Jar>();
        String selectQuery = "SELECT * FROM " + TABLE_JARS;
        //Log.e(LOG, selectQuery);
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        if(c.moveToFirst())
        {
            do {
                Jar aJar = new Jar();
                aJar.setID(c.getInt(c.getColumnIndex(JAR_ID)));
                aJar.setOpendate(c.getString(c.getColumnIndex(JAR_OPENDATE)));
                aJar.setMemories(c.getString(c.getColumnIndex(JAR_MEMORIES)));
                aJar.setName(c.getString(c.getColumnIndex(JAR_NAME)));
                aJar.setColor(c.getString(c.getColumnIndex(JAR_COLOR)));
                aJar.setLocation(c.getString(c.getColumnIndex(JAR_LOCATION)));
                aJar.setJarStatus(c.getString(c.getColumnIndex(JAR_JARSTATUS)));
                aJar.setOpenLocation(c.getString(c.getColumnIndex(JAR_OPENLOCATION)));

                jarList.add(aJar);
            }while(c.moveToNext());
        }
        return jarList;
    }

    //(9) UPDATE A JAR
    public int updateJar(Jar aJar)
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

        return db.update(TABLE_JARS, cv, JAR_ID + " = ?", new String[] {String.valueOf(aJar.getID())});
    }

    //(10) DELETE A JAR AND ALL ASSOCIATED MEMORIES
    public void deleteJar(Jar aJar, boolean deleteJar)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        if(deleteJar)
        {
            List<Memory> memoriesToDelete = getAllMemoriesByJar(aJar.getName());
            for(Memory mem : memoriesToDelete)
            {
                deleteMemory(mem.getID());
            }
        }
    }

    //(1) CREATE A MEMORY
    public long createMemory(Memory mem, long[] memIds)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(MEMORY_FILEPATH, mem.getFilepath());
        cv.put(MEMORY_FILE, mem.getFile());
        cv.put(MEMORY_MEMORYTYPE, mem.getMemoryType());
        cv.put(MEMORY_LOCATION, mem.getLocation());
        cv.put(MEMORY_DESCRIPTION, mem.getDescription());
        cv.put(MEMORY_CREATEDDATE, mem.getCreateddate());

        long id = db.insert(TABLE_MEMORIES, null, cv);

        for(long memId : memIds)
        {
            createMemoryToJarLink(id, memId);
        }

        return id;
    }



    //(2) FETCH A MEMORY
    public Memory getMemory(long id)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + TABLE_MEMORIES + " WHERE " + JAR_ID + " = " + id;

        //Log.e(LOG, selectQuery);
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null)
        {
            c.moveToFirst();
        }
        Memory aMem = new Memory();
        aMem.setJarID(c.getInt(c.getColumnIndex(JAR_ID)));
        aMem.setFilepath(c.getString(c.getColumnIndex(MEMORY_FILEPATH)));
        aMem.setFile(c.getString(c.getColumnIndex(MEMORY_FILE)));
        aMem.setMemoryType(c.getString(c.getColumnIndex(MEMORY_MEMORYTYPE)));
        aMem.setLocation(c.getString(c.getColumnIndex(MEMORY_LOCATION)));
        aMem.setDescription(c.getString(c.getColumnIndex(MEMORY_DESCRIPTION)));
        aMem.setCreateddate(c.getString(c.getColumnIndex(MEMORY_CREATEDDATE)));
        return aMem;
    }

    //(3) FETCH ALL THE MEMORIES
    public List<Memory> getAllMemories()
    {
        List<Memory> memoryList = new ArrayList<Memory>();
        String selectQuery = "SELECT * FROM " + TABLE_MEMORIES;

        //Log.e(LOG, selectQuery);
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        if(c.moveToFirst())
        {
            do {
                Memory aMem = new Memory();
                aMem.setJarID(c.getInt(c.getColumnIndex(JAR_ID)));
                aMem.setFilepath(c.getString(c.getColumnIndex(MEMORY_FILEPATH)));
                aMem.setFile(c.getString(c.getColumnIndex(MEMORY_FILE)));
                aMem.setMemoryType(c.getString(c.getColumnIndex(MEMORY_MEMORYTYPE)));
                aMem.setLocation(c.getString(c.getColumnIndex(MEMORY_LOCATION)));
                aMem.setDescription(c.getString(c.getColumnIndex(MEMORY_DESCRIPTION)));
                aMem.setCreateddate(c.getString(c.getColumnIndex(MEMORY_CREATEDDATE)));

                memoryList.add(aMem);
            } while(c.moveToNext());
        }
        return memoryList;
    }

    //(4) FETCH ALL THE MEMORIES BY JAR
    public List<Memory> getAllMemoriesByJar(String jarName)
    {
        List<Memory> memoryList = new ArrayList<Memory>();
        String selectQuery = "SELECT * FROM " + TABLE_MEMORIES + " mem, "
                + TABLE_JARS + " jrs, " + REF_TABLE + " rt WHERE jrs."
                + JAR_NAME + " = '" + jarName + "'" + " AND jrs."
                + JAR_ID + " = " + "rt."
                + REFID_JAR + " AND mem."
                + JAR_ID + " = " + "rt."
                + REFID_MEM;

        //Log.e(LOG, selectQuery);
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        if(c.moveToFirst())
        {
            do {
                Memory aMem = new Memory();
                aMem.setJarID(c.getInt(c.getColumnIndex(JAR_ID)));
                aMem.setFilepath(c.getString(c.getColumnIndex(MEMORY_FILEPATH)));
                aMem.setFile(c.getString(c.getColumnIndex(MEMORY_FILE)));
                aMem.setMemoryType(c.getString(c.getColumnIndex(MEMORY_MEMORYTYPE)));
                aMem.setLocation(c.getString(c.getColumnIndex(MEMORY_LOCATION)));
                aMem.setDescription(c.getString(c.getColumnIndex(MEMORY_DESCRIPTION)));
                aMem.setCreateddate(c.getString(c.getColumnIndex(MEMORY_CREATEDDATE)));

                memoryList.add(aMem);
            } while(c.moveToNext());
        }
        return memoryList;
    }

    //(5) UPDATE A MEMORY
    public int updateMemory(Memory mem)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(MEMORY_FILEPATH, mem.getFilepath());
        cv.put(MEMORY_FILE, mem.getFile());
        cv.put(MEMORY_MEMORYTYPE, mem.getMemoryType());
        cv.put(MEMORY_LOCATION, mem.getLocation());
        cv.put(MEMORY_DESCRIPTION, mem.getDescription());
        cv.put(MEMORY_CREATEDDATE, mem.getCreateddate());

        int aNum = db.update(TABLE_MEMORIES, cv, JAR_ID + " = ?", new String[]{String.valueOf(mem.getJarID())});
        return aNum;
    }

    //(6) DELETE A MEMORY
    public void deleteMemory(long id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_MEMORIES, JAR_ID + " = ?", new String[] {String.valueOf(id)});
    }

    //(11) "LINK" A MEMORY TO A JAR
    public long createMemoryToJarLink(long memID, long jarID)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(REFID_MEM, memID);
        cv.put(REFID_JAR, jarID);
        //date

        long id = db.insert(REF_TABLE, null, cv);
        return id;
    }

    //(12) REMOVE A MEMORY-TO-JAR "LINK"
    public int removeLink(long id, long jarID)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(REFID_JAR, jarID);

        return db.update(TABLE_MEMORIES, cv, JAR_ID + " = ?", new String[] {String.valueOf(id)});
    }

    //(13) CHANGE MEMORY "LINK" TO ANOTHER JAR
    public int updateLink(long id, long jarID)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(REFID_JAR, jarID);

        return db.update(TABLE_MEMORIES, cv, JAR_ID + " = ?", new String[] {String.valueOf(id)});
    }

    public void exitDatabase()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        if(db != null && db.isOpen())
        {
            db.close();
        }
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
