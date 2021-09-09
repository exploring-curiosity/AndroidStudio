package com.example.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt_rotate=findViewById(R.id.bt_rotate);
        Button bt_zoom=findViewById(R.id.bt_zoom);
        Button bt_car=findViewById(R.id.bt_car);
        Button bt_forward=findViewById(R.id.bt_forward);
        Button bt_backward=findViewById(R.id.bt_backward);
        Button bt_draw = findViewById(R.id.bt_Draw);
        Button bt_blink = findViewById(R.id.bt_blink);
        final ImageView iv_animate=findViewById(R.id.iv_animate);
        bt_rotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_animate.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_in));
            }
        });
        bt_zoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                iv_animate.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_in));

            }
        });
        bt_blink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView image = (ImageView)findViewById(R.id.iv_animate);
//                Animation animation1 =AnimationUtils.loadAnimation(getApplicationContext(),R.anim.blink);
//                image.startAnimation(animation1);
                iv_animate.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.blink));
            }
        });
        bt_draw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap b=Bitmap.createBitmap(720,480, Bitmap.Config.ARGB_8888);
                iv_animate.setBackgroundDrawable(new BitmapDrawable(b));
                Canvas canvas=new Canvas(b);
                Paint p=new Paint();
                p.setStrokeWidth(5);
                p.setColor(Color.RED);
                RectF r=new RectF(150,200,500,250);
                canvas.drawRect(r,p);
                r=new RectF(250,150,400,200);
                canvas.drawRect(r,p);
                canvas.drawLine(400,150,450,200,p);
                p.setColor(Color.BLACK);
                canvas.drawCircle(200,250,30,p);
                canvas.drawCircle(280,250,30,p);
                canvas.drawCircle(450,250,30,p);
                iv_animate.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in));
            }
        });
        bt_car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uri = "@drawable/car";  // where myresource (without the extension) is the file
                int imageResource = getResources().getIdentifier(uri, null, getPackageName());
                Drawable res = getResources().getDrawable(imageResource);
                iv_animate.setBackground(res);
                iv_animate.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in));
            }
        });
        bt_forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_animate.animate().translationXBy(300f).setDuration(600);
            }
        });
        bt_backward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_animate.animate().translationXBy(-300f).setDuration(600);
            }
        });
    }
}
