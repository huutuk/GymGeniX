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
import android.widget.Toast;

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

        //Edition de l'exercice
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

        //suppression de l'exercice
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                deleteExo((long) viewHolder.itemView.getTag());
                Toast.makeText(EditSeanceActivity.this, "supprim??!", Toast.LENGTH_SHORT).show();
                exoAdapter.notifyDataSetChanged();

            }
        }).attachToRecyclerView(recyclerView);


        tvRepAmount = findViewById(R.id.tv_rep);
        tvWeightAmount = findViewById(R.id.tv_weight);


        Button buttonRepInc = findViewById(R.id.rep_inc);
        Button buttonRepDec = findViewById(R.id.rep_dec);
        Button buttonWeightInc = findViewById(R.id.weight_inc);
        Button buttonWeightDec = findViewById(R.id.weight_dec);
        Button buttonRep5Inc = findViewById(R.id.rep_5inc);
        Button buttonRep5Dec = findViewById(R.id.rep_5dec);
        Button buttonWeight10Inc = findViewById(R.id.weight_10inc);
        Button buttonWeight10Dec = findViewById(R.id.weight_10dec);
        Button buttonAddExo = findViewById(R.id.add_exo);


        // toutes les methodes pour gerer les incr??mentations de poids et de r??p??titions
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

        ////
        buttonRep5Inc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rep5Increased();
            }
        });
        buttonRep5Dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rep5Decreased();

            }
        });

        buttonWeight10Inc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                weight10Increased();
            }
        });
        buttonWeight10Dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                weight10Decreased();
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
    //

    private void rep5Increased() {
        repAmount += 5;
        tvRepAmount.setText(String.valueOf(repAmount));
    }

    private void rep5Decreased() {
        if (repAmount > 4) {
            repAmount -= 5;
            tvRepAmount.setText(String.valueOf(repAmount));
        }
    }

    private void weight10Increased() {
        weightAmount += 10;
        tvWeightAmount.setText(String.valueOf(weightAmount));
    }

    private void weight10Decreased() {
        if (weightAmount > 9) {
            weightAmount -= 10;
            tvWeightAmount.setText(String.valueOf(weightAmount));
        }
    }

    private void addExo() {
        if (autoCompleteTextView.getText().toString().trim().length() == 0 || repAmount == 0 || weightAmount < 0) {
            Toast.makeText(this, "nom/rep/poids requis", Toast.LENGTH_SHORT).show();
            return;
        }
        String name = autoCompleteTextView.getText().toString();
        ContentValues cv = new ContentValues();
        cv.put(SeanceStringUtils.ExoEntry.COLUMN_EXO_NAME, name);
        cv.put(SeanceStringUtils.ExoEntry.COLUMN_EXO_REP, repAmount);
        cv.put(SeanceStringUtils.ExoEntry.COLUMN_EXO_WEIGHT, weightAmount);
        cv.put(SeanceStringUtils.ExoEntry.COLUMN_EXO_SEANCENAME, seanceName);
        database.insert(SeanceStringUtils.ExoEntry.TABLE_EXO_NAME, null, cv);
        Toast.makeText(this, "Ajout??!", Toast.LENGTH_SHORT).show();
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

