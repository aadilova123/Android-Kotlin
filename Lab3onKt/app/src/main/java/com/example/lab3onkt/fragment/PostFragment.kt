package com.example.lab3onkt.fragment

import android.app.PendingIntent.getActivity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab3onkt.R
import com.example.lab3onkt.adapter.PostAdapter
import com.example.lab3onkt.main.MainActivity
import com.example.lab3onkt.main.Post
import com.example.lab3onkt.main.PostData
import java.security.AccessController.getContext
import java.util.*


class FragmentPost {
    private var recyclerView: RecyclerView? = null
    private var adapter: PostAdapter? = null
    private var isAllPostVersion = false
    private val dataSet: MutableList<Post> = ArrayList<Post>()
    private val postsContainer: PostData = PostData.get()!!

    companion object {
        fun newInstance(isAllPostVersion: Boolean): FragmentPost? {
            val fragment = FragmentPost()
            fragment.isAllPostVersion = isAllPostVersion
            return fragment
        }
    }

    fun onCreate(savedInstanceState: Bundle?) {
        (savedInstanceState)
    }

    fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v: View = inflater.inflate(R.layout.fragment, container, false)
        recyclerView = v.findViewById(R.id.recyclerView)
        if (isAllPostVersion) {
            dataSet.addAll(postsContainer.getAllPosts()!!)
        } else {
            dataSet.addAll(postsContainer.getLikedPosts()!!)
        }
        adapter = PostAdapter(dataSet, this)
//        recyclerView?.setLayoutManager(LinearLayoutManager(getActivity(v.context)))
        recyclerView?.addItemDecoration(
            DividerItemDecoration(
                v.context,
                LinearLayoutManager.VERTICAL
            )
        )
        recyclerView?.setAdapter(adapter)
        return v
    }


    fun onPostLike() {
//        (getActivity() as MainActivity).onPostLike()
    }

    fun updateLike() {
        dataSet.clear()
        dataSet.addAll(postsContainer.getLikedPosts()!!)
        adapter?.notifyDataSetChanged()
    }

    fun updatePage() {
        dataSet.clear()
        dataSet.addAll(postsContainer.getAllPosts()!!)
        adapter?.notifyDataSetChanged()
    }
}
