package com.example.tanyasrivastava.siri;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class seventh extends AppCompatActivity {
    float value1,value2,value3,value4,value5,value6;
    TextView s,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14,s15,s16;
    float x[][]=new float[4][4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seventh);
        Intent intent = getIntent();
        value1 = intent.getFloatExtra("x[0][1]", 1/4);
        value2 = intent.getFloatExtra("x[0][2]", 1/4);
        value3 = intent.getFloatExtra("x[0][3]", 1/4);
        value4 = intent.getFloatExtra("x[1][2]", 1/4);
        value5 = intent.getFloatExtra("x[1][3]", 1/4);
        value6 = intent.getFloatExtra("x[2][3]", 1/4);

        for(int i=0;i<4;i++)
        {
            for (int j=0;j<4;j++)
            {
                if(i==j)
                {x[i][j]=1f;}
            }
        }
        x[0][1]=value1;
        x[1][0]=(float)1/value1;
        x[0][2]=value2;
        x[2][0]=(float)1/value2;
        x[0][3]=value3;
        x[3][0]=(float)1/value3;
        x[1][2]=value4;
        x[2][1]=(float)1/value4;
        x[1][3]=value5;
        x[3][1]=(float)1/value5;
        x[2][3]=value6;
        x[3][2]=(float)1/value6;
        float sum=0;
        float a[]=new float[4];
        for(int k=0;k<4;k++)
        {
            for(int h=0;h<4;h++)
            {
                sum=sum+x[h][k];
            }
            a[k]=sum;
            sum=0;

        }
        for(int k=0;k<4;k++)
        {
            for(int h=0;h<4;h++)
            {
                x[h][k]=x[h][k]/a[k];

            }


        }
        float w[]=new float[4];
        for(int i=0;i<4;i++)
        {
            w[i]=0;
        }
        for(int k=0;k<4;k++)
        {
            for(int h=0;h<4;h++)
            {
                w[k]=w[k]+x[k][h];
            }


        }

        s=findViewById(R.id.textView);
        s2=findViewById(R.id.textView2);
        s3=findViewById(R.id.textView3);
        s4=findViewById(R.id.textView4);

        s.setText(Float.toString(w[0]));
        s2.setText(Float.toString(w[1]));
        s3.setText(Float.toString( w[2]));
        s4.setText(Float.toString(w[3]));



    }





}
