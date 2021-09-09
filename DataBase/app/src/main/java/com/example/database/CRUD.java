package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;

public class CRUD extends AppCompatActivity {
    myDbAdapter helper;
    EditText Ecode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud);
        Button insert = findViewById(R.id.ins_id);
        Button delete = findViewById(R.id.del_id);
        Button update = findViewById(R.id.upd_id);
        Button search = findViewById(R.id.srch_id);
        Ecode = (EditText) findViewById(R.id.crud_ecode);
        helper=new myDbAdapter(this);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CRUD.this,insert.class);
                startActivity(i);
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String t1 = Ecode.getText().toString();
                Intent i = new Intent(CRUD.this,update.class);
                i.putExtra("Ecode",t1);
                startActivity(i);
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String t1 = Ecode.getText().toString();
                Intent i = new Intent(CRUD.this,search.class);
                i.putExtra("Ecode",t1);
                startActivity(i);
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String t1 = Ecode.getText().toString();
                int a= helper.delete(t1);
                if(a<=0)
                {
                    Message.message(getApplicationContext(),"Unsuccessful");
                }
                else
                {
                    Message.message(getApplicationContext(), "DELETED");
                }
            }
        });
    }

}