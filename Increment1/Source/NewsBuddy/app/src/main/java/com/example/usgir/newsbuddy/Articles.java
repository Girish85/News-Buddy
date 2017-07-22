package com.example.usgir.newsbuddy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Console;
import java.util.ArrayList;

import static com.android.volley.toolbox.Volley.newRequestQueue;

public class Articles extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> titles,uris,links;
    RecyclerView.Adapter adapt2;
    String source;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articles);
        Intent intent = getIntent();
        source = intent.getStringExtra("source");
        recyclerView = (RecyclerView)findViewById(R.id.recy11);
        titles = new ArrayList<>();
        uris = new ArrayList<>();
        links = new ArrayList<>();
        RequestQueue requestQueue = newRequestQueue(this);
        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.GET, "https://newsapi.org/v1/articles?source="+source+"&apiKey=7a51c92205a54bd4ab71c00a9e780b73", null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_SHORT).show();
                try {
                    for (int i = 0;i<5;i++) {
                        String s1 = response.getJSONArray("articles").getJSONObject(i).getString("title");
                        String s2 = response.getJSONArray("articles").getJSONObject(i).getString("urlToImage");
                        String s3 = response.getJSONArray("articles").getJSONObject(i).getString("url");
                        titles.add(s1);
                        uris.add(s2);
                        links.add(s3);
                        adapt2.notifyDataSetChanged();
                    }
                } catch (JSONException e) {
                    Toast.makeText(getApplicationContext(),"Inner gone",Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"Failed"+error.toString(),Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(objectRequest);
        adapt2 = new Adapt2(getApplicationContext(),titles,uris,links);
        recyclerView.setAdapter(adapt2);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));
    }
}
