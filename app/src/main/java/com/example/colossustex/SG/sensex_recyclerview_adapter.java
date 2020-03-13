package com.example.colossustex.SG;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.colossustex.R;

import java.util.ArrayList;

public class sensex_recyclerview_adapter extends RecyclerView.Adapter<sensex_recyclerview_adapter.ViewHolder> {

    private ArrayList<String> headings = new ArrayList<>();
    // anything other you want to pass
    private Context context;

    public sensex_recyclerview_adapter(ArrayList<String> headings, Context context) {
        this.headings = headings;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sensex_card, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.head_sensex.setText(headings.get(position));
    }

    @Override
    public int getItemCount() {
        return headings.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView head_sensex;
        LinearLayout parentlayout = itemView.findViewById(R.id.sensex_layout1);
        //Something for list to be added here...
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            head_sensex = itemView.findViewById(R.id.head_sensex);
            parentlayout =  itemView.findViewById(R.id.sensex_layout1);

        }
    }

}
