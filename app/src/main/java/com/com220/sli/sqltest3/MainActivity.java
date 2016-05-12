package com.com220.sli.sqltest3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity// implements View.OnClickListener
{

    DatabaseHandler dbh;
    Jarmanager jm = new Jarmanager(this);
    Memorymanager mm = new Memorymanager(this);


    Button addJarButton, addMemButton, viewAllJarsButton, viewAllMemsButton, updateJarButton, updateMemButton, viewMemsOfJarIDButton, viewMemsOfJarButton, deleteJarButton, deleteMemButton, clearTextButton;
    EditText jarNameEdit, memDescriptionEdit, idEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        dbh = new DatabaseHandler(this);

        addJarButton = (Button)findViewById(R.id.btn_addjar);
        addMemButton = (Button)findViewById(R.id.btn_addmem);
        viewAllJarsButton = (Button)findViewById(R.id.btn_viewalljars);
        viewAllMemsButton = (Button)findViewById(R.id.btn_viewallmems);
        updateJarButton = (Button)findViewById(R.id.btn_updatejar);
        updateMemButton  = (Button)findViewById(R.id.btn_updatemem);
        viewMemsOfJarIDButton = (Button)findViewById(R.id.btn_viewallmemsofjarid);
        viewMemsOfJarButton = (Button)findViewById(R.id.btn_viewallmemsofjar);
        deleteJarButton  = (Button)findViewById(R.id.btn_deletejar);
        deleteMemButton = (Button)findViewById(R.id.btn_deletemem);
        clearTextButton = (Button)findViewById(R.id.btn_cleartext);

        jarNameEdit = (EditText)findViewById(R.id.edtx_name);
        memDescriptionEdit = (EditText)findViewById(R.id.edtx_description);
        idEdit = (EditText)findViewById(R.id.edtx_id);

        addJar();
        addMem();
        viewAllJars();
        viewAllMems();
        updateJar();
        updateMem();
        viewMemsOfJarID();
        viewMemsOfJar();
        deleteJar();
        deleteMem();
        clearText();
        test();

        /*
        Memorymanager mm = new Memorymanager();
        mm.readByJarID(1);
        */
    }

    public void test()
    {
        updateJarButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String name = jarNameEdit.getText().toString();
                long id = jm.addJar(name);
            }
        });
    }

    public void addJar()
    {
        addJarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String name = jarNameEdit.getText().toString();
                Jar aJar = new Jar(name);
                long jarId = dbh.createJar(aJar);
                Toast.makeText(getApplicationContext(), "Jar ID: " + jarId + "", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void addMem()
    {
        addMemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String desc = memDescriptionEdit.getText().toString();
                String idString = idEdit.getText().toString();
                long id = Long.parseLong(idString);
                Memory aMem = new Memory(desc);
                long memId = dbh.createMemory(aMem, new long[]{id});
                Toast.makeText(getApplicationContext(), "Mem ID: " + memId + "", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void viewAllJars()
    {
        viewAllJarsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                List<Jar> allJars = dbh.getAllJars();
                //Toast.makeText(getApplicationContext(), "View All", Toast.LENGTH_LONG).show();

                //viewAllJarsButton.setText("...");
                for(Jar aJar : allJars)
                {
                    Log.d("Jar Name", aJar.getName());
                    //Toast.makeText(getApplicationContext(), aJar.getName(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void viewAllMems()
    {
        viewAllMemsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                List<Memory> allMems = dbh.getAllMemories();
                //Toast.makeText(getApplicationContext(), "View All", Toast.LENGTH_LONG).show();

                //viewAllJarsButton.setText("...");
                for(Memory aMem : allMems)
                {
                    Log.d("Mem Desc", aMem.getDescription());
                    //Toast.makeText(getApplicationContext(), aJar.getName(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void updateJar()
    {
        updateJarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

            }
        });
    }

    public void updateMem()
    {
        updateMemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void viewMemsOfJar()
    {
        viewMemsOfJarButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String name = jarNameEdit.getText().toString();
                List<Memory> memoryList = dbh.getAllMemoriesByJar(name);
                for(Memory aMem : memoryList)
                {
                    Log.d("Mems Descs of JarName", aMem.getDescription());
                }
            }
        });
    }

    public void viewMemsOfJarID()
    {
        viewMemsOfJarIDButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String name = idEdit.getText().toString();
                long id;
                try
                {
                    id = Long.parseLong(name);
                }
                catch(NumberFormatException e)
                {
                    id = 1;
                }
                List<Memory> memoryList = dbh.getAllMemoriesByJarID(id);
                for(Memory aMem : memoryList)
                {
                    Log.d("Mems Descs of JarID", aMem.getDescription());
                }
            }
        });
    }

    public void deleteJar()
    {
        deleteJarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void deleteMem()
    {
        deleteMemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void clearText()
    {
        clearTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jarNameEdit.setText("");
                memDescriptionEdit.setText("");
                idEdit.setText("");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();

        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /*
    @Override
    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.btn_addjar:
            {
                break;
            }
            case R.id.btn_addmem:
            {
                break;
            }
            case R.id.btn_viewalljars:
            {
                List<Jar> allJars = dbh.getAllJars();
                viewAllJarsButton.setText("...");
                for(Jar aJar : allJars)
                {
                    Toast.makeText(getApplicationContext(), "View All", Toast.LENGTH_LONG).show();
                    Log.d("Jar Name", aJar.getName());
                }
                break;
            }
            case R.id.btn_viewallmems:
            {
                break;
            }
            case R.id.btn_updatejar:
            {
                break;
            }
            case R.id.btn_updatemem:
            {
                break;
            }
            case R.id.btn_deletejar:
            {
                break;
            }
            case R.id.btn_deletemem:
            {
                break;
            }
        }
    }
    */
}
