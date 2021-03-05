package com.example.workforce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main5Activity extends AppCompatActivity {
    Button sub;
    EditText name;
    Information information1;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        sub = findViewById(R.id.sub);
        name = findViewById(R.id.name);
        information1 = new Information(this);

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name2 = name.getText().toString();
                Integer del = information1.delete2(name2);
                Integer del2 = information1.delete3(name2);
                if(del>0) {
                    Toast.makeText(getBaseContext(), "Data Deleted", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(Main5Activity.this, MainActivity.class);
                    startActivity(i);
                }
            }
        });
    }
}
