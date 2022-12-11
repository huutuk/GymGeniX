package com.example.gymgenix;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Seances extends AppCompatActivity {

    private ListView seancesLV;

    private ArrayList<Seance> seancesList = new ArrayList<>();

    private DatabaseManager dbManager;

    private SeanceAdapter seanceAdapter;

    private Button addSeanceButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seances);
        DatabaseManager databaseManager = new DatabaseManager(getApplicationContext());
        seancesLV = findViewById(R.id.seancesLVID);
        addSeanceButton = findViewById(R.id.addSeanceButtonID);
        seancesList = databaseManager.getAllSeances();
        seanceAdapter = new SeanceAdapter(this, seancesList);
        seancesLV.setAdapter(seanceAdapter);

        addSeanceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startActivityAddSeance = new Intent(getApplicationContext(), AddSeance.class);
                startActivity(startActivityAddSeance);
            }
        });
    }
}