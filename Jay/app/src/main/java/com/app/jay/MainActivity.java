package com.app.jay;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterViewAnimator;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Contact> contactList = new ArrayList<>();
    private ContactAdapter adapter;
    private ListView listView;
    private Contact selectedContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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

                builder.setNegativeButton("MODIFIER", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //do things
                    }
                });

                builder.setNeutralButton("RIEN", new DialogInterface.OnClickListener()     {
                    public void onClick(DialogInterface dialog, int id) {
                        //do things
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();


                return true;
            }
        });

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
    }

}