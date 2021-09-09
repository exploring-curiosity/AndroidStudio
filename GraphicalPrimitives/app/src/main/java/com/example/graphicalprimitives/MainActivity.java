package com.example.graphicalprimitives;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bitmap bg = Bitmap.createBitmap(720, 1280, Bitmap.Config.ARGB_8888);
        ImageView i = (ImageView) findViewById(R.id.imageView);
        i.setBackgroundDrawable(new BitmapDrawable(bg));
        Canvas canvas = new Canvas(bg);
        Paint paint1 = new Paint();
        paint1.setColor(Color.BLACK);
        paint1.setTextSize(50);
        Paint paint2=new Paint();
        paint2.setColor(Color.RED);
        Paint paint3=new Paint();
        paint3.setColor(Color.CYAN);
        Paint paint4=new Paint();
        paint4.setColor(Color.GREEN);
        Paint paint5=new Paint();
        paint5.setColor(Color.YELLOW);
        //To draw a Rectangle
        canvas.drawText("Rectangle", 80, 550, paint1);
        canvas.drawRect(100, 100, 300, 500, paint2);
        //To draw a Circle
        canvas.drawText("Circle", 500, 550, paint1);
        canvas.drawCircle(550, 250, 150, paint3);
        //To draw a Square
        canvas.drawText("Square", 120, 800, paint1);
        canvas.drawRect(50, 850, 350, 1150, paint4);
        //To draw a Line
        canvas.drawText("Line", 480, 800, paint1);
        canvas.drawLine(520, 850, 520, 1150, paint5);
    }
}