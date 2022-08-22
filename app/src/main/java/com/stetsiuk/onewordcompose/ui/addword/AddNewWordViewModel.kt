package com.stetsiuk.onewordcompose.ui.addword

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stetsiuk.onewordcompose.app.Constants
import com.stetsiuk.onewordcompose.data.WordRepository
import com.stetsiuk.onewordcompose.models.Word
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddNewWordViewModel @Inject constructor(
    private val wordRepository: WordRepository,
) : ViewModel() {
    private var _uiState: MutableLiveData<AddNewWordUiState> =
        MutableLiveData<AddNewWordUiState>(AddNewWordUiState.EmptyText)
    val uiState: LiveData<AddNewWordUiState> = _uiState

    fun addNewWord(word: String) {
        viewModelScope.launch(Constants.DISPATCHERS_IO) {
            val newWord = Word(word = word)
            wordRepository.addNewWord(newWord)
        }
    }

    fun textChanged(text: String) {
        if (text.length == AddNewWordUiState.EmptyText.value) {
            _uiState.value = AddNewWordUiState.EmptyText
        } else if (text.length < AddNewWordUiState.MiddleText.value) {
            _uiState.value = AddNewWordUiState.MiddleText
        } else if (text.length < AddNewWordUiState.LongText.value) {
            _uiState.value = AddNewWordUiState.LongText
        } else {
            _uiState.value = AddNewWordUiState.MaxText
        }
    }
}