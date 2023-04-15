package com.example.roots;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class rootsolve extends AppCompatActivity {
    Intent gi;
    double a, b, c, x1 = 0, x2 = 0;
    int resam;
    TextView tv1, tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rootsolve);
        gi=getIntent();
        a = gi.getDoubleExtra("a", 1);
        b = gi.getDoubleExtra("b", 0);
        c = gi.getDoubleExtra("c", 1);
        ImageView iv = (ImageView) findViewById(R.id.iv);
        tv1 = (TextView)findViewById(R.id.tv1);
        tv2 = (TextView)findViewById(R.id.tv2);
        if(b*b>4*a*c){
            resam = 2;
            x1 = (-b+ Math.sqrt(b*b-4*a*c))/(2*a);
            x2 = (-b- Math.sqrt(b*b-4*a*c))/(2*a);
            if(a<0) iv.setImageResource(R.drawable.sadtwo);
            else iv.setImageResource(R.drawable.happytwo);
            tv1.setText("x1 = "+x1);
            tv2.setText("x2 = "+x2);
        }
        else if(b*b==4*a*c){
            resam = 1;
            x1 = -b/(2*a);
            if(a<0) iv.setImageResource(R.drawable.sadone);
            else iv.setImageResource(R.drawable.happyone);
            tv1.setText("x = "+x1);
            tv2.setText("");
        }
        else{
            resam = 0;
            if(a<0) iv.setImageResource(R.drawable.sadnone);
            else iv.setImageResource(R.drawable.happynone);
            tv1.setText("no");
            tv2.setText("solution");
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