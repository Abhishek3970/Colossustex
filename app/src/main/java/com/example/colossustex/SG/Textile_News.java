package com.example.colossustex.SG;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.colossustex.MainActivity;
import com.example.colossustex.R;
import com.example.colossustex.SG.interface_firebase.FirebaseLoadListener;
import com.example.colossustex.SG.model.ItemGroup;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Textile_News extends AppCompatActivity {

    ArrayList<String> heading = new ArrayList<>();
    ArrayList<String> place = new ArrayList<>();
    ArrayList<String> news = new ArrayList<>();
    ArrayList<String> time = new ArrayList<>();
    ArrayList<String> nameArr = new ArrayList<>();

    ImageView back;
    TextView Refresh_button;
    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textile__news);
        back = findViewById(R.id.back);
        Refresh_button = findViewById(R.id.refresh_layout);
        mQueue = Volley.newRequestQueue(this);

        parse_data();////////makes double click problem for refresh method removed!!!!!!!!!!!

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Textile_News.this, MainActivity.class));
                finishAffinity();
            }
        });

        Refresh_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parse_data();
            }
        });


//        class Aclass{
//            private void load_data(){
//                Toast.makeText(Textile_News.this, "Function called successfully", Toast.LENGTH_SHORT).show();
//                parse_data();
//            }
//        }
//
//        new Aclass().load_data();


//        DatabaseReference dbr2 = FirebaseDatabase.getInstance().getReference().child("Textile News");
//
//        dbr2.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
//
//                    news_info info = snapshot.getValue(news_info.class);
//                    if(info!=null){
//                        heading.add(info.getName());
//                        news.add(info.getNews());
//                        place.add(info.getPlace());
//                        time.add(info.getTime());
//                    }
//                    startadapter();
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//                Toast.makeText(Textile_News.this, "Data load failed", Toast.LENGTH_SHORT).show();
//            }
//        });
//        startadapter();
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
        news_adapter adapter = new news_adapter(heading, place, news, time, nameArr, Textile_News.this);
        recyclerView.setLayoutManager(new LinearLayoutManager(Textile_News.this));
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void parse_data(){

        String news_url = "http://newsapi.org/v2/everything?q=textile&apikey=c0e62eb830324e9d936913e3813624a6";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, news_url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                startadapter();
                try {
                    JSONArray jsonArray = response.getJSONArray("articles");

                    for(int i = 0 ; i< jsonArray.length(); i++){
                        JSONObject article = jsonArray.getJSONObject(i);
                        String title = article.getString("title");
//                        String content = article.getString("content");
                        String content = article.getString("description");
                        String time_ = article.getString("publishedAt");
                        String url = article.getString("url");
                        String name = article.getJSONObject("source").getString("name");
                        time_ = time_.substring(0, 10);
                        heading.add(title);
                        news.add(content);
                        time.add(time_);
                        nameArr.add(name);
                        place.add(url);        // can be used later!!!!!
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mQueue.add(request);
    }

}
