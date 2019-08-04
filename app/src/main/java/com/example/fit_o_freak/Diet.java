package com.example.fit_o_freak;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Diet extends AppCompatActivity {
Button b1,b2;
ListView l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet);
        b1 = findViewById(R.id.body);
        b2= findViewById(R.id.lean);
        l = findViewById(R.id.listv);
        final ArrayList<String> listData = new ArrayList<>();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listData.add("Meal 1 Breakfast\n" +

                        "Quarter Cup Oat meal make with water mix, one table spoon peanut butter, 1 cup mix fruits");
                listData.add("Meal 2 Snacks\n" +
                        "\n" +
                        "1 cup rice puffs and green tea with lemon");
                listData.add("Meal 3 Lunch\n" +
                        "\n" +
                        "2 whole wheat Roti\n" +
                        "1 cup cooked Daal\n" +
                        "1 cup Cucumber");
                listData.add("Meal 4 Snacks\n" +
                        "\n" +
                        "100gm backed potato\n" +
                        "10 Almonds");
                listData.add("Meal 5 Dinner\n" +
                        "\n" +
                        "100 gm Tofu\n" +
                        "1 cup mix Salad\n" +
                        "70 Gm Sweet potato");
                listData.add("Meal 6\n" +
                        "1 Scoop Protein and Apple");
                ListAdapter adapter = new ArrayAdapter<>(Diet.this, android.R.layout.simple_list_item_1, listData);
                l.setAdapter(adapter);
            }

        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listData.add("Meal 1 Breakfast\n" +

                        "45g oats with 300ml skimmed milk and 1tsp honey; 200ml apple juice.");
                listData.add("Meal 2 Snacks\n" +
                        "\n" +
                        "120g low-fat yoghurt with blueberries and honey");
                listData.add("Meal 3 Lunch\n" +
                        "\n" +
                        "Grilled chicken (1 chicken breast) salad sandwich with wholemeal bread");
                listData.add("Meal 4 Snacks\n" +
                        "\n" +
                        "Smoothie – blend 25g whey protein, 80g raspberries, 80g blueberries, 50g blackberries and water.");
                listData.add("Meal 5 Dinner\n" +
                        "\n" +
                        "120g tuna steak with stir-fried broccoli, mushrooms, green beans, sesame seeds and oil; 70g brown rice.");
                listData.add("Meal 6\n" +
                        "250ml skimmed milk.");
                ListAdapter adapter = new ArrayAdapter<>(Diet.this, android.R.layout.simple_list_item_1, listData);
                l.setAdapter(adapter);
            }

        });
    }
}
