package com.example.colossustex.SG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.colossustex.R;

public class brain extends AppCompatActivity {

    ImageView news, stocks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brain);

        news = findViewById(R.id.news);
        stocks = findViewById(R.id.stocks);

        news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {startActivity(new Intent(brain.this, Textile_News.class)); }
        });

        stocks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { startActivity(new Intent(brain.this, sensex_SG.class)); }
        });

    }
}
