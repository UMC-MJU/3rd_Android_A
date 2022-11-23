package com.example.week8_umc

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Post (
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "des") val des: String,
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "postId") val postId :Int = 0
)