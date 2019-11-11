package com.example.menudigital;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.example.menudigital.Utils.act_choice_small;

public class Choices extends AppCompatActivity {
    String sex, age, act;
    List<Integer> img = new ArrayList<>();
    List<Integer> cant = new ArrayList<>();
    List<String> nom = new ArrayList<>();
    List<Integer> cal = new ArrayList<>();
    public static String PUBLIC_STATIC_STRING_IDENTIFIER = "myidentifier";
    RecyclerView rv;
    RecyclerView.Adapter mAdapter;
    Button calculate;

    int chosen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choices);
        // toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // add back arrow to toolbar
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        sex = getIntent().getStringExtra("sex_chosen");
        age = getIntent().getStringExtra("age_chosen");
        act = getIntent().getStringExtra("act_chosen");
        chosen = getIntent().getIntExtra("chosen", -1);
        calculate = findViewById(R.id.calcular);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Choices.this);
                builder.setTitle("Consumo de calorías");
                int alim = Utils.calculoAlimentos(cant);
                System.out.println(sex + " " + age + " " + act);
                int consumo_max = Utils.calculoTotal(sex, age, act);
                System.out.println("Consumo de menu:" + alim);
                System.out.println("Consumo total:" + consumo_max);
                float percentage = (float)alim/consumo_max;
                DecimalFormat df = new DecimalFormat("##.##%");
                String formattedPercent = df.format(percentage);
                System.out.println("Percentage:" + formattedPercent);
                builder.setMessage("");
                AlertDialog alert = builder.create();
                alert.show();
            }
        });


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MenuActivity.class);
                startActivityForResult(i, 1);
            }
        });

        img = Arrays.asList(Utils.images);
        cant = Arrays.asList(Utils.cant);
        nom = Arrays.asList(Utils.food_names);
        cal = Arrays.asList(Utils.cal);

        rv = (RecyclerView)findViewById(R.id.recyclerView);
        mAdapter = new MyRecyclerView(this, img, cant, nom, cal);
        rv.setAdapter(mAdapter);
        rv.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK) {
                int chosen = data.getIntExtra("chosen", -1);
                int prev_cant = cant.get(chosen);
                cant.set(chosen, prev_cant + 1);
                mAdapter.notifyDataSetChanged();
            }
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }
}
