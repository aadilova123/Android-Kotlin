package com.example.twitter.main;

import com.example.twitter.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class PostData {

    private static  PostData postsContainer;
    private List<Post> posts;

    public static PostData get() {
        if (postsContainer == null) {
            postsContainer = new PostData();
        }
        return postsContainer;
    }

    private PostData() {
        posts = new ArrayList<>();
        int like = R.drawable.ic_heart_row;
        SimpleDateFormat dateFormat = new SimpleDateFormat("d MMM", Locale.ENGLISH);
        posts.add(new Post("Aya","@lelove","‧ "+dateFormat.format(new Date()),"Live.Love.Laugh",
                R.drawable.a,"4","13",1000,false,like));
        posts.add(new Post("iamthebest","","‧ "+dateFormat.format(new Date()),"amsterdam is such a beautiful city with gorgeous veiws and sights to see. The red light district is also quite strangely a lovely place to go, you can sit at a pub and watch the world go by.",
                R.drawable.amsterdam,"","45",1000,false,like));
        posts.add(new Post("Armawwwkaa","@arma77","‧ "+dateFormat.format(new Date()),"Be the One",
                R.drawable.d,"16","219",2786,false,like));
        posts.add(new Post("Traveller","@LifeLover","‧ "+dateFormat.format(new Date()),"Alanya - is a beach resort city and a component district of Antalya Province on the southern coast of Turkey, in the country's Mediterranean Region, 138 kilometres (86 mi) east of the city of Antalya",
                R.drawable.italy,"4","5",248,false,like));
        posts.add(new Post("Aigerim","@CrazyCookie","‧ "+dateFormat.format(new Date()),"Be the change that you wish to see in the world.",
                R.drawable.c,"200","153",1122,false,like));
        posts.add(new Post("Iggy","@blackwidowbaby","‧ "+dateFormat.format(new Date()),"“Good friends, good books, and a sleepy conscience: this is the ideal life.",
                R.drawable.f,"4","41",155,false,like));
        posts.add(new Post("WhySoTrue","@gulcchi","‧ "+dateFormat.format(new Date()),"“Be yourself; everyone else is already taken.”\n" +
                "― Oscar Wilde",
                R.drawable.b,"2,751","6,544",108,false,like));
        posts.add(new Post("Литература","@literabook","‧ "+dateFormat.format(new Date()),"You've gotta dance like there's nobody watching,\n" +
                "Love like you'll never be hurt,\n" +
                "Sing like there's nobody listening,\n" +
                "And live like it's heaven on earth.”\n" +
                "\n\n" +
                "William W. Purkey",
                R.drawable.f,"2","120",868,false,like));
        posts.add(new Post("Science","@einstein","‧ "+dateFormat.format(new Date()),
                "“Two things are infinite: the universe and human stupidity; and I'm not sure about the universe.”+ ― Albert Einstein", R.drawable.g,"4","200",1177,false,like));
        posts.add(new Post("Великие слова","@topcitat","‧ "+dateFormat.format(new Date()),"Darkness cannot drive out darkness: only light can do that. Hate cannot drive out hate: only love can do that.",
                R.drawable.italy,"1","28",139,false,like));
        posts.add(new Post("Aya","@lelove","‧ "+dateFormat.format(new Date()),"Live.Love.Laugh",
                R.drawable.a,"4","13",1000,false,like));
        posts.add(new Post("iamthebest","","‧ "+dateFormat.format(new Date()),"amsterdam is such a beautiful city with gorgeous veiws and sights to see. The red light district is also quite strangely a lovely place to go, you can sit at a pub and watch the world go by.",
                R.drawable.amsterdam,"","45",1000,false,like));
        posts.add(new Post("Armawwwkaa","@arma77","‧ "+dateFormat.format(new Date()),"We accept the love we think we deserve.",
                R.drawable.d,"16","219",2786,false,like));
        posts.add(new Post("Traveller","@LifeLover","‧ "+dateFormat.format(new Date()),"Alanya - is a beach resort city and a component district of Antalya Province on the southern coast of Turkey, in the country's Mediterranean Region, 138 kilometres (86 mi) east of the city of Antalya",
                R.drawable.italy,"4","5",248,false,like));
        posts.add(new Post("Aigerim","@CrazyCookie","‧ "+dateFormat.format(new Date()),"Without music, life would be a mistake.",
                R.drawable.c,"200","153",1122,false,like));
        posts.add(new Post("Iggy","@blackwidowbaby","‧ "+dateFormat.format(new Date()),"“Good friends, good books, and a sleepy conscience: this is the ideal life.",
                R.drawable.f,"4","41",155,false,like));
        posts.add(new Post("WhySoTrue","@gulcchi","‧ "+dateFormat.format(new Date()),"“Be yourself; everyone else is already taken.”\n" +
                "― Oscar Wilde",
                R.drawable.b,"2,751","6,544",108,false,like));
        posts.add(new Post("Литература","@literabook","‧ "+dateFormat.format(new Date()),"You've gotta dance like there's nobody watching,\n" +
                "Love like you'll never be hurt,\n" +
                "Sing like there's nobody listening,\n" +
                "And live like it's heaven on earth.”\n" +
                "― William W. Purkey",
                R.drawable.f,"2","120",868,false,like));
        posts.add(new Post("Science","@einstein","‧ "+dateFormat.format(new Date()),
                "“Two things are infinite: the universe and human stupidity; and I'm not sure about the universe.”+ ― Albert Einstein", R.drawable.g,"4","200",1177,false,like));
        posts.add(new Post("Великие слова","@topcitat","‧ "+dateFormat.format(new Date()),"No one can make you feel inferior without your consent.",
                R.drawable.italy,"1","28",139,false,like));
    }
    public List<Post> getAllPosts() {
        return posts;
    }

    public  List<Post> getLikedPosts(){
        List<Post> likedPosts = new ArrayList<>();
        for (Post post : posts) {
            if(post.isLiked()){
                likedPosts.add(post);
            }
        }
        return likedPosts;
    }
}