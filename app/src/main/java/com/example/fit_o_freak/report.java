package com.example.fit_o_freak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class report extends AppCompatActivity {
Button b1,b2;
EditText w,h;
    ArrayList<String> listData = new ArrayList<>();
    ListView listView;
    MyDB myDB;
SharedPreferences sh;
TextView textView,t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        w = findViewById(R.id.w);
        listView = findViewById(R.id.list);
        sh = getSharedPreferences("sh",Context.MODE_PRIVATE);
        h = findViewById(R.id.h);
        myDB = new MyDB(this);
        t = findViewById(R.id.bmiInfo);
        textView = findViewById(R.id.t);
        populateListView();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager im = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                im.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);

                SharedPreferences.Editor editor = sh.edit();
                ArrayList<String> listData = new ArrayList<>();
               float height = sh.getFloat("h",165);
               float weight = sh.getFloat("w",0);
                String he = h.getText().toString();
                String we = w.getText().toString();
                if(he!= null&&!"".equals(he)){
                     height = Float.parseFloat(h.getText().toString());
                     editor.putFloat("h",height);
                     editor.commit();
                     editor.putString("hstring", he);
                    editor.commit();
                }
                if(we!= null&&!"".equals(we)){
                weight = Float.parseFloat(w.getText().toString());
                    editor.putFloat("h",height);
                    editor.commit();
                }
                float bmi = (weight*100*100)/(height*height);
                String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
                myDB.addData(date,bmi);
                populateListView();
                h.setText("");
                w.setText("");
                textView.setText("Current BMI is "+ bmi);
                if(h.getText().toString()!= null){
                    h.setClickable(false);
                    h.setFocusable(false);
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                h.setClickable(true);
                h.setFocusable(true);
            }
        });

    }
    private void populateListView() {
        Log.d("", "populateListView: Displaying data in the ListView.");

        //get the data and append to a list
        Cursor data = myDB.getData();
        ArrayList<String> listData = new ArrayList<>();
        while(data.moveToNext()){
            //get the value from the database in column 1
            //then add it to the ArrayList
            listData.add("Date "+data.getString(1)+" : BMI "+ data.getFloat(2));
            t.setText("IDEAL BMI SHOULD LIE IN THE RANGE OF 18 AND 25\n"+"Your current BMI is " + data.getFloat(2));


        }
        //create the list adapter and set the adapter
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
        listView.setAdapter(adapter);
       /* while(data.moveToLast()){
            if(data.getFloat(2)>25){
                t.append("\nAnd your current BMI is \n"+ (data.getFloat(2)-25) +" units more than ideal BMI");
            }
            if(data.getFloat(2)<18){
                t.append("\nAnd your current BMI is \n"+ (18-data.getFloat(2)) +" units more than ideal BMI");
            }
            if(data.getFloat(2)>=18&& data.getFloat(2)<=25){
                t.append("\nAnd your current BMI lies in ideal range");
            }
        }
*/

    }
}
