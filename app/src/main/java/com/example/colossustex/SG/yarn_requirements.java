package com.example.colossustex.SG;


import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.navigation.ViewKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.colossustex.MainActivity;
import com.example.colossustex.R;
import com.example.colossustex.SG.model.ItemGroup;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

public class yarn_requirements extends AppCompatActivity{

    ImageView back;
    int i = 1, sum = 0;
    CardView Grade;
    LinearLayout Fibre,Purpose,Count, Quality_Range_Texturised, Quality_Range_Fancy, Product_Range_Texturised, Product_Range_Fancy, Quality,Variety, Type, Nature, noofbags, description, sendto, denier, send_reqto, SingDub;
    TextView Fibre_, Purpose_, Count_ , Quality_Range_texturised,req,  Quality_Range_fancy, Product_Range_texturised, Product_Range_fancy, Quality_, Variety_, Type_, Nature_, Grade_ , sendto_, sendreqto, denier_, singdub;


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
        Type = findViewById(R.id.Type);
        Quality = findViewById(R.id.Quality);
        Nature = findViewById(R.id.Nature);
        Variety = findViewById(R.id.Variety);
        Grade = findViewById(R.id.Grade);
        sendto = findViewById(R.id.sendto);
        noofbags = findViewById(R.id.noofbags);
        description = findViewById(R.id.desc);
        send_reqto = findViewById(R.id.sendmill);
        SingDub = findViewById(R.id.SingDub);
        denier = findViewById(R.id.denier);
        Quality_Range_Texturised = findViewById(R.id.Quality_Range_texturised);
        Quality_Range_Fancy = findViewById(R.id.Quality_Range_fancy);
        Product_Range_Fancy = findViewById(R.id.Product_Range_fancy);
        Product_Range_Texturised = findViewById(R.id.Product_Range_texturised);
        Fibre_ = findViewById(R.id.f);
        Purpose_ = findViewById(R.id.p);
        req = findViewById(R.id.requirement);
        Type_ = findViewById(R.id.t);
        Quality_ = findViewById(R.id.q);
        Nature_ = findViewById(R.id.n);
        singdub = findViewById(R.id.singdub);
        Variety_ = findViewById(R.id.v);
        sendreqto = findViewById(R.id.send_mill);
        Quality_Range_texturised = findViewById(R.id.qrt);
        Quality_Range_fancy = findViewById(R.id.qrf);
        Product_Range_texturised = findViewById(R.id.rt);
        Product_Range_fancy = findViewById(R.id.rf);
        Grade_= findViewById(R.id.g);
        sendto_ = findViewById(R.id.sendto_text);

        Purpose.setVisibility(View.GONE);
        Count.setVisibility(View.GONE);
        Type.setVisibility(View.GONE);
        SingDub.setVisibility(View.GONE);
        Quality.setVisibility(View.GONE);
        denier.setVisibility(View.GONE);
        Quality_Range_Fancy.setVisibility(View.GONE);
        Quality_Range_Texturised.setVisibility(View.GONE);
        Nature.setVisibility(View.GONE);
        noofbags.setVisibility(View.GONE);
        description.setVisibility(View.GONE);
        sendto.setVisibility(View.GONE);
        Variety.setVisibility(View.GONE);
        Grade.setVisibility(View.GONE);
        send_reqto.setVisibility(View.GONE);
        Product_Range_Texturised.setVisibility(View.GONE);
        Product_Range_Fancy.setVisibility(View.GONE);



        Fibre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Ref.ObjectRef dialog = new Ref.ObjectRef();
//                Intrinsics.checkExpressionValueIsNotNull(it, "it");
                dialog.element = new Dialog(yarn_requirements.this);
                ((Dialog)dialog.element).setContentView(R.layout.buy_yarn_offers_dialog1);
                TextView cotton = (TextView)((Dialog)dialog.element).findViewById(R.id.dialog_cotton);
                TextView synthetic = (TextView)((Dialog)dialog.element).findViewById(R.id.dialog_synthetic);
                TextView viscose = (TextView)((Dialog)dialog.element).findViewById(R.id.dialog_viscose);
                TextView Texturised = (TextView)((Dialog)dialog.element).findViewById(R.id.dialog_texturised);
                TextView fancy = (TextView)((Dialog)dialog.element).findViewById(R.id.dialog_fancy);


