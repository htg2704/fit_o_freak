package com.example.fit_o_freak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class plan extends AppCompatActivity {
    ArrayList<String> listData = new ArrayList<>();
    ListView listView;
    Button b;
    EditText e1,e2;
    MyDB1 myDB1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);
        myDB1 = new MyDB1(getApplicationContext());
        listView = findViewById(R.id.l);
        Intent intent = getIntent();
        int x = intent.getIntExtra("value",0);
        final ArrayList<String> listData = new ArrayList<>();
        e1= findViewById(R.id.newE);
        e2= findViewById(R.id.newV);
        b= findViewById(R.id.add);
        if(x==1){
            abs();
        }
        if(x==2){
            chest();
        }
        if(x==3){
            legs();
        }
        if(x==4){
            arms();
        }
        if(x==5){
            back();
        }

    }
    public void chest(){
        listData.add("Inclined dumbbell press");
        listData.add("Flat dumbbell press");
        listData.add("Declined dumbbell press");
        listData.add("Dumbbell flyes");
        listData.add("Pushups");
        final String video = e2.getText().toString();

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                InputMethodManager im = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                im.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);
                String e, video;
                e = e1.getText().toString();
                video = e2.getText().toString();
                myDB1.addDataexer(e,video);
                if("".equals(e)||e==null||"".equals(video)||video==null){
                    Toast.makeText(plan.this, "Please enter both exercise name and VideoID", Toast.LENGTH_LONG).show();
                }
              /*  listData.add("Inclined dumbbell press");
                listData.add("Flat dumbbell press");
                listData.add("Declined dumbbell press");
                listData.add("Dumbbell flyes");
                listData.add("Pushups");*/
                Cursor data = myDB1.getDataexer();
                //ArrayList<String> listData = new ArrayList<>();
                while(data.moveToNext()){
                    //get the value from the database in column 1
                    //then add it to the ArrayList
                    listData.add(data.getString(1));
                }
                //create the list adapter and set the adapter
                ListAdapter adapter = new ArrayAdapter<>(plan.this, android.R.layout.simple_list_item_1, listData);
                listView.setAdapter(adapter);

              //  plan.this.listData.add(e);

               listView.setAdapter(adapter);
                e1.setText("");
                e2.setText("");
            }
        });
        Cursor data = myDB1.getDataexer();
        //ArrayList<String> listData = new ArrayList<>();
        while(data.moveToNext()){
            //get the value from the database in column 1
            //then add it to the ArrayList
            listData.add(data.getString(1));
        }
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
             Intent intent = new Intent(plan.this,detail.class);
             intent.putExtra("Ename", listView.getItemAtPosition(position).toString());
             intent.putExtra("vid",video);
             startActivity(intent);
            }
        });
    }
    public void abs(){
        listData.add("Crunches");
        listData.add("Plank");
        listData.add("Lying leg raise");
        listData.add("Seated Toe touch");
        listData.add("Laid Cycle");
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                InputMethodManager im = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                im.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);
                String e, video;
                e = e1.getText().toString();
                video = e2.getText().toString();
                myDB1.addDataexer1(e,video);
                if("".equals(e)||e==null||"".equals(video)||video==null){
                    Toast.makeText(plan.this, "Please enter both exercise name and VideoID", Toast.LENGTH_LONG).show();
                }
              /*  listData.add("Inclined dumbbell press");
                listData.add("Flat dumbbell press");
                listData.add("Declined dumbbell press");
                listData.add("Dumbbell flyes");
                listData.add("Pushups");*/
                Cursor data = myDB1.getDataexer1();
                //ArrayList<String> listData = new ArrayList<>();
                while(data.moveToNext()){
                    //get the value from the database in column 1
                    //then add it to the ArrayList
                    listData.add(data.getString(1));
                }
                //create the list adapter and set the adapter
                ListAdapter adapter = new ArrayAdapter<>(plan.this, android.R.layout.simple_list_item_1, listData);
                listView.setAdapter(adapter);

                //  plan.this.listData.add(e);

                listView.setAdapter(adapter);
                e1.setText("");
                e2.setText("");
            }
        });
        Cursor data = myDB1.getDataexer1();
        //ArrayList<String> listData = new ArrayList<>();
        while(data.moveToNext()){
            //get the value from the database in column 1
            //then add it to the ArrayList
            listData.add(data.getString(1));
        }
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(plan.this,detail.class);
                intent.putExtra("Ename", listView.getItemAtPosition(position).toString());
                startActivity(intent);
            }
        });
    }
    public void legs(){
        listData.add("Squats");
        listData.add("Backward Lunge");
        listData.add("Calf Raise");
        listData.add("Leg Press");
        listData.add("Leg Curls");
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                InputMethodManager im = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                im.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);
                String e, video;
                e = e1.getText().toString();
                video = e2.getText().toString();
                myDB1.addDataexer2(e,video);
                if("".equals(e)||e==null||"".equals(video)||video==null){
                    Toast.makeText(plan.this, "Please enter both exercise name and VideoID", Toast.LENGTH_LONG).show();
                }
              /*  listData.add("Inclined dumbbell press");
                listData.add("Flat dumbbell press");
                listData.add("Declined dumbbell press");
                listData.add("Dumbbell flyes");
                listData.add("Pushups");*/
                Cursor data = myDB1.getDataexer2();
                //ArrayList<String> listData = new ArrayList<>();
                while(data.moveToNext()){
                    //get the value from the database in column 1
                    //then add it to the ArrayList
                    listData.add(data.getString(1));
                }
                //create the list adapter and set the adapter
                ListAdapter adapter = new ArrayAdapter<>(plan.this, android.R.layout.simple_list_item_1, listData);
                listView.setAdapter(adapter);

                //  plan.this.listData.add(e);

                listView.setAdapter(adapter);
                e1.setText("");
                e2.setText("");
            }
        });
        Cursor data = myDB1.getDataexer2();
        //ArrayList<String> listData = new ArrayList<>();
        while(data.moveToNext()){
            //get the value from the database in column 1
            //then add it to the ArrayList
            listData.add(data.getString(1));
        }
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(plan.this,detail.class);
                intent.putExtra("Ename", listView.getItemAtPosition(position).toString());
                startActivity(intent);
            }
        });
    }
    public void arms(){
        listData.add("Curls");
        listData.add("Hammer Curls");
        listData.add("Tricep pull down");
        listData.add("Bend over curls");

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                InputMethodManager im = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                im.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);
                String e, video;
                e = e1.getText().toString();
                video = e2.getText().toString();
                myDB1.addDataexer3(e,video);
                if("".equals(e)||e==null||"".equals(video)||video==null){
                    Toast.makeText(plan.this, "Please enter both exercise name and VideoID", Toast.LENGTH_LONG).show();
                }
              /*  listData.add("Inclined dumbbell press");
                listData.add("Flat dumbbell press");
                listData.add("Declined dumbbell press");
                listData.add("Dumbbell flyes");
                listData.add("Pushups");*/
                Cursor data = myDB1.getDataexer3();
                //ArrayList<String> listData = new ArrayList<>();
                while(data.moveToNext()){
                    //get the value from the database in column 1
                    //then add it to the ArrayList
                    listData.add(data.getString(1));
                }
                //create the list adapter and set the adapter
                ListAdapter adapter = new ArrayAdapter<>(plan.this, android.R.layout.simple_list_item_1, listData);
                listView.setAdapter(adapter);

                //  plan.this.listData.add(e);

                listView.setAdapter(adapter);
                e1.setText("");
                e2.setText("");
            }
        });
        Cursor data = myDB1.getDataexer3();
        //ArrayList<String> listData = new ArrayList<>();
        while(data.moveToNext()){
            //get the value from the database in column 1
            //then add it to the ArrayList
            listData.add(data.getString(1));
        }
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(plan.this,detail.class);
                intent.putExtra("Ename", listView.getItemAtPosition(position).toString());
                startActivity(intent);
            }
        });
    }
    public void back(){
        listData.add("Dead lift");
        listData.add("Latch pull down");
        listData.add("Bend over rows");
        listData.add("Dumbbell Shrugs");
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                InputMethodManager im = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                im.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);
                String e, video;
                e = e1.getText().toString();
                video = e2.getText().toString();
                myDB1.addDataexer4(e,video);
                if("".equals(e)||e==null||"".equals(video)||video==null){
                    Toast.makeText(plan.this, "Please enter both exercise name and VideoID", Toast.LENGTH_LONG).show();
                }
                e1.setText("");
                e2.setText("");
              /*  listData.add("Inclined dumbbell press");
                listData.add("Flat dumbbell press");
                listData.add("Declined dumbbell press");
                listData.add("Dumbbell flyes");
                listData.add("Pushups");*/
                Cursor data = myDB1.getDataexer4();
                //ArrayList<String> listData = new ArrayList<>();
                while(data.moveToNext()){
                    //get the value from the database in column 1
                    //then add it to the ArrayList
                    listData.add(data.getString(1));
                }
                //create the list adapter and set the adapter
                ListAdapter adapter = new ArrayAdapter<>(plan.this, android.R.layout.simple_list_item_1, listData);
                listView.setAdapter(adapter);

                //  plan.this.listData.add(e);

                listView.setAdapter(adapter);
            }
        });
        Cursor data = myDB1.getDataexer4();
        //ArrayList<String> listData = new ArrayList<>();
        while(data.moveToNext()){
            //get the value from the database in column 1
            //then add it to the ArrayList
            listData.add(data.getString(1));
        }
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(plan.this,detail.class);
                intent.putExtra("Ename", listView.getItemAtPosition(position).toString());
                startActivity(intent);
            }
        });
    }
}
