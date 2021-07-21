package com.example.sample;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ex12_disp extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex12_disp);
        final TextView tv_name=findViewById(R.id.tv_name);
        final TextView tv_dob=findViewById(R.id.tv_dob);
        final TextView tv_gender=findViewById(R.id.tv_gender);
        final TextView tv_marital=findViewById(R.id.tv_marital);
        final TextView tv_reg_time=findViewById(R.id.tv_reg_time);
        final TextView tv_addict=findViewById(R.id.tv_addict);
        SharedPreferences Status=getSharedPreferences("status",MODE_PRIVATE);
        tv_name.setText(Status.getString("name",null));
        tv_dob.setText(Status.getString("dob",null));
        tv_gender.setText(Status.getString("gender",null));
        tv_marital.setText(Status.getString("marital",null));
        tv_reg_time.setText(Status.getString("reg_time",null));
        tv_addict.setText(Status.getString("addict",null));
    }
}