                cotton.setOnClickListener((new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Fibre_.setText("cotton");
                        Purpose.setVisibility(View.VISIBLE);
                        Count.setVisibility(View.VISIBLE);
                        Type.setVisibility(View.VISIBLE);
                        Quality.setVisibility(View.VISIBLE);
                        Quality_Range_Fancy.setVisibility(View.GONE);
                        Quality_Range_Texturised.setVisibility(View.GONE);
                        Nature.setVisibility(View.VISIBLE);
                        noofbags.setVisibility(View.VISIBLE);
                        description.setVisibility(View.VISIBLE);
                        SingDub.setVisibility(View.VISIBLE);
                        denier.setVisibility(View.GONE);
                        sendto.setVisibility(View.VISIBLE);
                        Variety.setVisibility(View.GONE);
                        Grade.setVisibility(View.GONE);
                        Product_Range_Texturised.setVisibility(View.GONE);
                        send_reqto.setVisibility(View.VISIBLE);
                        Product_Range_Fancy.setVisibility(View.GONE);
                    }
                }));
                synthetic.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Fibre_.setText("synthetic");
                        Purpose.setVisibility(View.GONE);
                        Count.setVisibility(View.VISIBLE);
                        SingDub.setVisibility(View.VISIBLE);
                        Type.setVisibility(View.VISIBLE);
                        Quality.setVisibility(View.GONE);
                        denier.setVisibility(View.GONE);
                        Quality_Range_Fancy.setVisibility(View.GONE);
                        Quality_Range_Texturised.setVisibility(View.GONE);
                        Nature.setVisibility(View.VISIBLE);
                        noofbags.setVisibility(View.VISIBLE);
                        description.setVisibility(View.VISIBLE);
                        sendto.setVisibility(View.VISIBLE);
                        Variety.setVisibility(View.VISIBLE);
                        send_reqto.setVisibility(View.VISIBLE);
                        Grade.setVisibility(View.GONE);
                        Product_Range_Texturised.setVisibility(View.GONE);
                        Product_Range_Fancy.setVisibility(View.GONE);
                    }
                }));
                viscose.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Fibre_.setText("viscose");
                        Purpose.setVisibility(View.GONE);
                        Count.setVisibility(View.VISIBLE);
                        SingDub.setVisibility(View.VISIBLE);
                        Type.setVisibility(View.VISIBLE);
                        Quality.setVisibility(View.GONE);
                        Quality_Range_Fancy.setVisibility(View.GONE);
                        Quality_Range_Texturised.setVisibility(View.GONE);
                        Nature.setVisibility(View.VISIBLE);
                        noofbags.setVisibility(View.VISIBLE);
                        description.setVisibility(View.VISIBLE);
                        sendto.setVisibility(View.VISIBLE);
                        denier.setVisibility(View.GONE);
                        Variety.setVisibility(View.GONE);
                        Grade.setVisibility(View.GONE);
                        send_reqto.setVisibility(View.VISIBLE);
                        Product_Range_Texturised.setVisibility(View.GONE);
                        Product_Range_Fancy.setVisibility(View.GONE);

                    }
                }));
                Texturised.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Fibre_.setText("Texturised");
                        Purpose.setVisibility(View.GONE);
                        Count.setVisibility(View.GONE);
                        SingDub.setVisibility(View.GONE);
                        Type.setVisibility(View.GONE);
                        Quality.setVisibility(View.GONE);
                        Quality_Range_Fancy.setVisibility(View.GONE);
                        Quality_Range_Texturised.setVisibility(View.VISIBLE);
                        Nature.setVisibility(View.GONE);
                        noofbags.setVisibility(View.VISIBLE);
                        description.setVisibility(View.VISIBLE);
                        denier.setVisibility(View.GONE);
                        sendto.setVisibility(View.VISIBLE);
                        Variety.setVisibility(View.GONE);
                        Grade.setVisibility(View.VISIBLE);
                        send_reqto.setVisibility(View.VISIBLE);
                        Product_Range_Texturised.setVisibility(View.VISIBLE);
                        Product_Range_Fancy.setVisibility(View.GONE);
                    }
                }));
                fancy.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Fibre_.setText("fancy");
                        Purpose.setVisibility(View.GONE);
                        Count.setVisibility(View.VISIBLE);
                        SingDub.setVisibility(View.VISIBLE);
                        Type.setVisibility(View.GONE);
                        Quality.setVisibility(View.GONE);
                        Quality_Range_Fancy.setVisibility(View.VISIBLE);
                        Quality_Range_Texturised.setVisibility(View.GONE);
                        Nature.setVisibility(View.GONE);
                        noofbags.setVisibility(View.VISIBLE);
                        description.setVisibility(View.VISIBLE);
                        sendto.setVisibility(View.VISIBLE);
                        Variety.setVisibility(View.GONE);
                        Grade.setVisibility(View.GONE);
                        send_reqto.setVisibility(View.VISIBLE);
                        Product_Range_Texturised.setVisibility(View.GONE);
                        Product_Range_Fancy.setVisibility(View.VISIBLE);
                    }
                }));
                ((Dialog)dialog.element).show();
            }
        });

        send_reqto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Ref.ObjectRef dialog = new Ref.ObjectRef();
