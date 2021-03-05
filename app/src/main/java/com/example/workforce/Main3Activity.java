package com.example.workforce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Main3Activity extends AppCompatActivity {
    EditText Nname;
    Button IN;
    Button OUT;
    Information information1;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Nname = findViewById(R.id.Nname);
        IN = findViewById(R.id.IN);
        OUT = findViewById(R.id.OUT);
        information1 = new Information(this);
        final String def = "0";
        IN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH");
                String datetime = simpleDateFormat.format(calendar.getTime());
                Toast.makeText(getBaseContext(), datetime, Toast.LENGTH_LONG).show();
                String name = Nname.getText().toString();
                boolean inserted = information1.insertData1(name, datetime, def);
                                if (inserted = true)
                                    Toast.makeText(getBaseContext(), "Data inserted", Toast.LENGTH_LONG).show();
                                else
                                    Toast.makeText(getBaseContext(), "Data not inserted", Toast.LENGTH_LONG).show();
                                Intent i = new Intent(Main3Activity.this, MainActivity.class);
                                startActivity(i);

            }
        });
        OUT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH");
                String datetime = simpleDateFormat.format(calendar.getTime());
                String name = Nname.getText().toString();
                boolean inserted = information1.insertData2(name, datetime);

                if (inserted = true)
                    Toast.makeText(getBaseContext(), "Data inserted", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getBaseContext(), "Data not inserted", Toast.LENGTH_LONG).show();
                Cursor d1 = information1.HRs(name);
                int t1, t2;
                String t;
                        t2 = Integer.parseInt(datetime);
                if (d1.getCount() == 0) {
                    Toast.makeText(getBaseContext(), "No data", Toast.LENGTH_LONG).show();
                }
                else{
                    //for time in
                    while(d1.moveToNext()){
                        String t7 = d1.getString(0);
                        t1 = Integer.parseInt(t7);
                        int t5 = t2 - t1;
                        t = Integer.toString(t5);
                        //for hrs
                        Cursor h = information1.up(name);
                        if (h.getCount() == 0) {
                            Toast.makeText(getBaseContext(), "No data", Toast.LENGTH_LONG).show();
                        }
                        else {
                            while(h.moveToNext()){
                                String h3 = h.getString(0);
                                int h1 = Integer.parseInt(h3);
                                int h4 = h1 + t5;
                                String  h2 = Integer.toString(h4);
                                information1.update1(name, h2, def, def);
                                //money of hrs
                                Cursor z = information1.SData(name);
                                if (z.getCount() == 0) {
                                    Toast.makeText(getBaseContext(), "No data", Toast.LENGTH_LONG).show();
                                }
                                else {
                                    while (z.moveToNext()){
                                        String z1 = z.getString(0);
                                        int z2 = Integer.parseInt(z1);
                                        int Sal = z2 * h4;
                                        String z3 = Integer.toString(Sal);
                                        //for total salary
                                        Cursor x = information1.TS(name);
                                        if (x.getCount() == 0) {
                                            Toast.makeText(getBaseContext(), "No data", Toast.LENGTH_LONG).show();
                                        }
                                        else {
                                            while (x.moveToNext()){
                                                String x1 = x.getString(0);
                                                int x2 = Integer.parseInt(x1);
                                                int fv = Sal + x2;
                                                String f1 = Integer.toString(fv);
                                                information1.Sfinal(name,f1);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                Intent i = new Intent(Main3Activity.this, MainActivity.class);
                startActivity(i);
            }
        });

    }
}
