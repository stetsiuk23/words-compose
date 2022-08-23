package com.stetsiuk.onewordcompose.ui.allwords

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stetsiuk.onewordcompose.data.WordRepository
import com.stetsiuk.onewordcompose.app.Constants
import com.stetsiuk.onewordcompose.models.Word
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AllWordViewModel @Inject constructor(
    private val wordRepository: WordRepository,
) : ViewModel() {

    fun getAllWords(): LiveData<List<Word>> {
        return wordRepository.getAllWords()
    }

    fun deleteAllWords() {
        viewModelScope.launch(Constants.DISPATCHERS_IO) {
            wordRepository.deleteAllWords()
        }
    }

}