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

    Button addJarButton, addMemButton, viewAllJarsButton, viewAllMemsButton, updateJarButton, updateMemButton, viewMemsOfJarButton, deleteJarButton, deleteMemButton, clearTextButton;
    EditText jarNameEdit, memDescriptionEdit, idEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        dbh = new DatabaseHandler(getApplicationContext());

        addJarButton = (Button)findViewById(R.id.btn_addjar);
        addMemButton = (Button)findViewById(R.id.btn_addmem);
        viewAllJarsButton = (Button)findViewById(R.id.btn_viewalljars);
        viewAllMemsButton = (Button)findViewById(R.id.btn_viewallmems);
        updateJarButton = (Button)findViewById(R.id.btn_updatejar);
        updateMemButton  = (Button)findViewById(R.id.btn_updatemem);
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
        viewMemsOfJar();
        deleteJar();
        deleteMem();
        clearText();

        /*
        //CREATE JAR
        Jar jar1 = new Jar("FIRST JAR");    //String name, String opendate, String color, String jarStatus
        long jar1_id = dbh.createJar(jar1);

        Jar jar2 = new Jar("SECOND JAR");
        long jar2_id = dbh.createJar(jar2);

        //CREATE MEMORY
        Memory mem1 = new Memory("FIRST MEMORY OF FIRST JAR");  //String description
        Memory mem2 = new Memory("SECOND MEMORY OF FIRST JAR");

        Memory mem3 = new Memory("FIRST MEMORY OF SECOND JAR");
        Memory mem4 = new Memory("SECOND MEMORY OF SECOND JAR");

        //INSERT MEMORY INTO DATABASE UNDER RESPECTIVE JARS
        long mem1_id = dbh.createMemory(mem1, new long[] {jar1_id});
        long mem2_id = dbh.createMemory(mem2, new long[] {jar1_id});

        long mem3_id = dbh.createMemory(mem3, new long[] {jar2_id});
        long mem4_id = dbh.createMemory(mem4, new long[] {jar2_id});
        */
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
                    Log.d("Mems Descs of Jar", aMem.getDescription());
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
