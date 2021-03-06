package com.example.colossustex.SG;


import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.colossustex.R;

import java.util.ArrayList;

public class news_adapter extends RecyclerView.Adapter<news_adapter.Viewholder>{
    private static final String TAG = "ProgrammingAdapter";
    private ArrayList<String>  heading = new ArrayList<>();
    private ArrayList<String> place = new ArrayList<>();
    private ArrayList<String> news = new ArrayList<>();
    private ArrayList<String> time = new ArrayList<>();
    private ArrayList<String> name = new ArrayList<>();
    private Context context;

    public news_adapter(ArrayList<String> desk, ArrayList<String> place, ArrayList<String> news, ArrayList<String> time, ArrayList<String> name, Context context) {
        this.heading = desk;
        this.place = place;  // todo
        this.news = news;
        this.time = time;
        this.name = name;
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
    public void onBindViewHolder(@NonNull Viewholder holder, final int position) {

        holder.heading.setText(heading.get(position));
        holder.name.setText(name.get(position));
//        holder.place.setText(place.get(position));
        holder.news.setText(news.get(position));
        holder.time.setText(time.get(position));

//        holder.txt9.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Intent.ACTION_SEND);intent.setType("text/plain");
//                intent.putExtra(Intent.EXTRA_SUBJECT,"Subject");
//                intent.putExtra(Intent.EXTRA_TEXT, "text");
//                context.startActivity(Intent.createChooser(intent, "Share using"));
//            }
//        });

        holder.img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT,place.get(position));
                intent.putExtra(Intent.EXTRA_TEXT, place.get(position));
                intent.putExtra(intent.EXTRA_TITLE, heading.get(position));
                context.startActivity(Intent.createChooser(intent, "Share news via :"));
            }
        });

    }

    @Override
    public int getItemCount() {
        return heading.size();
    }


    public class Viewholder extends RecyclerView.ViewHolder {

        ImageView img, image, img4;
        TextView heading, place, news, txt9, time, name;


        public Viewholder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.news_top);
            img = itemView.findViewById(R.id.imageView);
            image = itemView.findViewById(R.id.imageView2);
            img4 = itemView.findViewById(R.id.imageView4);
            news = itemView.findViewById(R.id.textView3);
            heading = itemView.findViewById(R.id.news_heading);
//            place = itemView.findViewById(R.id.textView7);
//            txt9 = itemView.findViewById(R.id.textView9);
            time = itemView.findViewById(R.id.textView10);
        }
    }

}
