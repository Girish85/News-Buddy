package com.example.usgir.newsbuddy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{
    RecyclerView recyclerView;
    List<Listclass> list;
    String[] StringList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView)findViewById(R.id.list);
        StringList = getResources().getStringArray(R.array.categories);
        int i[] = new int[]{R.drawable.sports,R.drawable.general,R.drawable.finance,R.drawable.technology,R.drawable.environment,R.drawable.entertainment,R.drawable.gaming};
        list = new ArrayList<>();
        int j = i.length;
        for (int k = 0;k<j;k++)
        {
            Listclass listclass = new Listclass();
            listclass.img_id = i[k];
            listclass.text = StringList[k];
            list.add(listclass);
        }
        RecyclerView.Adapter adapter = new Adapt(getApplicationContext(),list);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));
    }
}
