package com.app.jay;

import androidx.appcompat.app.AppCompatActivity;
import com.google.gson.*;

import android.app.AlertDialog;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterViewAnimator;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Contact> contactList;
    private ContactAdapter adapter;
    private ListView listView;
    private Contact selectedContact;
    private String fileName = "Contacts";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        contactList = new ArrayList<>();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("MainActivity", "Bonjour");
        FloatingActionButton button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent myIntent = new Intent(MainActivity.this, AddContactActivity.class);
                myIntent.putExtra("MainToAdd", "message");
                startActivityForResult(myIntent, 1);
            }
        });
        adapter = new ContactAdapter(getApplicationContext(), R.layout.list_item, contactList);
        listView = findViewById(R.id.contact_list);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selectedContact = (Contact) listView.getItemAtPosition(i);
                Intent intent = new Intent(MainActivity.this, ShowDetailContact.class);
                intent.putExtra("contact", selectedContact);
                        //"contact", contactList.get(i));
                startActivityForResult(intent, 2);
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l){

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Que faire de "+contactList.get(i).getSurname()+" "
                        +contactList.get(i).getTxtName()+" ?");

                builder.setPositiveButton("SUPPRIMER", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        contactList.remove(i);
                        adapter.notifyDataSetChanged();
                    }
                });

                builder.setNeutralButton("RIEN", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //do things
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();


                return true;
            }
        });
        /*try {             //ne fonctionne pas
            contactList = loadContacts();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Contact contact = (Contact) data.getSerializableExtra("contact");
            contactList.add(contact);
            adapter.notifyDataSetChanged();
            Log.d("ActA", contactList.get(0).toString());
        }
        else if(requestCode == 2 && resultCode == RESULT_OK) {
            contactList.remove(selectedContact);
            selectedContact = (Contact) data.getSerializableExtra("contact");
            contactList.add(selectedContact);
            adapter.notifyDataSetChanged();
            Log.d("ActA", contactList.get(0).toString());
        }

    }



    @Override
    protected void onStart() {
        super.onStart();
        Log.i("MainActivity", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("MainActivity", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("MainActivity", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("MainActivity", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("MainActivity", "onDestroy");
        try {
            saveContacts();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveContacts() throws IOException{
        //File test = new File(Environment.getDataDirectory());
        /*for (Contact c: contactList
             ) {
            Gson json = new Gson();
            try {
                json.toJson(c, new FileWriter("C:\\Users\\antho\\Documents\\GitHub\\jeromebonard\\Jay\\app\\src\\main\\res\\raw\\contacts.json"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
        Context context = getApplicationContext();
        File file = new File(fileName);
        file.delete();
        new File(context.getFilesDir(), fileName);
        FileOutputStream outputStream = context.openFileOutput(fileName, MODE_PRIVATE);

        for(Contact contact : contactList) {
            outputStream.write(contact.toString().getBytes());
        }
        outputStream.close();
    }

    private ArrayList<Contact> loadContacts() throws IOException {
            String row;
            String[] param;
            ArrayList<Contact> test = new ArrayList<>();

            Context context = getApplicationContext();
            FileInputStream inputStream = context.openFileInput(fileName);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            while((row = bufferedReader.readLine()) != null) {
                param = row.split(";");
                test.add(new Contact(param[0], param[1], param[2], param[3],
                        param[4], param[5], param[6], param[7]));
            }

            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();

            return test;

        }
}