package com.example.colossustex.SG;


import android.annotation.SuppressLint;
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
    String text, t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11;
    int i = 1, sum = 0;
    LinearLayout Fibre,Purpose,Count, Quality_Range_Texturised, Quality_Range_Fancy, Product_Range_Texturised, Grade, Product_Range_Fancy, Quality,Variety, Type, Nature, noofbags, description, sendto, denier, send_reqto, SingDub;
    TextView Fibre_, Purpose_, Count_ , Quality_Range_texturised,req,  Quality_Range_fancy, Product_Range_texturised, Product_Range_fancy, Quality_, Variety_, Type_, Nature_, Grade_ , sendto_, sendreqto, denier_, singdub;


    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        t1 = t2 = t3 = t4 = t5 = t6 = t7 = t8 = t9 = t10 = t11 = "";
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
                TextView cotton = ((Dialog)dialog.element).findViewById(R.id.dialog_cotton);
                TextView synthetic = ((Dialog)dialog.element).findViewById(R.id.dialog_synthetic);
                TextView viscose = ((Dialog)dialog.element).findViewById(R.id.dialog_viscose);
                TextView Texturised = ((Dialog)dialog.element).findViewById(R.id.dialog_texturised);
                TextView fancy = ((Dialog)dialog.element).findViewById(R.id.dialog_fancy);


                cotton.setOnClickListener((new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Fibre_.setText("Cotton");
                        t1 = "Cotton";
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
                synthetic.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Fibre_.setText("Synthetic");
                        t1 = "Synthetic";
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
                });
                viscose.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Fibre_.setText("Viscose");
                        t1 = "Viscose";
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
                });
                Texturised.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Fibre_.setText("Texturised");
                        t1 = "Texturised";
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
                });
                fancy.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Fibre_.setText("Fancy");
                        t1 = "Fancy";
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
                });
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
                TextView First = ((Dialog)dialog.element).findViewById(R.id.first_sendreqto);
                TextView Second = ((Dialog)dialog.element).findViewById(R.id.second_sendreqto);
                TextView Both = ((Dialog)dialog.element).findViewById(R.id.third_sendreqto);


                First.setOnClickListener((new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        sendreqto.setText("Mills Only");
                        t8="Mills Only";
                    }
                }));

                Second.setOnClickListener((new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        sendreqto.setText("Agents and Traders only");
                        t8 = "Agents and Traders only";
                    }
                }));
                Both.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        sendreqto.setText("Mills and Agents and Traders only");
                        t8 = "Mills and Agents and Traders only";
                    }
                });
