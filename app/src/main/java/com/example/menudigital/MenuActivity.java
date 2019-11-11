package com.example.menudigital;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {
    ArrayList<String> nom = new ArrayList<>();
    ArrayList<Integer> cal = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Intent inte = new Intent();

        load_names(nom);
        load_cal(cal);

        RecyclerView rv = (RecyclerView)findViewById(R.id.rv);
        rv.setAdapter(new MyRecyclerView2(this, nom, cal));
        rv.setLayoutManager(new LinearLayoutManager(this));
    }



    private void load_names(ArrayList<String> name){
        name.clear();
        name.add("Empanada de queso");
        name.add("Empanada de pollo");
        name.add("Tortilla de verde con queso");
        name.add("Papa con carne");
        name.add("Arepas de pollo");
        name.add("Tortilla de choclo con queso");
        name.add("Sánduche de atún");
        name.add("Sánduche de pollo");
        name.add("Submarino de jamón con queso y vegetales");
        name.add("Tostada de queso");
        name.add("Tostada mixta");
        name.add("Bolón con queso");
        name.add("Bolón de maduro");
        name.add("Hamburguesa");
        name.add("Choclo con queso cocinado");
        name.add("Pizza con jamón y queso");
        name.add("Canguil");
        name.add("Gelatina");
        name.add("Ensalada de fruta");
    }

    private void load_cal(ArrayList<Integer> cal) {
        cal.clear();
        cal.add(322);
        cal.add(247);
        cal.add(252);
        cal.add(159);
        cal.add(160);
        cal.add(252);
        cal.add(247);
        cal.add(168);
        cal.add(280);
        cal.add(223);
        cal.add(140);
        cal.add(211);
        cal.add(160);
        cal.add(129);
        cal.add(104);
        cal.add(174);
        cal.add(79);
        cal.add(201);
        cal.add(43);
    }
}
