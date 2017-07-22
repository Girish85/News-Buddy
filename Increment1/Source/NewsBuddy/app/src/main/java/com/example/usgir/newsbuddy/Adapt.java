package com.example.usgir.newsbuddy;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

/**
 * Created by usgir on 7/15/2017.
 */

public class Adapt extends RecyclerView.Adapter<Myholder> {
    List<Listclass> classlist = Collections.emptyList();
    Context c;
    LayoutInflater inflater;
    public Adapt(Context context, List<Listclass> list) {
        c = context;
        classlist = list;
        inflater = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public Myholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.listitem,parent,false);
        Myholder holder = new Myholder(view,c,classlist);
        return holder;
    }

    @Override
    public void onBindViewHolder(Myholder holder, int position) {
        Listclass listclass = classlist.get(position);
        holder.textView.setText(listclass.text);
        holder.imageView.setImageResource(listclass.img_id);
    }

    @Override
    public int getItemCount() {
        return classlist.size();
    }
}
class Myholder extends RecyclerView.ViewHolder implements View.OnClickListener{
    TextView textView;
    ImageView imageView;
    List<Listclass> classlist1 = Collections.emptyList();
    Context c2;
    public Myholder(View itemView,Context c3,List<Listclass> l1) {
        super(itemView);
        classlist1 = l1;
        c2 = c3;
        textView = (TextView)itemView.findViewById(R.id.textView);
        imageView = (ImageView)itemView.findViewById(R.id.imageView);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int ll = getAdapterPosition();
        Listclass listclass = classlist1.get(ll);
        //Toast.makeText(c2,"Clicked"+ll,Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(c2,News.class);
        intent.putExtra("Genre",listclass.img_id);
        c2.startActivity(intent);
    }
}
