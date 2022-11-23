package com.example.week8_umc

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Insert
    fun insert(user:User)

    @Delete
    fun delete(user:User)

    @Query("SELECT * FROM User")
    fun selectAll() : List<User>

    @Query("SELECT * FROM User WHERE userId = :userId")
    fun selectByUserId(userId: Int) : User

    @Query("SELECT * FROM User WHERE name = :name")
    fun selectByUserName(name: String) : List<User>

    @Query("UPDATE User SET name = :name WHERE userId = :userId")
    fun updateByUserId (userId: Int, name: String) // 업데이트 할 변수를 대부분 뒤에다가 넣어준다.
}