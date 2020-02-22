package com.example.colossustex.SG;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.colossustex.MainActivity;
import com.example.colossustex.R;

import java.util.ArrayList;

public class Textile_News extends AppCompatActivity {

    ArrayList<String> desk = new ArrayList<>();
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
        setall();
    }

    private void setall() {

        desk.add("YarnLIVE News Desk");
        place.add("Delhi");
        news.add("Below are Reinhart's cotton offer prices for today, 14th Feb 2020. To purchase cotton bales from Reinhart, please email Mr Vimal Verma on v.verma@reinhart.in");
        time.add("Yesterday, 1:43 PM");

        desk.add("YarnLIVE News Desk");
        place.add("Delhi");
        news.add("Below are Reinhart's cotton offer prices for today, 14th Feb 2020. To purchase cotton bales from Reinhart, please email Mr Vimal Verma on v.verma@reinhart.in");
        time.add("Yesterday, 1:43 PM");

        desk.add("YarnLIVE News Desk");
        place.add("Delhi");
        news.add("Below are Reinhart's cotton offer prices for today, 14th Feb 2020. To purchase cotton bales from Reinhart, please email Mr Vimal Verma on v.verma@reinhart.in");
        time.add("Yesterday, 1:43 PM");

        desk.add("YarnLIVE News Desk");
        place.add("Delhi");
        news.add("Below are Reinhart's cotton offer prices for today, 14th Feb 2020. To purchase cotton bales from Reinhart, please email Mr Vimal Verma on v.verma@reinhart.in");
        time.add("Yesterday, 1:43 PM");

        desk.add("YarnLIVE News Desk");
        place.add("Delhi");
        news.add("Below are Reinhart's cotton offer prices for today, 14th Feb 2020. To purchase cotton bales from Reinhart, please email Mr Vimal Verma on v.verma@reinhart.in");
        time.add("Yesterday, 1:43 PM");

        desk.add("YarnLIVE News Desk");
        place.add("Delhi");
        news.add("Below are Reinhart's cotton offer prices for today, 14th Feb 2020. To purchase cotton bales from Reinhart, please email Mr Vimal Verma on v.verma@reinhart.in");
        time.add("Yesterday, 1:43 PM");

        startadapter();

    }

    private void startadapter() {
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        news_adapter adapter = new news_adapter(desk, place, news, time, Textile_News.this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(Textile_News.this));
    }
}
