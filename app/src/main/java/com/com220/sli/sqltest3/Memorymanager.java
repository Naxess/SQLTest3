package com.com220.sli.sqltest3;

import android.content.Context;

import java.util.List;

public class Memorymanager
{
    DatabaseHandler dbh;
    Context context;
    public Memorymanager(Context context)
    {
        this.context = context;
    }
    public void createMemory(long jarId)
    {
        dbh = new DatabaseHandler(context);
        String description = "<NULL>"; //placeholder
        Memory aMem = new Memory(description);
        long memId = dbh.createMemory(aMem, new long[]{jarId});
        //dbh.createMemoryToJarLink(memId, jarId);
    }
    public List<Memory> readByJarID(long jarId)
    {
        dbh = new DatabaseHandler(context);
        List<Memory> memList = dbh.getAllMemoriesByJarID(jarId);
        return memList;
    }
    public Memory getMemory(long id)
    {
        dbh = new DatabaseHandler(context);
        Memory aMem = dbh.getMemory(id);
        return aMem;
    }
}

/*
JarManager
    JARCreate(JAR)
    JAR ReadByID(int ID)
    List<JAR> ReadAll()
    JAR UpdatebyID(JAR)
MemoryManager
    MEMORY Create(MEMORY)
    List<Memory> ReadbyJarID(int ID)
 */