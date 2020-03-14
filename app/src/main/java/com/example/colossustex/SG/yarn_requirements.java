package com.example.colossustex.SG;


import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.colossustex.MainActivity;
import com.example.colossustex.R;
import com.example.colossustex.SG.model.ItemGroup;

public class yarn_requirements extends AppCompatActivity{

    ImageView back;
    LinearLayout Fibre,Purpose,Count, Range, Quality,Variety, Type, Nature, Grade;
    TextView Fibre_, Purpose_, Range_, Quality_, Variety_, Type_, Nature_, Grade_ ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_requirements);
        Button add_more = findViewById(R.id.button);
        Button submit = findViewById(R.id.button2);
        back = findViewById(R.id.back);
        Fibre = findViewById(R.id.Fibre);
        Purpose = findViewById(R.id.Purpose);
        Count = findViewById(R.id.Count);
        Range = findViewById(R.id.Range);
        Quality = findViewById(R.id.Quality);
        Variety = findViewById(R.id.Variety);
        Type = findViewById(R.id.Type);
        Nature = findViewById(R.id.Nature);
        Grade = findViewById(R.id.Grade);
        Fibre_ = findViewById(R.id.f);
        Purpose_ = findViewById(R.id.p);
        Range_ = findViewById(R.id.r);
        Quality_ = findViewById(R.id.q);
        Variety_ = findViewById(R.id.v);
        Type_ = findViewById(R.id.t);
        Nature_ = findViewById(R.id.n);
        Grade_= findViewById(R.id.g);
         TextView cotton = findViewById(R.id.dialog_cotton);
         TextView synthetic = findViewById(R.id.dialog_synthetic);
         TextView viscose = findViewById(R.id.dialog_viscose);
         TextView Texturised = findViewById(R.id.dialog_texturised);
         TextView Fancy = findViewById(R.id.dialog_fancy);


        Fibre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(yarn_requirements.this);
                dialog.setContentView(R.layout.buy_yarn_offers_dialog1);
                dialog.show();
//                cotton.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                     Fibre_.setText("cotton");
//                     dialog.dismiss();
//                    }
//                });
//                synthetic.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Fibre_.setText("Synthetic");
//                        dialog.dismiss();
//                    }
//                });
//                viscose.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Fibre_.setText("Viscose");
//                        dialog.dismiss();
//                    }
//                });
//                Texturised.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Fibre_.setText("Texturised");
//                        dialog.dismiss();
//                    }
//                });
//                Fancy.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Fibre_.setText("Fancy");
//                        dialog.dismiss();
//                    }
//                });
            }
        });

        Purpose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(yarn_requirements.this);
                dialog.setContentView(R.layout.purpose_types);
                dialog.show();
            }
        });

        Range.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(yarn_requirements.this);
                dialog.setContentView(R.layout.range_types);
                dialog.show();
            }
        });

        Quality.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(yarn_requirements.this);
                dialog.setContentView(R.layout.quality_types);
                dialog.show();
            }
        });


        Variety.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(yarn_requirements.this);
                dialog.setContentView(R.layout.buy_yarn_offers_dialog1);
                dialog.show();
            }
        });
        Type.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(yarn_requirements.this);
                dialog.setContentView(R.layout.buy_yarn_offers_dialog1);
                dialog.show();
            }
        });
        Nature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(yarn_requirements.this);
                dialog.setContentView(R.layout.buy_yarn_offers_dialog1);
                dialog.show();
            }
        });
        Grade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(yarn_requirements.this);
                dialog.setContentView(R.layout.buy_yarn_offers_dialog1);
                dialog.show();
            }
        });























        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(yarn_requirements.this, "Order to save", Toast.LENGTH_SHORT).show();
            }
        });
        add_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(yarn_requirements.this, "order to save and taking more order", Toast.LENGTH_SHORT).show();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(yarn_requirements.this, MainActivity.class));
            }
        });

    }
}