//                Intrinsics.checkExpressionValueIsNotNull(it, "it");
                dialog.element = new Dialog(yarn_requirements.this);
                ((Dialog)dialog.element).setContentView(R.layout.sg_sendto_dialog);
                TextView First = (TextView)((Dialog)dialog.element).findViewById(R.id.first_sendreqto);
                TextView Second = (TextView)((Dialog)dialog.element).findViewById(R.id.second_sendreqto);
                TextView Both = (TextView)((Dialog)dialog.element).findViewById(R.id.third_sendreqto);


                First.setOnClickListener((new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        sendreqto.setText("Mills Only");
                    }
                }));

                Second.setOnClickListener((new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        sendreqto.setText("Agents and Traders only");
                    }
                }));
                Both.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        sendreqto.setText("Mills and Agents and Traders only");
                    }
                }));
                ((Dialog)dialog.element).show();
            }
        });

        sendto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Ref.ObjectRef dialog = new Ref.ObjectRef();
//                Intrinsics.checkExpressionValueIsNotNull(it, "it");
                dialog.element = new Dialog(yarn_requirements.this);
                ((Dialog)dialog.element).setContentView(R.layout.sg_sendto);
                TextView ind = (TextView)((Dialog)dialog.element).findViewById(R.id.india);
                TextView out = (TextView)((Dialog)dialog.element).findViewById(R.id.outside);
                TextView bangla = (TextView)((Dialog)dialog.element).findViewById(R.id.bangladesh);


                ind.setOnClickListener((new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        sendto_.setText("Within India");
                    }
                }));

                out.setOnClickListener((new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        sendto_.setText("Outside India");
                    }
                }));
                bangla.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        sendto_.setText("Bangladesh");
                    }
                }));
                ((Dialog)dialog.element).show();
            }
        });


        SingDub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Ref.ObjectRef dialog = new Ref.ObjectRef();
//                Intrinsics.checkExpressionValueIsNotNull(it, "it");
                dialog.element = new Dialog(yarn_requirements.this);
                ((Dialog)dialog.element).setContentView(R.layout.singledouble);
                final TextView single = (TextView)((Dialog)dialog.element).findViewById(R.id.single);
                TextView dubble = (TextView)((Dialog)dialog.element).findViewById(R.id.dubble);


                single.setOnClickListener((new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        singdub.setText("single");
                    }
                }));
                dubble.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        singdub.setText("double");
                    }
                }));
                ((Dialog)dialog.element).show();
            }
        });



        Purpose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Ref.ObjectRef dialog = new Ref.ObjectRef();
