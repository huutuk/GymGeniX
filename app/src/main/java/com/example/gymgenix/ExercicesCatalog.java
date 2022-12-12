package com.example.gymgenix;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ExercicesCatalog extends AppCompatActivity {
    ExerciceListUtils exerciceListUtils = new ExerciceListUtils();
    ArrayList<Exercice> exerciceList = exerciceListUtils.getExerciceList();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercices_catalog);



        ListView listExercicesLV = findViewById(R.id.exercicesLVID);

        // Traitement list
        String muscle = getIntent().getStringExtra("muscle");

        List<Exercice> exerciceListToDisplay = exerciceList.stream()
                .filter(exo -> Arrays.asList(exo.getMuscles()).contains(muscle))
                .collect(Collectors.toList());

        ArrayList<String> nomExerciceToDisplay = new ArrayList<String>();

        exerciceListToDisplay.stream()
                .forEach(exo -> nomExerciceToDisplay.add(exo.getNom()));


        Set<String> set = new HashSet<>(nomExerciceToDisplay);
        nomExerciceToDisplay.clear();
        nomExerciceToDisplay.addAll(set);
        // Fin de traitement
        ExerciceAdapter exerciceAdapter = new ExerciceAdapter(this, R.layout.list_row, (ArrayList<Exercice>) exerciceListToDisplay);
        listExercicesLV.setAdapter(exerciceAdapter);


        /*adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, nomExerciceToDisplay);
        listExercicesLV.setAdapter(adapter);*/

    }
}