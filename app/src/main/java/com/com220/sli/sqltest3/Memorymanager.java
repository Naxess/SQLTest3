package com.com220.sli.sqltest3;

import java.util.List;

public class Memorymanager
{
    DatabaseHandler dbh;
    public Memorymanager()
    {

    }
    public void createMemory(long jarId)
    {
        String description = "<NULL>"; //placeholder
        Memory aMem = new Memory(description);
        long memId = dbh.createMemory(aMem, new long[]{jarId});
        //dbh.createMemoryToJarLink(memId, jarId);
    }
    public List<Memory> readByJarID(long jarId)
    {
        List<Memory> memList = dbh.getAllMemoriesByJarID(jarId);
        return memList;
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