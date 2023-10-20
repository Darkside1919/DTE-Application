package com.example.dte;
import  java.util.*;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Logicgates extends AppCompatActivity {
    Spinner gate;
    Spinner inp1;
    Spinner inp2;
    Button output;
    TextView result;
    ImageView img;
    int gateOut=0;String sgateOut;
    int inpu1,inpu2;
    int fin;
    String sFin;

/*
0-AND gate
1-OR gate
2-NOT gate
3-NAND gate
4-NOR gate
5-EX_OR gate
6-EX_NOR gate
 */

    ArrayList<String> arrGates=new ArrayList<>();

    ArrayList<Integer> arrInp=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logicgates);
        setTitle("Logicgates");
        getActionBar();
        gate = findViewById(R.id.spinner3);
        inp1 = findViewById(R.id.spinner4);
        inp2 = findViewById(R.id.spinner5);
        output = findViewById(R.id.button2);
        result = findViewById(R.id.textView20);
        img=findViewById(R.id.imageView);
        int iGate = 0;
        arrInp.add(0);
        arrInp.add(1);

        arrGates.add("AND");
        arrGates.add("OR");
        arrGates.add("NOT");
        arrGates.add("NAND");
        arrGates.add("NOR");
        arrGates.add("EX-OR");
        arrGates.add("EX-NOR");

        ArrayAdapter<String> arrGate = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, arrGates);
        gate.setAdapter(arrGate);

        ArrayAdapter<Integer> arrInp1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, arrInp);
        inp1.setAdapter(arrInp1);
        inp2.setAdapter(arrInp1);
        gate.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {

                    gateOut = 0;
                }  if (position == 1) {
                    gateOut = 1;
                }  if (position == 2) {
                    gateOut = 2;
                }  if (position == 3) {
                    gateOut = 3;
                }  if (position == 4) {
                    gateOut = 4;
                }  if (position == 5) {
                    gateOut = 5;
                }  if (position == 6) {
                    gateOut = 6;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(Logicgates.this, "Please select and a gate", Toast.LENGTH_SHORT).show();
            }
        });


        inp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    inpu1 = 0;
                } else if (position == 1) {
                    inpu1 = 1;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        inp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    inpu2 = 0;
                } else if (position == 1) {
                    inpu2 = 1;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        output.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fin = logic_output(gateOut, inpu1, inpu2);
                sgateOut= Integer.toString(gateOut);
                sFin = Integer.toString(fin);
                result.setText(sFin);
                if (gateOut==0){
                    img.setImageResource(R.drawable.and);
                }
                else if (gateOut==1) {
                    img.setImageResource(R.drawable.or);
                }
                else if (gateOut==2) {
                    img.setImageResource(R.drawable.not);
                }
                else if (gateOut==3) {
                    img.setImageResource(R.drawable.nand);
                }
                else if (gateOut==4) {
                    img.setImageResource(R.drawable.nor);
                }
                else if (gateOut==5) {
                    img.setImageResource(R.drawable.exor);
                }
                else if (gateOut==6) {
                    img.setImageResource(R.drawable.exnor);
                }


            }
        });

    }

    int logic_output(int gatNo,int inp1,int inp2){
        int fin=0;
        if (gatNo==0){
            fin=andOut(inp1,inp2);
            return fin;
        }
        else if (gatNo==1){
            fin=orOut(inp1,inp2);
            return fin;
        }
        else if (gatNo==2){
            fin=notOut(inp1);
            return fin;
        }
        else if (gatNo==3){
            fin=nandOut(inp1,inp2);
            return fin;
        }
        else if (gatNo==4){
            fin=norOut(inp1,inp2);
            return fin;
        }
        else if (gatNo==5){
            fin=exorOut(inp1,inp2);
            return fin;
        }
        else if (gatNo==6) {
            fin = exnorOut(inp1, inp2);
            return fin;
        }

        return fin;
    }

    int andOut(int a,int b){

        return a*b;
    }
    int orOut(int a,int b){
        int fin=0;
        if(a==1&&b==1){
            fin= 1;
        }
        else
            return a+b;

        return fin;
    }
    int notOut(int a){
        int  in=0;

        if (a==0){
            fin=1;
        }
        else{
            fin=0;
        }
        return fin;
    }
    int nandOut(int a,int b){
        int fin=0;

        int pfin=andOut(a,b);
        fin=bar(pfin);
        return fin;

    }
    int norOut(int a,int b){
        int fin=0;
        int pfin=orOut(a,b);
        fin=bar(pfin);

        return fin;
    }
    int exorOut(int a,int b){
        if (a== 0 && b== 0 || a== 1 && b==1){
            return 0;
        }
        else {
            return 1;
        }
    }
    int exnorOut(int a,int b){
        int pfin = 0;
        pfin = exorOut(a,b);
        return bar(pfin);

    }
    int bar(int n){
        int fin=0;
        if(n==0){
            fin=1;
        }
        else{
            fin=0;
        }
        return fin;
    }
}