//                Intrinsics.checkExpressionValueIsNotNull(it, "it");
                dialog.element = new Dialog(yarn_requirements.this);
                ((Dialog)dialog.element).setContentView(R.layout.sg_purpose_dialog);
                TextView Weaving = (TextView)((Dialog)dialog.element).findViewById(R.id.purpose_Weaving_dialog);
                TextView Hoisery = (TextView)((Dialog)dialog.element).findViewById(R.id.purpose_Hosiery_dialog);


                Weaving.setOnClickListener((new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Purpose_.setText("Weaving");
                    }
                }));
                Hoisery.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Purpose_.setText("Hoisery");
                    }
                }));
                ((Dialog)dialog.element).show();
            }
        });

        Type.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Ref.ObjectRef dialog = new Ref.ObjectRef();
//                Intrinsics.checkExpressionValueIsNotNull(it, "it");
                dialog.element = new Dialog(yarn_requirements.this);
                ((Dialog)dialog.element).setContentView(R.layout.sg_type_dialog);
                TextView Wrap = (TextView)((Dialog)dialog.element).findViewById(R.id.wrap_type_dialog);
                TextView Weft = (TextView)((Dialog)dialog.element).findViewById(R.id.weft_type_dialog);

                Wrap.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Type_.setText("Wrap");
                    }
                }));
                Weft.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Type_.setText("Weft");
                    }
                }));
                ((Dialog)dialog.element).show();
            }
        });

        Quality.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Ref.ObjectRef dialog = new Ref.ObjectRef();
//                Intrinsics.checkExpressionValueIsNotNull(it, "it");
                //     ======Comber used later is actually combed wala=====================
                dialog.element = new Dialog(yarn_requirements.this);
                ((Dialog)dialog.element).setContentView(R.layout.sg_quality_dialog);
                TextView comber = (TextView)((Dialog)dialog.element).findViewById(R.id.comber_quality_dialog);
                TextView virgin = (TextView)((Dialog)dialog.element).findViewById(R.id.virgin_quality_dialog);
                TextView card = (TextView)((Dialog)dialog.element).findViewById(R.id.carded_quality_dialog);
                TextView combed = (TextView)((Dialog)dialog.element).findViewById(R.id.combed_compact_quality_dialog);
                TextView carded = (TextView)((Dialog)dialog.element).findViewById(R.id.carded_compact_quality_dialog);
                TextView Giza = (TextView)((Dialog)dialog.element).findViewById(R.id.giza_quality_dialog);


                comber.setOnClickListener((new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Quality_.setText("Combed");
                    }
                }));

                virgin.setOnClickListener((new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Quality_.setText("Virgin");
                    }
                }));
                card.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Quality_.setText("Carded");
                    }
                }));
                combed.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Quality_.setText("Combed Compact");
                    }
                }));
                carded.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Quality_.setText("Carded Compact");
                    }
                }));
                Giza.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Quality_.setText("Giza");
                    }
                }));
                ((Dialog)dialog.element).show();
            }
        });

        Quality_Range_Texturised.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Ref.ObjectRef dialog = new Ref.ObjectRef();
//                Intrinsics.checkExpressionValueIsNotNull(it, "it");
                dialog.element = new Dialog(yarn_requirements.this);
                ((Dialog)dialog.element).setContentView(R.layout.sg_quality_texturised);
                TextView nim = (TextView)((Dialog)dialog.element).findViewById(R.id.nim_quality_t_dialog);
                TextView gft = (TextView)((Dialog)dialog.element).findViewById(R.id.gft_quality_t_dialog);
                TextView limsim = (TextView)((Dialog)dialog.element).findViewById(R.id.lim_sim_quality_t_dialog);
                TextView imroto = (TextView)((Dialog)dialog.element).findViewById(R.id.im_roto_quality_t_dialog);
                TextView himroto = (TextView)((Dialog)dialog.element).findViewById(R.id.him_roto_quality_t_dialog);


                nim.setOnClickListener((new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Quality_Range_texturised.setText("NIM");
                    }
                }));
                gft.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Quality_Range_texturised.setText("GFT");
                    }
                }));
                limsim.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Quality_Range_texturised.setText("LIM / SIM");
                    }
                }));
                imroto.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Quality_Range_texturised.setText("IM / ROTO");
                    }
                }));
                himroto.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Quality_Range_texturised.setText("HIM / ROTO");
                    }
                }));
                ((Dialog)dialog.element).show();
            }
        });

        Quality_Range_Fancy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Ref.ObjectRef dialog = new Ref.ObjectRef();
