package com.example.week8_umc

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PostDao {
    @Insert
    fun insert(post:Post)

    @Delete
    fun delete(post:Post)

    @Query("SELECT * FROM Post")
    fun selectAll() : List<Post>

    @Query("SELECT * FROM Post WHERE postId = :postId")
    fun selectByPostId(postId: Int) : Post

    @Query("SELECT * FROM Post WHERE title = :title")
    fun selectByTitle(title: String) : List<Post>

    @Query("UPDATE Post SET title = :title WHERE postId = :postId")
    fun updateByPostId (postId: Int, title: String) // 업데이트 할 변수를 대부분 뒤에다가 넣어준다.
}