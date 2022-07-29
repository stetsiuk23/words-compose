package com.stetsiuk.onewordcompose.data

import androidx.lifecycle.LiveData
import com.stetsiuk.onewordcompose.data.room.WordDatabase
import com.stetsiuk.onewordcompose.models.Word
import javax.inject.Inject

class WordRepository @Inject constructor(
    private val wordDatabase: WordDatabase
) {

    fun getAllWords(): LiveData<List<Word>> {
        return wordDatabase.wordDao().getAllWords()
    }

    fun addNewWord(newWord: Word) {
        wordDatabase.wordDao().insert(newWord)
    }

    fun deleteAllWords() {
        wordDatabase.wordDao().deleteAll()
    }

}