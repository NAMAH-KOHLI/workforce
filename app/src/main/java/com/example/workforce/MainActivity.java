package com.example.workforce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button add_member;
Button inout;
Button salary;
Button remove_member;
Button pdf_list;
Button list;
Button update;
Information myDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        {
            add_member = findViewById(R.id.add_member);
            inout = findViewById(R.id.inout);
            salary = findViewById(R.id.salary);
            remove_member = findViewById(R.id.remove_member);
            pdf_list = findViewById(R.id.pdf_list);
            list = findViewById(R.id.list);
            update = findViewById(R.id.update);
            myDb = new Information(this);
            SQLiteDatabase db=myDb.getReadableDatabase();
//-----------------------------------------------------------------------------------------------------
            add_member.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(MainActivity.this, Main2Activity.class);
                    startActivity(i);
                }
            });
            inout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(MainActivity.this, Main3Activity.class);
                    startActivity(i);
                }
            });
            salary.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(MainActivity.this, Main4Activity.class);
                    startActivity(i);
                }
            });
            remove_member.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(MainActivity.this, Main5Activity.class);
                    startActivity(i);
                }
            });
            pdf_list.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(MainActivity.this, Main6Activity.class);
                    startActivity(i);
                }
            });
            list.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(MainActivity.this, Main7Activity.class);
                    startActivity(i);
                }
            });
            update.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(MainActivity.this, Main8Activity.class);
                    startActivity(i);
                }
            });
        }
    }
}
