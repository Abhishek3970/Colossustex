package com.example.colossustex.SG;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.colossustex.R;

import java.util.ArrayList;

public class yarn_offers_adapter extends RecyclerView.Adapter<yarn_offers_adapter.Viewholder> {

    private static final String TAG = "ProgrammingAdapter";

    private ArrayList<String> heading = new ArrayList<>();
    private ArrayList<String> content = new ArrayList<>();
    private Context context;

    public yarn_offers_adapter(ArrayList<String> heading, ArrayList<String> content, Context context) {
        this.heading = heading;
        this.content = content;
        this.context = context;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.yarn_offers_card, parent, false);
        Viewholder holder = new Viewholder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final Viewholder holder, int position) {

        Log.d(TAG, "onBindViewHolder: called.");

        holder.heading.setText(heading.get(position));
        holder.content.setText(content.get(position));

        holder.contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Segment made separately to be attach here", Toast.LENGTH_SHORT).show();
            }
        });
        holder.Contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Segment made separately to be attach here", Toast.LENGTH_SHORT).show();
            }
        });
        holder.share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT,"Subject");
                intent.putExtra(Intent.EXTRA_TEXT, "text");
                context.startActivity(Intent.createChooser(intent, "Share using"));
            }
        });
        holder.Share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT,"Subject");
                intent.putExtra(Intent.EXTRA_TEXT, "text");
                context.startActivity(Intent.createChooser(intent, "Share using"));
            }
        });
    }

    @Override
    public int getItemCount() {
        return heading.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder{

        TextView heading, content, contact, share;
        ImageView Contact, Share;
        CardView parentlayout;

        public Viewholder(@NonNull View itemView) {
            super(itemView);

            heading = itemView.findViewById(R.id.textView);
            content = itemView.findViewById(R.id.textView3);
            contact = itemView.findViewById(R.id.textView4);
            share = itemView.findViewById(R.id.textView5);
            Contact = itemView.findViewById(R.id.imageView2);
            Share = itemView.findViewById(R.id.imageView3);
            parentlayout = itemView.findViewById(R.id.parent_layout);
        }
    }

}

