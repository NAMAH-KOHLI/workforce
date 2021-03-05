package com.example.workforce;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Information extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Data";
    public static final String TABLE_NAME = "ADD_MEMBERS";
    public static final String COL_1 = "NAME";
    public static final String COL_2 = "AADHAR_NO";
    public static final String COL_3 = "PAN_NO";
    public static final String COL_4 = "WORK_TYPE";
    public static final String COL_5 = "NEFT_NO";
    public static final String COL_6 = "EPF_NO";
    public static final String COL_7 = "HRS";

    public static final String TABLE_NAME2 = "IN_OUT";
    public static final String COLM_1 = "NAMEs";
    public static final String COLM_2 = "Hrs";
    public static final String COLM_3 = "Time_In";
    public static final String COLM_4 = "Time_Out";

    public static final String TABLE_NAME3 = "SALARY";
    public static final String C_1 = "NNAME";
    public static final String C_2 ="T_SALARY";
    //---------------------------------------------------------------------------
    public Information(@Nullable Context context)
    {
        super(context, DATABASE_NAME, null, 1);
    }
    @Override
    //---------------------------------------------------------------------------
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, AADHAR_NO INTEGER, PAN_NO INTEGER, WORK_TYPE TEXT, NEFT_NO INTEGER, EPF_NO INTEGER, HRS INTEGER)");
        db.execSQL("create table " + TABLE_NAME2 + "(NAMEs TEXT, Hrs INTEGER, Time_In INTEGER, Time_Out INTEGER)");
        db.execSQL("create table " + TABLE_NAME3 + "(NNAME TEXT, T_SALARY INTEGER)");
    }

    //----------------------------------------------------------------------------
    public boolean insertData(String name, String aadhar_no, String pan_no, String work_type, String neft_no, String epf_no, String hrs){
        SQLiteDatabase myDb=this.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put(COL_1, name);
        values.put(COL_2, aadhar_no);
        values.put(COL_3, pan_no);
        values.put(COL_4, work_type);
        values.put(COL_5, neft_no);
        values.put(COL_6, epf_no);
        values.put(COL_7, hrs);
        ContentValues values1= new ContentValues();
        values1.put(COLM_1, name);
        myDb.insert(TABLE_NAME2, null, values1);
        ContentValues values2= new ContentValues();
        values2.put(C_1, name);
        myDb.insert(TABLE_NAME3,null, values2);
        long result = myDb.insert(TABLE_NAME, null, values);
        if(result==-1)
            return false;
        else
            return true;
    }

    public boolean insertData1(String name, String time_in1, String def){
        SQLiteDatabase myDb=this.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put(COLM_3, time_in1);
        values.put(COLM_2, def);
        ContentValues value = new ContentValues();
        value.put(C_2, def);
        myDb.update(TABLE_NAME3,value,"NNAME=?", new String[] {name});
        long result = myDb.update(TABLE_NAME2,values,"NAMEs=?",new String[] {name});
        if(result==-1)
            return false;
        else
            return true;
    }

    public boolean insertData2(String name, String time_out1){
        SQLiteDatabase myDb=this.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put(COLM_4, time_out1);
        long result = myDb.update(TABLE_NAME2,values,"NAMEs=?",new String[] {name});
        if(result==-1)
            return false;
        else
            return true;
    }

    //------------------------------------------------------------------------------
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME2);
        onCreate(db);
    }
    public Cursor AllData(){
        SQLiteDatabase myDb=this.getWritableDatabase();
        Cursor res = myDb.rawQuery("select * from " +TABLE_NAME,null);
        return res;
    }
    public Integer delete2 (String name){
        SQLiteDatabase myDb = this.getWritableDatabase();
        return myDb.delete(TABLE_NAME, "NAME=?" ,new String[] {name});
    }
    public Integer delete3 (String name){
        SQLiteDatabase myDb = this.getWritableDatabase();
        return myDb.delete(TABLE_NAME3, "NNAME=?" ,new String[] {name});
    }
    public Boolean update(String n1, String hr1) {
        SQLiteDatabase myDb = this.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put("HRS",hr1);
        myDb.update(TABLE_NAME,value,"NAME=?",new String[] {n1});
        return true;
    }
    public Boolean salary(String name, String total_sal){
        SQLiteDatabase myDb = this.getWritableDatabase();
        String t_sal = null;
        Integer sal = 0;
        ContentValues value = new ContentValues();
        value.put("T_SALARY", t_sal);
        myDb.insert(TABLE_NAME3, null, value);
        return true;
    }
    public Cursor HRs(String n){
        SQLiteDatabase myDb=this.getWritableDatabase();
        Cursor d = myDb.rawQuery(" SELECT " + COLM_3 +" FROM " + TABLE_NAME2 + " WHERE " + COLM_1 + "=?", new String[] {n});
        return d;
    }
    public  Cursor up(String n1){
        SQLiteDatabase myDb=this.getWritableDatabase();
        Cursor d1 = myDb.rawQuery(" SELECT " + COLM_2 +" FROM " + TABLE_NAME2 + " WHERE " + COLM_1 + "=?", new String[] {n1});;
        return  d1;
    }
    public Boolean update1(String n1, String h, String a, String b) {
        SQLiteDatabase myDb = this.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put(COLM_2,h);
        value.put(COLM_3,a);
        value.put(COLM_4,b);
        myDb.update(TABLE_NAME2,value,"NAMEs=?",new String[] {n1});
        return true;
    }
    public Cursor SData(String n){
        SQLiteDatabase myDb=this.getWritableDatabase();
        Cursor res = myDb.rawQuery(" SELECT " + COL_7 + " FROM " +TABLE_NAME + " WHERE " + COL_1 + "=?", new String[] {n});
        return res;
    }
    public Cursor TS(String n){
        SQLiteDatabase myDb=this.getWritableDatabase();
        Cursor res = myDb.rawQuery(" SELECT " + C_2 + " FROM " +TABLE_NAME3 + " WHERE " + C_1 + "=?", new String[] {n});
        return res;
    }
    public Boolean Sfinal(String n1, String h) {
        SQLiteDatabase myDb = this.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put(C_2,h);
        myDb.update(TABLE_NAME3,value,"NNAME=?",new String[] {n1});
        return true;
    }
    public Cursor Data(){
        SQLiteDatabase myDb=this.getWritableDatabase();
        Cursor res = myDb.rawQuery("select * from " +TABLE_NAME3,null);
        return res;
    }
}
