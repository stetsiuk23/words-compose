package com.stetsiuk.onewordcompose.data.room_word

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.stetsiuk.onewordcompose.models.Word

@Dao
interface WordDao {

    @Query("SELECT * FROM Word")
    fun getAllWords(): LiveData<List<Word>>

    @Insert
    fun insert(word: Word)

    @Query("DELETE FROM Word")
    fun deleteAll()
}