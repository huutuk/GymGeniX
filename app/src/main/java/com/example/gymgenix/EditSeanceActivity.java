package com.example.gymgenix;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EditSeanceActivity extends AppCompatActivity {
    ExoAdapter exoAdapter;
    ExerciceListUtils exerciceListUtils = new ExerciceListUtils();
    ArrayList<Exercice> exerciceList = exerciceListUtils.getExerciceList();
    ArrayList<String> nomExerciceList = new ArrayList<String>();
    private SQLiteDatabase database;
    private TextView tvRepAmount;
    private int repAmount = 0;
    private TextView tvWeightAmount;
    private int weightAmount = 0;
    private String seanceName;
    private AutoCompleteTextView autoCompleteTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_seance);

        String seanceNameFromSeanceActivity = getIntent().getStringExtra("seanceName");
        seanceName = seanceNameFromSeanceActivity;

        exerciceList.stream().forEach(exo -> nomExerciceList.add(exo.getNom()));

        autoCompleteTextView = findViewById(R.id.at_exoName);
        autoCompleteTextView.setAdapter(new ArrayAdapter<String>(EditSeanceActivity.this, android.R.layout.simple_list_item_1, nomExerciceList.toArray(new String[0])));


        SeanceDBHelper dbHelper = new SeanceDBHelper(this);
        database = dbHelper.getWritableDatabase();
        RecyclerView recyclerView = findViewById(R.id.rv_exos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        exoAdapter = new ExoAdapter(this, getAllItems());
        recyclerView.setAdapter(exoAdapter);
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                editExo((long) viewHolder.itemView.getTag());
                exoAdapter.notifyDataSetChanged();
            }
        }).attachToRecyclerView(recyclerView);

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                deleteExo((long) viewHolder.itemView.getTag());
                exoAdapter.notifyDataSetChanged();

            }
        }).attachToRecyclerView(recyclerView);


        tvRepAmount = findViewById(R.id.tv_rep);
        tvWeightAmount = findViewById(R.id.tv_weight);

        Button buttonRepInc = findViewById(R.id.rep_inc);
        Button buttonRepDec = findViewById(R.id.rep_dec);
        Button buttonWeightInc = findViewById(R.id.weight_inc);
        Button buttonWeightDec = findViewById(R.id.weight_dec);
        Button buttonAddExo = findViewById(R.id.add_exo);


        buttonRepInc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                repIncreased();
            }
        });
        buttonRepDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                repDecreased();

            }
        });

        buttonWeightInc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                weightIncreased();
            }
        });
        buttonWeightDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                weightDecreased();
            }
        });

        buttonAddExo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addExo();
            }
        });


    }

    private void repIncreased() {
        repAmount++;
        tvRepAmount.setText(String.valueOf(repAmount));
    }

    private void repDecreased() {
        if (repAmount > 0) {
            repAmount--;
            tvRepAmount.setText(String.valueOf(repAmount));
        }
    }

    private void weightIncreased() {
        weightAmount++;
        tvWeightAmount.setText(String.valueOf(weightAmount));
    }

    private void weightDecreased() {
        if (weightAmount > 0) {
            weightAmount--;
            tvWeightAmount.setText(String.valueOf(weightAmount));
        }
    }

    private void addExo() {
        if (autoCompleteTextView.getText().toString().trim().length() == 0 || repAmount == 0 || weightAmount < 0) {
            return;
        }
        String name = autoCompleteTextView.getText().toString();
        ContentValues cv = new ContentValues();
        cv.put(SeanceStringUtils.ExoEntry.COLUMN_EXO_NAME, name);
        cv.put(SeanceStringUtils.ExoEntry.COLUMN_EXO_REP, repAmount);
        cv.put(SeanceStringUtils.ExoEntry.COLUMN_EXO_WEIGHT, weightAmount);
        cv.put(SeanceStringUtils.ExoEntry.COLUMN_EXO_SEANCENAME, seanceName);
        database.insert(SeanceStringUtils.ExoEntry.TABLE_EXO_NAME, null, cv);
        exoAdapter.swapCursor(getAllItems());
    }

    private void editExo(long id) {
        String editStr = "UPDATE " + SeanceStringUtils.ExoEntry.TABLE_EXO_NAME +
                " SET " + SeanceStringUtils.ExoEntry.COLUMN_EXO_REP + " = '" + repAmount + "'," +
                SeanceStringUtils.ExoEntry.COLUMN_EXO_WEIGHT + " = '" + weightAmount + "'" +
                "WHERE " + SeanceStringUtils.ExoEntry._ID + " = " + "'" + id + "'";
        database.execSQL(editStr);
        exoAdapter.swapCursor(getAllItems());
    }

    private void deleteExo(long id) {
        String delStr = "DELETE FROM " + SeanceStringUtils.ExoEntry.TABLE_EXO_NAME +
                " WHERE " + SeanceStringUtils.ExoEntry._ID + " = " + "'" + id + "'";
        database.execSQL(delStr);
        exoAdapter.swapCursor(getAllItems());
    }

    private Cursor getAllItems() {
        return database.query(
                SeanceStringUtils.ExoEntry.TABLE_EXO_NAME,
                null,
                SeanceStringUtils.ExoEntry.COLUMN_EXO_SEANCENAME + " = " + "'" + seanceName + "'",
                null,
                null,
                null,
                null
        );


    }

}

