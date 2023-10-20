package com.example.dte;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

//     opt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //On click of button Theorem
        Button btn1 = findViewById(R.id.theoremtabbt);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myInt = new Intent(getApplicationContext(), Theorems.class);
                startActivity(myInt);
            }


        });
        //On click  button Notes
        Button btn2 = findViewById(R.id.notetabbt);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myInt = new Intent(getApplicationContext(), Notes.class);
                startActivity(myInt);
            }


        });
        //On click button Logicgates
        Button btn3 = findViewById(R.id.logicgatestabbt);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myInt = new Intent(getApplicationContext(), Logicgates.class);
                startActivity(myInt);
            }


        });
        //On click button Conversion
        Button btn4 = findViewById(R.id.conversiontabbt);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myInt = new Intent(getApplicationContext(), Conversion.class);
                startActivity(myInt);
            }


        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater m=getMenuInflater();
        m.inflate(R.menu.menueopt,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id=item.getItemId();
        if (id==R.id.item1){
            Intent in1=new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.instagram.com/gaurav._.salve_/?igshid=OGQ5ZDc2ODk2ZA%3D%3D"));

            startActivity(in1);
            Toast.makeText(this, "Gaurav Salve", Toast.LENGTH_SHORT).show();
        } else if (id==R.id.item2) {
            Intent in2=new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.instagram.com/abhi._.1919/?igshid=NTc4MTIwNjQ2YQ%3D%3D"));

            startActivity(in2);
            Toast.makeText(this, "Abhishek Shinde", Toast.LENGTH_SHORT).show();
        } else if (id==R.id.item3) {
            Intent in3=new Intent(Intent.ACTION_VIEW,Uri.parse("https://forms.gle/PUoQDZKcfkdmzdC8A"));
            startActivity(in3);


        }

        return super.onOptionsItemSelected(item);
    }
}