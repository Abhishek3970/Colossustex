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

public class sensex_SG extends AppCompatActivity {

    ImageView back;
    private ArrayList<String> Headings = new ArrayList<>();
//    private ArrayList<List> List = new ArrayList<>();
//    public class card{
//        public ArrayList<node> nodes;
//
//    }
//    class node{ String name, value, date, type, relative, percentage;}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensex);
        Headings.add("h1");
        Headings.add("h2");
        Headings.add("h3");

        back = findViewById(R.id.back_sensex);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(sensex_SG.this, MainActivity.class));
            }
        });

        initRCV();
    }

    private void initRCV(){
        RecyclerView recyclerView = findViewById(R.id.sensex);
        sensex_recyclerview_adapter adapter = new sensex_recyclerview_adapter(Headings, sensex_SG.this );
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(sensex_SG.this));
    }
}
