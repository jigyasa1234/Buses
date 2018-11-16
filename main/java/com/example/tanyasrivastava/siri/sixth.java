package com.example.tanyasrivastava.siri;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class sixth extends AppCompatActivity {
    CheckBox a;
    CheckBox b;
    CheckBox c;
    CheckBox d;
    CheckBox e;
     TextView s;
    Button bt;
    float a6,value1,value2,value3,value4,value5;
    float x[][];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixth);

        a = (CheckBox) findViewById(R.id.checkbox1);
        b =(CheckBox) findViewById(R.id.checkbox2);
        c = (CheckBox) findViewById(R.id.checkbox3);
        d = (CheckBox) findViewById(R.id.checkbox4);
        e = (CheckBox) findViewById(R.id.checkbox5);
        bt=findViewById(R.id.button);
        Intent intent = getIntent();
         value1 = intent.getFloatExtra("x[0][1]", 1/4);
         value2 = intent.getFloatExtra("x[0][2]", 1/4);
         value3 = intent.getFloatExtra("x[0][3]", 1/4);
         value4 = intent.getFloatExtra("x[1][2]", 1/4);
         value5 = intent.getFloatExtra("x[1][3]", 1/4);




    }
    public void yo6(View view) {
        Log.i("gg:","bhghghgghghghghg");
        if (a.isChecked())
        {
            a6=1f;
        }
        else if (b.isChecked()) {
            a6 =3f;
        }
        else if (c.isChecked())
        {a6= 5f;}
        else if (d.isChecked())
        {a6=7f;}
        else if (e.isChecked()){

            a6=9f;

        }



        //x[0][1]=a1;
        Intent intent = new Intent(sixth.this, seventh.class);
        intent.putExtra("x[2][3]",a6);
        intent.putExtra("x[0][1]",value1);
        intent.putExtra("x[0][2]",value2);
        intent.putExtra("x[0][3]",value3);
        intent.putExtra("x[1][2]",value4);
        intent.putExtra("x[1][3]",value5);

        startActivity(intent);

    }
}
