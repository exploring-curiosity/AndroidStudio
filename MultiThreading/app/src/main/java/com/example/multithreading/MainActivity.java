package com.example.multithreading;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int i=0;
    int prev=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt_forward = (Button) findViewById(R.id.mv_right);
        Button bt_backward = (Button) findViewById(R.id.mv_left);
        TextView tv_animate = (TextView) findViewById(R.id.banner);
        TextView xVal = (TextView) findViewById(R.id.x_val);
        int arr[] = new int[5];
        arr[0]= Color.RED;
        arr[1] = Color.BLUE;
        arr[2] = Color.GREEN;
        arr[3]=Color.YELLOW;
        arr[4] = Color.MAGENTA;
        bt_forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    public void run() {
                        // a potentially time consuming task

                        tv_animate.setTranslationX(410f);
                    }
                }).start();

                runOnUiThread(new Runnable() {
                    public void run() {
                        // a potentially time consuming task
                        int x = Integer.valueOf(xVal.getText().toString())+410;
                        xVal.setText(String.valueOf(x));

                    }
                });

                new Thread(new Runnable() {
                    public void run() {
                        // a potentially time consuming task
                        tv_animate.setBackgroundColor(arr[i]);
                        i=(i+1)%5;
                    }
                }).start();

            }
        });
        bt_backward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    public void run() {
                        // a potentially time consuming task

                        tv_animate.setTranslationX(-410f);
                    }
                }).start();


                runOnUiThread(new Runnable() {
                    public void run() {
                        // a potentially time consuming task
                        int x = Integer.valueOf(xVal.getText().toString())-410;
                        xVal.setText(String.valueOf(x));

                    }
                });

                new Thread(new Runnable() {
                    public void run() {
                        // a potentially time consuming task

                        tv_animate.setBackgroundColor(arr[i]);
                        i=(i-1);
                        if(i==-1) i=4;
                    }
                }).start();
            }
        });
    }
}