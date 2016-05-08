package com.com220.sli.sqltest3;

public class Memory
{
    int ID;
    int JarID;
    String filepath;
    String file;
    String memorytype;
    String location;
    String description;
    String createddate;

    public Memory()
    {
        //DEFAULT CONSTRUCTOR
    }

    public Memory(int ID, int JarID, String filepath, String file, String memorytype, String location, String description, String createddate)
    {
        this.ID = ID;
        this.JarID = JarID;
        this.filepath = filepath;
        this.file = file;
        this.memorytype = memorytype;
        this.location = location;
        this.description = description;
        this.createddate = createddate;
    }

    //GET METHODS
    public int getID()
    {
        return ID;
    }
    public int getJarID()
    {
        return ID;
    }
    public String getFilepath()
    {
        return filepath;
    }
    public String getFile()
    {
        return file;
    }
    public String getMemoryType()
    {
        return memorytype;
    }
    public String getLocation()
    {
        return location;
    }
    public String getDescripton()
    {
        return description;
    }
    public String getCreateddate()
    {
        return createddate;
    }

    //SET METHODS
    public void setID(int newID)
    {
        ID = newID;
    }
    public void setJarID(int newJarID)
    {
        JarID = newJarID;
    }
    public void setFilepath(String newFilepath)
    {
        filepath = newFilepath;
    }
    public void setFile(String newFile)
    {
        file = newFile;
    };
    public void setMemoryType(String newMemoryType)
    {
        memorytype = newMemoryType;
    }
    public void setLocation(String newLocation)
    {
        location = newLocation;
    }
    public void setDescription(String newDescription)
    {
        description = newDescription;
    }
    public void setCreateddate(String newCreateddate)
    {
        createddate = newCreateddate;
    }
}

//
//public class Memory
//{
//    int ID;
//    int JarID;
//    String filepath;
//    File file;
//    String memorytype; //MemoryType memorytype;
//    Location location;
//    String descripton;
//    String createddate; //Date createddate;
//
//    public Memory()
//    {
//
//    }
//
//    public Memory(int ID, int JarID, String filepath, File file, Location location, String description)
//    {
//        this.ID = ID;
//        this.JarID = JarID;
//        this.filepath = filepath;
//        this.file = file;
//        this.location = location;
//        this.descripton = description;
//    }
//
//    /*
//    public Memory(int ID, int JarID, String filepath, File file, MemoryType memorytype, Location location, String description, Date createddate)
//    {
//        this.ID = ID;
//        this.JarID = JarID;
//        this.filepath = filepath;
//        this.file = file;
//        this.memorytype = memorytype;
//        this.location = location;
//        this.descripton = description;
//        this.createddate = createddate;
//    }
//    */
//
//    //GET METHODS
//    public int getID()
//    {
//        return ID;
//    }
//    public int getJarID()
//    {
//        return ID;
//    }
//    public String getFilepath()
//    {
//        return filepath;
//    }
//    public File getFile()
//    {
//        return file;
//    }
//    public String getMemoryType()
//    {
//        return memorytype;
//    }
//    /*
//    public MemoryType getMemoryType()
//    {
//        return memorytype;
//    }
//    */
//    public Location getLocation()
//    {
//        return location;
//    }
//    public String getDescripton()
//    {
//        return descripton;
//    }
//    public String getCreateddate()
//    {
//        return createddate;
//    }
//    /*
//    public Date getCreateddate()
//    {
//        return createddate;
//    }
//    */
//
//    //SET METHODS
//    public void setID(int newID)
//    {
//        ID = newID;
//    }
//    public void setJarID(int newJarID)
//    {
//        JarID = newJarID;
//    }
//    public void setFilepath(String newFilepath)
//    {
//        filepath = newFilepath;
//    }
//    public void setFile(File newFile)
//    {
//        file = newFile;
//    }
//    /*
//    public void setMemoryType(MemoryType newMemoryType)
//    {
//        memorytype = newMemorytype;
//    }
//    */
//    public void setvoid(Location newLocation)
//    {
//        location = newLocation;
//    }
//    public void setDescripton(String newDescription)
//    {
//        descripton = newDescription;
//    }
//    /*
//    public void setCreatedvoid(Date newCreateddate)
//    {
//        createddate = newCreateddate;
//    }
//    */
//}