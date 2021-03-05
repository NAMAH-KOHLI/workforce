package com.example.workforce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main8Activity extends AppCompatActivity {
    EditText name2;
    EditText newHr;
    Button update;
    Information information1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        name2 = findViewById(R.id.name2);
        newHr = findViewById(R.id.newHr);
        update = findViewById(R.id.update);
        information1 = new Information(this);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = name2.getText().toString();
                String Hr = newHr.getText().toString();
                Boolean updatedata = information1.update(name,Hr);
                Toast.makeText(getBaseContext(), "Data Updated", Toast.LENGTH_LONG).show();
                Intent i = new Intent(Main8Activity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}