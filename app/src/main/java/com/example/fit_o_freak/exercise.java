package com.example.fit_o_freak;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class exercise extends AppCompatActivity {
    Button b1,b2,b3,b4,b5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercise);
        b1 = (Button) findViewById(R.id.absbeg);
        b2 = (Button) findViewById(R.id.chestbeg);
        b3 = (Button) findViewById(R.id.legbeg);
        b4 = (Button) findViewById(R.id.armbeg);
        b5 = (Button) findViewById(R.id.backbeg);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),plan.class);
                int x = 1;
                intent.putExtra("value",x);
                startActivity(intent);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),plan.class);
                int x = 2;
                intent.putExtra("value",x);
                startActivity(intent);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),plan.class);
                int x = 3;
                intent.putExtra("value",x);
                startActivity(intent);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),plan.class);
                int x = 4;
                intent.putExtra("value",x);
                startActivity(intent);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),plan.class);
                int x = 5;
                intent.putExtra("value",x);
                startActivity(intent);
            }
        });
    }
}
