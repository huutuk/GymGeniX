package com.example.gymgenix;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SeanceActivity extends AppCompatActivity {
    EditText etSeanceName;
    Button btnSeanceAdd;
    ListView lvSeanceList;
    ArrayList<String> seanceList;
    ArrayAdapter<String> adapter;
    SeanceDBHelper db;
    private SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seance);
        etSeanceName = (EditText) findViewById(R.id.etSeanceName);
        btnSeanceAdd = findViewById(R.id.btn_add_seance);
        lvSeanceList = findViewById(R.id.lv_seanceList);
        db = new SeanceDBHelper(this);
        database = db.getWritableDatabase();

        seanceList = new ArrayList<String>();
        viewSeance();
        onBtnClick();

        lvSeanceList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view,
                                           int arg2, long arg3) {
                String clearDBQuery = "DELETE FROM " + SeanceStringUtils.ExoEntry.TABLE_EXO_NAME +
                        " WHERE " + SeanceStringUtils.ExoEntry.COLUMN_EXO_SEANCENAME + " = '" + seanceList.get(arg2) + "'";
                database.execSQL(clearDBQuery);
                db.deleteSeance(seanceList.get(arg2));

                seanceList.remove(arg2);
                Toast.makeText(SeanceActivity.this, "Séance supprimée!", Toast.LENGTH_SHORT).show();

                adapter.notifyDataSetChanged();

                return false;
            }
        });

        lvSeanceList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(SeanceActivity.this, EditSeanceActivity.class);
                intent.putExtra("seanceName", seanceList.get(i));
                startActivity(intent);
            }
        });
    }

    public void onBtnClick() {
        btnSeanceAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etSeanceName.getText().toString();
                if (!name.equals("") && db.insertSeance(name)) {
                    if (!seanceList.isEmpty()) seanceList.clear();

                    viewSeance();
                    adapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(SeanceActivity.this, "Echec de l'ajout   ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void viewSeance() {
        Cursor cursor = db.viewSeance();
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "Pas de séance", Toast.LENGTH_SHORT).show();
            String clearDBQuery = "DELETE FROM " + SeanceStringUtils.ExoEntry.TABLE_EXO_NAME;
            database.execSQL(clearDBQuery);

        } else {
            while (cursor.moveToNext()) {
                seanceList.add(cursor.getString(1));
            }
            adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, seanceList);
            lvSeanceList.setAdapter(adapter);
        }
    }
}