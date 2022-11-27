package com.example.gymgenix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class CatalogExo extends AppCompatActivity {
    ListView listView;
    TextView textview;
    String[] listItems;

    ArrayList<String> data;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog_exo);

        listView = findViewById(R.id.liste_exo);
        textview = findViewById(R.id.TextCatalogID);

        listItems = getResources().getStringArray(R.array.partie_du_corps);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, listItems);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(CatalogExo.this, GroupeExercice.class);
                intent.putExtra("value", arrayAdapter.getItem(i).toString());
                startActivity(intent);
            }
        });

    }
}