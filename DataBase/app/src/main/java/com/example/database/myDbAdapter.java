package com.example.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class myDbAdapter {
    myDbHelper myhelper;
    public myDbAdapter(Context context)
    {
        myhelper = new myDbHelper(context);
    }

    public long insertData(String name, String gender, String uid, String dept, String sal)
    {
        SQLiteDatabase dbb = myhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(myDbHelper.NAME, name);
        contentValues.put(myDbHelper.GENDER, gender);
        contentValues.put(myDbHelper.UID, uid);
        contentValues.put(myDbHelper.DEPT, dept);
        contentValues.put(myDbHelper.SALARY, sal);
        long id = dbb.insert(myDbHelper.TABLE_NAME, null , contentValues);
        return id;
    }

    public String[] getData(String eid)
    {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String[] columns = {myDbHelper.UID,myDbHelper.NAME,myDbHelper.GENDER,myDbHelper.DEPT,myDbHelper.SALARY};
        Cursor cursor =db.query(myDbHelper.TABLE_NAME,columns,myDbHelper.UID+"=?",new String[] {eid},null,null,null);
        String[] res = new String[]{"NA","NA",eid,"NA","NA"};
        while (cursor.moveToNext())
        {
            String ecode =cursor.getString(cursor.getColumnIndex(myDbHelper.UID));
            String name =cursor.getString(cursor.getColumnIndex(myDbHelper.NAME));
            String gender =cursor.getString(cursor.getColumnIndex(myDbHelper.GENDER));
            String Dept =cursor.getString(cursor.getColumnIndex(myDbHelper.DEPT));
            String sal =cursor.getString(cursor.getColumnIndex(myDbHelper.SALARY));
            res[0] = name;
            res[1] = gender;
            res[2] = ecode;
            res[3] = Dept;
            res[4] = sal;
        }
        return res;
    }

    public  int delete(String eid)
    {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String[] whereArgs ={eid};

        int count =db.delete(myDbHelper.TABLE_NAME ,myDbHelper.UID+" = ?",whereArgs);
        return  count;
    }

    public int updateData(String name, String gender, String uid, String dept, String sal)
    {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(myDbHelper.NAME, name);
        contentValues.put(myDbHelper.GENDER, gender);
        contentValues.put(myDbHelper.UID, uid);
        contentValues.put(myDbHelper.DEPT, dept);
        contentValues.put(myDbHelper.SALARY, sal);
        String[] whereArgs= {uid};
        int count =db.update(myDbHelper.TABLE_NAME,contentValues, myDbHelper.UID+" = ?",whereArgs );
        return count;
    }

    static class myDbHelper extends SQLiteOpenHelper
    {
        private static final String DATABASE_NAME = "myDatabase";    // Database Name
        private static final String TABLE_NAME = "Employees";   // Table Name
        private static final int DATABASE_Version = 1;    // Database Version
        private static final String UID="EmployeeCode";     // Column I (Primary Key)
        private static final String NAME = "Name";    //Column II
        private static final String GENDER= "Gender";    // Column III
        private static final String DEPT= "Department";    // Column IV
        private static final String SALARY= "Salary";    // Column V
        private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+
                " ("+UID+" INTEGER PRIMARY KEY, "+NAME+" VARCHAR(255) ,"+ GENDER+" VARCHAR(225) ,"+ DEPT+" VARCHAR(225)," + SALARY+" INTEGER);";
        private static final String DROP_TABLE ="DROP TABLE IF EXISTS "+TABLE_NAME;
        private Context context;

        public myDbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_Version);
            this.context=context;
        }

        public void onCreate(SQLiteDatabase db) {

            try {
                db.execSQL(CREATE_TABLE);
            } catch (Exception e) {
                Message.message(context,""+e);
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            try {
                Message.message(context,"OnUpgrade");
                db.execSQL(DROP_TABLE);
                onCreate(db);
            }catch (Exception e) {
                Message.message(context,""+e);
            }
        }
    }
}
