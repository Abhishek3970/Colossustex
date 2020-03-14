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
        MyViewHolder.sub_heading.setText(itemDataList.get(position).getSub_heading());
        MyViewHolder.sub_price.setText(itemDataList.get(position).getSub_price().toString());
        MyViewHolder.sub_time.setText(itemDataList.get(position).getSub_time());
        MyViewHolder.sub_title.setText(itemDataList.get(position).getSub_title());
        MyViewHolder.sub_change.setText(itemDataList.get(position).getSub_change());
        MyViewHolder.sub_ultimate.setText(itemDataList.get(position).getSub_ultimate());
    }

    @Override
    public int getItemCount() {
        return (itemDataList != null ? itemDataList.size() : 0);
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        static TextView sub_heading;
        static TextView sub_price;
        static TextView sub_time;
        static TextView sub_title;
        static TextView sub_change;
        static TextView sub_ultimate;
        ItemClickListener itemClickListener;

        public void getitemClickListener(ItemClickListener itemClickListener){
            this.itemClickListener = itemClickListener;
        }

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            sub_heading = itemView.findViewById(R.id.sub_heading);
            sub_price = itemView.findViewById(R.id.sub_price);
            sub_time = itemView.findViewById(R.id.sub_time);
            sub_title = itemView.findViewById(R.id.sub_title);
            sub_change = itemView.findViewById(R.id.sub_change);
            sub_ultimate = itemView.findViewById(R.id.sub_ultimate_change);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
        itemClickListener.onItemClickListener(v, getAdapterPosition());
        }
    }
}
