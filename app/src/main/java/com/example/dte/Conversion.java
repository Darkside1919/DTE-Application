package com.example.dte;
import java.util.*;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Conversion extends AppCompatActivity {
    Button convert;
    Button reset;
    EditText number;
    EditText fromBase;
    EditText toBase;
    TextView result;

int tBase=2,fBase=10,num=10,fin=0,dec=0;
int def=0;
String stBase="",finRes="enter correct values",sfBase="",sNum="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion);
        setTitle("Conversion");
        getActionBar();
        convert = findViewById(R.id.button);
        reset=findViewById(R.id.button4);
        number = findViewById(R.id.editTextText);
        fromBase = findViewById(R.id.editTextNumber3);
        toBase = findViewById(R.id.editTextNumber4);
        result = findViewById(R.id.textView14);

//conversion logic

                    convert.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            sNum = number.getText().toString();
                            sfBase = fromBase.getText().toString();
                            stBase = toBase.getText().toString();


                            if (sNum.isEmpty()||sfBase.isEmpty()||stBase.isEmpty()){

                                Toast.makeText(Conversion.this, "First enter all the values", Toast.LENGTH_SHORT).show();

                            }else {


                                fBase = Integer.parseInt(sfBase);
                                tBase = Integer.parseInt(stBase);

                                dec = AnyToDec(sNum, fBase);

                                if(tBase==16){

                                    finRes=Integer.toHexString(dec);
                                    result.setText(finRes);
                                } else if (tBase==8) {
                                    finRes=Integer.toOctalString(dec);
                                    result.setText(finRes);
                                } else if (tBase==2) {
                                    finRes=Integer.toBinaryString(dec);
                                    result.setText(finRes);
                                } else if (tBase==10) {
                                    finRes = Integer.toString(dec);
                                    result.setText(finRes);
                                }
                                else if(fBase!=10||fBase!=2||fBase!=8||fBase!=16) {
                                    Toast.makeText(Conversion.this, "Incorrect Base", Toast.LENGTH_SHORT).show();
                                    result.setText("Incorrect Base");
                                }


                            }
                        }
                    });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent res =new Intent(getApplicationContext(),Conversion.class);

                startActivity(res);
                finish();

            }
        });

                }




//conversion logic





    public static int AnyToDec(String a, int base) {


        int fin=0;
        int d=0;
        int result = 0;
        int n = a.length();
        for (int i = 0; i < n; i++)
        {

            //convert the string to integer and A to F to its decimal number
            if (a.charAt(i) >= 'A' && a.charAt(i) <= 'H')
            {
                d = (a.charAt(i) - 'A' + 10);
            }
            if (a.charAt(i) >= 'a' && a.charAt(i) <= 'h')
            {
                d = (a.charAt(i) - 'a' + 10);
            }
            else if (a.charAt(i) >= '0' && a.charAt(i) <= '9')
            {
                d = (a.charAt(i) - '0');
            }

            fin = fin * base + d;
        }


        return  fin;
    }



}