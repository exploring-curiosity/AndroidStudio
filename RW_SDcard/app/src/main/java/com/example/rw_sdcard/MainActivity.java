package com.example.rw_sdcard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {
    EditText fname,fcont;
    Button read,write;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fname = (EditText) findViewById(R.id.file_name);
        fcont = (EditText) findViewById(R.id.file_cont);
        read = (Button) findViewById(R.id.btn_read);
        write = (Button) findViewById(R.id.btn_write);
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    String inp="",text="";
                    File file = new File(getFilesDir(),fname.getText().toString());
                    BufferedReader bf = new BufferedReader(new FileReader(file));
                    while((inp=bf.readLine())!=null) text+=inp;
                    fcont.setText(text);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    String inp="",text="";
                    File file = new File(getFilesDir(),fname.getText().toString());
                    FileOutputStream fp = new FileOutputStream(file);
                    fp.write(fcont.getText().toString().getBytes());
                    fp.close();
                    fcont.setText("");
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

}