package com.example.fragmentinteraction.main;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;


import com.example.fragmentinteraction.R;
import com.example.fragmentinteraction.fragment.FragmentPost;
import com.example.fragmentinteraction.fragment.Like;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements Like {
    private FragmentPost fragmentPage = FragmentPost.newInstance(true);
    private FragmentPost fragmentLike = FragmentPost.newInstance(false);
    private FragmentManager fm;
    Fragment active = fragmentPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fm = getSupportFragmentManager();
        fm.beginTransaction().add(R.id.fragment_container, fragmentLike, "2").hide(fragmentLike).commit();
        fm.beginTransaction().add(R.id.fragment_container,fragmentPage, "1").commit();
        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_bar);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_list:
                        fm.beginTransaction().hide(active).show(fragmentPage).commit();
                        active = fragmentPage;
                        return true;

                    case R.id.action_favorite:
                        fm.beginTransaction().hide(active).show(fragmentLike).commit();
                        active = fragmentLike;
                        return true;
                }
                return false;
            }
        });
        if(savedInstanceState == null){
            bottomNavigationView.setSelectedItemId(R.id.action_list);
        }
    }

    @Override
    public void onPostLike() {
        fragmentPage.updatePage();
        fragmentLike.updateLike();
    }
}


