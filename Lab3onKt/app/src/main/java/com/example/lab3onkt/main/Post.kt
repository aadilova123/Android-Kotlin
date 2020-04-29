package com.example.lab3onkt.main


import android.os.Parcel
import android.os.Parcelable


data class Post internal constructor(
    var name: String? = null,
    var login: String? = null,
    var date: String? = null,
    var post: String? = null,
    var profileImg: Int = 0,
    var commentCnt: String? = null,
    var tweetCnt: String? = null,
    var likeCnt: Int = 0,
    var isLiked: Boolean = false,
    var redlike: Int = 0
) {

    fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(login)
        dest.writeString(date)
        dest.writeString(post)
        dest.writeInt(likeCnt)
        dest.writeInt(profileImg)
        dest.writeString(name)
        dest.writeString(commentCnt)
        dest.writeString(tweetCnt)
        dest.writeInt(redlike)
    }

    private fun Post(`in`: Parcel) {
        login = `in`.readString()
        date = `in`.readString()
        post = `in`.readString()
        name = `in`.readString()
        commentCnt = `in`.readString()
        tweetCnt = `in`.readString()
        likeCnt = `in`.readInt()
        profileImg = `in`.readInt()
        redlike = `in`.readInt()
    }

    val CREATOR: Parcelable.Creator<Post?> = object : Parcelable.Creator<Post?> {
        override fun createFromParcel(parcel: Parcel?): Post? {
//            return Post(parcel)
            return Post()
        }

        override fun newArray(i: Int): Array<Post?> {
            return arrayOfNulls(i)
        }
    }
}