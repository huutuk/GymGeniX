package com.example.gymgenix;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MuscleCatalog extends AppCompatActivity {
    ExerciceListUtils exerciceListUtils = new ExerciceListUtils();
    ArrayList<Exercice> exerciceList = exerciceListUtils.getExerciceList();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muscle_catalog);
        TextView nomMuscleTV = findViewById(R.id.muscleTVID);
        ListView listMuscleLV = findViewById(R.id.muscleLVID);

        // on récupère la partie du corps
        String groupeExo = getIntent().getStringExtra("groupeExo");

        nomMuscleTV.setText(groupeExo);

        List<Exercice> exoListToDisplay = exerciceList.stream()
                .filter(exo -> exo.getGroupeExo().equals(groupeExo))
                .collect(Collectors.toList());


        ArrayList<String> muscleToDisplay = new ArrayList<String>();
        exoListToDisplay
                .stream()
                .forEach(exo -> muscleToDisplay.addAll(Arrays.asList(exo.getMuscles())));


        //suppression des doublons via un set
        Set<String> set = new HashSet<>(muscleToDisplay);
        muscleToDisplay.clear();
        muscleToDisplay.addAll(set);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, muscleToDisplay);
        listMuscleLV.setAdapter(adapter);

        // idem que la main activity
        listMuscleLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // on ajoute les autres activities ici

                Intent intent = new Intent(MuscleCatalog.this, ExercicesCatalog.class);
                intent.putExtra("muscle", adapter.getItem(i).toString());
                startActivity(intent);

            }
        });

    }
}