package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView im1;
    private ImageView im2;
    private ImageView im3;
    private ImageView im4;
    private ImageView im5;
    private ImageView im6;
    private ImageView im7;
    private ImageView im8;
    private ImageView im9;
    private ImageView im10;

    private RecyclerView recyclerView;

    private NewsListAdapter adapter;

    private NewsListAdapter.ItemClickListener listener = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        im1 = findViewById(R.id.im1);
        im2 = findViewById(R.id.im2);
        im3 = findViewById(R.id.im3);
        im4 = findViewById(R.id.im4);

        im1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NextActivity.class);
                startActivity(intent);
                //finish();
            }
        });
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new NewsListAdapter(newsGenerator(), listener);
        recyclerView.setAdapter(adapter);

        private List<News> newsGenerator() {
            String loremIpsum = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
            List<News> items = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                News news = new News(
                        "date " + i,
                        "author " + i,
                        loremIpsum,
                        "theme " + i,
                        i,
                        i,
                        i
                );
                items.add(news);
            }
            return items;
        }
    }
}
