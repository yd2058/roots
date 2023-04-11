package com.example.roots;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText tea, teb, tec;
    TextView tv;
    Random rnd = new Random();
    Double a,b,c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tea = (EditText)findViewById(R.id.tea);
        teb = (EditText)findViewById(R.id.teb);
        tec = (EditText)findViewById(R.id.tec);
        tv = (TextView)findViewById(R.id.tv);
    }

    public void root(View view) {
        if(a!=null && b!=null && c!=null){
            Intent si = new Intent(this,rootsolve.class);
            si.putExtra("a",a);
            si.putExtra("b",b);
            si.putExtra("c",c);
            startActivityForResult(si, 1);
        }
        else{
            Toast.makeText(this, "You forgot to input something", Toast.LENGTH_LONG).show();
        }
    }

    public void rand(View view) {
        a = ((double)rnd.nextInt(101)+(rnd.nextInt(101)/100));
        b = ((double)rnd.nextInt(101)+(rnd.nextInt(101)/100));
        c = ((double)rnd.nextInt(101)+(rnd.nextInt(101)/100));
        tea.setText(a.toString());
        teb.setText(b.toString());
        tec.setText(c.toString());
    }
}