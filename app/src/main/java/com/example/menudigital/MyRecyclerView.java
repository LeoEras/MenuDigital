package com.example.menudigital;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyRecyclerView extends RecyclerView.Adapter<MyRecyclerView.ViewHolder> {

    private List<Integer> img;
    private List<Integer> cant;
    private List<String> nombre;
    private List<Integer> calorías;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    // data is passed into the constructor
    MyRecyclerView(Context context, List<Integer> img, List<Integer> cant, List<String> nom, List<Integer> cal) {
        this.mInflater = LayoutInflater.from(context);
        this.img = img;
        this.cant = cant;
        this.nombre = nom;
        this.calorías = cal;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.food_item, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        RecyclerView.LayoutParams param = (RecyclerView.LayoutParams)holder.itemView.getLayoutParams();
        if(cant.get(position) > 0){
            param.height = LinearLayout.LayoutParams.WRAP_CONTENT;
            param.width = LinearLayout.LayoutParams.MATCH_PARENT;
            holder.itemView.setVisibility(View.VISIBLE);
            holder.imageView.setImageResource(Utils.images[position]);
            holder.food_name.setText(Utils.food_names[position]);
            holder.food_calories.setText(Utils.cal[position] + "");
            holder.food_quant.setText(cant.get(position) + "");
        } else {
            holder.itemView.setVisibility(View.GONE);
            param.height = 0;
            param.width = 0;
        }
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return nombre.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView;
        TextView food_name, food_calories, food_quant;
        Button btn;

        ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.food_icon);
            food_name = itemView.findViewById(R.id.food_name);
            food_calories = itemView.findViewById(R.id.cal);
            food_quant = itemView.findViewById(R.id.cant);
            btn = itemView.findViewById(R.id.remove);
            btn.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int index = getAdapterPosition();
            int value = cant.get(index);
            cant.set(index, value - 1);
            notifyDataSetChanged();
        }
    }

    // convenience method for getting data at click position
    String getItem(int id) {
        return nombre.get(id);
    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}