package com.example.ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_dob.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                c= Calendar.getInstance();
                if(hasFocus){
                    new DatePickerDialog(ex12_main.this, new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            c.set(year,month,dayOfMonth);
                            SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy", Locale.US);
                            et_dob.setText(sdf.format(c.getTime()));
                        }
                    },c.get(Calendar.YEAR),c.get(Calendar.MONTH),c.get(Calendar.DAY_OF_MONTH)).show();
                }
            }
        });
        et_reg_time.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                c=Calendar.getInstance();
                if(hasFocus){
                    new TimePickerDialog(ex12_main.this, new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                            et_reg_time.setText(String.format(Integer.toString(hourOfDay) +":"+Integer.toString(minute)));
                        }
                    },c.get(Calendar.HOUR_OF_DAY),c.get(Calendar.MINUTE),false).show();
                }
            }
        });
    }
}