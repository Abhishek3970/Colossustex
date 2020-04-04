package com.example.colossustex.SG;
 import android.app.AlertDialog;
 import android.content.Intent;
 import android.os.Bundle;
 import android.view.View;
 import android.webkit.WebView;
 import android.webkit.WebViewClient;
 import android.widget.ImageView;
 import android.widget.Toast;

 import androidx.annotation.NonNull;
 import androidx.appcompat.app.AppCompatActivity;
 import androidx.recyclerview.widget.LinearLayoutManager;
 import androidx.recyclerview.widget.RecyclerView;

 import com.example.colossustex.MainActivity;
 import com.example.colossustex.R;
 import com.example.colossustex.SG.interface_firebase.FirebaseLoadListener;
 import com.example.colossustex.SG.model.ItemData;
 import com.example.colossustex.SG.model.ItemGroup;
 import com.example.colossustex.SG.sensex_adapters.ItemGroupAdapter;
 import com.google.firebase.database.DataSnapshot;
 import com.google.firebase.database.DatabaseError;
 import com.google.firebase.database.DatabaseReference;
 import com.google.firebase.database.FirebaseDatabase;
 import com.google.firebase.database.GenericTypeIndicator;
 import com.google.firebase.database.ValueEventListener;

 import java.util.ArrayList;
 import java.util.List;

 import dmax.dialog.SpotsDialog;

public class sensex_SG extends AppCompatActivity {

    ImageView back;
    WebView webView;
    String str;

//    FirebaseLoadListener iFirebaseLoadListener;
//
//    RecyclerView myRecyclerView;
//    AlertDialog dialog;
//    DatabaseReference myData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensex);
        if(getIntent().hasExtra("For"))
            if(getIntent().getStringExtra("For") == "stocks")
                str = "https://ssltsw.forexprostools.com/?notChosenTab=%2312a13f&lang=1&forex=1,2,3,5,7,9,10&commodities=8830,8836,8831,8849,8833,8862,8832&indices=175,166,172,27,179,170,174&stocks=334,345,346,347,348,349,350&tabs=1,2,3,4";
            if(getIntent().getStringExtra("For")=="col_move")
                str = "https://www.searates.com/";
        webView = (WebView)findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(str);

//        myRecyclerView = findViewById(R.id.sensex);
//        myRecyclerView.setHasFixedSize(true);
//        myRecyclerView.setLayoutManager(new LinearLayoutManager(sensex_SG.this, LinearLayoutManager.VERTICAL, false));
//
//        myData = FirebaseDatabase.getInstance().getReference("sensex_data");
//        dialog = new SpotsDialog.Builder().setContext(sensex_SG.this).build();
//        iFirebaseLoadListener = this;
//
//        getFirebaseData();

        back = findViewById(R.id.back_sensex);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(sensex_SG.this, MainActivity.class));
            }
        });

    }

//    private void getFirebaseData() {
//        dialog.show();
//        myData.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                List<ItemGroup> itemGroups = new ArrayList<>();
//                for(DataSnapshot groupSnapShot:dataSnapshot.getChildren()){
//                    ItemGroup itemGroup = new ItemGroup();
//                    itemGroup.setHeadTitle(groupSnapShot.child("head title").getValue(true).toString());
//                    GenericTypeIndicator<ArrayList<ItemData>> t = new GenericTypeIndicator<ArrayList<ItemData>>(){};
//                    itemGroup.setListelements(groupSnapShot.child("list elements").getValue(t));
//                    itemGroups.add(itemGroup);
//                }
//                iFirebaseLoadListener.onFirebaseLoadSuccess(itemGroups);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//                iFirebaseLoadListener.onFirebaseLoadFailed(databaseError.getMessage());
//            }
//        });
//    }
//
//    @Override
//    public void onFirebaseLoadSuccess(List<ItemGroup> itemGroupList) {
//        ItemGroupAdapter adapter = new ItemGroupAdapter(sensex_SG.this, itemGroupList);
//        myRecyclerView.setAdapter(adapter);
//
//        dialog.dismiss();
//    }
//
//    @Override
//    public void onFirebaseLoadFailed(String message) {
//
//        Toast.makeText(sensex_SG.this, message, Toast.LENGTH_SHORT).show();
//        dialog.dismiss();
//
//    }
}
