package com.stetsiuk.onewordcompose.app.di

import android.content.Context
import androidx.room.Room
import com.stetsiuk.onewordcompose.app.Constants
import com.stetsiuk.onewordcompose.data.room.WordDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun newWordDatabase(@ApplicationContext context: Context): WordDatabase {
        return Room.databaseBuilder(
            context,
            WordDatabase::class.java,
            Constants.WORD_DATABASE_NAME
        )
            .build()
    }
}