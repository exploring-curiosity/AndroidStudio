package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class insert extends AppCompatActivity {
    EditText Name, Salary, Dept, Ecode;
    RadioGroup Gender;
    myDbAdapter helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        Name = (EditText) findViewById(R.id.ins_name);
        Gender = (RadioGroup) findViewById(R.id.ins_rg);
        Ecode = (EditText) findViewById(R.id.ins_ecode);
        Dept = (EditText) findViewById(R.id.ins_dept);
        Salary = (EditText) findViewById(R.id.ins_sal);
        Button Ins = findViewById(R.id.ins_button);

        helper = new myDbAdapter(this);

        Ins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String t1 = Name.getText().toString();
                RadioButton gend = (RadioButton) findViewById(Gender.getCheckedRadioButtonId());
                String t2 = gend.getText().toString();
                String t3 = Ecode.getText().toString();
                String t4 = Dept.getText().toString();
                String t5 = Salary.getText().toString();
                long id = helper.insertData(t1,t2,t3,t4,t5);
                if(id<=0)
                {
                    Message.message(getApplicationContext(),"Insertion Unsuccessful");
                } else
                {
                    Message.message(getApplicationContext(),"Insertion Successful");
                }
                Name.setText("");
                Gender.clearCheck();
                Ecode.setText("");
                Dept.setText("");
                Salary.setText("");
                Intent i = new Intent(insert.this,CRUD.class);
                startActivity(i);
            }
        });
    }

}