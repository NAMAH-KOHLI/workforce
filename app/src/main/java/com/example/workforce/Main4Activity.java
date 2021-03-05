package com.example.workforce;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main4Activity extends AppCompatActivity {
    Information information1;
    ListView mListView;
    ArrayList<String> listdata;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        mListView = findViewById(R.id.salary_list);

        information1 = new Information(this);
        listdata = new ArrayList<>();

        Cursor res = information1.Data();
        if (res.getCount() ==0) {
            Toast.makeText(getBaseContext(), "Error,Nothing found", Toast.LENGTH_LONG).show();
            return;
        }
        else {
            while (res.moveToNext()) {
                listdata.add(res.getString(0) + " = " + res.getString(1));
            }
        }
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listdata);
        mListView.setAdapter(adapter);
        Toast.makeText(getBaseContext(), "Data found", Toast.LENGTH_LONG).show();
    }
}
