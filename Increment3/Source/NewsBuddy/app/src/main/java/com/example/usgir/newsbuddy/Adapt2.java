package com.example.usgir.newsbuddy;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by usgir on 7/16/2017.
 */

public class Adapt2 extends RecyclerView.Adapter<Myhold> {
    ArrayList<String> titles,uris,links;
    Context c;
    LayoutInflater inflater;
    public Adapt2(Context context,ArrayList<String> ts,ArrayList<String> us,ArrayList<String> ls) {
        c = context;
        titles = ts;
        uris = us;
        links = ls;
        inflater = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public Myhold onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.newsitem,parent,false);
        Myhold myhold = new Myhold(view,c,links);
        //Toast.makeText(c,"Got it",Toast.LENGTH_SHORT).show();
        return myhold;
    }

    @Override
    public void onBindViewHolder(Myhold holder, int position) {
        holder.textView.setText(titles.get(position));
        Uri uri = Uri.parse(uris.get(position));
        Picasso.with(c).setLoggingEnabled(true);
        Picasso.with(c).load(uri).resize(130,130).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }
}

class Myhold extends RecyclerView.ViewHolder implements View.OnClickListener {
    Context context;
    TextView textView;
    ImageView imageView;
    ArrayList<String> links;
    public Myhold(View itemView,Context c,ArrayList<String> lks) {
        super(itemView);
        context = c;
        links = lks;
        itemView.setOnClickListener(this);
        textView = (TextView)itemView.findViewById(R.id.textView3);
        imageView = (ImageView)itemView.findViewById(R.id.imageView8);
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(context,Webpage.class);
        i.putExtra("url",links.get(getAdapterPosition()));
        context.startActivity(i);
    }
}
