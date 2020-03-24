package com.example.colossustex.SG.sensex_adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.colossustex.R;
import com.example.colossustex.SG.interface_firebase.ItemClickListener;
import com.example.colossustex.SG.model.ItemData;

import java.util.List;

public class MyItemAdapter extends RecyclerView.Adapter<MyItemAdapter.MyViewHolder> {

    private Context context;
    private List<ItemData> itemDataList;

    public MyItemAdapter(Context context, List<ItemData> itemDataList) {
        this.context = context;
        this.itemDataList = itemDataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.sub_sensex_card, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.sub_heading.setText(itemDataList.get(position).getSub_heading());
        holder.sub_price.setText(itemDataList.get(position).getSub_price());
        holder.sub_time.setText(itemDataList.get(position).getSub_time());
        holder.sub_title.setText(itemDataList.get(position).getSub_title());
        holder.sub_change.setText(itemDataList.get(position).getSub_change());
        holder.sub_ultimate.setText(itemDataList.get(position).getSub_ultimate());
    }

    @Override
    public int getItemCount() {
        return (itemDataList != null ? itemDataList.size() : 0);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView sub_heading;
        TextView sub_price;
        TextView sub_time;
        TextView sub_title;
        TextView sub_change;
        TextView sub_ultimate;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            sub_heading = itemView.findViewById(R.id.sub_heading);
            sub_price = itemView.findViewById(R.id.sub_price);
            sub_time = itemView.findViewById(R.id.sub_time);
            sub_title = itemView.findViewById(R.id.sub_title);
            sub_change = itemView.findViewById(R.id.sub_change);
            sub_ultimate = itemView.findViewById(R.id.sub_ultimate_change);


        }
    }
}
