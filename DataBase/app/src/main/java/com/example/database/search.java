package com.example.database;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class search extends AppCompatActivity {
    EditText Name, Salary, Dept, Ecode;
    RadioGroup Gender;
    myDbAdapter helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Name = (EditText) findViewById(R.id.srch_name);
        Gender = (RadioGroup) findViewById(R.id.srch_rg);
        Ecode = (EditText) findViewById(R.id.srch_ecode);
        Dept = (EditText) findViewById(R.id.srch_dept);
        Salary = (EditText) findViewById(R.id.srch_sal);
        Bundle extras = getIntent().getExtras();
        Name.setFocusable(false);
        Ecode.setFocusable(false);
        Dept.setFocusable(false);
        Salary.setFocusable(false);
        RadioButton male = (RadioButton) findViewById(R.id.srch_male);
        RadioButton female = (RadioButton) findViewById(R.id.srch_female);
        male.setEnabled(false);
        female.setEnabled(false);
        String setName = "";
        String setGender = "";
        String setEcode = "";
        String setDept = "";
        String setSal = "";
        helper = new myDbAdapter(this);
        if(extras!=null){
            String ecode = extras.getString("Ecode");
            String[] res = helper.getData(ecode);
            setName = res[0];
            setGender = res[1];
            setEcode = res[2];
            setDept = res[3];
            setSal = res[4];
            Name.setText(setName);
            if(setGender.equals("Male")){
                Gender.check(R.id.srch_male);
            }
            else if(setGender.equals("Female")){
                Gender.check(R.id.srch_female);
            }
            Ecode.setText(setEcode);
            Dept.setText(setDept);
            Salary.setText(setSal);
        }
    }
}