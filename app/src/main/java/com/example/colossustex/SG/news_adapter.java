package com.example.colossustex.SG;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.colossustex.R;

import java.util.ArrayList;

public class news_adapter extends RecyclerView.Adapter<news_adapter.Viewholder>{
    private static final String TAG = "ProgrammingAdapter";
    private ArrayList<String> desk = new ArrayList<>();
    private ArrayList<String> place = new ArrayList<>();
    private ArrayList<String> news = new ArrayList<>();
    private ArrayList<String> time = new ArrayList<>();
    private Context context;

    public news_adapter(ArrayList<String> desk, ArrayList<String> place, ArrayList<String> news, ArrayList<String> time, Context context) {
        this.desk = desk;
        this.place = place;
        this.news = news;
        this.time = time;
        this.context = context;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_card, parent, false);
        Viewholder holder = new Viewholder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {

        holder.desk.setText(desk.get(position));
        holder.place.setText(place.get(position));
        holder.news.setText(news.get(position));
        holder.time.setText(time.get(position));

        holder.txt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT,"Subject");
                intent.putExtra(Intent.EXTRA_TEXT, "text");
                context.startActivity(Intent.createChooser(intent, "Share using"));
            }
        });

    }

    @Override
    public int getItemCount() {
        return desk.size();
    }


    public class Viewholder extends RecyclerView.ViewHolder {

        ImageView img, image, img4;
        TextView desk, place, news, txt9, time;


        public Viewholder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imageView);
            image = itemView.findViewById(R.id.imageView2);
            img4 = itemView.findViewById(R.id.imageView4);
            news = itemView.findViewById(R.id.textView3);
            desk = itemView.findViewById(R.id.textView6);
            place = itemView.findViewById(R.id.textView7);
            txt9 = itemView.findViewById(R.id.textView9);
            time = itemView.findViewById(R.id.textView10);
        }
    }

}
