package com.example.colossustex.SG;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.colossustex.R;

import java.util.ArrayList;

public class sub_sensex_adapter extends RecyclerView.Adapter<sub_sensex_adapter.sub_holder>{

    sub_sensex_info info = null;
    Context context;

    public sub_sensex_adapter(sub_sensex_info info, Context context) {
        this.info = info;
        this.context = context;
    }

    @NonNull
    @Override
    public sub_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sub_sensex_card, parent, false);
        sub_holder holder = new sub_holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull sub_holder holder, int position) {
        holder.sub_heading.setText(info.sub_heading);
        holder.sub_price.setText(info.sub_price);
        holder.sub_time.setText(info.sub_time);
        holder.sub_title.setText(info.sub_title);
        holder.sub_change.setText(info.sub_change);
        holder.sub_ultimate_change.setText(info.sub_ultimate_change);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class sub_holder extends RecyclerView.ViewHolder {
        TextView sub_heading, sub_price, sub_time, sub_title, sub_change, sub_ultimate_change;
        public sub_holder(@NonNull View itemView) {
            super(itemView);
            sub_heading = itemView.findViewById(R.id.sub_heading);
            sub_price = itemView.findViewById(R.id.sub_price);
            sub_time = itemView.findViewById(R.id.sub_time);
            sub_title = itemView.findViewById(R.id.sub_title);
            sub_change = itemView.findViewById(R.id.sub_change);
            sub_ultimate_change = itemView.findViewById(R.id.sub_ultimate_change);
        }
    }
}
