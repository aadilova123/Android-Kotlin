package com.example.fragmentinteraction.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.fragmentinteraction.R;
import com.example.fragmentinteraction.adapter.PostAdapter;
import com.example.fragmentinteraction.main.MainActivity;
import com.example.fragmentinteraction.main.Post;
import com.example.fragmentinteraction.main.PostData;

import java.util.ArrayList;
import java.util.List;

public class FragmentPost extends Fragment implements Like {

    private RecyclerView recyclerView;
    private PostAdapter adapter;
    private boolean isAllPostVersion;
    private List<Post> dataSet = new ArrayList<>();
    private PostData postsContainer = PostData.get();

    public static FragmentPost newInstance(boolean isAllPostVersion) {
        FragmentPost fragment = new FragmentPost();
        fragment.isAllPostVersion = isAllPostVersion;
        return fragment;
    }

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment,container,false);
        recyclerView = v.findViewById(R.id.recyclerView);

        if(isAllPostVersion){
            dataSet.addAll(postsContainer.getAllPosts());
        }
        else{
            dataSet.addAll(postsContainer.getLikedPosts());
        }
        adapter = new PostAdapter(dataSet,this);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);
        return v;

    }
    public void onPostLike()
    {
        ((MainActivity)getActivity()).onPostLike();
    }
    public void updateLike(){
        dataSet.clear();
        dataSet.addAll(postsContainer.getLikedPosts());
        adapter.notifyDataSetChanged();
    }
    public void updatePage(){
        dataSet.clear();
        dataSet.addAll(postsContainer.getAllPosts());
        adapter.notifyDataSetChanged();
    }
}