//                t8 = getText(R.id.sendreqto);
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
                TextView ind = ((Dialog)dialog.element).findViewById(R.id.india);
                TextView out = ((Dialog)dialog.element).findViewById(R.id.outside);
                TextView bangla = ((Dialog)dialog.element).findViewById(R.id.bangladesh);


                ind.setOnClickListener((new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        sendto_.setText("Within India");
                        t9 = "Within India";
                    }
                }));

                out.setOnClickListener((new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        sendto_.setText("Outside India");
                        t9 = "Outside India";
                    }
                }));
                bangla.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        sendto_.setText("Bangladesh");
                        t9 = "Bangladesh";
                    }
                });
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
                final TextView single = ((Dialog)dialog.element).findViewById(R.id.single);
                TextView dubble = ((Dialog)dialog.element).findViewById(R.id.dubble);


                single.setOnClickListener((new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        singdub.setText("Single");
                        t4 = "Single";
                    }
                }));
                dubble.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        singdub.setText("Double");
                        t4 = "Double";
                    }
                });
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
                TextView Weaving = ((Dialog)dialog.element).findViewById(R.id.purpose_Weaving_dialog);
                TextView Hoisery = ((Dialog)dialog.element).findViewById(R.id.purpose_Hosiery_dialog);


                Weaving.setOnClickListener((new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Purpose_.setText("Weaving");
                        t2 = "Weaving";
                    }
                }));
                Hoisery.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Purpose_.setText("Hoisery");
                        t2 = "Hosiery";
                    }
                });
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
                TextView Wrap = ((Dialog)dialog.element).findViewById(R.id.wrap_type_dialog);
                TextView Weft = ((Dialog)dialog.element).findViewById(R.id.weft_type_dialog);

                Wrap.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Type_.setText("Wrap");
                        t6 = "Wrap";
                    }
                });
                Weft.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Type_.setText("Weft");
                        t6 = "Weft";
                    }
                });
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
                TextView comber = ((Dialog)dialog.element).findViewById(R.id.comber_quality_dialog);
                TextView virgin = ((Dialog)dialog.element).findViewById(R.id.virgin_quality_dialog);
                TextView card = ((Dialog)dialog.element).findViewById(R.id.carded_quality_dialog);
                TextView combed = ((Dialog)dialog.element).findViewById(R.id.combed_compact_quality_dialog);
                TextView carded = ((Dialog)dialog.element).findViewById(R.id.carded_compact_quality_dialog);
                TextView Giza = ((Dialog)dialog.element).findViewById(R.id.giza_quality_dialog);


                comber.setOnClickListener((new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Quality_.setText("Combed");
                        t5 = "Combed";
                    }
                }));

                virgin.setOnClickListener((new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Quality_.setText("Virgin");
                        t5 = "Virgin";
                    }
                }));
                card.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Quality_.setText("Carded");
                        t5 = "Carded";
                    }
                });
                combed.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Quality_.setText("Combed Compact");
                        t5 = "Combed Compact";
                    }
                });
                carded.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Quality_.setText("Carded Compact");
                        t5 = "Carded Compact";
                    }
                });
                Giza.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Quality_.setText("Giza");
                        t5 = "Giza";
                    }
                });
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
                TextView nim = ((Dialog)dialog.element).findViewById(R.id.nim_quality_t_dialog);
                TextView gft = ((Dialog)dialog.element).findViewById(R.id.gft_quality_t_dialog);
                TextView limsim = ((Dialog)dialog.element).findViewById(R.id.lim_sim_quality_t_dialog);
                TextView imroto = ((Dialog)dialog.element).findViewById(R.id.im_roto_quality_t_dialog);
                TextView himroto = ((Dialog)dialog.element).findViewById(R.id.him_roto_quality_t_dialog);


                nim.setOnClickListener((new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Quality_Range_texturised.setText("NIM");
                        t5 = "NIM";
                    }
                }));
                gft.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Quality_Range_texturised.setText("GFT");
                        t5 = "GFT";
                    }
                });
                limsim.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Quality_Range_texturised.setText("LIM / SIM");
                        t5 = "LIM / SIM";
                    }
                });
                imroto.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Quality_Range_texturised.setText("IM / ROTO");
                        t5 = "IM / ROTO";
                    }
                });
                himroto.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Quality_Range_texturised.setText("HIM / ROTO");
                        t6 = "HIM / ROTO";
                    }
                });
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
                TextView cotton = ((Dialog)dialog.element).findViewById(R.id.cotton_quality_f_dialog);
                TextView pv = ((Dialog)dialog.element).findViewById(R.id.pv_quality_f_dialog);
                TextView pc = ((Dialog)dialog.element).findViewById(R.id.pc_quality_f_dialog);
                TextView psf = ((Dialog)dialog.element).findViewById(R.id.psf_quality_f_dialog);
                TextView vsf = ((Dialog)dialog.element).findViewById(R.id.vsf_quality_f_dialog);
                TextView texturised = ((Dialog)dialog.element).findViewById(R.id.texturised_quality_f_dialog);


                cotton.setOnClickListener((new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Quality_Range_fancy.setText("Cotton");
                        t5 = "Cotton";
                    }
                }));

                pv.setOnClickListener((new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Quality_Range_fancy.setText("PV");
                        t5 = "PV";
                    }
                }));
                pc.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Quality_Range_fancy.setText("PC");
                        t5 = "PC";
                    }
                });
                psf.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Quality_Range_fancy.setText("PSF");
                        t5 = "PSF";
                    }
                });
                vsf.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Quality_Range_fancy.setText("VSF");
                        t5 = "VSF";
                    }
                });
                texturised.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Quality_Range_fancy.setText("Texturised");
                        t5 = "Texturised";
                    }
                });
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
                TextView open = ((Dialog)dialog.element).findViewById(R.id.open_end_nature_dialog);
                TextView ring = ((Dialog)dialog.element).findViewById(R.id.ring_span_nature_dialog);
                TextView vortex = ((Dialog)dialog.element).findViewById(R.id.vortex_nature_dialog);

                open.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Nature_.setText("Open End");
                        t7 = "Open End";
                    }
                });
                ring.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Nature_.setText("Ring Span");
                        t7 = "Ring Span";
                    }
                });
                vortex.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Nature_.setText("Vortex");
                        t7 = "Vortex";
                    }
                });
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
                TextView psf = ((Dialog)dialog.element).findViewById(R.id.psf_variety_dialog);
                TextView pv = ((Dialog)dialog.element).findViewById(R.id.pv_variety_dialog);
                TextView pc = ((Dialog)dialog.element).findViewById(R.id.pc_variety_dialog);

                psf.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Variety_.setText("PSF");
                        t5 = "PSF";
                    }
                });
                pv.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Variety_.setText("PV");
                        t5 = "PV";
                    }
                });
                pc.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Variety_.setText("PC");
                        t5 = "PC";
                    }
                });
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
                TextView slub = ((Dialog)dialog.element).findViewById(R.id.Slub);
                TextView multi_color = ((Dialog)dialog.element).findViewById(R.id.multicolor_product_f_dialog);
                TextView modal = ((Dialog)dialog.element).findViewById(R.id.modal_product_f_dialog);
                TextView excel = ((Dialog)dialog.element).findViewById(R.id.excel_product_f_dialog);
                TextView tencel = ((Dialog)dialog.element).findViewById(R.id.tencel_product_f_dialog);


                slub.setOnClickListener((new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Product_Range_fancy.setText("Slub");
                        t6 = "Slub";
                    }
                }));
                multi_color.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Product_Range_fancy.setText("Multi Colour");
                        t6 = "Multi Colour";
                    }
                });
                modal.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Product_Range_fancy.setText("Modal");
                        t6 = "Modal";
                    }
                });
                excel.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Product_Range_fancy.setText("Excel");
                        t6 = "Excel";
                    }
                });
                tencel.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Product_Range_fancy.setText("Tencel");
                        t6 = "Tencel";
                    }
                });
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
                TextView bright = ((Dialog)dialog.element).findViewById(R.id.bright_product_t_dialog);
                TextView semidull = ((Dialog)dialog.element).findViewById(R.id.Semidull_product_t_dialog);
                TextView fulldull = ((Dialog)dialog.element).findViewById(R.id.fulldull_cot_look_product_t_dialog);
                final TextView stretch = ((Dialog)dialog.element).findViewById(R.id.stretch_lycra_product_t_dialog);
                TextView catonic = ((Dialog)dialog.element).findViewById(R.id.catonic_product_t_dialog);
                TextView airtex = ((Dialog)dialog.element).findViewById(R.id.airtex_cooltex_product_t_dialog);
                TextView blackdope = ((Dialog)dialog.element).findViewById(R.id.blackdope_dyed_);
                TextView fdy = ((Dialog)dialog.element).findViewById(R.id.FDY_product_t_dialog);


                bright.setOnClickListener((new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Product_Range_texturised.setText("Bright");
                        t6 = "Bright";
                    }
                }));
                semidull.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Product_Range_texturised.setText("Semi Dull");
                        t6 = "Semi Dull";
                    }
                });
                fulldull.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Product_Range_texturised.setText("Full Dull");
                        t6 = "Full Dull";
                    }
                });

                stretch.setOnClickListener((new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Product_Range_texturised.setText("Stretch / Lycra");
                        t6 = "Stretch / Lycra";
                    }
                }));
                catonic.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Product_Range_texturised.setText("Catonic");
                        t6 = "Catonic";
                    }
                });
                airtex.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Product_Range_texturised.setText("Airtex / Cooltex");
                        t6 = "Airtex / Cooltex";
                    }
                });
                blackdope.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Product_Range_texturised.setText("Black Dope Dyed");
                        t6 = "Black Dope Dyed";
                    }
                });
                fdy.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Product_Range_texturised.setText("FDY");
                        t6 = "FDY";
                    }
                });
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
                TextView Ist = ((Dialog)dialog.element).findViewById(R.id.Ist_grade_dialog);
                TextView pq = ((Dialog)dialog.element).findViewById(R.id.pq_grade_dialog);
                TextView clq = ((Dialog)dialog.element).findViewById(R.id.clq_grade_dialog);
                TextView std = ((Dialog)dialog.element).findViewById(R.id.std_grade_dialog);


                Ist.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Grade_.setText("1st");
                        t4 = "1st";
                    }
                });
                pq.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Grade_.setText("PQ");
                        t4 = "PQ";
                    }
                });
                clq.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Grade_.setText("CLQ");
                        t4 = "CLQ";
                    }
                });
                std.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View it) {
                        ((Dialog)dialog.element).dismiss();
                        Grade_.setText("STD");
                        t4 = "STD";
                    }
                });
                ((Dialog)dialog.element).show();
            }
        });



        if(t1 == "Texturised"){
            t3 = getText(R.id.denier).toString();
        }
        else{
            t3 = getText(R.id.count).toString();
        }


        t10 = getText(R.id.noofbags).toString();
        t11 = getText(R.id.desc).toString();


        submit.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {

                text = t1+" , "+t2+" , "+t3+" , "+t4+" , "+t5+" , "+t6+" , "+" , "+t7+" , "+t8+" , "+t9+" , "+t10+" , "+t11;
                    Toast.makeText(yarn_requirements.this, t1+" , "+t2+" , "+t3+" , "+t4+" , "+t5+" , "+t6+" , "+" , "+t7+" , "+t8+" , "+t9+" , "+t10+" , "+t11 , Toast.LENGTH_SHORT).show();
                    Toast.makeText(yarn_requirements.this, "Data Stored for using once! more Space in Database recommended", Toast.LENGTH_LONG).show();
                    send_reqto.setVisibility(View.GONE);
                    t1 = t2 = t3 = t4 = t5 = t6 = t7 = t8 = t9 = t10 = t11 = "";
            }
        });
        add_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                req.setText("Requirement"+ (i+1));
                i+=1;
                send_reqto.setVisibility(View.VISIBLE);
                Toast.makeText(yarn_requirements.this, "order taken and new requirement begin...", Toast.LENGTH_SHORT).show();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(yarn_requirements.this, MainActivity.class));
                Toast.makeText(yarn_requirements.this, "Data lost !", Toast.LENGTH_SHORT).show();
                finishAffinity();
            }
        });

    }
}
