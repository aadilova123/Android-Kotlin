package com.example.lab3onkt.main

import com.example.lab3onkt.R
import java.text.SimpleDateFormat
import java.util.*
class PostData {

    private var posts: MutableList<Post>? = null

    companion object {
        private var postsContainer:PostData = TODO()
        fun get(): PostData? {
            if (PostData.postsContainer == null) {
                PostData.postsContainer = PostData()
            }
            return PostData.postsContainer
        }
    }
    private fun PostsContainer() {
        posts = ArrayList()
        val like: Int = R.drawable.ic_heart_row
        val dateFormat = SimpleDateFormat("d MMM", Locale.ENGLISH)
        (posts as ArrayList<Post>).add(
            Post("Aya","@lelove","‧ "+dateFormat.format(Date()),"Live.Love.Laugh",
                R.drawable.a,"4","13",1000,false,like)
        )
        (posts as ArrayList<Post>).add(
            Post("iamthebest","","‧ "+dateFormat.format(Date()),"amsterdam is such a beautiful city with gorgeous veiws and sights to see. The red light district is also quite strangely a lovely place to go, you can sit at a pub and watch the world go by.",
                R.drawable.amsterdam,"","45",1000,false,like)
        )
        (posts as ArrayList<Post>).add(
            Post("Armawwwkaa","@arma77","‧ "+dateFormat.format(Date()),"Be the One",
                R.drawable.d,"16","219",2786,false,like)
        )
        (posts as ArrayList<Post>).add(
            Post("Traveller","@LifeLover","‧ "+dateFormat.format(Date()),"Alanya - is a beach resort city and a component district of Antalya Province on the southern coast of Turkey, in the country's Mediterranean Region, 138 kilometres (86 mi) east of the city of Antalya",
                R.drawable.italy,"4","5",248,false,like)
        )
        (posts as ArrayList<Post>).add(
            Post("Aigerim","@CrazyCookie","‧ "+dateFormat.format(Date()),"Be the change that you wish to see in the world.",
                R.drawable.c,"200","153",1122,false,like)
        )
        (posts as ArrayList<Post>).add(
            Post("Iggy","@blackwidowbaby","‧ "+dateFormat.format(Date()),"“Good friends, good books, and a sleepy conscience: this is the ideal life.",
                R.drawable.f,"4","41",155,false,like)
        )
        (posts as ArrayList<Post>).add(
            Post("WhySoTrue","@gulcchi","‧ "+dateFormat.format(Date()),"“Be yourself; everyone else is already taken.”\n" +
                    "― Oscar Wilde",
                R.drawable.b,"2,751","6,544",108,false,like)
        )
        (posts as ArrayList<Post>).add(
            Post("Литература","@literabook","‧ "+dateFormat.format(Date()),"You've gotta dance like there's nobody watching,\n" +
                    "Love like you'll never be hurt,\n" +
                    "Sing like there's nobody listening,\n" +
                    "And live like it's heaven on earth.”\n" +
                    "\n\n" +
                    "William W. Purkey",
                R.drawable.f,"2","120",868,false,like)
        )
        (posts as ArrayList<Post>).add(
            Post("Science","@einstein","‧ "+dateFormat.format(Date()),
                "“Two things are infinite: the universe and human stupidity; and I'm not sure about the universe.”+ ― Albert Einstein", R.drawable.g,"4","200",1177,false,like)
        )
        (posts as ArrayList<Post>).add(
            Post("Великие слова","@topcitat","‧ "+dateFormat.format(Date()),"Darkness cannot drive out darkness: only light can do that. Hate cannot drive out hate: only love can do that.",
            R.drawable.italy,"1","28",139,false,like)
        )
    }

    fun getAllPosts(): List<Post>? {
        return posts
    }

    fun getLikedPosts(): List<Post>? {
        val likedPosts: MutableList<Post> = ArrayList()
        for (post in posts!!) {
            if (post.isLiked) {
                likedPosts.add(post)
            }
        }
        return likedPosts
    }
}