//                Intrinsics.checkExpressionValueIsNotNull(it, "it");
                dialog.element = new Dialog(yarn_requirements.this);
                ((Dialog)dialog.element).setContentView(R.layout.sg_quality_fancy);
                TextView cotton = (TextView)((Dialog)dialog.element).findViewById(R.id.cotton_quality_f_dialog);
                TextView pv = (TextView)((Dialog)dialog.element).findViewById(R.id.pv_quality_f_dialog);
                TextView pc = (TextView)((Dialog)dialog.element).findViewById(R.id.pc_quality_f_dialog);
                TextView psf = (TextView)((Dialog)dialog.element).findViewById(R.id.psf_quality_f_dialog);
                TextView vsf = (TextView)((Dialog)dialog.element).findViewById(R.id.vsf_quality_f_dialog);
                TextView texturised = (TextView)((Dialog)dialog.element).findViewById(R.id.texturised_quality_f_dialog);


                cotton.setOnClickListener((new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Quality_Range_fancy.setText("Cotton");
                    }
                }));

                pv.setOnClickListener((new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Quality_Range_fancy.setText("PV");
                    }
                }));
                pc.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Quality_Range_fancy.setText("PC");
                    }
                }));
                psf.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Quality_Range_fancy.setText("PSF");
                    }
                }));
                vsf.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Quality_Range_fancy.setText("VSF");
                    }
                }));
                texturised.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Quality_Range_fancy.setText("Texturised");
                    }
                }));
                ((Dialog)dialog.element).show();
            }
        });

        Nature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Ref.ObjectRef dialog = new Ref.ObjectRef();
//                Intrinsics.checkExpressionValueIsNotNull(it, "it");
                dialog.element = new Dialog(yarn_requirements.this);
                ((Dialog)dialog.element).setContentView(R.layout.sg_nature_dialog);
                TextView open = (TextView)((Dialog)dialog.element).findViewById(R.id.open_end_nature_dialog);
                TextView ring = (TextView)((Dialog)dialog.element).findViewById(R.id.ring_span_nature_dialog);
                TextView vortex = (TextView)((Dialog)dialog.element).findViewById(R.id.vortex_nature_dialog);

                open.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Nature_.setText("Open End");
                    }
                }));
                ring.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Nature_.setText("Ring Span");
                    }
                }));
                vortex.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Nature_.setText("Vortex");
                    }
                }));
                ((Dialog)dialog.element).show();
            }
        });

        Variety.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Ref.ObjectRef dialog = new Ref.ObjectRef();
//                Intrinsics.checkExpressionValueIsNotNull(it, "it");
                dialog.element = new Dialog(yarn_requirements.this);
                ((Dialog)dialog.element).setContentView(R.layout.sg_variety_dialog);
                TextView psf = (TextView)((Dialog)dialog.element).findViewById(R.id.psf_variety_dialog);
                TextView pv = (TextView)((Dialog)dialog.element).findViewById(R.id.pv_variety_dialog);
                TextView pc = (TextView)((Dialog)dialog.element).findViewById(R.id.pc_variety_dialog);

                psf.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Variety_.setText("PSF");
                    }
                }));
                pv.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Variety_.setText("PV");
                    }
                }));
                pc.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Variety_.setText("PC");
                    }
                }));
                ((Dialog)dialog.element).show();
            }
        });

        Product_Range_Fancy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Ref.ObjectRef dialog = new Ref.ObjectRef();
//                Intrinsics.checkExpressionValueIsNotNull(it, "it");
                dialog.element = new Dialog(yarn_requirements.this);
                ((Dialog)dialog.element).setContentView(R.layout.sg_product_f_dialog);
                TextView slub = (TextView)((Dialog)dialog.element).findViewById(R.id.Slub);
                TextView multi_color = (TextView)((Dialog)dialog.element).findViewById(R.id.multicolor_product_f_dialog);
                TextView modal = (TextView)((Dialog)dialog.element).findViewById(R.id.modal_product_f_dialog);
                TextView excel = (TextView)((Dialog)dialog.element).findViewById(R.id.excel_product_f_dialog);
                TextView tencel = (TextView)((Dialog)dialog.element).findViewById(R.id.tencel_product_f_dialog);


                slub.setOnClickListener((new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Product_Range_fancy.setText("Slub");
                    }
                }));
                multi_color.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Product_Range_fancy.setText("Multi Colour");
                    }
                }));
                modal.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Product_Range_fancy.setText("Modal");
                    }
                }));
                excel.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Product_Range_fancy.setText("Excel");
                    }
                }));
                tencel.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Product_Range_fancy.setText("Tencel");
                    }
                }));
                ((Dialog)dialog.element).show();
            }
        });

        Product_Range_Texturised.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Ref.ObjectRef dialog = new Ref.ObjectRef();
