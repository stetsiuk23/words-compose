package com.stetsiuk.onewordcompose.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.stetsiuk.onewordcompose.ui.addword.AddNewWord
import com.stetsiuk.onewordcompose.ui.allwords.AllWords

@Composable
fun NewWordApp(
    wordsViewModel: WordsViewModel = viewModel(),
    modifier: Modifier = Modifier
        .padding(30.dp)
) {
    if (wordsViewModel.filteredData == "") wordsViewModel.setCurrentScreen(WordsViewModel.ALL_WORDS_SCREEN)
    val currentScreen = wordsViewModel.filteredData
    if (currentScreen == WordsViewModel.ALL_WORDS_SCREEN) {
        AllWords(
            modifier = modifier,
            move = {
                wordsViewModel.setCurrentScreen(WordsViewModel.ADD_NEW_WORD_SCREEN)
            }
        )
    } else {
        AddNewWord(
            modifier = modifier,
            moveBack = {
                wordsViewModel.setCurrentScreen(WordsViewModel.ALL_WORDS_SCREEN)
            }
        )
    }
}