package com.example.gymgenix;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    ListView mainList;
    String[] page;
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainList = findViewById(R.id.mainList);
        page = new String[]{"Séances", "Calendrier", "Exercices", "Progrès"};
        // PageNames contient la liste des pages


        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, page);
        mainList.setAdapter(adapter);
        mainList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // on ajoute les autres activities ici

                if (i == 0) {
                    Intent intent = new Intent(view.getContext(), Seances.class);
                    startActivity(intent);

                }

                if (i == 2) {
                    Intent intent = new Intent(view.getContext(), CatalogExo.class);
                    startActivity(intent);

                }

            }
        });


    }
}
