package com.stetsiuk.onewordcompose.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.stetsiuk.onewordcompose.app.Constants
import com.stetsiuk.onewordcompose.models.Word

@Database(entities = [Word::class], version = Constants.WORD_DATABASE_VERSION)
abstract class WordDatabase: RoomDatabase() {

    abstract fun wordDao(): WordDao
}