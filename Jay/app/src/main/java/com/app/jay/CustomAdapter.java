package com.app.jay;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter{
    private ArrayList<Contact> contacts;
    Context context;

    public CustomAdapter(ArrayList<Contact> contacts, Context context){
        this.context = context;
        this.contacts = contacts;
    }

    @Override
    public int getCount() {
        return 0;
    }

    public Object getItem(int position){
        return null;
    }

    public long getItemId(int position){
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        return null;
    }
}
