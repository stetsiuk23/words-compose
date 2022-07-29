package com.stetsiuk.onewordcompose.ui.addword

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stetsiuk.onewordcompose.data.WordRepository
import com.stetsiuk.onewordcompose.di.Constants
import com.stetsiuk.onewordcompose.models.Word
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddNewWordViewModel @Inject constructor(
    private val wordRepository: WordRepository
) : ViewModel() {

    fun addNewWord(word: String) {
        viewModelScope.launch(Constants.DISPATCHERS_IO) {
            val newWord = Word(word = word)
            wordRepository.addNewWord(newWord)
        }
    }
}