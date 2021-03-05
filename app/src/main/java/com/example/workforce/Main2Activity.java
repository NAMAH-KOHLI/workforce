package com.example.workforce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    EditText Name;
    EditText Aadhar_no;
    EditText PAN_no;
    EditText Work_type;
    EditText Neft_no;
    EditText Epf_no;
    EditText Hrs;
    Button Submit;
    Information information1;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Submit = findViewById(R.id.submit);
        Name = findViewById(R.id.name);
        Aadhar_no = findViewById(R.id.aadhar);
        PAN_no = findViewById(R.id.pan);
        Work_type = findViewById(R.id.work);
        Neft_no = findViewById(R.id.neft);
        Epf_no = findViewById(R.id.epf);
        Hrs = findViewById(R.id.Phrs);

        information1 = new Information(this);
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = Name.getText().toString();
                String aadhar_no = Aadhar_no.getText().toString();
                String pan_no = PAN_no.getText().toString();
                String work_type = Work_type.getText().toString();
                String neft_no = Neft_no.getText().toString();
                String epf_no = Epf_no.getText().toString();
                String hrs = Hrs.getText().toString();
                boolean inserted = information1.insertData(name, aadhar_no, pan_no, work_type, neft_no, epf_no, hrs);
                if (inserted = true)
                    Toast.makeText(getBaseContext(), "Data inserted", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getBaseContext(), "Data not inserted", Toast.LENGTH_LONG).show();
                Intent i = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
    }
