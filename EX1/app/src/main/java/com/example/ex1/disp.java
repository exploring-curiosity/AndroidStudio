package com.example.ex1;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class disp extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.disp);
        SharedPreferences Status=getSharedPreferences("status",MODE_PRIVATE);
        final TextView name=findViewById(R.id.name);
        name.setText(Status.getString("name",null));
        final TextView addr=findViewById(R.id.addr);
        addr.setText(Status.getString("addr",null));
        final TextView age=findViewById(R.id.age);
        age.setText(Status.getString("age",null));
        final TextView dob=findViewById(R.id.dob);
        dob.setText(Status.getString("dob",null));
        final TextView gen=findViewById(R.id.gen);
        gen.setText(Status.getString("gen",null));
        final TextView marital=findViewById(R.id.marital);
        marital.setText(Status.getString("marital",null));
        final TextView mobile=findViewById(R.id.mobile);
        mobile.setText(Status.getString("mobile",null));
        final TextView time=findViewById(R.id.time);
        time.setText(Status.getString("time",null));
        final TextView addict=findViewById(R.id.addict);
        addict.setText(Status.getString("addict",null));
    }
}
