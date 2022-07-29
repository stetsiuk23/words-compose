package com.stetsiuk.onewordcompose.ui

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.Snapshot.Companion.withMutableSnapshot
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.saveable
import com.stetsiuk.onewordcompose.data.WordRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WordsViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val wordRepository: WordRepository
) : ViewModel() {

    var filteredData: String by savedStateHandle.saveable {
        mutableStateOf("")
    }

    fun setCurrentScreen(query: String) {
        withMutableSnapshot {
            filteredData = query
        }
    }

    companion object {
        const val ALL_WORDS_SCREEN = "all_words_screen"
        const val ADD_NEW_WORD_SCREEN = "add_new_word_screen"
    }
}