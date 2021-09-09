package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class update extends AppCompatActivity {

    EditText Name, Salary, Dept, Ecode;
    RadioGroup Gender;
    myDbAdapter helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        Name = (EditText) findViewById(R.id.upd_name);
        Gender = (RadioGroup) findViewById(R.id.upd_rg);
        Ecode = (EditText) findViewById(R.id.upd_ecode);
        Dept = (EditText) findViewById(R.id.upd_dept);
        Salary = (EditText) findViewById(R.id.upd_sal);
        Button Upd = findViewById(R.id.upd_button);
        Bundle extras = getIntent().getExtras();
        Ecode.setFocusable(false);
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
                Gender.check(R.id.upd_male);
            }
            else if(setGender.equals("Female")){
                Gender.check(R.id.upd_female);
            }
            Ecode.setText(setEcode);
            Dept.setText(setDept);
            Salary.setText(setSal);
        }


        Upd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String t1 = Name.getText().toString();
                RadioButton gend = (RadioButton) findViewById(Gender.getCheckedRadioButtonId());
                String t2 = gend.getText().toString();
                String t3 = Ecode.getText().toString();
                String t4 = Dept.getText().toString();
                String t5 = Salary.getText().toString();
                long id = helper.updateData(t1,t2,t3,t4,t5);
                if(id<=0)
                {
                    Message.message(getApplicationContext(),"Update Unsuccessful");
                } else
                {
                    Message.message(getApplicationContext(),"Update Successful");
                }
                Name.setText("");
                Gender.clearCheck();
                Ecode.setText("");
                Dept.setText("");
                Salary.setText("");
                Intent i = new Intent(update.this,CRUD.class);
                startActivity(i);
            }
        });
    }
}