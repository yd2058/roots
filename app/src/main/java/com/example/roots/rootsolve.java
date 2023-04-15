package com.example.roots;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class rootsolve extends AppCompatActivity {
    Intent gi;
    double a, b, c, x1, x2;
    int resam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rootsolve);
        gi=getIntent();
        a = gi.getDoubleExtra("a", 1);
        b = gi.getDoubleExtra("b", 0);
        c = gi.getDoubleExtra("c", 1);
        if(b*b>4*a*c){
            resam = 2;
        }
        else if(b*b==4*a*c){
            resam = 1;
        }
        else{
            resam = 0;
        }

    }

    public void ret(View view) {
        gi.putExtra("a", a);
        gi.putExtra("b", b);
        gi.putExtra("c", c);
        gi.putExtra("x1", x1);
        gi.putExtra("x2", x2);
        gi.putExtra("resam", resam);
        setResult(RESULT_OK, gi);
        finish();
    }
}

//± √