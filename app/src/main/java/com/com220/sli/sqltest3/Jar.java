package com.com220.sli.sqltest3;

import android.graphics.Color;
import android.location.Location;

import java.util.List;

public class Jar
{
    int ID;
    //Date opendate;
    List<Memory> memories;
    String name;
    Color color;
    Location location;
    //JarStatus jarStatus;
    Location openLocation;

    public Jar()
    {

    }

    public Jar(int ID, List<Memory> memories, String name, Color color, Location location, Location openLocation)
    {
        this.ID = ID;
        this.memories = memories;
        this.name = name;
        this.color = color;
        this.location = location;
        this.openLocation = openLocation;
    }

    /*
    public Jar(int ID, Date opendate, List<Memory> memories, String name, Color color, Location location, JarStatus jarStatus, Location openLocation)
    {
        this.ID = ID;
        this.opendate = opendate;
        this.memories = memories;
        this.name = name;
        this.color = color;
        this.location = location;
        this.jarStatus = jarStatus;
        this.openLocation = openLocation;
    }
    */

    //GET METHODS
    public int getID()
    {
        return ID;
    }
    /*
    public Date getOpendate()
    {
        return opendate;
    }
    */
    public List<Memory> getMemories()
    {
        return memories;
    }
    public String getName()
    {
        return name;
    }
    public Color getColor()
    {
        return color;
    }
    public Location getLocation()
    {
        return location;
    }
    /*
    public JarStatus getJarStatus()
    {
        return jarStatus;
    }
    */
    public Location getOpenLocation()
    {
        return openLocation;
    }

    //SET METHODS
    public void setID(int newID)
    {
        ID = newID;
    }
    /*
    public void setOpendate(Date newOpendate)
    {
        opendate = newOpendate;
    }
    */
    public void setMemories(List<Memory> newMemories)
    {
        memories = newMemories;
    }
    public void setName(String newName)
    {
        name = newName;
    }
    public void setColor(Color newColor)
    {
        color = newColor;
    }
    public void setLocation(Location newLocation)
    {
        location = newLocation;
    }
    /*
    public void setJarStatus(JarStatus newJarStatus)
    {
        jarStatus = newJarStatus;
    }
    */
    public void setOpenLocation(Location newOpenLocation)
    {
        openLocation = newOpenLocation;
    }
}
