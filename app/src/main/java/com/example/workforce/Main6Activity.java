package com.example.workforce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class Main6Activity extends AppCompatActivity {
    EditText pdf_convert;
    Button convert;
    Information information1;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        convert = findViewById(R.id.convert);
        information1 = new Information(this);
        db=information1.getWritableDatabase();
        ActivityCompat.requestPermissions(this, new String[] {READ_EXTERNAL_STORAGE, WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //String pdf_convert1 = pdf_convert.toString();
               //information1.PDF();
                //public void CreatePDF(View view){
                //                    String query = “Select Text from PDFTable where SerialNumber=” + editTextSerialNumberFetch.getText().toString();
                //                    Cursor cursor = sqLiteDatabase.rawQuery(query,null);
                //                    try {
                //                        cursor.moveToFirst();
                //                        textViewDisplay.setText(cursor.getString(0));
                //                    }
                //                    catch (Exception e){
                //                        e.printStackTrace();
                //                        textViewDisplay.setText(“”);
                //                        return;
                //                    }
                //                PdfDocument pdfDocument = new PdfDocument();
                //                PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(300, 600,1).create();
                //                PdfDocument.Page page = pdfDocument.startPage(pageInfo);
                //                page.getCanvas().drawText(cursor.getString(0),10, 25, new Paint());
                //                pdfDocument.finishPage(page);
                //                String filePath = Environment.getExternalStorageDirectory().getPath()+"/Download/” + editTextSerialNumberFetch.getText().toString() + ".pdf”;
                //                File file = new File(filePath);
                //                try {
                //                    pdfDocument.writeTo(new FileOutputStream(file));
                //                } catch (IOException e) {
                //                    e.printStackTrace();
                //                }
                //                pdfDocument.close();
                //            }
                
            }
        });

    }
}
