package com.example.roots;

import androidx.annotation.Nullable;
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
        tea.setText("");
        teb = (EditText)findViewById(R.id.teb);
        teb.setText("");
        tec = (EditText)findViewById(R.id.tec);
        tec.setText("");
        tv = (TextView)findViewById(R.id.tv);
    }
    public void root(View view) {

        if(!(tea.getText().toString().equals("")&&teb.getText().toString().equals("")&&tec.getText().toString().equals(""))){

            Intent si = new Intent(this,rootsolve.class);
            si.putExtra("a",Double.valueOf(tea.getText().toString()));
            si.putExtra("b",Double.valueOf(teb.getText().toString()));
            si.putExtra("c",Double.valueOf(tec.getText().toString()));
            startActivityForResult(si, 1);
        }
        else{
            Toast.makeText(this, "You forgot to input something", Toast.LENGTH_LONG).show();
        }
    }
    @Override
    protected void onActivityResult(int source, int good, @Nullable Intent data_back) {
        if (data_back != null) {
            if(data_back.getIntExtra("resam",0)==2) tv.setText("for a="+data_back.getDoubleExtra("a",0)+", b="+data_back.getDoubleExtra("b",0)+", c="+data_back.getDoubleExtra("c",0)+" results were:"+data_back.getDoubleExtra("x1",0)+", "+data_back.getDoubleExtra("x2",0));
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