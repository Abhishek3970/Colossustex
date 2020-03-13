package com.example.colossustex.SG;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.colossustex.MainActivity;
import com.example.colossustex.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Textile_News extends AppCompatActivity {

    ArrayList<String> heading = new ArrayList<>();
    ArrayList<String> place = new ArrayList<>();
    ArrayList<String> news = new ArrayList<>();
    ArrayList<String> time = new ArrayList<>();
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textile__news);
        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Textile_News.this, MainActivity.class));
            }
        });

        DatabaseReference dbr2 = FirebaseDatabase.getInstance().getReference().child("Textile News");

        dbr2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){

                    news_info info = snapshot.getValue(news_info.class);
                    if(info!=null){
                        heading.add(info.getName());
                        news.add(info.getNews());
                        place.add(info.getPlace());
                        time.add(info.getTime());
                    }

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(Textile_News.this, "Data load failed", Toast.LENGTH_SHORT).show();
            }
        });

        startadapter();
    }

//    private void setall() {
//
//        desk.add("YarnLIVE News Desk");
//        place.add("Delhi");
//        news.add("Below are Reinhart's cotton offer prices for today, 14th Feb 2020. To purchase cotton bales from Reinhart, please email Mr Vimal Verma on v.verma@reinhart.in");
//        time.add("Yesterday, 1:43 PM");
//
//        desk.add("YarnLIVE News Desk");
//        place.add("Delhi");
//        news.add("Below are Reinhart's cotton offer prices for today, 14th Feb 2020. To purchase cotton bales from Reinhart, please email Mr Vimal Verma on v.verma@reinhart.in");
//        time.add("Yesterday, 1:43 PM");
//
//        desk.add("YarnLIVE News Desk");
//        place.add("Delhi");
//        news.add("Below are Reinhart's cotton offer prices for today, 14th Feb 2020. To purchase cotton bales from Reinhart, please email Mr Vimal Verma on v.verma@reinhart.in");
//        time.add("Yesterday, 1:43 PM");
//
//        desk.add("YarnLIVE News Desk");
//        place.add("Delhi");
//        news.add("Below are Reinhart's cotton offer prices for today, 14th Feb 2020. To purchase cotton bales from Reinhart, please email Mr Vimal Verma on v.verma@reinhart.in");
//        time.add("Yesterday, 1:43 PM");
//
//        desk.add("YarnLIVE News Desk");
//        place.add("Delhi");
//        news.add("Below are Reinhart's cotton offer prices for today, 14th Feb 2020. To purchase cotton bales from Reinhart, please email Mr Vimal Verma on v.verma@reinhart.in");
//        time.add("Yesterday, 1:43 PM");
//
//        desk.add("YarnLIVE News Desk");
//        place.add("Delhi");
//        news.add("Below are Reinhart's cotton offer prices for today, 14th Feb 2020. To purchase cotton bales from Reinhart, please email Mr Vimal Verma on v.verma@reinhart.in");
//        time.add("Yesterday, 1:43 PM");
//
//        startadapter();
//
//    }

    private void startadapter() {
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        news_adapter adapter = new news_adapter(heading, place, news, time, Textile_News.this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(Textile_News.this));
    }
}
