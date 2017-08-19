package com.example.usgir.newsbuddy;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewAnimator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{
    //RecyclerView recyclerView;
    //List<Listclass> list;
    String[] StringList;
    CardView cardView;
    ImageView imageView;
    TextView textView;
    ValueAnimator animator12,animator22;
    ObjectAnimator animator11,animator13,animator21,animator23;
    AnimatorSet set1,set2;
    int img_id;
    int i[];
    String Name;
    Button button1,button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cardView = (CardView)findViewById(R.id.cardview);
        imageView = (ImageView)findViewById(R.id.imageView9);
        textView = (TextView)findViewById(R.id.textView2);
        button1 = (Button)findViewById(R.id.button);
        button2 = (Button)findViewById(R.id.button2);
        set1 = new AnimatorSet();
        set2 = new AnimatorSet();
        animator11 = new ObjectAnimator().ofFloat(cardView,"RotationY",0,45,45,90);
        animator11.setDuration(100);
        animator13 = new ObjectAnimator().ofFloat(cardView,"RotationY",90,135,135,180,225,225,270,315,315,360);
        animator13.setDuration(300);
        animator21 = new ObjectAnimator().ofFloat(cardView,"RotationY",360,315,315,270);
        animator21.setDuration(100);
        animator23 = new ObjectAnimator().ofFloat(cardView,"RotationY",270,225,225,180,135,135,90,45,45,0);
        animator23.setDuration(300);
        //recyclerView = (RecyclerView)findViewById(R.id.list);
        StringList = getResources().getStringArray(R.array.categories);
        i = new int[]{R.drawable.sports,R.drawable.general,R.drawable.finance,R.drawable.technology,R.drawable.environment,R.drawable.entertainment,R.drawable.gaming};
        //list = new ArrayList<>();
        int j = i.length;
        img_id = 0;
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,imageView,"trans");
                Intent intent = new Intent(getApplicationContext(),News.class);
                intent.putExtra("Genre",i[img_id]);
                startActivity(intent,options.toBundle());
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (img_id<6)
                {
                    img_id++;
                }
                else
                {
                    img_id = 0;
                }
                animator12 = new ValueAnimator().ofInt(1,10);
                animator12.setDuration(10);
                animator12.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        imageView.setImageResource(i[img_id]);
                        textView.setText(StringList[img_id]);
                    }
                });
                set1.play(animator11).before(animator12);
                set1.play(animator12).before(animator13);
                set1.start();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (img_id>0)
                {
                    img_id--;
                }
                else
                {
                    img_id = 6;
                }
                animator22 = new ValueAnimator().ofInt(1,10);
                animator22.setDuration(10);
                animator22.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        imageView.setImageResource(i[img_id]);
                        textView.setText(StringList[img_id]);
                    }
                });
                set2.play(animator21).before(animator22);
                set2.play(animator22).before(animator23);
                set2.start();
            }
        });
        /*for (int k = 0;k<j;k++)
        {
            Listclass listclass = new Listclass();
            listclass.img_id = i[k];
            listclass.text = StringList[k];
            //list.add(listclass);
        }*/
        //RecyclerView.Adapter adapter = new Adapt(getApplicationContext(),list);
        //recyclerView.setAdapter(adapter);
        //recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));
    }
}
