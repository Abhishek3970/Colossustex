package com.example.colossustex.SG;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.colossustex.MainActivity;
import com.example.colossustex.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.EventListener;

public class yarn_offers extends AppCompatActivity {

    ArrayList<String> headings = new ArrayList<>();
    ArrayList<String> contents = new ArrayList<>();
    ImageView back;
    ImageView button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yarn_offers);

        DatabaseReference dbr = FirebaseDatabase.getInstance().getReference().child("yarn offers");

        dbr.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){

                    offers_info info = snapshot.getValue(offers_info.class);
                    if(info!=null){
                        headings.add(info.getName());
                        contents.add(info.getContent());
                    }

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(yarn_offers.this, "Data load failed", Toast.LENGTH_SHORT).show();
            }
        });

//        indbr.addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//                String name = dataSnapshot.getValue(String.class);
////                String content = dataSnapshot.getValue(String.class);
//                headings.add(name.toString());
////                contents.add(content);
//            }
//
//            @Override
//            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//            }
//
//            @Override
//            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });

        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(yarn_offers.this, MainActivity.class));
            }
        });
        initializeRV();
        button = findViewById(R.id.yarn_offers_menu);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Here we go");
                registerForContextMenu(button);
            }
        });
    }
//
//    @Override
//    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
//        super.onCreateContextMenu(menu, v, menuInfo);
//        getMenuInflater().inflate(R.menu.main_menu, menu);
//    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item){
        switch(item.getItemId()){
            case R.id.notification_Settings:
                Toast.makeText(this, "Notification Settings menu pop up", Toast.LENGTH_SHORT).show();
                break;
            case R.id.edit_profile:
                Toast.makeText(this, "profile editing option pop up", Toast.LENGTH_SHORT).show();
                break;
            case R.id.change_password:
                Toast.makeText(this, "Password changing option pop up", Toast.LENGTH_SHORT).show();
                break;
            case R.id.spinning_mill:
                Toast.makeText(this, "Spinning mills list pop up", Toast.LENGTH_SHORT).show();
                break;
            case R.id.support:
                Toast.makeText(this, "Support option will pop up pop up", Toast.LENGTH_SHORT).show();
                break;
            case R.id.advertise_with_us:
                Toast.makeText(this, "Advertisement methods pop up", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rate_this_app:
                Toast.makeText(this, "take to playstore pop up", Toast.LENGTH_SHORT).show();
                break;
            case R.id.share_app:

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT,"Subject");
                intent.putExtra(Intent.EXTRA_TEXT, "playstore app link...");
                this.startActivity(Intent.createChooser(intent, "Share using"));
                break;
        }
        return super.onContextItemSelected(item);
    }


    private void initializeRV(){
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        yarn_offers_adapter adapter = new yarn_offers_adapter(headings, contents, yarn_offers.this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(yarn_offers.this));
    }

}
