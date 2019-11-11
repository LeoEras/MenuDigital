package com.example.menudigital;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.menudigital.Utils.act_choice;
import static com.example.menudigital.Utils.act_choice_small;
import static com.example.menudigital.Utils.age_choice;
import static com.example.menudigital.Utils.sex_choice;

public class MainActivity extends AppCompatActivity {
    Button sex_btn, age_btn, act_btn, next_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sex_btn = findViewById(R.id.sex_btn);
        age_btn = findViewById(R.id.age_btn);
        act_btn = findViewById(R.id.act_btn);
        next_btn = findViewById(R.id.next);

        showListForButtons("Seleccione su sexo", sex_btn, sex_choice);
        showListForButtons("Seleccione su edad", age_btn, age_choice);
        showListForButtons("Seleccione su tipo de actividad", act_btn, act_choice);

        next_action(next_btn, sex_btn, age_btn, act_btn);
    }

    private void showListForButtons(final String title, final Button btn, final String[] data) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle(title)
                        .setItems(data, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                if(data.length == 3){
                                    btn.setText(act_choice_small[which]);
                                } else {
                                    btn.setText(data[which]);
                                }
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }

    private void next_action(Button next, final Button btn1, final Button btn2, final Button btn3){
        next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(btn1.getText().equals("") || btn2.getText().equals("")|| btn3.getText().equals("")){
                    Toast.makeText(getApplicationContext(), R.string.missing_fields, Toast.LENGTH_LONG).show();
                } else {
                    Intent next_activity = new Intent(getApplicationContext(), Choices.class);
                    next_activity.putExtra("sex_chosen", btn1.getText());
                    next_activity.putExtra("age_chosen", btn2.getText());
                    next_activity.putExtra("act_chosen", btn3.getText());
                    startActivity(next_activity);
                }
            }
        });

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString("sex_selected", (String)sex_btn.getText());
        savedInstanceState.putString("age_selected", (String)age_btn.getText());
        savedInstanceState.putString("act_selected", (String)act_btn.getText());
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        sex_btn.setText(savedInstanceState.getString("sex_selected"));
        age_btn.setText(savedInstanceState.getString("age_selected"));
        act_btn.setText(savedInstanceState.getString("act_selected"));
    }
}
