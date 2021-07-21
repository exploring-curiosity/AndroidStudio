package com.example.sample;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TimePicker;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
public class ex12_main extends AppCompatActivity {
    Calendar c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex12_main);
        final EditText et_name=findViewById(R.id.et_name);
        final EditText et_dob=findViewById(R.id.et_dob);
        final EditText et_reg_time=findViewById(R.id.et_reg_time);
        final RadioGroup rg_gender=findViewById(R.id.rg_gender);
        final Spinner sp_marital=findViewById(R.id.sp_marital);
        final CheckBox ck_smoke=findViewById(R.id.ck_smoke);
        final CheckBox ck_alcohol=findViewById(R.id.ck_alcohol);
        Button bt_submit=findViewById(R.id.bt_submit);
        Button bt_reset=findViewById(R.id.bt_reset);
        ArrayAdapter<CharSequence>
                adapter=ArrayAdapter.createFromResource(this,R.array.marital,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_marital.setAdapter(adapter);
        et_dob.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                c=Calendar.getInstance();
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
        bt_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences Status=getSharedPreferences("status",MODE_PRIVATE);
                SharedPreferences.Editor EStatus=Status.edit();
                EStatus.putString("name",et_name.getEditableText().toString()); EStatus.apply();
                EStatus.putString("dob",et_dob.getEditableText().toString()); EStatus.apply();
                EStatus.putString("gender",((RadioButton)findViewById(rg_gender.getCheckedRadioButtonId())).getText().toString());
                EStatus.apply();
                EStatus.putString("marital",sp_marital.getSelectedItem().toString()); EStatus.apply();
                EStatus.putString("reg_time",et_reg_time.getEditableText().toString()); EStatus.apply();
                String str="";
                if(ck_smoke.isChecked())
                    str+="Smoking ";
                if(ck_alcohol.isChecked())
                    str+="Alcohol ";
                EStatus.putString("addict",str); EStatus.apply();
                startActivity(new Intent(getApplicationContext(), ex12_disp.class));
            }
        });
        bt_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ex12_main.class));
            }
        });
    }
}
