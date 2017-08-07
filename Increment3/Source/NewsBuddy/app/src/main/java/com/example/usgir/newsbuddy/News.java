package com.example.usgir.newsbuddy;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class News extends AppCompatActivity implements View.OnClickListener {
    int j[];
    String source[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        Intent intent = getIntent();
        int i = intent.getIntExtra("Genre",R.drawable.general);
        ImageView imageView = (ImageView)findViewById(R.id.imageView2);
        imageView.setImageResource(i);
        ImageView imageView1 = (ImageView)findViewById(R.id.imageView3);
        ImageView imageView2 = (ImageView)findViewById(R.id.imageView5);
        ImageView imageView3 = (ImageView)findViewById(R.id.imageView4);
        ImageView imageView4 = (ImageView)findViewById(R.id.imageView6);
        ImageView imageView5 = (ImageView) findViewById(R.id.imageView7);
        imageView1.setOnClickListener(this);
        imageView2.setOnClickListener(this);
        imageView3.setOnClickListener(this);
        imageView4.setOnClickListener(this);
        imageView5.setOnClickListener(this);
        imageView3.setVisibility(View.GONE);
        imageView4.setVisibility(View.GONE);
        imageView5.setVisibility(View.GONE);
        switch (i)
        {
            case R.drawable.sports :
                j = new int[]{R.drawable.bbcsport,R.drawable.espn,R.drawable.four,R.drawable.foxsport,R.drawable.nfl};
                source = new String[]{"bbc-sport","espn","four-four-two","fox-sports","nfl-news"};
                break;
            case R.drawable.general :
                j = new int[]{R.drawable.bbc,R.drawable.cnn,R.drawable.abc,R.drawable.focus,R.drawable.time};
                source = new String[]{"bbc-news","cnn","abc-news-au","focus","time"};
                break;
            case R.drawable.finance :
                j = new int[]{R.drawable.bloomberg,R.drawable.businessinsider,R.drawable.economist,R.drawable.ft};
                source = new String[]{"bloomberg","business-insider","the-economist","financial-times"};
                break;
            case R.drawable.technology :
                j = new int[]{R.drawable.techcrunch,R.drawable.techradar,R.drawable.thenextweb,R.drawable.wired,R.drawable.hackernews};
                source = new String[]{"techcrunch","techradar","the-next-web","wired-de","hacker-news"};
                break;
            case R.drawable.environment :
                j = new int[]{R.drawable.nationalgeo,R.drawable.newscientist};
                source = new String[]{"national-geographic","new-scientist"};
                break;
            case R.drawable.entertainment :
                j = new int[]{R.drawable.mtv,R.drawable.buzzfeed,R.drawable.entertainmentweek,R.drawable.mashable};
                source = new String[]{"mtv-news","buzzfeed","entertainment-weekly","mashable"};
                break;
            case R.drawable.gaming:
                j = new int[]{R.drawable.ign,R.drawable.polygon};
                source = new String[]{"ign","polygon"};
                break;
        }
        int l = j.length;
        Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(),j[0]);
        RoundedBitmapDrawable bitmapDrawable1 = RoundedBitmapDrawableFactory.create(getResources(),bitmap1);
        bitmapDrawable1.setCircular(true);
        imageView1.setImageDrawable(bitmapDrawable1);
        Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(),j[1]);
        RoundedBitmapDrawable bitmapDrawable2 = RoundedBitmapDrawableFactory.create(getResources(),bitmap2);
        bitmapDrawable2.setCircular(true);
        imageView2.setImageDrawable(bitmapDrawable2);
        if (l>2) {
            imageView4.setVisibility(View.VISIBLE);
            imageView3.setVisibility(View.VISIBLE);
            Bitmap bitmap3 = BitmapFactory.decodeResource(getResources(),j[2]);
            RoundedBitmapDrawable bitmapDrawable3 = RoundedBitmapDrawableFactory.create(getResources(), bitmap3);
            bitmapDrawable3.setCircular(true);
            Bitmap bitmap4 = BitmapFactory.decodeResource(getResources(),j[3]);
            RoundedBitmapDrawable bitmapDrawable4 = RoundedBitmapDrawableFactory.create(getResources(), bitmap4);
            bitmapDrawable4.setCircular(true);
            imageView3.setImageDrawable(bitmapDrawable3);
            imageView4.setImageDrawable(bitmapDrawable4);
        }
        if (l == 5) {
            imageView5.setVisibility(View.VISIBLE);
            Bitmap bitmap5 = BitmapFactory.decodeResource(getResources(),j[4]);
            RoundedBitmapDrawable bitmapDrawable5 = RoundedBitmapDrawableFactory.create(getResources(), bitmap5);
            bitmapDrawable5.setCircular(true);
            imageView5.setImageDrawable(bitmapDrawable5);
        }
    }

    @Override
    public void onClick(View v) {
        String src = "cnn";
        switch (v.getId())
        {
            case R.id.imageView3 : src = source[0];
                break;
            case R.id.imageView5 : src = source[1];
                break;
            case R.id.imageView4 : src = source[2];
                break;
            case R.id.imageView6 : src = source[3];
                break;
            case R.id.imageView7 : src = source[4];
                break;
        }
        Intent intent = new Intent(getApplicationContext(),Articles.class);
        intent.putExtra("source",src);
        startActivity(intent);
    }
}
