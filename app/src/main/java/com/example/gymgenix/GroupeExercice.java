package com.example.gymgenix;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class GroupeExercice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groupeexercice);

        TextView GpMuscID = findViewById(R.id.GpMuscId);

        String vl = getIntent().getStringExtra("value");
        GpMuscID.setText(vl);
    }
}