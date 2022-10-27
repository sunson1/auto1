package com.example.auto.di

import android.app.Application
import androidx.room.Room
import com.example.auto.data.local.AppDatabase
import com.example.auto.data.local.WorkListDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(application: Application, callback: AppDatabase.Callback): AppDatabase{
        return Room.databaseBuilder(application, AppDatabase::class.java, "news_database")
            .fallbackToDestructiveMigration()
            .addCallback(callback)
            .build()
    }

    @Provides
    fun provideArticleDao(db: AppDatabase): WorkListDao { //ArticleDao
        return db.getWorkListDao()
    }
}