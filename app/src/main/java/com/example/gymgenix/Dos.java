package com.example.gymgenix;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Dos extends AppCompatActivity {
    ListView lv;
    ArrayList<String> data;
    ArrayAdapter<String> adapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dos);

        lv = (ListView) findViewById(R.id.liste_dos);
        data = new ArrayList<>();

        https://developer.android.com/guide/topics/ui/declaring-layout#AdapterViews
        /* adapts an array of data of type List<T> of undetermined size. this is to further be used by a view */
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,  /* android standard layout for a single entry from list: just some text and just a horizontal separator */
                data /* the List<T> contents */);
        lv.setAdapter(adapter);
    }
}