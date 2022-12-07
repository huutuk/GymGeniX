package com.example.gymgenix;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class CatalogExo extends AppCompatActivity {

    ListView groupeLV;
    String[] groupeList;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog_exo);

        groupeLV = findViewById(R.id.catalogLVID);
        groupeList = new String[]{"Haut", "Jambes"};
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, groupeList);
        groupeLV.setAdapter(adapter);

        groupeLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // on ajoute les autres activities ici

                Intent intent = new Intent(CatalogExo.this, MuscleCatalog.class);
                intent.putExtra("groupeExo", adapter.getItem(i).toString());
                startActivity(intent);

            }
        });

    }
}