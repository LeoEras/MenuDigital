package com.example.menudigital;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import static android.app.Activity.RESULT_OK;

public class MyRecyclerView2 extends RecyclerView.Adapter<MyRecyclerView2.ViewHolder> {

    private Activity act;
    private List<String> nombre;
    private List<Integer> calorías;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    // data is passed into the constructor
    MyRecyclerView2(Activity context, List<String> nom, List<Integer> cal) {
        this.act = context;
        this.mInflater = LayoutInflater.from(context);
        this.nombre = nom;
        this.calorías = cal;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.food_item_menu, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.imageView.setImageResource(Utils.images[position]);
        holder.food_name.setText(nombre.get(position));
        holder.food_calories.setText(calorías.get(position) +  "");
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return nombre.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView;
        TextView food_name, food_calories;
        Button btn;

        ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.food_icon);
            food_name = itemView.findViewById(R.id.food_name);
            food_calories = itemView.findViewById(R.id.cal);
            btn = itemView.findViewById(R.id.add);
            btn.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent resultIntent = new Intent();
            resultIntent.putExtra("chosen", getAdapterPosition());
            act.setResult(RESULT_OK, resultIntent);
            act.finish();
        }
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}