package com.example.colossustex.SG;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.colossustex.R;

import java.util.ArrayList;

import kotlin.jvm.internal.Ref;

public class posted_card_adapter extends RecyclerView.Adapter<posted_card_adapter.Viewholder>{

    private ArrayList<String> number = new ArrayList<>();
    private ArrayList<String> details = new ArrayList<>();
    Context context;

    public posted_card_adapter(ArrayList<String> number, ArrayList<String> details, Context context) {
        this.number = number;
        this.details = details;
        this.context = context;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.req_card, parent, false);       //make card and call adapter
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final Viewholder holder, final int position) {
        holder.number.setText(number.get(position));
        holder.details.setText(details.get(position));
        holder.cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.card.setVisibility(View.GONE);
            }
        });
//        holder.req.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                Toast.makeText(context, details.get(position), Toast.LENGTH_SHORT).show();
//                final Ref.ObjectRef dialog = new Ref.ObjectRef<>();
//                dialog.element = new Dialog(context);
//                holder.data.setText(details.get(position));
//                ((Dialog)dialog.element).setContentView(R.layout.show_req);
//            }
//        });
//        holder.details.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                final Ref.ObjectRef dialog = new Ref.ObjectRef<>();
//                dialog.element = new Dialog(context);
//                holder.data.setText(details.get(position));
//                ((Dialog)dialog.element).setContentView(R.layout.show_req);
//            }
//        });
    }

    @Override
    public int getItemCount(){ return number.size(); }

    public class Viewholder extends RecyclerView.ViewHolder{
        TextView number, details, cross, data;
        RelativeLayout card;
        LinearLayout req;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            number = itemView.findViewById(R.id.number);
            details = itemView.findViewById(R.id.details);
            cross = itemView.findViewById(R.id.cross);
            req = itemView.findViewById(R.id.req);
            card = itemView.findViewById(R.id.card);
            data = itemView.findViewById(R.id.datum);
        }
    }
}
