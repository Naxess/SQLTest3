package com.com220.sli.sqltest3;

public class Jar
{
    int ID;
    String opendate;
    String memories;
    String name;
    String color;
    String location;
    String jarStatus;
    String openLocation;

    public Jar()
    {
        //DEFAULT CONSTRUCTOR
    }

    public Jar(int ID, String opendate, String memories, String name, String color, String location, String jarStatus, String openLocation)
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

    //GET METHODS
    public int getID()
    {
        return ID;
    }
    public String getOpendate()
    {
        return opendate;
    }
    public String getMemories()
    {
        return memories;
    }
    public String getName()
    {
        return name;
    }
    public String getColor()
    {
        return color;
    }
    public String getLocation()
    {
        return location;
    }
    public String getJarStatus()
    {
        return jarStatus;
    }
    public String getOpenLocation()
    {
        return openLocation;
    }

    //SET METHODS
    public void setID(int newID)
    {
        ID = newID;
    }
    public void setOpendate(String newOpendate)
    {
        opendate = newOpendate;
    }
    public void setMemories(String newMemories)
    {
        memories = newMemories;
    }
    public void setName(String newName)
    {
        name = newName;
    }
    public void setColor(String newColor)
    {
        color = newColor;
    }
    public void setLocation(String newLocation)
    {
        location = newLocation;
    }
    public void setJarStatus(String newJarStatus)
    {
        jarStatus = newJarStatus;
    }
    public void setOpenLocation(String newOpenLocation)
    {
        openLocation = newOpenLocation;
    }
}

//public class Jar
//{
//    int ID;
//    String opendate; //Date opendate;
//    List<Memory> memories;
//    String name;
//    Color color;
//    Location location;
//    String jarStatus; //JarStatus jarStatus;
//    Location openLocation;
//
//    public Jar()
//    {
//
//    }
//
//    public Jar(int ID, List<Memory> memories, String name, Color color, Location location, Location openLocation)
//    {
//        this.ID = ID;
//        this.memories = memories;
//        this.name = name;
//        this.color = color;
//        this.location = location;
//        this.openLocation = openLocation;
//    }
//
//    /*
//    public Jar(int ID, Date opendate, List<Memory> memories, String name, Color color, Location location, JarStatus jarStatus, Location openLocation)
//    {
//        this.ID = ID;
//        this.opendate = opendate;
//        this.memories = memories;
//        this.name = name;
//        this.color = color;
//        this.location = location;
//        this.jarStatus = jarStatus;
//        this.openLocation = openLocation;
//    }
//    */
//
//    //GET METHODS
//    public int getID()
//    {
//        return ID;
//    }
//    public String getOpendate()
//    {
//        return opendate;
//    }
//    /*
//    public Date getOpendate()
//    {
//        return opendate;
//    }
//    */
//    public List<Memory> getMemories()
//    {
//        return memories;
//    }
//    public String getName()
//    {
//        return name;
//    }
//    public Color getColor()
//    {
//        return color;
//    }
//    public Location getLocation()
//    {
//        return location;
//    }
//    public String getJarStatus()
//    {
//        return jarStatus;
//    }
//    /*
//    public JarStatus getJarStatus()
//    {
//        return jarStatus;
//    }
//    */
//    public Location getOpenLocation()
//    {
//        return openLocation;
//    }
//
//    //SET METHODS
//    public void setID(int newID)
//    {
//        ID = newID;
//    }
//    /*
//    public void setOpendate(Date newOpendate)
//    {
//        opendate = newOpendate;
//    }
//    */
//    public void setMemories(List<Memory> newMemories)
//    {
//        memories = newMemories;
//    }
//    public void setName(String newName)
//    {
//        name = newName;
//    }
//    public void setColor(Color newColor)
//    {
//        color = newColor;
//    }
//    public void setLocation(Location newLocation)
//    {
//        location = newLocation;
//    }
//    /*
//    public void setJarStatus(JarStatus newJarStatus)
//    {
//        jarStatus = newJarStatus;
//    }
//    */
//    public void setOpenLocation(Location newOpenLocation)
//    {
//        openLocation = newOpenLocation;
//    }
//}
