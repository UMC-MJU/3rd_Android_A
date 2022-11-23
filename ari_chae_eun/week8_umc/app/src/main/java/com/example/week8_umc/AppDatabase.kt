package com.example.week8_umc

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase(){

    abstract fun userDao() : UserDao // 이렇게만 해줘도 자동으로 데이터 베이스를 가져오게 해준다. 값을 채워준다.
    companion object {
        private var appDatabase: AppDatabase ?= null

        @Synchronized
        fun getInstance(context: Context) : AppDatabase ? {
            if(appDatabase == null){
                synchronized(AppDatabase::class.java){
                    appDatabase = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "app-database"
                        ).allowMainThreadQueries().build()
                }
            }
            return appDatabase
        }
    }
}