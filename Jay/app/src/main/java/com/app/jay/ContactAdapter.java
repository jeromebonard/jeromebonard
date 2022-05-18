package com.app.jay;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ContactAdapter extends ArrayAdapter<Contact> {
    private ArrayList<Contact> contactList;


    public ContactAdapter(@NonNull Context context, int resource, ArrayList<Contact> contactList) {
        super(context, resource, contactList);
        this.contactList = contactList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        int contactIndex = position;
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,
                    parent, false);
        }

        ImageView contactImage = convertView.findViewById(R.id.contact_imageview);
        TextView nameTextView = convertView.findViewById(R.id.name_textview);
        TextView surnameTextView = convertView.findViewById(R.id.surname_textview);

        contactImage.setImageResource(contactList.get(position).getImageId());
        nameTextView.setText(contactList.get(position).getTxtName());
        surnameTextView.setText(contactList.get(position).getSurname());

        return convertView;
    }
}
