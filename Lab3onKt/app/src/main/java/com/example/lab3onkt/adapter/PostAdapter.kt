package com.example.lab3onkt.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lab3onkt.R
import com.example.lab3onkt.fragment.Like
import com.example.lab3onkt.fragment.FragmentPost
import com.example.lab3onkt.main.Post

class PostAdapter(
    dataSet: MutableList<Post>,
    postFragment: FragmentPost
) : RecyclerView.Adapter<PostAdapter.PostHolder>() {
    var posts: List<Post>? = null
    private var mChangeListener: Like? = null

    fun PostAdapter(posts: List<Post>?, mChangeListener: Like?) {
        this.posts = posts
        this.mChangeListener = mChangeListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item, parent, false)
        return PostHolder(itemView)
    }

    override fun onBindViewHolder(holder: PostHolder, position: Int) {
        holder.bind(posts?.get(position))
    }

    override fun getItemCount(): Int {
        return posts?.size ?: 0
    }


    inner class PostHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(post: Post?) {
            val name = view.findViewById<TextView>(R.id.name_txt)
            val post1 = view.findViewById<TextView>(R.id.post_txt)
            val login = view.findViewById<TextView>(R.id.login_txt)
            val date = view.findViewById<TextView>(R.id.date)
            val commentCnt = view.findViewById<TextView>(R.id.comments_cnt)
            val tweetCnt = view.findViewById<TextView>(R.id.reTweet_cnt)
            val likeCnt = view.findViewById<TextView>(R.id.likes_cnt)
            val profileImg = view.findViewById<ImageView>(R.id.profile_img)
            val like = view.findViewById<ImageView>(R.id.likes_cnt)
            name?.text = post?.name
            login.text = post?.login
            date.text = post?.date
            commentCnt.text = post?.commentCnt
            tweetCnt.text = post?.tweetCnt
            likeCnt.text = post?.likeCnt.toString()
            profileImg.setImageResource(post?.profileImg!!)
            like.setOnClickListener {
                if (!post.isLiked) {
                    like.setImageResource(R.drawable.ic_like_clicked_row)
                    val s = likeCnt.text.toString().toInt() + 1
                    likeCnt.text = s.toString()
                    post.isLiked = true
                    post.redlike = R.drawable.ic_like_clicked_row
                    post.likeCnt = post.likeCnt + 1
                    if (mChangeListener != null) {
                        mChangeListener!!.onPostLike()
                    }

                } else {
                    like.setImageResource(R.drawable.ic_heart_row)
                    val s = likeCnt.text.toString().toInt() - 1
                    likeCnt.text = s.toString()
                    post.isLiked = false
                    post.likeCnt = post.likeCnt - 1
                    post.redlike = R.drawable.ic_heart_row
                    if (mChangeListener != null) {
                        mChangeListener!!.onPostLike()
                    }
                }
            }
        }
    }
}