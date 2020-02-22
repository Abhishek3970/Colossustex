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

public class yarn_offers extends AppCompatActivity {

    ArrayList<String> headings = new ArrayList<>();
    ArrayList<String> contents = new ArrayList<>();
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yarn_offers);
        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(yarn_offers.this, MainActivity.class));
            }
        });
        setContents();

    }

    private void setContents(){
        headings.add("Open End Waxed Yarn for Knitting");
        contents.add("We can offer 100% cotton open end waxed yarn for knitting. Count available is 24s. Can even make 30s if required. The mill is located in North India." +
                "" +
                "Please email oon support@yarnlive.com or whatsapp on 9876543210 if you have any questions." +
                "" +
                "Thank you");
        headings.add("Open End Waxed Yarn for Knitting");
        contents.add("We can offer 100% cotton open end waxed yarn for knitting. Count available is 24s. Can even make 30s if required. The mill is located in North India." +
                "" +
                "Please email oon support@yarnlive.com or whatsapp on 9876543210 if you have any questions." +
                "" +
                "Thank you");
        headings.add("Open End Waxed Yarn for Knitting");
        contents.add("We can offer 100% cotton open end waxed yarn for knitting. Count available is 24s. Can even make 30s if required. The mill is located in North India." +
                "" +
                "Please email oon support@yarnlive.com or whatsapp on 9876543210 if you have any questions." +
                "" +
                "Thank you");
        headings.add("Open End Waxed Yarn for Knitting");
        contents.add("We can offer 100% cotton open end waxed yarn for knitting. Count available is 24s. Can even make 30s if required. The mill is located in North India." +
                "" +
                "Please email oon support@yarnlive.com or whatsapp on 9876543210 if you have any questions." +
                "" +
                "Thank you");
        headings.add("Open End Waxed Yarn for Knitting");
        contents.add("We can offer 100% cotton open end waxed yarn for knitting. Count available is 24s. Can even make 30s if required. The mill is located in North India." +
                "" +
                "Please email oon support@yarnlive.com or whatsapp on 9876543210 if you have any questions." +
                "" +
                "Thank you");
        headings.add("Open End Waxed Yarn for Knitting");
        contents.add("We can offer 100% cotton open end waxed yarn for knitting. Count available is 24s. Can even make 30s if required. The mill is located in North India." +
                "" +
                "Please email oon support@yarnlive.com or whatsapp on 9876543210 if you have any questions." +
                "" +
                "Thank you");
        headings.add("Open End Waxed Yarn for Knitting");
        contents.add("We can offer 100% cotton open end waxed yarn for knitting. Count available is 24s. Can even make 30s if required. The mill is located in North India." +
                "" +
                "Please email oon support@yarnlive.com or whatsapp on 9876543210 if you have any questions." +
                "" +
                "Thank you");


        initializeRV();
    }

    private void initializeRV(){
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        yarn_offers_adapter adapter = new yarn_offers_adapter(headings, contents, yarn_offers.this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(yarn_offers.this));
    }

}
