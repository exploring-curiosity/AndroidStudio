package com.example.exe1;

import androidx.appcompat.app.AppCompatActivity;
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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Calendar c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.disp);
        final EditText name=findViewById(R.id.nameVal);
        final EditText addr=findViewById(R.id.addrVal);
        final EditText age=findViewById(R.id.ageVal);
        final EditText dob=findViewById(R.id.dobVal);
        final EditText mobile=findViewById(R.id.mobileVal);
        final EditText time=findViewById(R.id.timeVal);
        final RadioGroup gen=findViewById(R.id.genVal);
        final Spinner marital=findViewById(R.id.maritalVal);
        final CheckBox smoke=findViewById(R.id.smoke);
        final CheckBox alcohol=findViewById(R.id.alcohol);
        Button submit=findViewById(R.id.submit);
        Button reset=findViewById(R.id.reset);

        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.marital,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        marital.setAdapter(adapter);

        dob.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                c=Calendar.getInstance();
                if(hasFocus) {
                    new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            c.set(year,month,dayOfMonth);
                            SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy", Locale.US);
                            dob.setText(sdf.format(c.getTime()));
                        }
                    },c.get(Calendar.YEAR),c.get(Calendar.MONTH),c.get(Calendar.DAY_OF_MONTH)).show();
                }
            }
        });

        time.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v,boolean hasFocus) {
                c=Calendar.getInstance();
                if(hasFocus) {
                    new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                            time.setText(String.format(Integer.toString(hourOfDay)+":"+Integer.toString(minute)));
                        }
                    },c.get(Calendar.HOUR_OF_DAY),c.get(Calendar.MINUTE),false).show();
                }
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences Status=getSharedPreferences("status",MODE_PRIVATE);
                SharedPreferences.Editor EStatus=Status.edit();
                EStatus.putString("name",name.getEditableText().toString());EStatus.apply();
                EStatus.putString("addr",addr.getEditableText().toString());EStatus.apply();
                EStatus.putString("age",age.getEditableText().toString());EStatus.apply();
                EStatus.putString("dob",dob.getEditableText().toString());EStatus.apply();
                EStatus.putString("mobile",mobile.getEditableText().toString());EStatus.apply();
                EStatus.putString("time",time.getEditableText().toString());EStatus.apply();
                EStatus.putString("gen",((RadioButton)findViewById(gen.getCheckedRadioButtonId())).getText().toString());EStatus.apply();
                EStatus.putString("marital",marital.getSelectedItem().toString());EStatus.apply();
                String addiction="";
                if(smoke.isChecked()) addiction+="Smoking ";
                if(alcohol.isChecked()) addiction+="Alcohol";
                EStatus.putString("addict",addiction);EStatus.apply();
                startActivity(new Intent(getApplicationContext(),disp.class));
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });
    }
}
