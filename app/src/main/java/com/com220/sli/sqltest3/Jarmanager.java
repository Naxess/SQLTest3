package com.com220.sli.sqltest3;

import android.content.Context;

import java.util.List;

public class Jarmanager
{
    DatabaseHandler dbh;
    Context context;

    public Jarmanager(Context context)
    {
        this.context = context;
    }
    public long addJar(String name)
    {
        dbh = new DatabaseHandler(context);
        Jar aJar = new Jar(name);
        long id = dbh.createJar(aJar);
        return id;
    }
    public Jar getJar(long id)
    {
        dbh = new DatabaseHandler(context);
        Jar aJar = dbh.getJar(id);
        return aJar;
    }
    public List<Jar> ReadAll()
    {
        dbh = new DatabaseHandler(context);
        List<Jar> jarList = dbh.getAllJars();
        return jarList;
    }
    public void updateById(long id)
    {
        dbh = new DatabaseHandler(context);
        Jar aJar = dbh.getJar(id);
        //String jarStatus_str = aJar.getJarStatus();
        //aJar.setJarStatus(jarStatus_str);
        dbh.updateJar(aJar);
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