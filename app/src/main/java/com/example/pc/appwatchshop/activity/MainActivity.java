package com.example.pc.appwatchshop.activity;

import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.telecom.GatewayInfo;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ViewFlipper;

import com.example.pc.lakeshop.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Toolbar toobar ;
    ViewFlipper viewflipper;
    RecyclerView recyclerviewmanhinhchinh;
    NavigationView navigationview;
    ListView lisviewmenu;
    DrawerLayout drawerlayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        ActionBar();
        ActionViewFlipper();

    }
    private void ActionViewFlipper(){
        ArrayList<String> mangquangcao =new ArrayList<>();
        mangquangcao.add("https://dantricdn.com/thumb_w/640/2017/photo-3-1492047610256.jpg");
        mangquangcao.add("https://dantricdn.com/thumb_w/640/2016/photo-2-1482900391922.jpg");
        for (int i = 0;i<mangquangcao.size();i++) {
            ImageView imageview = new ImageView(getApplicationContext());
            Picasso.with(getApplicationContext()).load(mangquangcao.get(i)).into(imageview);
            imageview.setScaleType(ImageView.ScaleType.FIT_XY);
            viewflipper.addView(imageview);
        }
        viewflipper.setFlipInterval(5000);
        viewflipper.setAutoStart(true);
        Animation animation_slide_in= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_in_right);
        Animation animation_slide_out= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_out_right);
        viewflipper.setOutAnimation(animation_slide_in);
        viewflipper.setOutAnimation(animation_slide_out);
    }
    private void ActionBar(){
        setSupportActionBar(toobar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toobar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
        toobar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerlayout.openDrawer(GravityCompat.START);
            }
        });
    }
    private void Anhxa(){
        toobar= (Toolbar) findViewById(R.id.toolbarmanhinhchinh);
        viewflipper= (ViewFlipper) findViewById(R.id.viewflipper);
        recyclerviewmanhinhchinh= (RecyclerView) findViewById(R.id.recyclerview);
        navigationview= (NavigationView) findViewById(R.id.navigationview);
        lisviewmenu= (ListView) findViewById(R.id.listviewmenu);
        drawerlayout= (DrawerLayout) findViewById(R.id.draverlayout);
    }
}


