package com.example.ex2;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int cap_count=0;
    int num_count=0;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        TableLayout table= findViewById(R.id.table);
        table.setVisibility(View.INVISIBLE);
        TextView type_here= findViewById(R.id.type_here);
        type_here.setShowSoftInputOnFocus(false);
        type_here.setCursorVisible(false);
        type_here.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                table.setVisibility(View.VISIBLE);
            }
        });
        type_here.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    table.setVisibility(View.VISIBLE);
                else
                    table.setVisibility(View.INVISIBLE);
            }
        });

        Button q= findViewById(R.id.q);
        q.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt=type_here.getText().toString();
                txt+=q.getText().toString();
                type_here.setText(txt);
            }
        });

        Button w= findViewById(R.id.w);
        w.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt=type_here.getText().toString();
                txt+=w.getText().toString();
                type_here.setText(txt);
            }
        });

        Button e= findViewById(R.id.e);
        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt=type_here.getText().toString();
                txt+=e.getText().toString();
                type_here.setText(txt);
            }
        });

        Button r= findViewById(R.id.r);
        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt=type_here.getText().toString();
                txt+=r.getText().toString();
                type_here.setText(txt);
            }
        });

        Button t= findViewById(R.id.t);
        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt=type_here.getText().toString();
                txt+=t.getText().toString();
                type_here.setText(txt);
            }
        });

        Button y= findViewById(R.id.y);
        y.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt=type_here.getText().toString();
                txt+=y.getText().toString();
                type_here.setText(txt);
            }
        });

        Button u= findViewById(R.id.u);
        u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt=type_here.getText().toString();
                txt+=u.getText().toString();
                type_here.setText(txt);
            }
        });

        Button i= findViewById(R.id.i);
        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt=type_here.getText().toString();
                txt+=i.getText().toString();
                type_here.setText(txt);
            }
        });

        Button o= findViewById(R.id.o);
        o.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt=type_here.getText().toString();
                txt+=o.getText().toString();
                type_here.setText(txt);
            }
        });

        Button p= findViewById(R.id.p);
        p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt=type_here.getText().toString();
                txt+=p.getText().toString();
                type_here.setText(txt);
            }
        });

        Button a= findViewById(R.id.a);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt=type_here.getText().toString();
                txt+=a.getText().toString();
                type_here.setText(txt);
            }
        });

        Button s= findViewById(R.id.s);
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt=type_here.getText().toString();
                txt+=s.getText().toString();
                type_here.setText(txt);
            }
        });

        Button d= findViewById(R.id.d);
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt=type_here.getText().toString();
                txt+=d.getText().toString();
                type_here.setText(txt);
            }
        });

        Button f= findViewById(R.id.f);
        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt=type_here.getText().toString();
                txt+=f.getText().toString();
                type_here.setText(txt);
            }
        });

        Button g= findViewById(R.id.g);
        g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt=type_here.getText().toString();
                txt+=g.getText().toString();
                type_here.setText(txt);
            }
        });

        Button h= findViewById(R.id.h);
        h.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt=type_here.getText().toString();
                txt+=h.getText().toString();
                type_here.setText(txt);
            }
        });

        Button j= findViewById(R.id.j);
        j.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt=type_here.getText().toString();
                txt+=j.getText().toString();
                type_here.setText(txt);
            }
        });

        Button k= findViewById(R.id.k);
        k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt=type_here.getText().toString();
                txt+=k.getText().toString();
                type_here.setText(txt);
            }
        });

        Button l= findViewById(R.id.l);
        l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt=type_here.getText().toString();
                txt+=l.getText().toString();
                type_here.setText(txt);
            }
        });

        Button z= findViewById(R.id.z);
        z.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt=type_here.getText().toString();
                txt+=z.getText().toString();
                type_here.setText(txt);
            }
        });

        Button x= findViewById(R.id.x);
        x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt=type_here.getText().toString();
                txt+=x.getText().toString();
                type_here.setText(txt);
            }
        });

        Button c= findViewById(R.id.c);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt=type_here.getText().toString();
                txt+=c.getText().toString();
                type_here.setText(txt);
            }
        });

        Button v= findViewById(R.id.v);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View w) {
                String txt=type_here.getText().toString();
                txt+=v.getText().toString();
                type_here.setText(txt);
            }
        });

        Button b= findViewById(R.id.b);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt=type_here.getText().toString();
                txt+=b.getText().toString();
                type_here.setText(txt);
            }
        });

        Button n= findViewById(R.id.n);
        n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt=type_here.getText().toString();
                txt+=n.getText().toString();
                type_here.setText(txt);
            }
        });

        Button m= findViewById(R.id.m);
        m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt=type_here.getText().toString();
                txt+=m.getText().toString();
                type_here.setText(txt);
            }
        });

        Button space= findViewById(R.id.space);
        space.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt=type_here.getText().toString();
                txt+=" ";
                type_here.setText(txt);
            }
        });

        Button enter= findViewById(R.id.enter);
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt=type_here.getText().toString();
                txt+="\n";
                type_here.setText(txt);
            }
        });

        Button comma= findViewById(R.id.comma);
        comma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt=type_here.getText().toString();
                txt+=",";
                type_here.setText(txt);
            }
        });

        Button period= findViewById(R.id.period);
        period.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt=type_here.getText().toString();
                txt+=".";
                type_here.setText(txt);
            }
        });

        Button clr= findViewById(R.id.clr);
        clr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!TextUtils.isEmpty(type_here.getText())) {
                    String txt = type_here.getText().toString();
                    txt = txt.substring(0, txt.length() - 1);
                    type_here.setText(txt);
                }
            }
        });

        Button cap= findViewById(R.id.cap);
        cap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vi) {
                cap_count+=1;
                if (cap_count%2==0) {
                    q.setText("q");
                    w.setText("w");
                    e.setText("e");
                    r.setText("r");
                    t.setText("t");
                    y.setText("y");
                    u.setText("u");
                    i.setText("i");
                    o.setText("o");
                    p.setText("p");
                    a.setText("a");
                    s.setText("s");
                    d.setText("d");
                    f.setText("f");
                    g.setText("g");
                    h.setText("h");
                    j.setText("j");
                    k.setText("k");
                    l.setText("l");
                    z.setText("z");
                    x.setText("x");
                    c.setText("c");
                    v.setText("v");
                    b.setText("b");
                    n.setText("n");
                    m.setText("m");

                }
                else{
                    q.setText("Q");
                    w.setText("W");
                    e.setText("E");
                    r.setText("R");
                    t.setText("T");
                    y.setText("Y");
                    u.setText("U");
                    i.setText("I");
                    o.setText("O");
                    p.setText("P");
                    a.setText("A");
                    s.setText("S");
                    d.setText("D");
                    f.setText("F");
                    g.setText("G");
                    h.setText("H");
                    j.setText("J");
                    k.setText("K");
                    l.setText("L");
                    z.setText("Z");
                    x.setText("X");
                    c.setText("C");
                    v.setText("V");
                    b.setText("B");
                    n.setText("N");
                    m.setText("M");
                }
            }
        });

        Button num= findViewById(R.id.num);
        num.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vi) {
                num_count+=1;
                if (num_count%2==0) {
                    q.setText("q");
                    w.setText("w");
                    e.setText("e");
                    r.setText("r");
                    t.setText("t");
                    y.setText("y");
                    u.setText("u");
                    i.setText("i");
                    o.setText("o");
                    p.setText("p");
                    a.setText("a");
                    s.setText("s");
                    d.setText("d");
                    f.setText("f");
                    g.setText("g");
                    h.setText("h");
                    j.setText("j");
                    k.setText("k");
                    l.setText("l");
                    z.setText("z");
                    x.setText("x");
                    c.setText("c");
                    v.setText("v");
                    b.setText("b");
                    n.setText("n");
                    m.setText("m");

                }
                else{
                    q.setText("1");
                    w.setText("2");
                    e.setText("3");
                    r.setText("4");
                    t.setText("5");
                    y.setText("6");
                    u.setText("7");
                    i.setText("8");
                    o.setText("9");
                    p.setText("0");
                    a.setText("@");
                    s.setText("#");
                    d.setText("?");
                    f.setText("_");
                    g.setText("&");
                    h.setText("-");
                    j.setText("+");
                    k.setText("(");
                    l.setText(")");
                    z.setText("/");
                    x.setText("*");
                    c.setText("\"");
                    v.setText("'");
                    b.setText(":");
                    n.setText(";");
                    m.setText("!");
                }
            }
        });
    }
}