//                Intrinsics.checkExpressionValueIsNotNull(it, "it");
                dialog.element = new Dialog(yarn_requirements.this);
                ((Dialog)dialog.element).setContentView(R.layout.sg_product_t_dialog);
                TextView bright = (TextView)((Dialog)dialog.element).findViewById(R.id.bright_product_t_dialog);
                TextView semidull = (TextView)((Dialog)dialog.element).findViewById(R.id.Semidull_product_t_dialog);
                TextView fulldull = (TextView)((Dialog)dialog.element).findViewById(R.id.fulldull_cot_look_product_t_dialog);
                final TextView stretch = (TextView)((Dialog)dialog.element).findViewById(R.id.stretch_lycra_product_t_dialog);
                TextView catonic = (TextView)((Dialog)dialog.element).findViewById(R.id.catonic_product_t_dialog);
                TextView airtex = (TextView)((Dialog)dialog.element).findViewById(R.id.airtex_cooltex_product_t_dialog);
                TextView blackdope = (TextView)((Dialog)dialog.element).findViewById(R.id.blackdope_dyed_);
                TextView fdy = (TextView)((Dialog)dialog.element).findViewById(R.id.FDY_product_t_dialog);


                bright.setOnClickListener((new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Product_Range_texturised.setText("Bright");
                    }
                }));
                semidull.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Product_Range_texturised.setText("Semi Dull");
                    }
                }));
                fulldull.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Product_Range_texturised.setText("Full Dull");
                    }
                }));

                stretch.setOnClickListener((new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Product_Range_texturised.setText("Stretch / Lycra");
                    }
                }));
                catonic.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Product_Range_texturised.setText("Catonic");
                    }
                }));
                airtex.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Product_Range_texturised.setText("Airtex / Cooltex");
                    }
                }));
                blackdope.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Product_Range_texturised.setText("Black Dope Dyed");
                    }
                }));
                fdy.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Product_Range_texturised.setText("FDY");
                    }
                }));
                ((Dialog)dialog.element).show();
            }
        });


        Grade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Ref.ObjectRef dialog = new Ref.ObjectRef();
//                Intrinsics.checkExpressionValueIsNotNull(it, "it");
                dialog.element = new Dialog(yarn_requirements.this);
                ((Dialog)dialog.element).setContentView(R.layout.sg_grade_dialog);
                TextView Ist = (TextView)((Dialog)dialog.element).findViewById(R.id.Ist_grade_dialog);
                TextView pq = (TextView)((Dialog)dialog.element).findViewById(R.id.pq_grade_dialog);
                TextView clq = (TextView)((Dialog)dialog.element).findViewById(R.id.clq_grade_dialog);
                TextView std = (TextView)((Dialog)dialog.element).findViewById(R.id.std_grade_dialog);


                Ist.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Grade_.setText("1st");
                    }
                }));
                pq.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Grade_.setText("PQ");
                    }
                }));
                clq.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Grade_.setText("CLQ");
                    }
                }));
                std.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Grade_.setText("STD");
                    }
                }));
                ((Dialog)dialog.element).show();
            }
        });





        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Toast.makeText(yarn_requirements.this, "minimum 10 requirements!", Toast.LENGTH_SHORT).show();
            }
        });
        add_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                req.setText("Requirement"+ (i+1));
                i+=1;
                Toast.makeText(yarn_requirements.this, "order taken and new requirement begin...", Toast.LENGTH_SHORT).show();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(yarn_requirements.this, MainActivity.class));
                finishAffinity();
            }
        });

    }
}
